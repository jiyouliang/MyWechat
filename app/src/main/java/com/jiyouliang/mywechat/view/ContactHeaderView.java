package com.jiyouliang.mywechat.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.jiyouliang.mywechat.R;

/**
 * Created by JiYouLiang on 2018/09/30.
 */

public class ContactHeaderView extends LinearLayout {
    public ContactHeaderView(Context context) {
        this(context, null, 0);
    }

    public ContactHeaderView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ContactHeaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.view_contact_header, this);
    }
}
