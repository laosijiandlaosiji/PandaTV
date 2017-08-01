package com.example.administrator.pandatv.ui.pandalive.fragment;

import com.example.administrator.pandatv.base.BasePresenter;
import com.example.administrator.pandatv.base.BaseView;
import com.example.administrator.pandatv.entity.PandaLiveFragmentBean;
import com.example.administrator.pandatv.entity.PandaLiveFragmentMultiAngleBean;
import com.example.administrator.pandatv.entity.WatchandChatBean;

/**
 * Created by li on 2017/7/30.
 */

public interface LiveFragmentContract {
////
    interface View extends BaseView<Presenter>{
        void getPandaLiveFragment(PandaLiveFragmentBean pandaLiveFragmentBean);
        void getPandaLiveFragmentMultiAngle(PandaLiveFragmentMultiAngleBean pandaLiveFragmentMultiAngleBean);
        void getWatchandChatBean(WatchandChatBean watchandChatBean);
    }

    interface Presenter extends BasePresenter{
        void getWatchChat(String app, String itemid, String nature, String page);
    }
}
