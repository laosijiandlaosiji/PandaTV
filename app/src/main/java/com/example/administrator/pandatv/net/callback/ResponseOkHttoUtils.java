package com.example.administrator.pandatv.net.callback;


import com.example.administrator.pandatv.app.App;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ResponseOkHttoUtils {
    private static ResponseOkHttoUtils utils;
    private OkHttpClient  client;

    public ResponseOkHttoUtils() {
        client = new OkHttpClient.Builder().build();
    }

    public static ResponseOkHttoUtils getInstance(){
        if(utils == null) {
            synchronized (ResponseOkHttoUtils.class){
                if(utils == null) {
                    utils = new ResponseOkHttoUtils();
                }
            }
        }
        return utils;
    }

    public void get(String url, Map<String, String> params, Map<String, String> headers, final ResponseNetWork callback){
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
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure(e.getMessage());
            }

            @Override
            public void onResponse(Call call, final Response response) {
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            callback.onResponse(response);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

    }


    public void post(String url, Map<String, String> headers, RequestBody formBody, final ResponseNetWork callback) {
        Request.Builder builder = new Request.Builder();
        if (headers != null && headers.size() > 0) {
            Set<String> keys = headers.keySet();
            for (String key : keys) {
                String value = headers.get(key);
                builder.addHeader(key, value);
            }
        }
        Request request = builder.url(url).post(formBody).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                App.context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callback.onFailure( e.getMessage().toString());
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
                        try {
                            callback.onResponse(response);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });

            }
        });
    }
}
