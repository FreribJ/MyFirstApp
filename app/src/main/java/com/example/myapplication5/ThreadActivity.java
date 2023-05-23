package com.example.myapplication5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

public class ThreadActivity extends AppCompatActivity {

    TextView clock;
    boolean running = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        this.clock = findViewById(R.id.clockDisplay);

        new Thread(this::updateClock).start();

        Button stop = findViewById(R.id.threadButton1);
        stop.setOnClickListener(view -> {
            running = !running;
            if (running)
                new Thread(this::updateClock).start();
        });

        Button startService = findViewById(R.id.threadButton2);
        startService.setOnClickListener(view -> {
            Intent intent = new Intent(this, TestService.class);
            intent.putExtra("fibo", 5);
            startService(intent);
        });
    }

    void updateClock() {
        while (running) {
            try {
                Date d = new Date() ;
                clock.setText(d.getHours() + ":" +d.getMinutes() + ":" +d.getSeconds());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}