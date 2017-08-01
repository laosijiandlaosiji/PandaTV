package com.example.administrator.pandatv.ui.personal.contract;


import android.graphics.Bitmap;

import com.example.administrator.pandatv.base.BasePresenter;
import com.example.administrator.pandatv.base.BaseView;

public interface RegisterContract {
    interface Presenter extends BasePresenter{
        boolean checkEmail(String emailAddress);
        boolean checkPwd(String pwd);
        boolean checkImgCode(String imgCode);
        boolean testPwd(String passWord,String againPassWord);
        void emailRegister(String email, String passWord, String imgCode,String againPass);
        void phoneVerifiCodeRegister(String phone, String imgCode);
        void phoneRegisters(String phone, String passWord, String verifiCode);
    }
    interface View extends BaseView<Presenter>{
        void showImageCode(Bitmap bitmap);
        void showEmailTips(String msg);
        void dismissEmailTips();
        void showPwdTips(String msg);
        void dismissPwdTips();
        void toLogin();
        void showError(String error);
    }
}
