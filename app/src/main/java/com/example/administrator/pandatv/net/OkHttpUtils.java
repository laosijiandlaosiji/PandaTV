package com.example.administrator.pandatv.net;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.administrator.pandatv.app.App;
import com.example.administrator.pandatv.config.Keys;
import com.example.administrator.pandatv.net.callback.MyNetWorkCallback;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/7/28.
 */

public class OkHttpUtils implements IHttp {

    private OkHttpClient okHttpClient;

    //构造函数私有化
    private OkHttpUtils() {
        okHttpClient = new OkHttpClient.Builder().build();
    }

    private static OkHttpUtils okHttpUtils;

    //提供一个公共的、静态的、返回值类型是当前本类的对象
    public static OkHttpUtils getInstance() {
        if (okHttpUtils == null) {
            synchronized (OkHttpUtils.class) {
                if (okHttpUtils == null)
                    okHttpUtils = new OkHttpUtils();
            }
        }
        return okHttpUtils;
    }

    @Override
    public <T> void get(String url, MyNetWorkCallback<T> callback) {

    }

    /**
     * 发送get请求
     *
     * @param url      请求地址
     * @param params   请求参数
     * @param callback 回调
     * @param <T>      请求回来的数据对应的JavaBean
     */
    @Override
    public <T> void get(String url, Map<String, String> params, final MyNetWorkCallback<T> callback) {

        StringBuffer sb = new StringBuffer(url);
        if (params != null && params.size() > 0) {
            sb.append("?");
            Set<String> keys = params.keySet();
            for (String key : keys) {
                String value = params.get(key);
                sb.append(key).append("=").append(value).append("&");
            }
            url = sb.deleteCharAt(sb.length() - 1).toString();
        }
        Log.d("OkHttpUtils",sb.toString());
        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.onError(404, e.getMessage().toString());
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String jsonData = response.body().string();

                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        callback.onSuccess(getGeneric(jsonData, callback));
                    }
                });

            }
        });

    }

    @Override
    public <T> void post(String url, Map<String, String> params, Map<String, String> headers, final MyNetWorkCallback<T> callback) {

        StringBuffer sb = new StringBuffer(url);
        if (params != null && params.size() > 0) {
            sb.append("?");
            Set<String> keys = params.keySet();
            for (String key : keys) {
                String value = params.get(key);
                sb.append(key).append("=").append(value).append("&");
            }
            url = sb.deleteCharAt(sb.length() - 1).toString();
        }
        Request.Builder builder = new Request.Builder();
        if (headers != null && headers.size() > 0) {
            Set<String> keys = headers.keySet();
            for (String key : keys) {
                String value = headers.get(key);
                builder.addHeader(key, value);
            }
        }
        Request request = builder.url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.onError(404, e.getMessage().toString());
                    }
                });

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String jsonData = response.body().string();
                //执行在子线程中
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(getGeneric(jsonData, callback));
                    }
                });

            }
        });
    }

    @Override
    public <T> void post(String url, Map<String, String> params, final MyNetWorkCallback<T> callback) {

        FormBody.Builder builder = new FormBody.Builder();
        if (params != null && params.size() > 0) {
            Set<String> keys = params.keySet();
            for (String key : keys) {
                String value = params.get(key);
                builder.add(key, value);
            }
        }
        Request request = new Request.Builder().url(url).post(builder.build()).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callback.onError(404, e.getMessage().toString());
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String jsonData = response.body().string();
                //执行在子线程中
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //执行在主线程
                        callback.onSuccess(getGeneric(jsonData, callback));
                    }
                });

            }
        });
    }

    @Override
    public <T> void post(String url, Map<String, String> headers, RequestBody formBody, final MyNetWorkCallback<T> callback) {
        final Request.Builder builder = new Request.Builder();
        if (headers != null && headers.size() > 0) {
            Set<String> keys = headers.keySet();
            for (String key : keys) {
                String value = headers.get(key);
                builder.addHeader(key, value);
            }
        }
        Request request = builder.url(url).post(formBody).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.onError(404, e.getMessage().toString());
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String jsonData = response.body().string();
                //执行在子线程中
                final Bundle bundle = new Bundle();
                bundle.putString("yanzhengma",jsonData);

                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        callback.onSuccess((T) bundle);
                    }
                });

            }
        });
    }


    @Override
    public void upload() {

    }

    @Override
    public void download() {

    }

    public void loadImgCode(String url, final MyNetWorkCallback<Bundle> callback){
        final Request request = new Request.Builder().url(url).build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.onError(404,e.getMessage().toString());

                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                byte[] bytes = response.body().bytes();
                Headers headers = response.headers();
                String jsessionId =  headers.get("Set-Cookie");
                Log.e("OkHttpUtils", jsessionId);
                final Bundle bundle = new Bundle();
                bundle.putString(Keys.JSESSIONID,jsessionId);
                bundle.putByteArray(Keys.IMGCODE,bytes);

                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(bundle);
                    }
                });
            }
        });

    }
    @Override
    public void loadImage(String url, ImageView imageView) {
        Glide.with(App.context).load(url).into(imageView);
    }


    /**
     * 自动解析json至回调中的JavaBean
     * @param jsonData
     * @param callBack
     * @param <T>
     * @return
     */
    private <T> T getGeneric(String jsonData,MyNetWorkCallback<T> callBack){
        Gson gson = new Gson();
        //通过反射获取泛型的实例
        Type[] types = callBack.getClass().getGenericInterfaces();
        Type[] actualTypeArguments = ((ParameterizedType) types[0]).getActualTypeArguments();
        Type type = actualTypeArguments[0];
        T t = gson.fromJson(jsonData,type);
        return t;
    }


}
