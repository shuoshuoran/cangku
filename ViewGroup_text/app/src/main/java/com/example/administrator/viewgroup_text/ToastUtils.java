package com.example.administrator.viewgroup_text;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/9/28.
 */
public class ToastUtils {
   private static Toast toast;
    public static void setToast(Context context, String string) {
        if (toast == null) {
            toast = Toast.makeText(context, string, Toast.LENGTH_SHORT);
            toast.show();
        } else {
            toast.setText(string);
            toast.show();
        }
    }

}
