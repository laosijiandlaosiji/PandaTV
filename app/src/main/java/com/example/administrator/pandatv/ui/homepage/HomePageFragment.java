package com.example.administrator.pandatv.ui.homepage;

import android.view.View;
import android.widget.TextView;

import com.example.administrator.pandatv.R;
import com.example.administrator.pandatv.base.BaseFragment;
import com.example.administrator.pandatv.model.entity.homepagebean.HomePageBean;

/**
 * Created by Administrator on 2017/7/28.
 */

public class HomePageFragment extends BaseFragment implements HomePageContract.View{
    private HomePageContract.Presenter presenter;
    private TextView viewById;

    @Override
    protected int getLayoutId() {
        return R.layout.homepagefragment;
    }

    @Override
    protected void init(View view) {
        viewById = (TextView) view.findViewById(R.id.textView);
        new HomePagePresenter(this);
    }

    @Override
    protected void loadData() {
        presenter.start();
    }

    @Override
    public void showHomePageBean(HomePageBean homePageBean) {
        viewById.setText(homePageBean.toString());
    }


    @Override
    public void showProgress() {

    }

    @Override
    public void closeProgress() {

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void setPresenter(HomePageContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
