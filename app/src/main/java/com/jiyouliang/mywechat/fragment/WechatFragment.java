package com.jiyouliang.mywechat.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiyouliang.mywechat.R;
import com.jiyouliang.mywechat.adapter.WechatFragmentAdapter;
import com.jiyouliang.mywechat.model.CommunicateInfo;

import java.util.ArrayList;
import java.util.List;


public class WechatFragment extends Fragment {

    private LinearLayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;
    private WechatFragmentAdapter mAdapter;
    private List<CommunicateInfo> mDatas = new ArrayList<CommunicateInfo>();
    private String[] TITLES = new String[]{"UI设计交流群", "微信支付", "梁紫美", "吉彦易-产品经理", "UI设计组群", "携程旅行网", "招商银行"};
    private String[] DESC = new String[]{"【链接】Sketch必备高大上技能", "微信支付凭证", "帮我设计这个logo", "这是今天开会的资料", "UI组长:下午2:30开会哦！", "机票预订成功通知", "【链接】告诉你个发家致富的秘密"};
    private int[] RES_IDS = new int[]{R.drawable.ui_designer_group, R.drawable.wechat_pay, R.drawable.friend2, R.drawable.friend1, R.drawable.group2, R.drawable.logo_ctrip, R.drawable.dianxin};
    private boolean[] MSG_STATUS = new boolean[]{false, true, false, false, true, true, true};


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wechat, container, false);
        mRecyclerView = view.findViewById(R.id.rv_list);

        mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        //item divider
        DividerItemDecoration divider = new DividerItemDecoration(getContext(), mLayoutManager.getOrientation());
        divider.setDrawable(getContext().getResources().getDrawable(R.drawable.common_line));
        mRecyclerView.addItemDecoration(divider);

        initData();

        return view;
    }

    private void initData() {
        mDatas.clear();
        for (int i = 0; i < TITLES.length; i++) {
            CommunicateInfo info = new CommunicateInfo();
            info.title = TITLES[i];
            info.desc = DESC[i];
            info.drawable_id = RES_IDS[i];
            info.msg_status = MSG_STATUS[i];
            mDatas.add(info);
        }
        mAdapter = new WechatFragmentAdapter(mDatas);
        mRecyclerView.setAdapter(mAdapter);
    }
}
