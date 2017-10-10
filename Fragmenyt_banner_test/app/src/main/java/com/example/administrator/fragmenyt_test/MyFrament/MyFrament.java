package com.example.administrator.fragmenyt_test.MyFrament;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.administrator.fragmenyt_test.MainActivity;
import com.example.administrator.fragmenyt_test.R;

import java.util.Random;

/**
 * Created by Administrator on 2017/9/20.
 */

public class MyFrament extends Fragment {
    private Button bt_me;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
         final MainActivity mainActivity = (MainActivity) getActivity();
        view = LayoutInflater.from(getActivity()).inflate(R.layout.frament_me, null);
        bt_me = (Button) view.findViewById(R.id.bt_me);
        bt_me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int i=random.nextInt();
                mainActivity.setFragmentText(i+"");
            }
        });

        return view;
    }
}
