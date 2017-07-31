package com.example.administrator.pandatv.ui.personal.contract;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;

import com.example.administrator.pandatv.config.Keys;
import com.example.administrator.pandatv.entity.Register;
import com.example.administrator.pandatv.model.biz.login.IRegisterModel;
import com.example.administrator.pandatv.model.biz.login.RegisterModelImp;
import com.example.administrator.pandatv.net.callback.MyNetWorkCallback;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterPresenter implements RegisterContract.Presenter{
    private IRegisterModel model;
    private RegisterContract.View view;
    private String jsessionid,jsessionid1;

    public RegisterPresenter(RegisterContract.View view) {
        model = new RegisterModelImp();
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void start() {
        model.loadImgCode(new MyNetWorkCallback<Bundle>() {
            @Override
            public void onSuccess(Bundle bundle) {
                jsessionid = bundle.getString(Keys.JSESSIONID);
                byte[] byteArray = bundle.getByteArray(Keys.IMGCODE);
                Log.e("TAG","email:"+byteArray.length);
                Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                view.showImageCode(bitmap);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });

        model.loadPhoneImg(new MyNetWorkCallback<Bundle>() {
            @Override
            public void onSuccess(Bundle bundle) {
                jsessionid = bundle.getString(Keys.JSESSIONID);
                byte[] byteArray = bundle.getByteArray(Keys.IMGCODE);
                Log.e("TAG","phone:"+byteArray.length);
                Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                view.showImageCode(bitmap);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }

    @Override
    public boolean checkEmail(String emailAddress) {
        if(emailAddress ==null || "".equals(emailAddress)) {
            view.showEmailTips("账号不能为空");
            return false;
        }
//      正则表达式 判断是否是手机号
        String regex = "^(13[0-9]|14[579]|15[0-3,5-9]|17[0135678]|18[0-9])\\\\d{8}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(emailAddress);
//        字符串是否与手机号正则表达式相匹配
        boolean matches = matcher.matches();
//        判断是否是邮箱
        String regEx = "/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$/";
        Pattern emailPattern = Pattern.compile(regEx);
        Matcher emailMatcher = emailPattern.matcher(emailAddress);
        boolean emailMatches = emailMatcher.matches();

//        if(!matches || !emailMatches) {
//            view.showAccountTips("账号格式不对");
//            return false;
//        }
        return true;
    }

    @Override
    public boolean checkPwd(String pwd) {
        if(pwd == null || "".equals(pwd)) {
            view.showPwdTips("密码为空");
            return false;
        }
        if(pwd.length()<6 && pwd.length()>15) {
            view.showPwdTips("请输入正确格式的密码");
            return false;
        }else {
            return true;
        }
    }

    @Override
    public boolean checkImgCode(String imgCode) {
        return true;
    }

    @Override
    public void emailRegister(String email, String passWord, String imgCode) {
        if(!checkEmail(email)) {
            return;
        }
        if(!checkPwd(passWord)) {
            return;
        }
        if(!checkImgCode(imgCode))
            return;

        model.emailRegister(email, passWord, jsessionid, imgCode, new MyNetWorkCallback<Register>() {
            @Override
            public void onSuccess(Register register) {
                String msg = register.getMsg();
                if("成功".equals(msg)){
                    view.toLogin();
                }
                view.showMessage(msg);
                view.dismissEmailTips();
                view.dismissPwdTips();
            }

            @Override
            public void  onError(int errorCode, String errorMsg) {
                view.showError(errorMsg);
                view.dismissEmailTips();
                view.dismissPwdTips();
            }
        });
    }

    @Override
    public void phoneVerifiCodeRegister(String phone, String imgCode) {
        model.phoneVerfiCodeRegister(phone, jsessionid, imgCode, new MyNetWorkCallback<Bundle>() {
            @Override
            public void onSuccess(Bundle bundle) {
                String yanzhengma = bundle.getString("yanzhengma");
                view.dismissEmailTips();
                view.dismissPwdTips();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                view.showError(errorMsg);
                view.dismissEmailTips();
                view.dismissPwdTips();
            }
        });
    }

    @Override
    public void phoneRegisters(String phone, String passWord, String verifiCode) {
        model.phoneRegisers(phone, passWord, verifiCode, new MyNetWorkCallback<Bundle>() {
            @Override
            public void onSuccess(Bundle register) {
                String yanzhengma = register.getString("yanzhengma");
//                if("success".equals(register1.getMsg())){
//                    view.toLogin();
//                }
//                view.showMessage(register1.getMsg());
                view.dismissEmailTips();
                view.dismissPwdTips();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                view.showMessage(errorMsg);
                view.dismissEmailTips();
                view.dismissPwdTips();
            }
        });
    }
}
