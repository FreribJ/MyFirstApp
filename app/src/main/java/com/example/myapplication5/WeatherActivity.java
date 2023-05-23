package com.example.myapplication5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherActivity extends AppCompatActivity {

    EditText input;
    Button button;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        input = findViewById(R.id.RESTInput);
        output = findViewById(R.id.RESTOutput);
        button = findViewById(R.id.startREST);

        button.setOnClickListener(view -> new Thread(()-> {
            this.getInformation(input.getText().toString());
        }).start());
    }

    void getInformation(String param) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL("https://api.frankfurter.app/latest?from=" + param).openConnection();

            StringBuilder stringBuilder = new StringBuilder();
            new BufferedReader(new InputStreamReader(connection.getInputStream())).lines().forEach(stringBuilder::append);
            JSONObject jsonObject = new JSONObject(stringBuilder.toString());

            runOnUiThread(() -> {
                try {
                    output.setText(jsonObject.getJSONObject("rates").getString("EUR"));
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

            });


        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }
    }
}