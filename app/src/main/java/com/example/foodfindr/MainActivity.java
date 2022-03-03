package com.example.foodfindr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.os.Bundle;

import com.example.foodfindr.ui.login.LoginActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureMapButton();
        configureLoginButton();
        configurePreferencesButton();
    }

    private void configureMapButton(){
        Button mapButton = (Button) findViewById(R.id.mapButton);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                startActivity(new Intent(MainActivity.this, MapsActivity.class));
            }
        });
    }

    private void configureLoginButton(){
        Button mapButton = (Button) findViewById(R.id.loginButton);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });
    }

    private void configurePreferencesButton(){
        Button mapButton = (Button) findViewById(R.id.preferencesButton);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                startActivity(new Intent(MainActivity.this, PreferencesActivity.class));
            }
        });
    }
}