package com.example.android.scavengerhunt;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.android.scavengerhunt.DataObjects.Clue;

public class FoundClueActivity extends AppCompatActivity {

    int clueFound;
    public static int CLUE;
    int clueLookingFor;
    //String str1 = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_found_clue);


        Intent intent = getIntent();
        Uri uri = intent.getData();
        clueFound = Integer.parseInt(uri.getLastPathSegment());

        //int clueNumber = CLUE;

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        clueLookingFor = sharedPreferences.getInt(Clue.CLUEKEY, CLUE);

        if (clueFound == clueLookingFor) {
            TextView clue_0 = (TextView) findViewById(R.id.clue_found_text_view);
            clue_0.setText("You found clue no. " + clueFound + "!");
            CLUE++;

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(Clue.CLUEKEY, CLUE);
            editor.commit();

            if(clueLookingFor == 2 && CLUE == 3 && clueFound == clueLookingFor) {
                Intent intent2 = new Intent(this, WinActivity.class);
                startActivity(intent2);
            }
        }

        else
        {
            TextView clue_0 = (TextView) findViewById(R.id.clue_found_text_view);
            clue_0.setText("Whoops! Wrong clue!");
        }


    }

    public void goToNextActivity(View view){

        if (clueFound == clueLookingFor && CLUE<3) {

            Intent intent1 = new Intent(this, CurrentClueActivity.class);
            startActivity(intent1);
        }
        else if(clueFound != clueLookingFor && CLUE<3)
        {
            Intent intent1 = new Intent(this, CurrentClueActivity.class);
            startActivity(intent1);
        }
    }

    //else {
    //TextView clue_1 = (TextView) findViewById(R.id.clue01);
    //clue_1.setText("You found clue no. 1!");}

}





