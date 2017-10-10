package com.example.administrator.flash;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    private ServiceConnection sc = new ServiceConnection() {


        @Override
        public void onServiceConnected(ComponentName name, IBinder iBinder) {
            Log.e(TAG, "onServiceConnected:");
            myBinder = (Mypalyer.MyBinder) iBinder;
            myBinder.sing();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    private Mypalyer.MyBinder myBinder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void close(View view) {
        Intent intent = new Intent();
        intent.setAction("com.example.administrator.flash");
        unbindService(sc);
        stopService(intent);
        myBinder = null;

    }

    public void before(View view) {

    }

    public void pause(View view) {
        Intent intent = new Intent();
        intent.setAction("com.example.administrator.flash");
        startService(intent);
        bindService(intent, sc, BIND_AUTO_CREATE);
        if (myBinder != null) {
            myBinder.sing();
        }
    }

    public void next(View view) {
        myBinder.next();
    }
}
