package test.demo.dahua.com.testbroadcastsender;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by dragon on 2017/9/4.
 */

public class MySMSReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        abortBroadcast();

    }
}
