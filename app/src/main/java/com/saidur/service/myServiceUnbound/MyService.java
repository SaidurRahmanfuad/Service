package com.saidur.service.myServiceUnbound;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
//UnBound Service
public class MyService extends Service{
    private static final String tg="MyService";
    Notify notify;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        //notify.StartOrStop("Service Created");
        Toast.makeText(this, "Service Created", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service Started", Toast.LENGTH_SHORT).show();
       // notify.StartOrStop("Service Started");
        Log.d(tg, "onStartCommand: Service Started");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service Stop", Toast.LENGTH_SHORT).show();
        //notify.StartOrStop("Service Stop");
        super.onDestroy();
    }
}
