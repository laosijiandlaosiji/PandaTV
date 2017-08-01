package com.example.administrator.pandatv.ui.homepage;

import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.example.administrator.pandatv.R;
import com.example.administrator.pandatv.base.BaseFragment;
import com.example.administrator.pandatv.entity.HomeListBean;
import com.example.administrator.pandatv.entity.HomePageBean;
import com.example.administrator.pandatv.ui.homepage.homepageadapter.HomePageAdapter;
import com.example.administrator.pandatv.widget.view.CustomDialog;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/7/28.
 */

public class HomePageFragment extends BaseFragment implements HomePageContract.View {

    @BindView(R.id.homePage_xRecyclerView)
    XRecyclerView homePageXRecyclerView;
    private HomePageContract.Presenter presenter;
    private List<Object> datas;
    private List<List<HomeListBean.ListBean>> lists;
    private HomePageAdapter adapter;
    private ArrayList<HomeListBean.ListBean> listBeen;

    @Override
    protected int getLayoutId() {
        return R.layout.homepagefragment;
    }

    @Override
    protected void init(View view) {
        listBeen = new ArrayList<>();
        new HomePagePresenter(this);
        datas = new ArrayList<Object>();
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        homePageXRecyclerView.setLayoutManager(manager);
        homePageXRecyclerView.setPullRefreshEnabled(true);
        homePageXRecyclerView.setLoadingMoreEnabled(false);
        adapter = new HomePageAdapter(getActivity(),datas,listBeen);
        homePageXRecyclerView.setAdapter(adapter);
        homePageXRecyclerView.setPullRefreshEnabled(true);
        homePageXRecyclerView.setLoadingMoreEnabled(false);
        homePageXRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                homePageXRecyclerView.refreshComplete();
            }

            @Override
            public void onLoadMore() {

            }
        });


    }

    @Override
    protected void loadData() {
        presenter.start();
    }


    @Override
    public void showProgress() {
        CustomDialog.show(getActivity());
    }

    @Override
    public void closeProgress() {
        CustomDialog.dimiss();
    }

    @Override
    public void showHomePageBean(HomePageBean homePageBean) {

        datas.clear();
        datas.add(homePageBean.getData().getBigImg());
        datas.add(homePageBean.getData().getArea());
        datas.add(homePageBean.getData().getPandaeye());
        datas.add(homePageBean.getData().getPandalive());
        datas.add(homePageBean.getData().getInteractive());
        datas.add(homePageBean.getData().getList());
        List<HomePageBean.DataBean.ListBeanXXX> list = homePageBean.getData().getList();
        String listUrl = list.get(0).getListUrl();
        presenter.setListUrl(listUrl);
        adapter.notifyDataSetChanged();
        homePageXRecyclerView.refreshComplete();
    }

    @Override
    public void showHomeListBean(HomeListBean homeListBean) {

        listBeen.addAll(homeListBean.getList());
        adapter.notifyDataSetChanged();

    }

    @Override
    public void showMessage(String msg) {
        Log.d("HomePageFragment", msg);
    }

    @Override
    public void setPresenter(HomePageContract.Presenter presenter) {
        this.presenter = presenter;
    }



}
