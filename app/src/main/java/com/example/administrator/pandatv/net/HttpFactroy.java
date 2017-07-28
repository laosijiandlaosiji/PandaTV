package com.example.administrator.pandatv.net;

/**
 * Created by Administrator on 2017/7/28.
 */
public class HttpFactroy {
    public static IHttp create(){
        return OkHttpUtils.getInstance();
    }
}
