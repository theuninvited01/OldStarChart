package com.example.game_dude.mystarchart;

import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.EditText;

import java.util.Locale;

public class UserBirthPlaceLocation extends AppCompatActivity {

    WebView birthMap;
    EditText birthCityLbl;
    EditText birthLoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_birth_place_location);

        birthMap = (WebView)findViewById(R.id.birthLocator);
        birthCityLbl = (EditText)findViewById(R.id.userBirthLocLbl);
        birthLoc = (EditText)findViewById(R.id.userBirthLoc);

        Geocoder g = new Geocoder(this, Locale.getDefault());
    }
}
