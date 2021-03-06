package com.example.administrator.pandatv.model.biz.pandaeye;

import com.example.administrator.pandatv.entity.PandaEyeBean;
import com.example.administrator.pandatv.entity.PandaEyeListurlBean;
import com.example.administrator.pandatv.entity.PandaEyeVideoBean;
import com.example.administrator.pandatv.model.biz.BaseModel;
import com.example.administrator.pandatv.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/7/28.
 */


public interface IPandaEyeModel extends BaseModel {

    void getPandaEyeBean(MyNetWorkCallback<PandaEyeBean> callbacks);
    void getPandaEyeBeanUrl(String url, int a, MyNetWorkCallback<PandaEyeListurlBean> callback);
    void getPandaEyeBeanVideo(String url, MyNetWorkCallback<PandaEyeVideoBean> callback);
}
