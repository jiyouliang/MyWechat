package com.jiyouliang.mywechat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiyouliang.mywechat.fragment.ContactFragment;
import com.jiyouliang.mywechat.fragment.DiscoveryFragment;
import com.jiyouliang.mywechat.fragment.MineFragment;
import com.jiyouliang.mywechat.fragment.WechatFragment;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private LinearLayout mLlWechat;
    private LinearLayout mLlContact;
    private LinearLayout mLlDiscovery;
    private LinearLayout mLlMine;
    private ViewPager mViewPager;
    private WechatAdapter mAdapter;
    private List<Fragment> mFragmentList = new ArrayList<Fragment>();
    private Toolbar mToolbar;
    private ImageView mIvWechat;
    private TextView mTvWechat;
    private TextView mTvContact;
    private ImageView mIvContact;
    private TextView mTvDiscovery;
    private ImageView mIvDiscovery;
    private TextView mTvMine;
    private ImageView mIvMine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    /**
     * 初始化控件
     */
    private void initView() {
        mLlWechat = (LinearLayout) findViewById(R.id.ll_wechat);
        mLlContact = (LinearLayout) findViewById(R.id.ll_contact);
        mLlDiscovery = (LinearLayout) findViewById(R.id.ll_discovery);
        mLlMine = (LinearLayout) findViewById(R.id.ll_mine);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mToolbar = (Toolbar)findViewById(R.id.toolbar);

        mIvWechat = (ImageView) mLlWechat.findViewById(R.id.iv_wechat);
        mTvWechat = (TextView) mLlWechat.getChildAt(1);
        mTvWechat.setActivated(true);
        mIvWechat.setActivated(true);

        mIvContact = (ImageView) mLlContact.getChildAt(0);
        mTvContact = (TextView) mLlContact.getChildAt(1);
        mIvDiscovery = (ImageView) mLlDiscovery.getChildAt(0);
        mTvDiscovery = (TextView) mLlDiscovery.getChildAt(1);
        mIvMine = (ImageView) mLlMine.getChildAt(0);
        mTvMine = (TextView) mLlMine.getChildAt(1);

//        mToolbar.setNavigationIcon(R.drawable.add);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);//避免toolbar默认标题占位
        setListener();
    }

    private void initData() {
        WechatFragment wechatFragment = new WechatFragment();
        ContactFragment contactFragment = new ContactFragment();
        DiscoveryFragment discoveryFragment = new DiscoveryFragment();
        MineFragment mineFragment = new MineFragment();

        mFragmentList.add(wechatFragment);
        mFragmentList.add(contactFragment);
        mFragmentList.add(discoveryFragment);
        mFragmentList.add(mineFragment);

        mAdapter = new WechatAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
    }

    /**
     * 点击监听
     */
    private void setListener() {
        mLlWechat.setOnClickListener(MainActivity.this);
        mLlContact.setOnClickListener(MainActivity.this);
        mLlDiscovery.setOnClickListener(MainActivity.this);
        mLlMine.setOnClickListener(MainActivity.this);
        mViewPager.setOnPageChangeListener(MainActivity.this);
    }

    @Override
    public void onClick(View v) {
        resetTab();
        if (v == mLlWechat) {
            showWechatTab();
            mViewPager.setCurrentItem(0);
        } else if (v == mLlContact) {
            showContactTab();
            mViewPager.setCurrentItem(1);
        } else if (v == mLlDiscovery) {
            showDiscoveryTab();
            mViewPager.setCurrentItem(2);
        } else if (v == mLlMine) {
            showMineTab();
            mViewPager.setCurrentItem(3);
        }
    }

    private void showWechatTab() {
        mTvWechat.setActivated(true);
        mIvWechat.setActivated(true);
    }

    private void showContactTab() {
        mIvContact.setActivated(true);
        mTvContact.setActivated(true);
    }

    private void showDiscoveryTab() {
        mIvDiscovery.setActivated(true);
        mTvDiscovery.setActivated(true);
    }

    private void showMineTab() {
        mTvMine.setActivated(true);
        mIvMine.setActivated(true);
    }

    /**
     * 重置底部导航样式
     */
    private void resetTab() {
        mTvWechat.setActivated(false);
        mIvWechat.setActivated(false);
        mTvContact.setActivated(false);
        mIvContact.setActivated(false);
        mTvDiscovery.setActivated(false);
        mIvDiscovery.setActivated(false);
        mIvMine.setActivated(false);
        mTvMine.setActivated(false);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        resetTab();
        switch (position) {
            case 0:
                showWechatTab();
                break;
            case 1:
                showContactTab();
                break;
            case 2:
                showDiscoveryTab();
                break;
            case 3:
                showMineTab();
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private class WechatAdapter extends FragmentPagerAdapter {

        public WechatAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("RestrictedApi")
    @Override
    //解决menu icon不显示问题
    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        if (menu != null) {
            if (menu.getClass() == MenuBuilder.class) {
                try {
                    Method m = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);
                } catch (Exception e) {
//                    e.print(getClass().getSimpleName() + "onMenuOpened...unable to set icons for overflow menu" + e);
                }
            }
        }
        return super.onPrepareOptionsPanel(view, menu);
    };
}
