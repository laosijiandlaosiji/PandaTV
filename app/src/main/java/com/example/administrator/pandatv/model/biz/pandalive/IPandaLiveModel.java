package com.example.administrator.pandatv.model.biz.pandalive;

import com.example.administrator.pandatv.entity.PandaLiveFragmentBean;
import com.example.administrator.pandatv.entity.PandaLiveFragmentMultiAngleBean;
import com.example.administrator.pandatv.entity.PandaLiveOtherFragentBean;
import com.example.administrator.pandatv.entity.PandaLiveTab;
import com.example.administrator.pandatv.model.biz.BaseModel;
import com.example.administrator.pandatv.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/7/28.
 */

public interface IPandaLiveModel extends BaseModel {
     void getPandaLive(MyNetWorkCallback<PandaLiveTab>callback);

     void getPandaLiveQiTaFragment(String vsid, String n, String serviceId, String o, String of, String p,MyNetWorkCallback<PandaLiveOtherFragentBean>callback);

     void getPandaLiveFragmentMultiAngle(MyNetWorkCallback<PandaLiveFragmentMultiAngleBean>callback);
//
     void getPandaLiveFragment(MyNetWorkCallback<PandaLiveFragmentBean>callback);

//     void getWatchChatBean(String app, String itemId, String nature, String page, MyNetWorkCallback<WatchandChatBean> callbacks);
}
