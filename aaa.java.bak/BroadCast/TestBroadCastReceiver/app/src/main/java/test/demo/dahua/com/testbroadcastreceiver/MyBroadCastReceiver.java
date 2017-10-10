package test.demo.dahua.com.testbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by dragon on 2017/9/4.
 */

public class MyBroadCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
/*        Bundle extras = intent.getExtras();
        String data = extras.getString("data");
        Toast.makeText(context,data,Toast.LENGTH_SHORT).show();
        extras.putString("data","20");
        intent.putExtras(extras);*/



        Bundle bundle = getResultExtras(false);
        String data = bundle.getString("data");
        Toast.makeText(context,data,Toast.LENGTH_SHORT).show();
        bundle.putString("data", "20");
        setResultExtras(bundle);







    }
}
