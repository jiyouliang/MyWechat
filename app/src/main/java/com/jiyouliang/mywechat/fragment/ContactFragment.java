package com.jiyouliang.mywechat.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jiyouliang.mywechat.R;
import com.jiyouliang.mywechat.adapter.ContactAdapter;
import com.jiyouliang.mywechat.model.ContactModel;
import com.jiyouliang.mywechat.util.PinyinUtils;
import com.jiyouliang.mywechat.view.SideBar;

import net.sourceforge.pinyin4j.PinyinHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ContactFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private TextView mDialog;
    private SideBar mSideBar;
    private ContactAdapter mAdapter;
    private List<ContactModel> mContactsList = new ArrayList<ContactModel>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mDialog = (TextView) view.findViewById(R.id.dialog);
        mSideBar = (SideBar) view.findViewById(R.id.sideBar);
    }

    private void initData() {
        String[] names = getContext().getResources().getStringArray(R.array.names);
        mContactsList.clear();
        for (String name : names) {
            ContactModel contact = new ContactModel();
            String pingYin = PinyinUtils.getPingYin(name);
            contact.name = name;
            contact.firstLetter = pingYin.substring(0, 1).toUpperCase();

            mContactsList.add(contact);
        }
        Collections.sort(mContactsList, new Comparator<ContactModel>() {
            @Override
            public int compare(ContactModel o1, ContactModel o2) {
                return o1.firstLetter.compareTo(o2.firstLetter);
            }
        });
        mAdapter = new ContactAdapter(mContactsList);
        mRecyclerView.setAdapter(mAdapter);
    }
}
