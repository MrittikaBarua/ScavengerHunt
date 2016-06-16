package com.example.android.scavengerhunt.DataObjects;

/**
 * Created by mrittika.barua on 6/11/2016.
 */
public class Clue {

   private String mClue;
   private int mId;
   public static final String CLUEKEY ="clueKey";

    public Clue(String mClue,int mId ){
        this.mClue = mClue;
        this.mId=mId;
    }
    public String getmClue(){
        return mClue;
    }

    public int getmId(){
        return mId;
    }

}
