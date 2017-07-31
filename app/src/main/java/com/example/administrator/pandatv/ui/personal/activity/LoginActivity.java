package com.example.administrator.pandatv.ui.personal.activity;


import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.pandatv.R;
import com.example.administrator.pandatv.base.BaseActivity;
import com.example.administrator.pandatv.entity.LoginBean;
import com.example.administrator.pandatv.entity.NickNameBean;
import com.example.administrator.pandatv.ui.personal.contract.LoginContract;
import com.example.administrator.pandatv.ui.personal.contract.LoginPresenter;
import com.example.administrator.pandatv.utils.SharedPreferencesUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginContract.View {

    LoginContract.Presenter presenter;
    String jsonId;
    @BindView(R.id.login_back)
    ImageButton loginBack;
    @BindView(R.id.register)
    TextView register;
    @BindView(R.id.weixin)
    ImageView weixin;
    @BindView(R.id.qq)
    ImageView qq;
    @BindView(R.id.sina)
    ImageView sina;
    @BindView(R.id.login_name)
    EditText loginName;
    @BindView(R.id.login_pwd)
    EditText loginPwd;
    @BindView(R.id.forget)
    TextView forget;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.activity_login)
    LinearLayout activityLogin;
    @BindView(R.id.login_user)
    TextView loginUser;
    @BindView(R.id.login_password)
    TextView loginPassword;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void init() {
        new LoginPresenter(this);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void closeProgress() {

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showAccountTips(String msg) {
        loginUser.setText(msg);
    }

    @Override
    public void dismissAccountTips() {
        loginUser.setText("");
    }

    @Override
    public void showPwdTips(String msg) {
        loginPassword.setText(msg);
    }

    @Override
    public void dismissPwdTips(){
        loginPassword.setText("");
    }

    @Override
    public void showError(String error) {
        Toast.makeText(LoginActivity.this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setLoginBean(LoginBean bean) {
        Toast.makeText(LoginActivity.this, bean.getErrMsg(), Toast.LENGTH_SHORT).show();
        if(bean.getErrMsg().equals("成功")) {
            SharedPreferencesUtils.putBoolean("login",true);
            presenter.getUserTicket(bean.getUser_seq_id(), jsonId);
        }
    }

    @Override
    public void setJsessionid(String jsessionid) {
        jsonId = jsessionid;
    }

    @Override
    public void setNickNameBean(NickNameBean bean) {
        if(bean !=null) {
            SharedPreferencesUtils.putString("nickName",bean.getContent().getNickname());
            Intent intent = new Intent(LoginActivity.this, MineCenterActivity.class);
            intent.putExtra("userName",bean.getContent().getNickname());
            startActivity(intent);
        }
    }

    @OnClick({R.id.login_back, R.id.weixin, R.id.qq, R.id.sina, R.id.login,R.id.forget,R.id.login_user,R.id.register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_back:
                finish();
                break;
            case R.id.weixin:
                break;
            case R.id.qq:
                break;
            case R.id.sina:
                break;
            case R.id.login:
                presenter.login(loginName.getText().toString().trim(), loginPwd.getText().toString().trim());
                break;
            case R.id.forget:
                startActivity(new Intent(LoginActivity.this,ForgetActivity.class));
                break;
            case R.id.register:
                startActivity(new Intent(LoginActivity.this,RegistActivity.class));
                break;
        }
    }
}
