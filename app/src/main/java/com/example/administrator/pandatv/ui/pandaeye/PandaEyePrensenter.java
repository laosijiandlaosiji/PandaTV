package com.example.administrator.pandatv.ui.pandaeye;

import com.example.administrator.pandatv.entity.PandaEyeBean;
import com.example.administrator.pandatv.model.biz.pandaeye.IPandaEyeModel;
import com.example.administrator.pandatv.model.biz.pandaeye.PandaEyeModelImpl;
import com.example.administrator.pandatv.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/7/30.
 */

public class PandaEyePrensenter implements PandaEyeContract.Presenter {
    private IPandaEyeModel iPandaEyeModel;
    private PandaEyeContract.View pandview;
    public PandaEyePrensenter(PandaEyeContract.View pandview){
        this.pandview = pandview;
        this.pandview.setPresenter(this);
        iPandaEyeModel = new PandaEyeModelImpl();
        this.pandview =pandview;
    }

    @Override
    public void start() {
        iPandaEyeModel.getPandaEyeBean(new MyNetWorkCallback<PandaEyeBean>() {
            @Override
            public void onSuccess(PandaEyeBean pandaEyeBean) {
                pandview.showPandaBean(pandaEyeBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                pandview.showMessage(errorMsg);
            }
        });
    }
}
