package com.example.administrator.pandatv.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.umeng.analytics.MobclickAgent;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/7/27.
 */

public  abstract class BaseFragment extends Fragment {
    protected Unbinder unbinder;
    protected Bundle bundle;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayoutId(), null);
        ButterKnife.bind(this,inflate);
        return inflate;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        loadData();
    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(hidden){
            hidden();
        }else {
            show();
        }

    }



    protected abstract int getLayoutId();

    protected abstract void init(View view);

    protected abstract void loadData();

    protected  void show(){}

    protected void hidden(){}


    public void setBundle(Bundle bundle){
        this.bundle = bundle;
    }



    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart("MainScreen"); //统计页面，"MainScreen"为页面名称，可自定义
    }
    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd("MainScreen");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

}
