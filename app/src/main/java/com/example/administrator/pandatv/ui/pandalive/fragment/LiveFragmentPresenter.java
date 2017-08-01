package com.example.administrator.pandatv.ui.pandalive.fragment;

import com.example.administrator.pandatv.entity.PandaLiveFragmentBean;
import com.example.administrator.pandatv.entity.PandaLiveFragmentMultiAngleBean;
import com.example.administrator.pandatv.model.biz.pandalive.IPandaLiveModel;
import com.example.administrator.pandatv.model.biz.pandalive.PandaLiveModel;
import com.example.administrator.pandatv.net.callback.MyNetWorkCallback;

/**
 * Created by li on 2017/7/30.
 */
//
public class LiveFragmentPresenter implements LiveFragmentContract.Presenter {
    private IPandaLiveModel iPandaLiveModel;
    private LiveFragmentContract.View view;
    public LiveFragmentPresenter(LiveFragmentContract.View view) {
        this.view = view;
        view.setPresenter(this);
        iPandaLiveModel = new PandaLiveModel();
    }

    @Override
    public void start() {
        iPandaLiveModel.getPandaLiveFragment(new MyNetWorkCallback<PandaLiveFragmentBean>() {
            @Override
            public void onSuccess(PandaLiveFragmentBean pandaLiveFragmentBean) {
                view.getPandaLiveFragment(pandaLiveFragmentBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
        iPandaLiveModel.getPandaLiveFragmentMultiAngle(new MyNetWorkCallback<PandaLiveFragmentMultiAngleBean>() {
            @Override
            public void onSuccess(PandaLiveFragmentMultiAngleBean pandaLiveFragmentMultiAngleBean) {
                view.getPandaLiveFragmentMultiAngle(pandaLiveFragmentMultiAngleBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }
        });
    }

//    @Override
//    public void getWatchChat(String app, String itemId, String nature, String page, MyNetWorkCallback<WatchandChatBean> callbacks) {
//        iPandaLiveModel.getWatchChatBean(app, itemId, nature, page, new MyNetWorkCallback<WatchandChatBean>() {
//            @Override
//            public void onSuccess(WatchandChatBean watchandChatBean) {
//                Log.e("TAG",watchandChatBean.getMessage());
//            }
//
//            @Override
//            public void onError(int errorCode, String errorMsg) {
//
//            }
//
//            @Override
//            public void getseccess(String s) {
//
//            }
//        });
//    }


//    @Override
//    public void OtherFragentUrl(String vsid, String n, String serviceId, String o, String of, String p) {
//        iPandaLiveModel.getPandaLiveQiTaFragment(vsid, n, serviceId, o, of, p, new MyNetWorkCallback<PandaLiveOtherFragentBean>() {
//            @Override
//            public void onSuccess(PandaLiveOtherFragentBean pandaLiveOtherFragentBean) {
//                view.getPandaLiveOtherFragent(pandaLiveOtherFragentBean);
//            }
//
//            @Override
//            public void onError(int errorCode, String errorMsg) {
//
//            }
//        });
//    }
}
