package com.jiyouliang.mywechat.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jiyouliang.mywechat.R;

/**
 * Created by JiYouLiang on 2018/09/27.
 */

public class WechatFragmentAdapter extends RecyclerView.Adapter<WechatFragmentAdapter.WechatViewHolder> {

    //关联布局文件
    @Override
    public WechatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.communicate_item_view_layout, parent, false);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return new WechatViewHolder(itemView);
    }

    //设置数据
    @Override
    public void onBindViewHolder(WechatViewHolder holder, int position) {

    }

    //item条数
    @Override
    public int getItemCount() {
        return 10;
    }

    public static class WechatViewHolder extends RecyclerView.ViewHolder{

        public WechatViewHolder(View itemView) {
            super(itemView);
            //初始化item的子view
            ImageView ivLogo = itemView.findViewById(R.id.iv_logo);

        }
    }
}
