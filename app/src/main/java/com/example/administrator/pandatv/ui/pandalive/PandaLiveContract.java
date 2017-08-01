package com.example.administrator.pandatv.ui.pandalive;

import com.example.administrator.pandatv.base.BasePresenter;
import com.example.administrator.pandatv.base.BaseView;
import com.example.administrator.pandatv.entity.PandaLiveOtherFragentBean;
import com.example.administrator.pandatv.entity.PandaLiveTab;

/**
 * Created by li on 2017/7/30.
 */

public interface PandaLiveContract {
//
    interface View extends BaseView<Presenter>{
        void getPandaLiveData(PandaLiveTab pandaliveBean);
        void getPandaLiveOtherFragent(PandaLiveOtherFragentBean pandaLiveOtherFragentBean);
    }

    interface Presenter extends BasePresenter{
        void OtherFragentUrl(String vsid,String n,String serviceId,String o,String of,String p);
    }
}
