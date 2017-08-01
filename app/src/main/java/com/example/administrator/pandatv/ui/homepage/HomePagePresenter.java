package com.example.administrator.pandatv.ui.homepage;

import com.example.administrator.pandatv.entity.HomeListBean;
import com.example.administrator.pandatv.entity.HomePageBean;
import com.example.administrator.pandatv.model.biz.homepage.HomePageModelImpl;
import com.example.administrator.pandatv.model.biz.homepage.IHomePageModel;
import com.example.administrator.pandatv.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/7/28.
 */

public class HomePagePresenter implements HomePageContract.Presenter {
    private HomePageContract.View homeview;
    private IHomePageModel homePageModel;
    public HomePagePresenter(HomePageContract.View homeview) {
        this.homeview = homeview;
        homeview.setPresenter(this);
        this.homePageModel = new HomePageModelImpl();
    }

    @Override
    public void start() {
        homeview.showProgress();
        homePageModel.homepage(new MyNetWorkCallback<HomePageBean>() {
            @Override
            public void onSuccess(HomePageBean homePageBean) {
                homeview.showHomePageBean(homePageBean);

            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                homeview.showMessage(errorMsg);
            }
        });
    }

    @Override
    public void setListUrl(String listUrl) {
        homePageModel.homepage(listUrl, new MyNetWorkCallback<HomeListBean>() {
            @Override
            public void onSuccess(HomeListBean homeListBean) {
                homeview.showHomeListBean(homeListBean);
                homeview.closeProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                homeview.showMessage(errorMsg);
                homeview.closeProgress();
            }

        });
    }
}
