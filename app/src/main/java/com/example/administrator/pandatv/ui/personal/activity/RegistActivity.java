package com.example.administrator.pandatv.ui.personal.activity;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageButton;

import com.example.administrator.pandatv.R;
import com.example.administrator.pandatv.base.BaseActivity;
import com.example.administrator.pandatv.ui.personal.adapter.RegisterFragmentAdapter;
import com.example.administrator.pandatv.ui.personal.fragment.MailboxFragment;
import com.example.administrator.pandatv.ui.personal.fragment.PhoneFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class RegistActivity extends BaseActivity {
    @BindView(R.id.activity_register_back)
    ImageButton activityRegisterBack;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    private ArrayList<Fragment> fragmentArrayList;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void init() {
        fragmentArrayList = new ArrayList<>();

        PhoneFragment phoneFragment = new PhoneFragment();
        MailboxFragment mailboxFragment = new MailboxFragment();

        fragmentArrayList.add(phoneFragment);
        fragmentArrayList.add(mailboxFragment);

        RegisterFragmentAdapter registerFragmentAdapter = new RegisterFragmentAdapter(getSupportFragmentManager(), fragmentArrayList);
        viewPager.setAdapter(registerFragmentAdapter);

        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);


    }


    @OnClick(R.id.activity_register_back)
    public void onViewClicked() {
        finish();
    }
}
