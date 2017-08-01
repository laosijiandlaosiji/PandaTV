package com.example.administrator.pandatv.ui.personal.contract;


import com.example.administrator.pandatv.entity.LoginBean;
import com.example.administrator.pandatv.entity.NickNameBean;
import com.example.administrator.pandatv.model.biz.login.ILoginModel;
import com.example.administrator.pandatv.model.biz.login.LoginModelImp;
import com.example.administrator.pandatv.net.callback.MyNetWorkCallback;
import com.example.administrator.pandatv.net.callback.ResponseNetWork;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.Headers;
import okhttp3.Response;

public class LoginPresenter implements LoginContract.Presenter{
    ILoginModel model;
    LoginContract.View view;
    private LoginBean loginBean;

    public LoginPresenter(LoginContract.View view) {
        model = new LoginModelImp();
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public boolean checkAccount(String account) {
        if(account ==null || "".equals(account)) {
            view.showAccountTips("账号不能为空");
            return false;
        }
//      正则表达式 判断是否是手机号
        String regex = "^(13[0-9]|14[579]|15[0-3,5-9]|17[0135678]|18[0-9])\\\\d{8}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(account);
//        字符串是否与手机号正则表达式相匹配
        boolean matches = matcher.matches();
//        判断是否是邮箱
        String regEx = "/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$/";
        Pattern emailPattern = Pattern.compile(regEx);
        Matcher emailMatcher = emailPattern.matcher(account);
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
    public void login(String userName, String passWord) {
        if(!checkAccount(userName)) {
            return;
        }
        if(!checkPwd(passWord)) {
            return;
        }

        model.login(userName, passWord, new ResponseNetWork() {

            @Override
            public void onResponse(Response response) throws IOException {
                Headers headers = response.headers();
                view.setJsessionid(headers.get("Set-Cookie"));
                Gson gson = new Gson();
                loginBean = gson.fromJson(response.body().string(), LoginBean.class);
                view.setLoginBean(loginBean);
                view.dismissPwdTips();
                view.dismissAccountTips();
                view.showMessage(loginBean.getErrMsg());
            }

            @Override
            public void onFailure(String errorMsg) {
                view.showError(loginBean.getErrMsg());
            }
        });
    }

    @Override
    public void getUserTicket(String userId, String jsessionid) {
        model.getUserTicket(userId, jsessionid, new MyNetWorkCallback<NickNameBean>() {
            @Override
            public void onSuccess(NickNameBean nickNameBean) {
                view.setNickNameBean(nickNameBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                view.showError(errorMsg);
            }
        });
    }
}
