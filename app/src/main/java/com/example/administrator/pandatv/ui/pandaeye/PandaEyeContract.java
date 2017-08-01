package com.example.administrator.pandatv.ui.pandaeye;

import com.example.administrator.pandatv.base.BasePresenter;
import com.example.administrator.pandatv.base.BaseView;
import com.example.administrator.pandatv.entity.PandaEyeBean;
import com.example.administrator.pandatv.entity.PandaEyeListurlBean;
import com.example.administrator.pandatv.entity.PandaEyeVideoBean;

/**
 * Created by Administrator on 2017/7/30.
 */

public interface PandaEyeContract {


    interface View extends BaseView<Presenter> {
        void setrefreash();
        void getHeadLayout();
        void setOnClicktHeadLayout();
        void showPandaBean(PandaEyeBean pandaEyeBean);
        void showUrl(PandaEyeListurlBean pandaEyeListurlBean);
        void showVideo(PandaEyeVideoBean pandaEyeVideoBean);
        void showMessage(String msg);

    }
    interface Presenter extends BasePresenter {
        void geturl(String url,int a);
        void getVodio(String url);
    }
}
