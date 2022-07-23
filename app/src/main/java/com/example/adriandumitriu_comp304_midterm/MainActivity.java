package com.example.adriandumitriu_comp304_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String SOCCER_ATH = "soccer_ath";
    public static final String BASKETBALL_ATH = "basketball_ath";
    public static final String TENNIS_ATH = "tennis_ath";
    private String getSoccerAth;
    private String getBasketballAth;
    private String getTennisAth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    public void proceedToAthleteName(View view) {
        editText = (EditText) findViewById(R.id.yourName);
        String yourName = editText.getText().toString();
        if (!yourName.matches("")) {
            Intent intent = new Intent(this, HomeActivity.class);
            intent.putExtra("Your name", yourName);
            startActivity(intent);
        } else {
            Toast.makeText(this, R.string.noName, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.soccer:
                loadSoccerAthlete();
                Toast.makeText(this, getString(R.string.savedSoccerAthlete, getSoccerAth), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.basketball:
                loadBasketballAthlete();
                Toast.makeText(this, getString(R.string.savedBasketballAthlete, getBasketballAth), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.tennis:
                loadTennisAthlete();
                Toast.makeText(this, getString(R.string.savedTennisAthlete, getTennisAth), Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



    public void loadSoccerAthlete(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        getSoccerAth = sharedPreferences.getString(SOCCER_ATH, "DEFAULT");
    }

    public void loadBasketballAthlete(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        getBasketballAth = sharedPreferences.getString(BASKETBALL_ATH, "DEFAULT");
    }

    public void loadTennisAthlete(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        getTennisAth = sharedPreferences.getString(TENNIS_ATH, "DEFAULT");
    }

}