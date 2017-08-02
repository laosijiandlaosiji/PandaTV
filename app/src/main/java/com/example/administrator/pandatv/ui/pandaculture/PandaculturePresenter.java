package com.example.administrator.pandatv.ui.pandaculture;

import com.example.administrator.pandatv.entity.PandaCultureSYSPBean;
import com.example.administrator.pandatv.entity.PandacultureDetailsBean;
import com.example.administrator.pandatv.entity.PandacultureDetailsSPBean;
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
    }//

    @Override
    public void start() {
        view.showProgress();
        model.getPandaculture(new MyNetWorkCallback<PandacultureListViewBean>() {
            @Override
            public void onSuccess(PandacultureListViewBean bean) {
                view.getListData(bean);
                view.closeProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

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

    @Override
    public void getPandacultureDetailsSP(String pid) {
        model.getPandacultureSP(pid, new MyNetWorkCallback<PandacultureDetailsSPBean>() {
            @Override
            public void onSuccess(PandacultureDetailsSPBean pandacultureDetailsSPBean) {
                view.getPandacultureDetailsSP(pandacultureDetailsSPBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }

    @Override
    public void getcultureSP(String pid) {
        model.getcultureSP(pid, new MyNetWorkCallback<PandaCultureSYSPBean>() {
            @Override
            public void onSuccess(PandaCultureSYSPBean pandaCultureSYSPBean) {
                view.getcultureSP(pandaCultureSYSPBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }
}
