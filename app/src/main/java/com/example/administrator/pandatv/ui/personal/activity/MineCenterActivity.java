package com.example.administrator.pandatv.ui.personal.activity;


import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.pandatv.R;
import com.example.administrator.pandatv.base.BaseActivity;
import com.example.administrator.pandatv.net.OkHttpUtils;
import com.example.administrator.pandatv.utils.SharedPreferencesUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class MineCenterActivity extends BaseActivity {
    @BindView(R.id.personal_center_back)
    ImageButton back;
    @BindView(R.id.personalCenter_Signin)
    LinearLayout personalCenterSignin;
    @BindView(R.id.personalCenter_History)
    LinearLayout personalCenterHistory;
    @BindView(R.id.personalCenter_Collection)
    LinearLayout personalCenterCollection;
    @BindView(R.id.personalCenter_set)
    LinearLayout personalCenterSet;
    @BindView(R.id.activity_personal_center)
    LinearLayout activityPersonalCenter;
    @BindView(R.id.user_img)
    ImageView userImg;
    @BindView(R.id.user_nick)
    TextView userNick;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_personal_center;
    }

    @Override
    protected void init() {
        boolean login = SharedPreferencesUtils.getBoolean("login");
        if (login) {

            userImg.setImageResource(R.mipmap.tab_panda_live_normal);
            OkHttpUtils.getInstance().loadImage(SharedPreferencesUtils.getString("iconUrl"),userImg);
            userNick.setText(SharedPreferencesUtils.getString("nickName"));
        }
    }

    @OnClick({R.id.personal_center_back, R.id.personalCenter_Signin, R.id.personalCenter_History, R.id.personalCenter_Collection, R.id.personalCenter_set, R.id.activity_personal_center})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.personal_center_back:
                finish();
                break;
            case R.id.personalCenter_Signin:
                boolean login = SharedPreferencesUtils.getBoolean("login");
                if(login) {
                    Intent intent  = new Intent(MineCenterActivity.this, LoginSuccessActivity.class);
                    startActivity(intent);
                }else {
                    startActivity(new Intent(MineCenterActivity.this, LoginActivity.class));
                }
                break;
            case R.id.personalCenter_History:
                startActivity(new Intent(MineCenterActivity.this, HistoryActivity.class));
                break;
            case R.id.personalCenter_Collection:
                startActivity(new Intent(MineCenterActivity.this, CollectActivity.class));
                break;
            case R.id.personalCenter_set:
                startActivity(new Intent(MineCenterActivity.this, SetActivity.class));
                break;
        }
    }
}
