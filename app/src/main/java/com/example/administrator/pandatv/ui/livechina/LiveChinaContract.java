package com.example.administrator.pandatv.ui.livechina;


import com.example.administrator.pandatv.base.BasePresenter;
import com.example.administrator.pandatv.base.BaseView;
import com.example.administrator.pandatv.entity.LiveChinaBean;
import com.example.administrator.pandatv.entity.SceneryBean;

public interface LiveChinaContract {
    /**
     * view接口
     */
    interface View extends BaseView<Presenter> {

        /**
         * 返回网络数据
         * @param netBean
         */
        void setLiveChina(LiveChinaBean netBean);

        /**
         * 返回网络数据
         * @param netBean
         */
        void setScenery(SceneryBean netBean);

    }

    /**
     * presenter接口
     */
    interface Presenter extends BasePresenter {
        void onLoad(String str);
    }
}
