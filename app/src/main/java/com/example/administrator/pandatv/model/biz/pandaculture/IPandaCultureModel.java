package com.example.administrator.pandatv.model.biz.pandaculture;

import com.example.administrator.pandatv.entity.PandacultureDetailsBean;
import com.example.administrator.pandatv.entity.PandacultureDetailsSPBean;
import com.example.administrator.pandatv.entity.PandacultureListViewBean;
import com.example.administrator.pandatv.model.biz.BaseModel;
import com.example.administrator.pandatv.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/7/28.
 */
//
public interface IPandaCultureModel extends BaseModel {
    void getPandaculture(MyNetWorkCallback<PandacultureListViewBean> callback);
    void getPandacultureDetails(String n, String vsid, String p , String serviceId,String em,MyNetWorkCallback<PandacultureDetailsBean> callback);
    void getPandacultureSP(String pid,MyNetWorkCallback<PandacultureDetailsSPBean> callback);
}
