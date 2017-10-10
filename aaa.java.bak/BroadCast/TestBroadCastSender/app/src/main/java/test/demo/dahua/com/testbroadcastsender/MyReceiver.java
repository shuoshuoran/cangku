package test.demo.dahua.com.testbroadcastsender;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by dragon on 2017/9/4.
 */

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = getResultExtras(false);
        Toast.makeText(context, extras.getString("data"), Toast.LENGTH_SHORT).show();

    }
}
