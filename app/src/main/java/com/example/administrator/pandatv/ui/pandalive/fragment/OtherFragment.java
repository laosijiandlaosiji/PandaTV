package com.example.administrator.pandatv.ui.pandalive.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.administrator.pandatv.R;
import com.example.administrator.pandatv.base.BaseFragment;
import com.example.administrator.pandatv.entity.PandaLiveOtherFragentBean;
import com.example.administrator.pandatv.entity.PandaLiveTab;
import com.example.administrator.pandatv.ui.pandalive.PandaLiveContract;
import com.example.administrator.pandatv.ui.pandalive.PandaLivePresenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import in.srain.cube.views.ptr.PtrClassicDefaultFooter;
import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by li on 2017/7/30.
 */

public class OtherFragment extends BaseFragment implements PandaLiveContract.View {
    @BindView(R.id.pandaLive_OtherFragment_list)
    ListView pandaLiveOtherFragmentList;
    Unbinder unbinder;
    @BindView(R.id.PandaLive_OtherFragment_ptr)
    PtrFrameLayout ptr;
    private PandaLiveContract.Presenter presenter;
    private ArrayList<PandaLiveOtherFragentBean.VideoBean> list;
    private PandaLiveOtherFragmentListAdapter adapter;
    int p = 1;
    private String vsid;

    @Override
    protected int getLayoutId() {
        return R.layout.otherfragment;
    }

    @Override
    protected void init(View view) {
        vsid = getArguments().getString("id");
        presenter = new PandaLivePresenter(this);
        presenter.OtherFragentUrl(vsid, "7", "panda", "desc", "time", String.valueOf(p));
        list = new ArrayList<>();
        adapter = new PandaLiveOtherFragmentListAdapter(getActivity(), list);
        pandaLiveOtherFragmentList.setAdapter(adapter);


        PtrClassicDefaultHeader header = new PtrClassicDefaultHeader(getActivity());
        header.setPadding(0, 15, 0, 10);
        PtrClassicDefaultFooter footer = new PtrClassicDefaultFooter(getActivity());
        ptr.setHeaderView(header);
        ptr.setFooterView(footer);
        ptr.addPtrUIHandler(header);
        ptr.addPtrUIHandler(footer);
// the following are default settings
        ptr.setResistance(1.7f);
        ptr.setRatioOfHeaderHeightToRefresh(1.2f);
        ptr.setDurationToClose(200);
        ptr.setDurationToCloseHeader(1000);
        // default is false
        ptr.setPullToRefresh(false);
        // default is true
        ptr.setKeepHeaderWhenRefresh(true);
        ptr.setPtrHandler(new PtrDefaultHandler2() {
            @Override
            //上拉加载
            public void onLoadMoreBegin(PtrFrameLayout frame) {
                p++;
                presenter.OtherFragentUrl(vsid, "7", "panda", "desc", "time", String.valueOf(p));
                frame.refreshComplete();
            }

            @Override
            //下拉刷新
            public void onRefreshBegin(PtrFrameLayout frame) {
                p=1;
                presenter.OtherFragentUrl(vsid, "7", "panda", "desc", "time", String.valueOf(p));
                frame.refreshComplete();
            }
        });
    }

    @Override
    protected void loadData() {
        presenter.start();
    }

    @Override
    public void getPandaLiveData(PandaLiveTab pandaliveBean) {

//        List<PandaLiveTab.TablistBean> tablist = pandaliveBean.getTablist();
//
//            if(tablist.get(1).getTitle().equals("精彩一刻")) {
//                vsid = tablist.get(x).getId();
//            }

    }

    @Override
    public void getPandaLiveOtherFragent(PandaLiveOtherFragentBean pandaLiveOtherFragentBean) {
        list.addAll(pandaLiveOtherFragentBean.getVideo());
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapter.notifyDataSetChanged();
            }
        });
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
    public void setPresenter(PandaLiveContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
