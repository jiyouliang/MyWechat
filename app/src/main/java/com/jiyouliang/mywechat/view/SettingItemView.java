package com.jiyouliang.mywechat.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiyouliang.mywechat.R;

/**
 * Created by JiYouLiang on 2018/09/25.
 */

public class SettingItemView extends LinearLayout implements View.OnClickListener {
    public SettingItemView(Context context) {
        this(context, null);
    }

    public SettingItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View view = View.inflate(context, R.layout.setting_item_view_layout, this);
        view.setOnClickListener(this);


        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SettingItemView);
        Drawable background = a.getDrawable(R.styleable.SettingItemView_sivBackground);
        String title = a.getString(R.styleable.SettingItemView_sivTitle);
        boolean dividerEnable = a.getBoolean(R.styleable.SettingItemView_sivDividerEnable, true);

        a.recycle();
        //初始化view，设置内容
        ImageView ivIcon = findViewById(R.id.iv_icon);
        TextView tvTitle = findViewById(R.id.tv_title);
        View divider = findViewById(R.id.v_divider);

        ivIcon.setImageDrawable(background);
        tvTitle.setText(title);
        divider.setVisibility(dividerEnable ? View.VISIBLE : View.GONE);
    }

    public SettingItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onClick(View v) {

    }
}
