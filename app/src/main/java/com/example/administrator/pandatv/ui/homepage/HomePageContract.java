package com.example.administrator.pandatv.ui.homepage;

import com.example.administrator.pandatv.base.BasePresenter;
import com.example.administrator.pandatv.base.BaseView;
import com.example.administrator.pandatv.entity.HomeListBean;
import com.example.administrator.pandatv.entity.HomePageBean;

/**
 * Created by Administrator on 2017/7/28.
 */

public interface HomePageContract {

    interface  View extends BaseView<Presenter>{
        void showHomePageBean(HomePageBean homePageBean);
        void showHomeListBean(HomeListBean homeListBean);
    }
    interface Presenter extends BasePresenter{
        void setListUrl(String listUrl);
    }
}
