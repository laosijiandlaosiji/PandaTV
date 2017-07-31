package com.example.administrator.pandatv.model.biz.login;


import com.example.administrator.pandatv.config.Keys;
import com.example.administrator.pandatv.config.Urls;
import com.example.administrator.pandatv.entity.NickNameBean;
import com.example.administrator.pandatv.net.callback.MyNetWorkCallback;
import com.example.administrator.pandatv.net.callback.ResponseNetWork;
import com.example.administrator.pandatv.net.callback.ResponseOkHttoUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class LoginModelImp implements ILoginModel {

    @Override
    public  void login(String userName, String passWord, ResponseNetWork callback) {
        try {
            Map<String,String> params = new HashMap<>();
            params.put("username",URLEncoder.encode(userName, "UTF-8"));
            params.put("password",passWord);
            params.put("service","client_transaction");
            params.put("from", URLEncoder.encode(Urls.LOGIN, "UTF-8"));

            Map<String,String> head = new HashMap<>();
            head.put("Referer",URLEncoder.encode(Urls.LOGIN, "UTF-8"));
            head.put("User-Agent",URLEncoder.encode("CNTV_APP_CLIENT_CYNTV_MOBILE", "UTF-8"));

            ResponseOkHttoUtils.getInstance().get(Urls.LOGIN,params,head,callback);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getUserTicket(String userId, String jsessionid, MyNetWorkCallback<NickNameBean> callback) {

        try {
            Map<String,String> params = new HashMap<>();
            params.put(Keys.CLIENT,"cbox_mobile");
            params.put("method","user.getNickName");
            params.put("userid",userId);

            Map<String,String> head = new HashMap<>();
            head.put(Keys.REFERER,URLEncoder.encode(Urls.USERTICKET,"UTF-8"));
            head.put(Keys.USERAGENT,URLEncoder.encode("CNTV_APP_CLIENT_CBOX_MOBILE", "UTF-8"));
            head.put(Keys.COOKIE,jsessionid);

            iHttp.post(Urls.USERTICKETURL,params, head,callback);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
