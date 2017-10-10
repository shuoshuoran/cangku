package test.demo.dahua.com.testbroadcastsender;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_send = (Button) findViewById(R.id.btn_send);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED){

                    //有权限

                    Toast.makeText(MainActivity.this, "已经有权限了", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivity(intent);


                }else{

                    // 没有

                    ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CAMERA},1);

                }
               /* Intent intent = new Intent();
                intent.setAction("MMMM");
                Bundle bundle = new Bundle();
                bundle.putString("data","100");
                intent.putExtras(bundle);
                sendOrderedBroadcast(intent, null, new MyReceiver(), null, 0, null, bundle);*/
            }
        });


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "同意", Toast.LENGTH_SHORT).show();


            Toast.makeText(this, "已经有权限了", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent();
            intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(intent);

        }else{
            Toast.makeText(this, "拒绝", Toast.LENGTH_SHORT).show();
        }
    }
}
