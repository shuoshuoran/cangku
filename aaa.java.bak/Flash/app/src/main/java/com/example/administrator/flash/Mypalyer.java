package com.example.administrator.flash;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.File;
import java.io.IOException;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2017/9/6.
 */

public class Mypalyer extends Service {
    private MediaPlayer mp;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    class MyBinder extends Binder {
        public void sing() {
            onsing();

        }

        public void next() {
            onnext();

        }
    }

    @Override
    public boolean onUnbind(Intent intent) {
        mp.release();
        mp = null;

        return super.onUnbind(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreat: ");


        mp = new MediaPlayer();
        File f = new File(getFilesDir(), "aa.mp3");
        try {
            mp.setDataSource(f.getAbsolutePath());
            mp.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void onsing() {
        if (mp.isPlaying()) {
            mp.pause();
        } else {
            mp.start();
        }

    }

    public void onnext() {
        mp.stop();
        mp = new MediaPlayer();
        File f = new File(getFilesDir(), "bb.mp3");
        try {
            mp.setDataSource(f.getAbsolutePath());
            mp.prepare();
            mp.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void onDestroy() {
        super.onDestroy();
    }
}
