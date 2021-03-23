package com.example.android.fetch;

public class Word {
    private String mCategorySelection;
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String categorySelection){
        mCategorySelection = categorySelection;

    }
    public Word(String categorySelection, int imageResourceId){
        mCategorySelection = categorySelection;
        mImageResourceId = imageResourceId;

    }

    public String getCategorySelection() {
        return mCategorySelection;
    }

    public int getImageResourceId() { return mImageResourceId; }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mCategorySelection='" + mCategorySelection + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                '}';
    }
}
