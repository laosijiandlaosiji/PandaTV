package com.example.administrator.pandatv.ui.pandaeye;

import com.example.administrator.pandatv.base.BasePresenter;
import com.example.administrator.pandatv.base.BaseView;
import com.example.administrator.pandatv.entity.PandaEyeBean;
import com.example.administrator.pandatv.entity.PandaEyeListurlBean;

/**
 * Created by Administrator on 2017/7/30.
 */

public interface PandaEyeContract {

    interface View extends BaseView<Presenter> {
        void showPandaBean(PandaEyeBean pandaEyeBean);
        void showUrl(PandaEyeListurlBean pandaEyeListurlBean);
        void showMessage(String msg);

    }
    interface Presenter extends BasePresenter {
        void getrurl(String url);
    }
}
