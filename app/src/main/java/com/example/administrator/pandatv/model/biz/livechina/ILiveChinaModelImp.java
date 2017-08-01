package com.example.administrator.pandatv.model.biz.livechina;


import com.example.administrator.pandatv.config.Urls;
import com.example.administrator.pandatv.entity.LiveChinaBean;
import com.example.administrator.pandatv.entity.SceneryBean;
import com.example.administrator.pandatv.net.callback.MyNetWorkCallback;

public class ILiveChinaModelImp implements ILiveChinaModel{
    @Override
    public void getLiveChinaBean(String string, MyNetWorkCallback<LiveChinaBean> callback) {
        iHttp.get(string,null,callback);
    }

    @Override
    public void getSeneryBean(MyNetWorkCallback<SceneryBean> callbacks) {
        iHttp.get(Urls.LIVECHINA,null,callbacks);
    }
}
