package com.example.administrator.pandatv.model.biz.homepage;

import com.example.administrator.pandatv.model.biz.BaseModel;
import com.example.administrator.pandatv.model.entity.homepagebean.HomePageBean;
import com.example.administrator.pandatv.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/7/28.
 */

public interface IHomePageModel extends BaseModel {
    void homepage(MyNetWorkCallback<HomePageBean> callback);
}
