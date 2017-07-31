package com.example.administrator.pandatv.ui.personal.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.pandatv.R;
import com.example.administrator.pandatv.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by li on 2017/7/13.
 */

public class ForgetActivity extends BaseActivity {

    @BindView(R.id.forget_back)
    ImageButton fanhui;
    @BindView(R.id.edit_phonenumber)
    EditText editPhonenumber;
    @BindView(R.id.hint_phonenumber)
    TextView hintPhonenumber;
    @BindView(R.id.edit_checkimage)
    EditText editCheckimage;
    @BindView(R.id.personal_reg_imgcheck)
    TextView personalRegImgcheck;
    @BindView(R.id.hint_checkimage)
    TextView hintCheckimage;
    @BindView(R.id.edit_checkphone)
    EditText editCheckphone;
    @BindView(R.id.personal_reg_phonecheck)
    Button personalRegPhonecheck;
    @BindView(R.id.hint_checkphone)
    TextView hintCheckphone;
    @BindView(R.id.edit_newpssword)
    EditText editNewpssword;
    @BindView(R.id.hint_newpssword)
    TextView hintNewpssword;
    @BindView(R.id.tvfoundpswd)
    TextView tvfoundpswd;
    @BindView(R.id.activity_forget)
    LinearLayout activityForget;

    @Override
    public int getLayoutId() {
        return R.layout.activity_forget;
    }

    @Override
    protected void init() {

    }


    @OnClick({R.id.forget_back, R.id.personal_reg_imgcheck, R.id.personal_reg_phonecheck, R.id.tvfoundpswd})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.forget_back:
                finish();
                break;
            case R.id.personal_reg_imgcheck:
                break;
            case R.id.personal_reg_phonecheck:
                break;
            case R.id.tvfoundpswd:
                break;
        }
    }
}
