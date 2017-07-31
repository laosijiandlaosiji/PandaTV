package com.example.administrator.pandatv.model.biz.login;

import com.example.administrator.pandatv.entity.NickNameBean;
import com.example.administrator.pandatv.model.biz.BaseModel;
import com.example.administrator.pandatv.net.callback.MyNetWorkCallback;
import com.example.administrator.pandatv.net.callback.ResponseNetWork;

/**
 * Created by Administrator on 2017/7/28.
 */

public interface ILoginModel extends BaseModel {
    void login(String userName, String passWord, ResponseNetWork callback);
    void getUserTicket(String userId, String jsessionid, MyNetWorkCallback<NickNameBean> callback);
}
