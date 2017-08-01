package com.example.administrator.pandatv.model.biz.pandaeye;

import com.example.administrator.pandatv.config.Urls;
import com.example.administrator.pandatv.entity.PandaEyeBean;
import com.example.administrator.pandatv.entity.PandaEyeListurlBean;
import com.example.administrator.pandatv.entity.PandaEyeVideoBean;
import com.example.administrator.pandatv.net.callback.MyNetWorkCallback;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/30.
 */

public class PandaEyeModelImpl implements IPandaEyeModel {
    @Override
    public void getPandaEyeBean(MyNetWorkCallback<PandaEyeBean> callbacks) {
        iHttp.get(Urls.PANDATITLE,null,callbacks);
    }


    @Override
    public void getPandaEyeBeanUrl(String url, int a,MyNetWorkCallback<PandaEyeListurlBean> callback) {
        iHttp.get(url+"pagesize=6&page="+a,null,callback);
    }

    @Override
    public void getPandaEyeBeanVideo(String url, MyNetWorkCallback<PandaEyeVideoBean> callback) {
        Map<String, String > map =new HashMap<>();
        map.put("pid",url);
        iHttp.get(Urls.PANDAEYEVIDEO,map,callback);
    }
}
