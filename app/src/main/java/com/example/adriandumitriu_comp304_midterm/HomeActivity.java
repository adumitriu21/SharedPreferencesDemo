package com.example.adriandumitriu_comp304_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    String yourName;
    TextView welcomeTxt;

    EditText soccerTxt;
    EditText tennisTxt;
    EditText basketballTxt;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String SOCCER_ATH = "soccer_ath";
    public static final String BASKETBALL_ATH = "basketball_ath";
    public static final String TENNIS_ATH = "tennis_ath";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        yourName = getIntent().getStringExtra("Your name");
        welcomeTxt = findViewById(R.id.welcome);
        welcomeTxt.setText(getString(R.string.welcome) + " " +  yourName+ "!");

        soccerTxt = findViewById(R.id.soccerAth);
        basketballTxt = findViewById(R.id.basketballAth);
        tennisTxt = findViewById(R.id.tennisAth);

        final Button soccerBtn = (Button) findViewById(R.id.soccerBtn);
        soccerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveSoccerAth();
            }
        });

        final Button basketballBtn = (Button) findViewById(R.id.basketballBtn);
        basketballBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveBasketballAth();
            }
        });

        final Button tennisBtn = (Button) findViewById(R.id.tennisBtn);
        tennisBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveTennisAth();
            }
        });


    }

    public void saveSoccerAth() {
        String soccer = soccerTxt.getText().toString();
        SharedPreferences sharedPref = getSharedPreferences("SHARED_PREFS" , Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(SOCCER_ATH , soccer);
        editor.apply();
        Toast.makeText(this, R.string.soccerAthSaved, Toast.LENGTH_SHORT).show();
    }

    public void saveBasketballAth() {
        String basketball = basketballTxt.getText().toString();
        SharedPreferences sharedPref = getSharedPreferences(SHARED_PREFS , Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(BASKETBALL_ATH , basketball);
        editor.apply();
        Toast.makeText(this, R.string.basketballAthSaved, Toast.LENGTH_SHORT).show();
    }

    public void saveTennisAth() {
        String tennis = tennisTxt.getText().toString();
        SharedPreferences sharedPref = getSharedPreferences(SHARED_PREFS , Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(TENNIS_ATH , tennis);
        editor.apply();
        Toast.makeText(this, R.string.tennisAthSaved, Toast.LENGTH_SHORT).show();
    }
}