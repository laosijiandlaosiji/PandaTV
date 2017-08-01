package com.example.administrator.pandatv.model.biz.pandaculture;

import com.example.administrator.pandatv.entity.PandacultureDetailsBean;
import com.example.administrator.pandatv.entity.PandacultureListViewBean;
import com.example.administrator.pandatv.config.Urls;
import com.example.administrator.pandatv.net.callback.MyNetWorkCallback;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by li on 2017/7/29.
 */

public class PandacultureModel implements IPandaCultureModel {

    @Override
    public void getPandaculture(MyNetWorkCallback<PandacultureListViewBean> callback) {
        iHttp.get(Urls.PHANDACULTURE,null,callback);
    }
//
    @Override
    public void getPandacultureDetails(String n, String vsid, String p , String serviceId,String em,MyNetWorkCallback<PandacultureDetailsBean> callback) {
        Map<String,String> map = new HashMap<>();
        map.put("n",n);
        map.put("vsid",vsid);
        map.put("p",p);
        map.put("serviceId",serviceId);
        map.put("em",em);
        iHttp.get(Urls.PANDACULTUREDETAILS,map,callback);
    }
}
