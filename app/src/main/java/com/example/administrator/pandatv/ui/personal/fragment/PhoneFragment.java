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

import com.example.administrator.pandatv.R;
import com.example.administrator.pandatv.base.BaseFragment;
import com.example.administrator.pandatv.ui.personal.activity.LoginActivity;
import com.example.administrator.pandatv.ui.personal.contract.RegisterContract;
import com.example.administrator.pandatv.ui.personal.contract.RegisterPresenter;
import com.example.administrator.pandatv.widget.manager.ToastManager;
import com.example.administrator.pandatv.widget.view.CustomDialog;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by li on 2017/7/13.
 */

public class PhoneFragment extends BaseFragment implements RegisterContract.View{

    @BindView(R.id.edit_phone)
    EditText editPhone;
    @BindView(R.id.null_phone)
    TextView nullPhone;
    @BindView(R.id.edit_imgyanzhengma)
    EditText editImgyanzhengma;
    @BindView(R.id.personal_reg_imgVerification)
    ImageView personalRegImgcheck;
    @BindView(R.id.null_imagecheck)
    TextView nullImagecheck;
    @BindView(R.id.edit_phoneyanzhengma)
    EditText editPhoneyanzhengma;
    @BindView(R.id.personal_reg_phone_VerificationCode)
    TextView personalRegPhonecheck;
    @BindView(R.id.null_phonecheck)
    TextView nullPhonecheck;
    @BindView(R.id.edit_inputpasswrod)
    EditText editInputpasswrod;
    @BindView(R.id.hint_password)
    TextView hintPassword;
    @BindView(R.id.xieyi_check)
    CheckBox xieyiCheck;
    @BindView(R.id.personal_reg_xieyi_view)
    TextView personalRegXieyiView;
    @BindView(R.id.hint_xieyi)
    TextView hintXieyi;
    @BindView(R.id.btn_register)
    TextView btnRegister;
    private RegisterContract.Presenter presenter;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            presenter.start();
        }
    };

    @Override
    protected int getLayoutId() {
        return R.layout.phonefragment;
    }

    @Override
    protected void init(View view) {
        new RegisterPresenter(this);
    }

    @Override
    protected void loadData() {
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser) {
            handler.sendEmptyMessage(1000);
        }
    }

    @OnClick({R.id.personal_reg_phone_VerificationCode, R.id.btn_register,R.id.personal_reg_imgVerification})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.personal_reg_phone_VerificationCode:
                presenter.phoneVerifiCodeRegister(editPhone.getText().toString().trim(),
                        editImgyanzhengma.getText().toString().trim());
                break;
            case R.id.btn_register:
                presenter.phoneRegisters(editPhone.getText().toString().trim(),
                        editInputpasswrod.getText().toString().trim(),
                        editPhoneyanzhengma.getText().toString());
                break;
            case R.id.personal_reg_imgVerification:
                handler.sendEmptyMessage(1000);
                break;
        }
    }

    @Override
    public void showProgress() {
        CustomDialog.show(getActivity());
    }

    @Override
    public void closeProgress() {
        CustomDialog.dimiss();
    }

    @Override
    public void showMessage(String msg) {
        ToastManager.show(msg);
    }

    @Override
    public void setPresenter(RegisterContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showImageCode(Bitmap bitmap) {
        personalRegImgcheck.setImageBitmap(bitmap);
    }

    @Override
    public void showEmailTips(String msg) {
        nullPhone.setText(msg);
    }

    @Override
    public void dismissEmailTips() {
        nullPhone.setText("");
    }

    @Override
    public void showPwdTips(String msg) {
        nullImagecheck.setText(msg);
    }

    @Override
    public void dismissPwdTips() {
        nullImagecheck.setText("");
    }

    @Override
    public void toLogin() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void showError(String error) {
        ToastManager.show(error);
    }
}
