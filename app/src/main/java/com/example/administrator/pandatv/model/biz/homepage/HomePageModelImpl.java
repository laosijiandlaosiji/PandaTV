package com.example.administrator.pandatv.model.biz.homepage;

import com.example.administrator.pandatv.config.Urls;
import com.example.administrator.pandatv.model.entity.homepagebean.HomePageBean;
import com.example.administrator.pandatv.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/7/28.
 */

public class HomePageModelImpl implements IHomePageModel {

    @Override
    public void homepage(MyNetWorkCallback<HomePageBean> callback) {
        iHttp.get(Urls.HOMEPAGEURL,null,callback);
    }
}
