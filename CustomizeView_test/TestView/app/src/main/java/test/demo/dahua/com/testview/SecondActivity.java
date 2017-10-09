package test.demo.dahua.com.testview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/**
 * Created by dragon on 2017/9/25.
 */
public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "SecondActivity";
    private MyToggleButtom mtb_01;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mtb_01 = (MyToggleButtom) findViewById(R.id.mtb_01);

       mtb_01.setOnStateChangeListenner(new MyToggleButtom.onStateChangeListenner() {
           @Override
           public void stateChange(MyToggleButtom.State state) {
               if(state== MyToggleButtom.State.OFF){
                   Log.e(TAG, "stateChange: " +false);
               }else {
                   Log.e(TAG, "stateChange: " +true);
               }

           }
       });
    }

    public void back(View view){
        startActivity(new Intent(this,MainActivity.class));

    }
}
