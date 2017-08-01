package com.example.administrator.pandatv.ui.pandaeye;

import com.example.administrator.pandatv.entity.PandaEyeBean;
import com.example.administrator.pandatv.entity.PandaEyeListurlBean;
import com.example.administrator.pandatv.entity.PandaEyeVideoBean;
import com.example.administrator.pandatv.model.biz.pandaeye.IPandaEyeModel;
import com.example.administrator.pandatv.model.biz.pandaeye.PandaEyeModelImpl;
import com.example.administrator.pandatv.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/7/30.
 */

public class PandaEyePresenter implements PandaEyeContract.Presenter {
    private IPandaEyeModel iPandaEyeModel;
    private PandaEyeContract.View pandview;
    public PandaEyePresenter(PandaEyeContract.View pandview){
        this.pandview = pandview;
        this.pandview.setPresenter(this);
        iPandaEyeModel = new PandaEyeModelImpl();
        this.pandview =pandview;
    }


    @Override
    public void start() {
        pandview.showProgress();
        iPandaEyeModel.getPandaEyeBean(new MyNetWorkCallback<PandaEyeBean>() {
            @Override
            public void onSuccess(PandaEyeBean pandaEyeBean) {
                pandview.showPandaBean(pandaEyeBean);
                pandview.closeProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                pandview.showMessage(errorMsg);
            }

        });
    }


    @Override
    public void geturl(String url, int a) {
        iPandaEyeModel.getPandaEyeBeanUrl(url, a, new MyNetWorkCallback<PandaEyeListurlBean>() {
            @Override
            public void onSuccess(PandaEyeListurlBean pandaEyeListurlBean) {
                pandview.showUrl(pandaEyeListurlBean);
                pandview.closeProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                pandview.showMessage(errorMsg);
            }

        });
    }

    @Override
    public void getVodio(String url) {
        iPandaEyeModel.getPandaEyeBeanVideo(url, new MyNetWorkCallback<PandaEyeVideoBean>() {
            @Override
            public void onSuccess(PandaEyeVideoBean pandaEyeVideoBean) {
                pandview.showVideo(pandaEyeVideoBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                pandview.showMessage(errorMsg);
            }
        });
    }
}
