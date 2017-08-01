package com.example.administrator.pandatv.ui.pandaculture;

import com.example.administrator.pandatv.entity.PandacultureDetailsBean;
import com.example.administrator.pandatv.entity.PandacultureListViewBean;
import com.example.administrator.pandatv.model.biz.pandaculture.IPandaCultureModel;
import com.example.administrator.pandatv.model.biz.pandaculture.PandacultureModel;
import com.example.administrator.pandatv.net.callback.MyNetWorkCallback;

/**
 * Created by li on 2017/7/29.
 */

public class PandaculturePresenter implements PandacultureContract.Presenter {
    private IPandaCultureModel model;
    private PandacultureContract.View view;
    public PandaculturePresenter(PandacultureContract.View view) {
            this.view = view;
            view.setPresenter(this);
            model = new PandacultureModel();
    }

    @Override
    public void start() {
        model.getPandaculture(new MyNetWorkCallback<PandacultureListViewBean>() {
            @Override
            public void onSuccess(PandacultureListViewBean bean) {
                view.getListData(bean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                view.getErreo(errorMsg);
            }

        });
    }


    @Override
    public void getPandacultureDetails(String n, String vsid, String p, String serviceId, String em) {
        model.getPandacultureDetails(n, vsid, p, serviceId, em, new MyNetWorkCallback<PandacultureDetailsBean>() {
            @Override
            public void onSuccess(PandacultureDetailsBean pandacultureDetailsBean) {
                view.getPandacultureDetails(pandacultureDetailsBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }
}
