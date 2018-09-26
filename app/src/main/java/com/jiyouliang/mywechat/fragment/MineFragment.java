package com.jiyouliang.mywechat.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jiyouliang.mywechat.R;


public class MineFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        TextView tv = new TextView(getContext());
//        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
//        tv.setGravity(Gravity.CENTER);
//        tv.setTextColor(getResources().getColor(R.color.textNormal));
//        tv.setText("我的");
        View view = inflater.inflate(R.layout.fragment_mine, container, false);

        return view;
    }
}
