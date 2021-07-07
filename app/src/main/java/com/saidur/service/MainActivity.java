package com.saidur.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.saidur.service.myServiceUnbound.BackgroundPService;
import com.saidur.service.myServiceUnbound.MyService;
import com.saidur.service.myServiceUnbound.Notify;

public class MainActivity extends AppCompatActivity implements Notify, View.OnClickListener {
private Button play,stop;
private TextView msgtv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        play=findViewById(R.id.play);
        stop=findViewById(R.id.stop);
        msgtv=findViewById(R.id.msg);

        play.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    public void StartService(View view) {
        startService(new Intent(MainActivity.this, MyService.class));
    }

    public void StopService(View view) {
        stopService(new Intent(MainActivity.this,MyService.class));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.play:
startService(new Intent(MainActivity.this, BackgroundPService.class));
                break;

            case R.id.stop:
                stopService(new Intent(MainActivity.this, BackgroundPService.class));
                break;
        }
    }

    @Override
    public void StartOrStop(String msg) {
        msgtv.setText(msg);
    }
}