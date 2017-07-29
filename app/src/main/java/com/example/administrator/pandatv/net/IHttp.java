package com.example.administrator.pandatv.net;

import android.widget.ImageView;

import com.example.administrator.pandatv.net.callback.MyNetWorkCallback;

import java.util.Map;

import okhttp3.FormBody;

/**
 * Created by Administrator on 2017/7/28.
 */
public interface IHttp {

    <T> void get(String url, MyNetWorkCallback<T> callback);
    <T> void get(String url, Map<String, String> params, MyNetWorkCallback<T> callback);
    <T> void get(String url, Map<String, String> params, Map<String, String> headers, MyNetWorkCallback<T> callback);
    <T> void post(String url, Map<String, String> params, MyNetWorkCallback<T> callback);
    <T> void post(String url, Map<String,String> params, Map<String, String> headers, FormBody formBody, MyNetWorkCallback<T> callback);
    void upload();
    void download();
    void loadImage(String url, ImageView imageView);

}
