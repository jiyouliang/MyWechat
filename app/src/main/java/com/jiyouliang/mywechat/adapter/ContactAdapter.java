package com.jiyouliang.mywechat.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyouliang.mywechat.R;
import com.jiyouliang.mywechat.model.ContactModel;
import com.jiyouliang.mywechat.view.ContactHeaderView;
import com.jiyouliang.mywechat.view.ContactView;

import java.util.List;
import java.util.Random;

/**
 * Created by JiYouLiang on 2018/09/30.
 */

public class ContactAdapter extends RecyclerView.Adapter {

    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;
    private final List<ContactModel> mContactList;
    private Context mContext;
    private final int[] RES_ID = new int[]{R.drawable.friend1, R.drawable.friend2, R.drawable.friend3, R.drawable.friend4, R.drawable.friend5, R.drawable.friend6,
            R.drawable.friend7, R.drawable.friend8, R.drawable.friend9, R.drawable.friend10, R.drawable.friend11, R.drawable.friend12};

    public ContactAdapter(List<ContactModel> contactsList) {
        this.mContactList = contactsList;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        } else {
            return TYPE_NORMAL;
        }
//        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_contact, parent, false);
        if (viewType == TYPE_HEADER) {
            ContactHeaderView headerView = new ContactHeaderView(parent.getContext());
            this.mContext = parent.getContext();
            return new HeaderViewHolder(headerView);
        } else {
            ContactView view = new ContactView(parent.getContext());
            return new ContactViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        if (viewType == TYPE_HEADER) {
            return;
        } else if (viewType == TYPE_NORMAL) {
            //绑定数据
            ContactModel contact = mContactList.get(position);
            ((ContactViewHolder) holder).tvName.setText(contact.name);
            int rdm = new Random().nextInt(RES_ID.length);
            Drawable drawable = mContext.getResources().getDrawable(RES_ID[position % RES_ID.length]);
            ((ContactViewHolder) holder).ivLogo.setBackgroundDrawable(drawable);

        }
    }

    @Override
    public int getItemCount() {
        return mContactList.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivLogo;
        private TextView tvName;

        public ContactViewHolder(View itemView) {
            super(itemView);
            //初始化子view
            ivLogo = ((ContactView) itemView).getContactImageView();
            tvName = ((ContactView) itemView).getContactTextView();
        }
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {

        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }
}
