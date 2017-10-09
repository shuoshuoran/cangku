package test.demo.dahua.com.testview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG ="MainActivity" ;
    private CountDownView cdv_01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cdv_01 = (CountDownView) findViewById(R.id.cdv_01);
        cdv_01.setTime(3);

        cdv_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "onClick: " );
            }
        });

        cdv_01.setOnCountDownListenner(new CountDownView.onCountDownListenner() {
            @Override
            public void countDown(int time) {
                Log.e(TAG, "countDown: "+time );
            }
        });
    }

    public void go(View view) {
        startActivity(new Intent(this,SecondActivity.class));
        cdv_01.destorySelf();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cdv_01.destorySelf();

    }
}
