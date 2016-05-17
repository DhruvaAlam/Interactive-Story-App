package alam.naqib.dhruva.interactivestory.UI;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import alam.naqib.dhruva.interactivestory.Model.Page;
import alam.naqib.dhruva.interactivestory.Model.Story;
import alam.naqib.dhruva.interactivestory.R;

public class StoryActivity extends AppCompatActivity {

    private Story mStory = new Story();
    private ImageView mImageView;
    private TextView mTextView;
    private Button mButton1;
    private Button mButton2;
    private String mName;
    private Page mCurrentPage;

    public static String TAG = StoryActivity.class.getSimpleName();
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient mClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent(); //returns the intent that started this activity
        String name = intent.getStringExtra(getString(R.string.key_name)); //gets the string that has key "name" from the intent
        if (name == null) { //if there is no name from intent, or nothing mathces key name, then default to this
            name = "Ben";
        }
        mName = name;
        Log.d(TAG, name);

        mImageView= (ImageView) findViewById(R.id.storyImageView);
        mTextView = (TextView) findViewById(R.id.storyTextView);
        mButton1 = (Button) findViewById(R.id.choiceButtonA);
        mButton2 = (Button) findViewById(R.id.choiceButtonB);

        loadPage(0);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        mClient = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void loadPage(int choice) {
        mCurrentPage = mStory.getPages(choice);

        Drawable drawable = getResources().getDrawable(mCurrentPage.getImageId());
        mImageView.setImageDrawable(drawable);

        //add name to the pageText
        String pageText = mCurrentPage.getText();
        pageText = String.format(pageText, mName); //replaces occurences %1$s  with given name by user

        mTextView.setText(pageText);

        if(mCurrentPage.isLastPage()){
            //hide choice button 1
            mButton1.setVisibility(View.INVISIBLE); //hides the button only because you don't wanna screw up the layout
            mButton2.setText("Play Again");
            mButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    finish(); //restarts the current instance of the app and restarts it
                }
            });

        } else {

            mButton1.setText(mCurrentPage.getChoice1().getText());
            mButton2.setText(mCurrentPage.getChoice2().getText());

            //set onclick listeners to determine choice
            mButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = mCurrentPage.getChoice1().getNextPage();
                    loadPage(nextPage);
                }
            });
            mButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = mCurrentPage.getChoice2().getNextPage();
                    loadPage(nextPage);
                }
            });
        }

    }
    /*

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        mClient.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Story Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://alam.naqib.dhruva.interactivestory.UI/http/host/path")
        );
        AppIndex.AppIndexApi.start(mClient, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Story Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://alam.naqib.dhruva.interactivestory.UI/http/host/path")
        );
        AppIndex.AppIndexApi.end(mClient, viewAction);
        mClient.disconnect();
    }
    */
}
