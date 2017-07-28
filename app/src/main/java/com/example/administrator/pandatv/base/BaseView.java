package com.example.administrator.pandatv.base;

/**
 * Created by Administrator on 2017/7/27.
 */

public interface BaseView<T> {
    void showProgress();
    void closeProgress();
    void showMessage(String msg);
    void setPresenter(T t);
}
