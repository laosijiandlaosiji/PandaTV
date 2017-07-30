package com.example.administrator.pandatv.model.biz.pandaeye;

import com.example.administrator.pandatv.config.Urls;
import com.example.administrator.pandatv.entity.PandaEyeBean;
import com.example.administrator.pandatv.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/7/30.
 */

public class PandaEyeModelImpl implements IPandaEyeModel {
    @Override
    public void getPandaEyeBean(MyNetWorkCallback<PandaEyeBean> callbacks) {
        iHttp.get(Urls.PANDATITLE,null,callbacks);
    }
}
