package com.example.administrator.pandatv.model.biz.login;


import android.os.Bundle;

import com.example.administrator.pandatv.config.Keys;
import com.example.administrator.pandatv.config.Urls;
import com.example.administrator.pandatv.entity.Register;
import com.example.administrator.pandatv.net.OkHttpUtils;
import com.example.administrator.pandatv.net.callback.MyNetWorkCallback;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.RequestBody;


public class RegisterModelImp implements IRegisterModel{
    @Override
    public void loadImgCode(MyNetWorkCallback<Bundle> callback) {
        OkHttpUtils.getInstance().loadImgCode(Urls.IMGCODE,callback);
    }

    @Override
    public void loadPhoneImg(MyNetWorkCallback<Bundle> callback) {
        OkHttpUtils.getInstance().loadImgCode(Urls.IMGCODE,callback);
    }

    @Override
    public void emailRegister(String email, String passWord, String cookie, String imgCode, MyNetWorkCallback<Register> callback) {
        String addons = null;
        String userAgent = null;
        try {
            addons = URLEncoder.encode("iPanda.Android", "UTF-8");
            userAgent = URLEncoder.encode("CNTV_APP_CLIENT_CNTV_MOBILE", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Map<String,String> params = new HashMap<>();
        params.put("mailAdd",email);
        params.put("passWd",passWord);
        params.put("verificationCode",imgCode);
        params.put("addons", addons);

        Map<String,String> headers = new HashMap<>();
        headers.put(Keys.REFERER,addons);
        headers.put(Keys.USERAGENT,userAgent);
        headers.put(Keys.COOKIE,cookie);

        iHttp.post(Urls.EMAILREGISTER,params,headers,callback);
    }

    @Override
    public void phoneVerfiCodeRegister(String phone, String cookie, String imgCode, MyNetWorkCallback<Bundle> callback) {
// frombody
        RequestBody body = new FormBody.Builder()
                .add("method", "getRequestVerifiCodeM")
                .add("mobile", phone)
                .add("verfiCodeType", "1")
                .add("verificationCode", imgCode)
                .build();

//        头部
        Map<String,String> head = new HashMap<String, String>();
        try {
            head.put(Keys.REFERER,URLEncoder.encode(Urls.FROM, "UTF-8"));
            head.put(Keys.USERAGENT,URLEncoder.encode("CNTV_APP_CLIENT_CBOX_MOBILE", "UTF-8"));
            head.put(Keys.COOKIE,cookie);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        iHttp.post(Urls.PHONEIMGCODE,head,body,callback);
    }

    @Override
    public void phoneRegisers(String phone, String passWord, String verifiCode,MyNetWorkCallback<Bundle> callback) {
        RequestBody body = null;
        try {
        body = new FormBody.Builder()
                    .add("method", "saveMobileRegisterM")
                    .add("mobile", phone)
                    .add("verfiCode", verifiCode)
                    .add("passWd", URLEncoder.encode(passWord, "UTF-8"))
                    .add("verfiCod eType", "1")
                    .add("addons", URLEncoder.encode("http://cbox_mobile.regclientuser.cntv.cn", "UTF-8"))
                    .build();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Map<String , String> head = new HashMap<>();
        try {
            head.put(Keys.REFERER,URLEncoder.encode("http://cbox_mobile.regclientuser.cntv.cn", "UTF-8"));
            head.put(Keys.USERAGENT,URLEncoder.encode("CNTV_APP_CLIENT_CBOX_MOBILE", "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        iHttp.post(Urls.PHONEREGIST,head,body,callback);
    }

}
