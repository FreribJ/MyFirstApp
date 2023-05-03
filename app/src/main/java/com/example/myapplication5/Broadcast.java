package com.example.myapplication5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class Broadcast extends AppCompatActivity {

    private final String CHANNEL_ID = "main_01";
    private final int NOTIFICATION_ID = 12345;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);

        NotificationManagerCompat manager = NotificationManagerCompat.from(this);
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Testbenachrichtigung", NotificationManager.IMPORTANCE_DEFAULT);
        manager.createNotificationChannel(channel);


        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(view -> {
            this.showSnackbar();
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(view -> {
            this.sendNotification("Beispiel", "Das ist eine Beispielbenachrichtigung");
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void showSnackbar() {
        Snackbar.make(findViewById(android.R.id.content), "Hungrig?!?", Snackbar.LENGTH_LONG)
                .setAction("Iss ein Snickers!", v -> {
//                    Toast.makeText(this, "Snickers", Toast.LENGTH_SHORT).show();
                    this.sendNotification("Lieferung!", "Hier ist ein Snickers!");
                })
                .show();
    }

    public void sendNotification(String title, String message) {
        PendingIntent intent = PendingIntent.getActivity(this, 0, new Intent(this, NavigationActivity.class).setAction(Intent.ACTION_VIEW), PendingIntent.FLAG_UPDATE_CURRENT + PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        builder.setSmallIcon(R.mipmap.ic_launcher_round);
        builder.setContentIntent(intent);
        builder.setContentTitle(title);
        builder.setContentText(message);
        NotificationManagerCompat manager = NotificationManagerCompat.from(this);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        manager.notify(NOTIFICATION_ID, builder.build());
        }


    }