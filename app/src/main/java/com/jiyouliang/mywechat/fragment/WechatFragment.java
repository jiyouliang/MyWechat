package com.jiyouliang.mywechat.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jiyouliang.mywechat.R;
import com.jiyouliang.mywechat.adapter.WechatFragmentAdapter;


public class WechatFragment extends Fragment {

    private LinearLayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;
    private WechatFragmentAdapter mAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wechat, container, false);
        mRecyclerView = view.findViewById(R.id.rv_list);

        mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        //item divider
        DividerItemDecoration divider=new DividerItemDecoration(getContext(),mLayoutManager.getOrientation());
        divider.setDrawable(getContext().getResources().getDrawable(R.drawable.common_line));
        mRecyclerView.addItemDecoration(divider);

        mAdapter = new WechatFragmentAdapter();
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }
}
