package com.example.administrator.pandatv.model.biz.pandalive;

import com.example.administrator.pandatv.config.Urls;
import com.example.administrator.pandatv.entity.PandaLiveFragmentBean;
import com.example.administrator.pandatv.entity.PandaLiveFragmentMultiAngleBean;
import com.example.administrator.pandatv.entity.PandaLiveOtherFragentBean;
import com.example.administrator.pandatv.entity.PandaLiveTab;
import com.example.administrator.pandatv.entity.WatchandChatBean;
import com.example.administrator.pandatv.net.callback.MyNetWorkCallback;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by li on 2017/7/30.
 */

public class PandaLiveModel implements IPandaLiveModel {
    @Override
    public void getPandaLive(MyNetWorkCallback<PandaLiveTab> callback) {
        iHttp.get(Urls.PANDALIVETAB,null,callback);
    }

    @Override
        public void getPandaLiveQiTaFragment(String vsid, String n, String serviceId, String o, String of, String p, MyNetWorkCallback<PandaLiveOtherFragentBean> callback) {
        Map<String,String> map = new HashMap<>();
        map.put("vsid",vsid);
        map.put("n",n);
        map.put("serviceId",serviceId);
        map.put("o",o);
        map.put("of",of);
        map.put("p",p);
        iHttp.get(Urls.PANDALIVEOTHERFRAGMENT,map,callback);
    }

    @Override
    public void getPandaLiveFragmentMultiAngle(MyNetWorkCallback<PandaLiveFragmentMultiAngleBean> callback) {
        iHttp.get(Urls.PABDALIVEFRAGMENTMULTIANGLE,null,callback);
    }

    @Override
    public void getPandaLiveFragment(MyNetWorkCallback<PandaLiveFragmentBean> callback) {
        iHttp.get(Urls.PABDALIVEFRAGMENT,null,callback);
    }

    @Override
    public void getA(String app, String itemid, String nature, String page,MyNetWorkCallback<WatchandChatBean> callback) {
        Map<String,String> map = new HashMap<>();
        map.put("app",app);
        map.put("itemid",itemid);
        map.put("nature",nature);
        map.put("page",page);
        iHttp.get(Urls.PANDALIVEBIANKANBIANLIAO,map,callback);
    }
//
//    @Override
//    public void getWatchChatBean(String app, String itemId, String nature, String page, MyNetWorkCallback<WatchandChatBean> callbacks) {
//        Map<String,String> map = new HashMap<>();
//        map.put("app",app);
//        map.put("itemId",itemId);
//        map.put("nature",nature);
//        map.put("page",page);
//        iHttp.get(Urls.WATCHANDCHATBEAN,map,callbacks);
//    }
}
