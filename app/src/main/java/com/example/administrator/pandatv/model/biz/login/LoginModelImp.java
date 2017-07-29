package com.example.administrator.pandatv.model.biz.login;


import com.example.administrator.pandatv.config.Urls;
import com.example.administrator.pandatv.net.callback.MyNetWorkCallback;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class LoginModelImp implements ILoginModel {

    @Override
    public void login(String userName, String passWord,MyNetWorkCallback<String> callback) {
        try {
            Map<String,String> params = new HashMap<>();
            params.put("username",URLEncoder.encode(userName, "UTF-8"));
            params.put("password",passWord);
            params.put("service","client_transaction");
            params.put("from", URLEncoder.encode(Urls.LOGIN, "UTF-8"));

            Map<String,String> head = new HashMap<>();
            head.put("Referer",URLEncoder.encode(Urls.LOGIN, "UTF-8"));
            head.put("User-Agent",URLEncoder.encode("CNTV_APP_CLIENT_CYNTV_MOBILE", "UTF-8"));

            iHttp.post(Urls.LOGIN,params,callback);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
