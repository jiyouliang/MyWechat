package com.jiyouliang.mywechat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.jiyouliang.mywechat.R;

/**
 * Created by JiYouLiang on 2018/09/25.
 */

public class AccountInfoView extends RelativeLayout {
    public AccountInfoView(Context context) {
        this(context, null);
    }

    public AccountInfoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View.inflate(context, R.layout.account_info_view_layout, this);
    }

    public AccountInfoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
