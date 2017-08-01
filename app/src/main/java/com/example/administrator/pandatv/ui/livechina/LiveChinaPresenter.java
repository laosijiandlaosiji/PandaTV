package com.example.administrator.pandatv.ui.livechina;


import com.example.administrator.pandatv.entity.LiveChinaBean;
import com.example.administrator.pandatv.entity.SceneryBean;
import com.example.administrator.pandatv.model.biz.livechina.ILiveChinaModel;
import com.example.administrator.pandatv.model.biz.livechina.ILiveChinaModelImp;
import com.example.administrator.pandatv.net.callback.MyNetWorkCallback;

public class LiveChinaPresenter implements LiveChinaContract.Presenter{
    ILiveChinaModel model;
    LiveChinaContract.View view;

    public LiveChinaPresenter(LiveChinaContract.View view) {
        model = new ILiveChinaModelImp();
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void start() {
        view.showProgress();
        model.getSeneryBean(new MyNetWorkCallback<SceneryBean>() {
            @Override
            public void onSuccess(SceneryBean sceneryBean) {
                view.setScenery(sceneryBean);
                view.closeProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                view.showMessage(errorMsg);
                view.closeProgress();
            }
        });
    }

    @Override
    public void onLoad(String str) {
        model.getLiveChinaBean(str, new MyNetWorkCallback<LiveChinaBean>() {
            @Override
            public void onSuccess(LiveChinaBean liveChinaBean) {
                view.setLiveChina(liveChinaBean);
                view.closeProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                view.showMessage(errorMsg);
                view.closeProgress();
            }
        });
    }
}
