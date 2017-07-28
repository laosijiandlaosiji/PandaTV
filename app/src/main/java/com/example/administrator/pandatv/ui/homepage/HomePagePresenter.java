package com.example.administrator.pandatv.ui.homepage;

import com.example.administrator.pandatv.model.biz.homepage.HomePageModelImpl;
import com.example.administrator.pandatv.model.biz.homepage.IHomePageModel;
import com.example.administrator.pandatv.model.entity.homepagebean.HomePageBean;
import com.example.administrator.pandatv.net.callback.MyNetWorkCallback;

/**
 * Created by Administrator on 2017/7/28.
 */

public class HomePagePresenter implements HomePageContract.Presenter {
    private HomePageContract.View homeview;
    private IHomePageModel homePageModel;
    public HomePagePresenter(HomePageContract.View homeview) {
        this.homeview = homeview;
        this.homeview.setPresenter(this);
        this.homePageModel = new HomePageModelImpl();
    }

    @Override
    public void start() {
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
}
