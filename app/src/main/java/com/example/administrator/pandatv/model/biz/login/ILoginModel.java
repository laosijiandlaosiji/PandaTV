package com.example.administrator.pandatv.model.biz.login;

import com.example.administrator.pandatv.model.biz.BaseModel;
import com.example.administrator.pandatv.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/7/28.
 */

public interface ILoginModel extends BaseModel {
    void login(String userName,String passWord,MyNetWorkCallback<String> callback);
}
