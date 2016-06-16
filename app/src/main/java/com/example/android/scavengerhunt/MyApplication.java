package com.example.android.scavengerhunt;

import android.app.Application;

import com.example.android.scavengerhunt.DataObjects.Clue;


/**
 * Created by mrittika.barua on 6/11/2016.
 */

public class MyApplication extends Application {

    private Clue[] cluesArray;

    @Override
    public void onCreate()
    {
        super.onCreate();

        String[] clues = getResources().getStringArray(R.array.clues);

        int n = clues.length;
        cluesArray = new Clue[n];

        for(int i=0; i<n; i++)
        {
            Clue c = new Clue(clues[i], i);
            cluesArray[i] = c;
        }

        //Clue currentClue = cluesArray.get(0);
        //myClueTextView.setText(currentClue.getmClue());
    }

    public Clue[] getCLUES()
    {
        return cluesArray;
    }
}