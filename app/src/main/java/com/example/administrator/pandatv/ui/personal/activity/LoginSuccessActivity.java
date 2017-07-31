package com.example.administrator.pandatv.ui.personal.activity;


import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.pandatv.R;
import com.example.administrator.pandatv.base.BaseActivity;
import com.example.administrator.pandatv.utils.SharedPreferencesUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginSuccessActivity extends BaseActivity {
    @BindView(R.id.success_xin_back)
    ImageButton successXinBack;
    @BindView(R.id.iv_headicon)
    ImageView ivHeadicon;
    @BindView(R.id.person_have_login_layout)
    RelativeLayout personHaveLoginLayout;
    @BindView(R.id.nick_name)
    TextView nickName;
    @BindView(R.id.personal_nickname_layout)
    RelativeLayout personalNicknameLayout;
    @BindView(R.id.btn_login_out)
    TextView btnLoginOut;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_personal_xin;
    }

    @Override
    protected void init() {
        boolean login = SharedPreferencesUtils.getBoolean("login");
        if(login) {
            ivHeadicon.setImageResource(R.mipmap.tab_panda_live_normal);
            nickName.setText(SharedPreferencesUtils.getString("nickName"));
        }
    }

    @OnClick({R.id.success_xin_back, R.id.person_have_login_layout, R.id.personal_nickname_layout,R.id.btn_login_out})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.success_xin_back:
                finish();
                break;
            case R.id.person_have_login_layout:
                break;
            case R.id.personal_nickname_layout:
                startActivity(new Intent(LoginSuccessActivity.this,UpdateNameActivity.class));
                break;
            case R.id.btn_login_out:
                SharedPreferencesUtils.putBoolean("login",false);
                startActivity(new Intent(LoginSuccessActivity.this,MineCenterActivity.class));
                break;
        }
    }
}
