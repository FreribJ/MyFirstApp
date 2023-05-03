package com.example.myapplication5.Views;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication5.R;


public class ViewTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_test);
        setTitle("View Test");
    }

}