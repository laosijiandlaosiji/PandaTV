package com.example.administrator.pandatv.ui.pandalive;

import com.example.administrator.pandatv.entity.PandaLiveOtherFragentBean;
import com.example.administrator.pandatv.entity.PandaLiveTab;
import com.example.administrator.pandatv.model.biz.pandalive.IPandaLiveModel;
import com.example.administrator.pandatv.model.biz.pandalive.PandaLiveModel;
import com.example.administrator.pandatv.net.callback.MyNetWorkCallback;

/**
 * Created by li on 2017/7/30.
 */
//
public class PandaLivePresenter implements PandaLiveContract.Presenter {
    private IPandaLiveModel iPandaLiveModel;
    private PandaLiveContract.View view;
    public PandaLivePresenter(PandaLiveContract.View view) {
        this.view = view;
        view.setPresenter(this);
        iPandaLiveModel = new PandaLiveModel();
    }

    @Override
    public void start() {
        iPandaLiveModel.getPandaLive(new MyNetWorkCallback<PandaLiveTab>() {
            @Override
            public void onSuccess(PandaLiveTab pandaLiveTab) {
                view.getPandaLiveData(pandaLiveTab);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }

    @Override
    public void OtherFragentUrl(String vsid, String n, String serviceId, String o, String of, String p) {
        iPandaLiveModel.getPandaLiveQiTaFragment(vsid, n, serviceId, o, of, p, new MyNetWorkCallback<PandaLiveOtherFragentBean>() {
            @Override
            public void onSuccess(PandaLiveOtherFragentBean pandaLiveOtherFragentBean) {
                view.getPandaLiveOtherFragent(pandaLiveOtherFragentBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }
}
