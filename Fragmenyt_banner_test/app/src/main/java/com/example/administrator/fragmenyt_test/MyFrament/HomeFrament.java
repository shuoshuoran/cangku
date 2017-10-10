package com.example.administrator.fragmenyt_test.MyFrament;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.fragmenyt_test.MainActivity;
import com.example.administrator.fragmenyt_test.R;
import com.example.administrator.fragmenyt_test.SecondFragment;

import java.util.Random;

/**
 * Created by Administrator on 2017/9/20.
 */

public class HomeFrament extends Fragment {
    private static final String TAG = "HomeFrament";
    private View view;
    private Button bt_me;
    private TextView tv_home;
    private Button bt_home;
    private MainActivity MyActivity;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view=LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home,null);
        Bundle bundle = new Bundle();
        String str = bundle.getString("str","");
        MyActivity=(MainActivity)getActivity();
        bt_home = (Button) view.findViewById(R.id.bt_home);
        bt_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int i= random.nextInt();
                MyActivity.setText(i+"");

            }
        });
        tv_home = (TextView) view.findViewById(R.id.tv_home);
        tv_home.setText(str);

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e(TAG, "onDetach: ");
    }

    SecondFragment.OnButtonClickListenner onOnButtonClickListenner;

    public void setOnOnButtonClickListenner(SecondFragment.OnButtonClickListenner onOnButtonClickListenner) {
        this.onOnButtonClickListenner = onOnButtonClickListenner;
    }
    public void setFragmentText(String info){
        tv_home.setText(info);
    }
    public interface OnButtonClickListenner{
        void buttonClick(int i);
    }
}
