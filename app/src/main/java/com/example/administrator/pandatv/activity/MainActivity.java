package com.example.administrator.pandatv.activity;

import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.administrator.pandatv.R;
import com.example.administrator.pandatv.base.BaseActivity;
import com.example.administrator.pandatv.ui.homepage.HomePageFragment;
import com.example.administrator.pandatv.ui.livechina.LiveChinaFragment;
import com.example.administrator.pandatv.ui.pandaculture.PandaCultureFragment;
import com.example.administrator.pandatv.ui.pandaeye.PandaEyeFragment;
import com.example.administrator.pandatv.ui.pandalive.PandaLiveFragment;
import com.example.administrator.pandatv.ui.personal.activity.MineCenterActivity;
import com.example.administrator.pandatv.widget.manager.ToastManager;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by Administrator on 2017/7/28.
 */

public class MainActivity extends BaseActivity {
    @BindView(R.id.iconImg)
    ImageView iconImg;
    @BindView(R.id.personImg)
    ImageView personImg;
    @BindView(R.id.titleTv)
    TextView titleTv;
    @BindView(R.id.hudongImg)
    ImageView hudongImg;
    @BindView(R.id.container)
    FrameLayout container;
    @BindView(R.id.homePage)
    RadioButton homePage;
    @BindView(R.id.pandaLive)
    RadioButton pandaLive;
    @BindView(R.id.pandaCulture)
    RadioButton pandaCulture;
    @BindView(R.id.pandaEye)
    RadioButton pandaEye;
    @BindView(R.id.liveChina)
    RadioButton liveChina;
    @BindView(R.id.homeBottomGroup)
    RadioGroup homeBottomGroup;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    private long lastTime;
    final int TYPE = 1;
    final int TWO = 2;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        changeFragment(HomePageFragment.class, R.id.container, true, null, false);
    }


    @OnClick({R.id.personImg, R.id.hudongImg, R.id.container, R.id.homePage, R.id.pandaLive, R.id.pandaCulture, R.id.pandaEye, R.id.liveChina})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.personImg:
                startActivity(new Intent(MainActivity.this, MineCenterActivity.class));
                break;
            case R.id.hudongImg:
                break;
            case R.id.homePage:
                showTitle(null, TYPE);
                changeFragment(HomePageFragment.class, R.id.container, true, null, false);
                break;
            case R.id.pandaLive:
                showTitle("熊猫直播", TWO);
                changeFragment(PandaLiveFragment.class, R.id.container, true, null, false);
                break;
            case R.id.pandaCulture:
                showTitle("熊猫文化", TWO);
                changeFragment(PandaCultureFragment.class, R.id.container, true, null, false);
                break;
            case R.id.pandaEye:
                showTitle("熊猫观察", TWO);
                changeFragment(PandaEyeFragment.class, R.id.container, true, null, false);
                break;
            case R.id.liveChina:
                showTitle("直播中国", TWO);
                changeFragment(LiveChinaFragment.class, R.id.container, true, null, false);
                break;
        }
    }

    private void showTitle(String title, int type) {
        if (type == TYPE) {
            iconImg.setVisibility(View.VISIBLE);
            titleTv.setVisibility(View.GONE);
            hudongImg.setVisibility(View.VISIBLE);
        } else  {
            titleTv.setText(title);
            iconImg.setVisibility(View.GONE);
            titleTv.setVisibility(View.VISIBLE);
            hudongImg.setVisibility(View.GONE);
        }

    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - lastTime < 2000) {
            finish();
        } else {
            ToastManager.show("再按一次退出应用");
            lastTime = System.currentTimeMillis();
        }
    }


}
