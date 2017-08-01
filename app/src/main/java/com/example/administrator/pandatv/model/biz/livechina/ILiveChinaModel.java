package com.example.administrator.pandatv.model.biz.livechina;

import com.example.administrator.pandatv.entity.LiveChinaBean;
import com.example.administrator.pandatv.entity.SceneryBean;
import com.example.administrator.pandatv.model.biz.BaseModel;
import com.example.administrator.pandatv.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/7/28.
 */

public interface ILiveChinaModel extends BaseModel {
    //   直播中国
    void getLiveChinaBean(String string, MyNetWorkCallback<LiveChinaBean> callback);

    //直播中国详情
    void getSeneryBean(MyNetWorkCallback<SceneryBean> callbacks);
}
