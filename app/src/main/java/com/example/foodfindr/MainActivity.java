package com.example.foodfindr;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.os.Bundle;
import android.widget.Toast;

import com.example.foodfindr.ui.login.LoginActivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context;


        configureMapButton();
        configureLoginButton();
        configurePreferencesButton();
    }

    private void show() {
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

    @SuppressLint("NewApi")
    public Connection CONN() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String ConnURL = null;

        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnURL = "jdbc:jtds:sqlserver://foodfindr.database.windows.net:1433;DatabaseName=FoodFindr;user=FoodFindr@foodfindr;password=cs430Group6;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
            conn = DriverManager.getConnection(ConnURL);
        }
        catch (SQLException se) {
            Log.e("ERROR", se.getMessage());
        }
        catch (ClassNotFoundException e) {
            Log.e("ERROR", e.getMessage());
        }
        catch (Exception e) {
            Log.e("ERROR", e.getMessage());
        }
        return conn;
    }

}