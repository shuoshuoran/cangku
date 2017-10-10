package com.example.administrator.fragmenyt_test;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Administrator on 2017/9/19.
 */

public class SecondFragment extends Fragment {
    private Button fl_replace;
    private RadioButton bt_first;
    private TextView tv_01;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.second, null);
        tv_01 = (TextView) view.findViewById(R.id.tv_01);
        Bundle bundle = getArguments();
        String str = bundle.getString("str");
        MainActivity mainActivity= (MainActivity) getActivity();
        tv_01.setText(str);


        fl_replace = (Button) view.findViewById(R.id.fl_replace);

        fl_replace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int x = random.nextInt();

                if(onButtonClickListenner!=null){
                    onButtonClickListenner.buttonClick(x);
                }

            }
        });



        return view;

    }

    OnButtonClickListenner onButtonClickListenner;

    public void setOnButtonClickListenner(OnButtonClickListenner onButtonClickListenner) {
        this.onButtonClickListenner = onButtonClickListenner;
    }

    public interface OnButtonClickListenner{
        void buttonClick(int num);
    }

}

