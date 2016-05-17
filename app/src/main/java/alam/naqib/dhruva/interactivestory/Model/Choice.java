package alam.naqib.dhruva.interactivestory.Model;

/**
 * Created by naqib on 4/18/2016.
 */
public class Choice {
    private String mText; //the text
    private int mNextPage;


    //constructor
    public Choice(String text, int NextPage){
        mText =text;
        mNextPage = NextPage;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public int getNextPage() {
        return mNextPage;
    }

    public void setNextPage(int nextPage) {
        mNextPage = nextPage;
    }
}
