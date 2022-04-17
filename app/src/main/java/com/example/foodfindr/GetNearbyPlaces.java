package com.example.foodfindr;

import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetNearbyPlaces extends AsyncTask<Object, String, String> {
    GoogleMap mMap;
    String url;
    String[] nearbyRestaurants;

    @Override
    protected String doInBackground(Object... params) {
        mMap = (GoogleMap)params[0];
        url = (String)params[1];
        InputStream is;
        BufferedReader bufferedReader;
        StringBuilder stringBuilder;
        String data;
        try {
            URL myurl = new URL(url);
            Log.d("GetNearbyPlaces", url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) myurl.openConnection();
            httpURLConnection.connect();
            is = httpURLConnection.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(is));
            String line = "";
            stringBuilder = new StringBuilder();
            while((line = bufferedReader.readLine())!=null){
                stringBuilder.append(line);
            }
            data = stringBuilder.toString();
            return data;

        }catch(MalformedURLException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        try{
            JSONObject parentObject = new JSONObject(s);//issue with s here
            JSONArray resultsArray = parentObject.getJSONArray("results");
            nearbyRestaurants = new String[resultsArray.length()];
            for(int i = 0; i < resultsArray.length(); i++){
                JSONObject jsonObject = resultsArray.getJSONObject(i);
                String name = jsonObject.getString("name");
                nearbyRestaurants[i] = name;
            }
        }catch(JSONException e){
            e.printStackTrace();
        }
        for(int i = 0; i < nearbyRestaurants.length; i++){
            Log.d("GetNearbyPlaces", nearbyRestaurants[i]);
        }
    }
}
