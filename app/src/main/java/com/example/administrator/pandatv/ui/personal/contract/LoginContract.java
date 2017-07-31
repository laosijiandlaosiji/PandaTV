package com.example.administrator.pandatv.ui.personal.contract;


import com.example.administrator.pandatv.base.BasePresenter;
import com.example.administrator.pandatv.base.BaseView;
import com.example.administrator.pandatv.entity.LoginBean;
import com.example.administrator.pandatv.entity.NickNameBean;

public interface LoginContract {

    interface Presenter extends BasePresenter{

        boolean checkAccount(String account);
        boolean checkPwd(String pwd);
        void login(String userName, String passWord);
        void getUserTicket(String userId,String jsessionid);
    }
    interface View extends BaseView<Presenter>{

        void showAccountTips(String msg);
        void dismissAccountTips();
        void showPwdTips(String msg);
        void dismissPwdTips();
        void showError(String error);

        /**
         * 返回登录后的实体bean
         * @param bean
         */
        void setLoginBean(LoginBean bean);

        void setJsessionid(String jsessionid);

        /**
         * 获取昵称bean
         * @param bean
         */
        void setNickNameBean(NickNameBean bean);
    }
}
