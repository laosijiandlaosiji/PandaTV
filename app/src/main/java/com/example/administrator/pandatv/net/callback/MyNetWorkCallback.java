package com.example.administrator.pandatv.net.callback;

public interface MyNetWorkCallback<T> {

    void onSuccess(T t);
    void onError(int errorCode, String errorMsg);
//    void getseccess(String s);

}
