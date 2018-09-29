package com.jiyouliang.mywechat.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jiyouliang.mywechat.R;
import com.jiyouliang.mywechat.view.SideBar;


public class ContactFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private TextView mDialog;
    private SideBar mSideBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mDialog = (TextView) view.findViewById(R.id.dialog);
        mSideBar = (SideBar) view.findViewById(R.id.sideBar);
    }
}
