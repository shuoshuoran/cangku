package test.demo.dahua.com.testbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by dragon on 2017/9/4.
 */

public class MyBroadCastReceiver600 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
/*
        String data = intent.getStringExtra("data");
*/

        Bundle bundle = getResultExtras(false);
        String data = bundle.getString("data");
        Toast.makeText(context,data,Toast.LENGTH_SHORT).show();
        bundle.putString("data", "60");
         setResultExtras(bundle);
        abortBroadcast();




    }
}
