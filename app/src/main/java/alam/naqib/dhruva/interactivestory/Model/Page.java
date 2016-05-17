package alam.naqib.dhruva.interactivestory.Model;

/**
 * Created by naqib on 4/18/2016.
 */
public class Page {
    private int mImageId;
    private String mText;
    private boolean lastPage;

    //add choices as new member variables
    private Choice mChoice1;
    private Choice mChoice2;


    //for normal pages
    public Page(int imgId, String text, Choice a, Choice b){
        mImageId = imgId;
        mText = text;
        mChoice1 = a;
        mChoice2 = b;
        lastPage = false;

    }

    //for pages without any choices to choose from (last page)
    public Page(int imageId, String text){
        mImageId = imageId;
        mText = text;
        //initialize other choices to null
        mChoice1 = null;
        mChoice2 = null;
        lastPage = true;

    }

    public boolean isLastPage() {
        return lastPage;
    }

    public void setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
    }

    public int getImageId(){
        return mImageId;
    }
    public void setImageId(int id){
        mImageId = id;

    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public Choice getChoice1() {
        return mChoice1;
    }

    public void setChoice1(Choice choice1) {
        mChoice1 = choice1;
    }

    public Choice getChoice2() {
        return mChoice2;
    }

    public void setChoice2(Choice choice2) {
        mChoice2 = choice2;
    }
}
