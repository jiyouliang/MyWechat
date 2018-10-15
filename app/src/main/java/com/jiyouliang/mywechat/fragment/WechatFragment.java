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
    private String[] TITLES = new String[]{"堂妹", "UI设计交流群", "微信支付", "梁紫美", "吉彦易-产品经理", "UI设计组群",
            "携程旅行网", "招商银行", "玮哥", "交互设计师", "汽车设计-董师", "高三班-杨阬", "朗哥"};

    private String[] DESC = new String[]{"堂姐吃饭了没？", "【链接】Sketch必备高大上技能", "微信支付凭证", "收到，谢谢啦！", "这是今天开会的资料", "UI组长:下午2:30开会哦！",
            "机票预订成功通知", "【链接】告诉你个发家致富的秘密！", "【红包】中秋节快乐", "这个效果挺好玩的哦！", "【连接】全球十大豪车品牌设计！","过年有没有空哦，出来聚聚", "【连接】面膜优惠促销！"};

    private int[] RES_IDS = new int[]{R.drawable.friend4, R.drawable.ui_designer_group,
            R.drawable.wechat_pay, R.drawable.friend2, R.drawable.friend1, R.drawable.group2,
            R.drawable.logo_ctrip, R.drawable.dianxin, R.drawable.friend3,
            R.drawable.friend4, R.drawable.friend5, R.drawable.friend6, R.drawable.friend7};
    private boolean[] MSG_STATUS = new boolean[]{false, false, true, false, false, true, true, true, true, true, true, true, true};


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
