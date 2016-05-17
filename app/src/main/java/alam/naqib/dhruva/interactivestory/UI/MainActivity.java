package alam.naqib.dhruva.interactivestory.UI;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import alam.naqib.dhruva.interactivestory.R;

public class MainActivity extends AppCompatActivity {
    private EditText mNamePerson; //for the textfield for their name
    private Button mBegin; //for the button that starts the story

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get the object from the layout
        mNamePerson = (EditText)findViewById(R.id.nameEditText);
        mBegin = (Button) findViewById(R.id.startButton);

        //set the onclick listener to st start the story
        mBegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //for the line below, mNamePerson.getText() returns and edittext, which cannot be set to a string
                String userName = mNamePerson.getText().toString();

                if (userName.equals("")){
                    Toast.makeText(MainActivity.this, "Input a valid name.", Toast.LENGTH_LONG).show();
                } else {
                    startStory(userName); ///starts the next activity by launching method below
                }
                //checks what name is entered and toasts it Toast.makeText(MainActivity.this, userName, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void startStory(String name){
        //make new intent object
        Intent intent = new Intent(this, StoryActivity.class);
        intent.putExtra(getString(R.string.key_name), name); //sends the username to the next activity
        startActivity(intent);


    }
}
