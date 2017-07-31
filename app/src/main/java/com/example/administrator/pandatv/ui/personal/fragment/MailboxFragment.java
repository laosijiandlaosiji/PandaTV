package com.example.administrator.pandatv.ui.personal.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.pandatv.R;
import com.example.administrator.pandatv.base.BaseFragment;
import com.example.administrator.pandatv.ui.personal.activity.LoginActivity;
import com.example.administrator.pandatv.ui.personal.contract.RegisterContract;
import com.example.administrator.pandatv.ui.personal.contract.RegisterPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by li on 2017/7/13.
 */

public class MailboxFragment extends BaseFragment implements RegisterContract.View {
    @BindView(R.id.edit_email)
    EditText editEmail;
    @BindView(R.id.hint_email)
    TextView hintEmail;
    @BindView(R.id.edit_passwrok)
    EditText editPasswrok;
    @BindView(R.id.hint_password)
    TextView hintPassword;
    @BindView(R.id.edit_again_password)
    EditText editAgainPassword;
    @BindView(R.id.hint_again_password)
    TextView hintAgainPassword;
    @BindView(R.id.edit_yanzhengma)
    EditText editYanzhengma;
    @BindView(R.id.email_personal_reg_imgcheck)
    ImageView personalRegImgcheck;
    @BindView(R.id.hint_yanzhengma)
    TextView hintYanzhengma;
    @BindView(R.id.xieyi_check)
    CheckBox xieyiCheck;
    @BindView(R.id.personal_reg_xieyi_view)
    TextView personalRegXieyiView;
    @BindView(R.id.hint_xieyi)
    TextView hintXieyi;
    @BindView(R.id.btn_register)
    TextView btnRegister;

    RegisterContract.Presenter presenter;
    private ImageView imageView;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            presenter.start();
        }
    };

    @Override
    protected int getLayoutId() {
        return R.layout.mailboxfragment;
    }

    @Override
    protected void init(View view) {
        imageView = (ImageView) view.findViewById(R.id.email_personal_reg_imgcheck);
        new RegisterPresenter(this);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.start();
            }
        });
    }

    @Override
    protected void loadData() {
//        presenter.start();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser) {
            handler.sendEmptyMessage(2000);
        }
    }

    @OnClick({ R.id.btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
//            case R.id.personal_reg_imgcheck:
//                presenter.start();
//                break;
            case R.id.btn_register:
                presenter.emailRegister(editEmail.getText().toString().trim(),
                        editPasswrok.getText().toString().trim(),
                        editYanzhengma.getText().toString().trim());
                break;
        }
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void closeProgress() {

    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(RegisterContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showImageCode(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
    }

    @Override
    public void showEmailTips(String msg) {

    }

    @Override
    public void dismissEmailTips() {

    }

    @Override
    public void showPwdTips(String msg) {

    }

    @Override
    public void dismissPwdTips() {

    }

    @Override
    public void toLogin() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void showError(String error) {

    }
}
