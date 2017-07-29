package com.example.administrator.pandatv.ui.login.activity;


import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.administrator.pandatv.R;
import com.example.administrator.pandatv.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class CollectActivity extends BaseActivity {
    @BindView(R.id.collect_back)
    ImageButton collectBack;
    @BindView(R.id.collect_set)
    TextView collectSet;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_collection;
    }

    @Override
    protected void init() {

    }

    @OnClick(R.id.collect_back)
    public void onViewClicked() {
    }
}
