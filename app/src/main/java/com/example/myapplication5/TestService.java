package com.example.myapplication5;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class TestService extends Service {

    public Thread thread;
    public Intent intent;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        this.intent = intent;


        int i = this.intent.getIntExtra("fibo", 0);
        thread = new Thread(() -> {
            this.calculateFibo(i);
        });


        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public int calculateFibo(int i) {
        int fibo = i;
        Log.d("test", Integer.toString(fibo));
        return 1;
    }
}
