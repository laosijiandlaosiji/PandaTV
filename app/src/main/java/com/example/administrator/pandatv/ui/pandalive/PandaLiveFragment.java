package com.example.administrator.pandatv.ui.pandalive;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.pandatv.R;
import com.example.administrator.pandatv.base.BaseFragment;
import com.example.administrator.pandatv.entity.PandaLiveOtherFragentBean;
import com.example.administrator.pandatv.entity.PandaLiveTab;
import com.example.administrator.pandatv.ui.pandalive.fragment.LiveFragment;
import com.example.administrator.pandatv.ui.pandalive.fragment.OtherFragment;
import com.example.administrator.pandatv.widget.view.CustomDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/7/28.
 */
//
public class PandaLiveFragment extends BaseFragment implements PandaLiveContract.View {

    @BindView(R.id.pandalive_tab)
    TabLayout pandaliveTab;
    @BindView(R.id.pandalive_pager)
    ViewPager pandalivePager;
    Unbinder unbinder;
    private PandaLiveContract.Presenter presenter;
    private ArrayList<String>str;
    private ArrayList<Fragment> fragmentArrayList;
    private PandaLiveViewPagerAdapter viewpageradapter;

    @Override
    protected int getLayoutId() {
        return R.layout.pandalivefragment;
    }

    @Override
    protected void init(View view) {
        presenter = new PandaLivePresenter(this);
        fragmentArrayList = new ArrayList<>();
        str= new ArrayList<>();
        viewpageradapter = new PandaLiveViewPagerAdapter(getActivity().getSupportFragmentManager(),fragmentArrayList,str);
        pandalivePager.setAdapter(viewpageradapter);
        pandaliveTab.setTabMode(TabLayout.MODE_FIXED);
        pandaliveTab.setupWithViewPager(pandalivePager);
    }

    @Override
    protected void loadData() {
        presenter.start();
    }

    @Override
    public void getPandaLiveData(PandaLiveTab pandaliveBean) {
        List<PandaLiveTab.TablistBean> tablist = pandaliveBean.getTablist();
        for (int x = 0;x<tablist.size();x++){
//            str.add(tablist.get(x).getTitle());
            if(x==0) {
                LiveFragment livefragment = new LiveFragment();
                fragmentArrayList.add(0,livefragment);
                str.add(0, tablist.get(0).getTitle());
            }else {
                OtherFragment otherfragment = new OtherFragment();
                Bundle bundle = new Bundle();
                bundle.putString("id",tablist.get(x).getId());
                otherfragment.setArguments(bundle);
                fragmentArrayList.add(otherfragment);

                str.add(tablist.get(x).getTitle());
            }
                viewpageradapter.notifyDataSetChanged();
                pandalivePager.setOffscreenPageLimit(tablist.size());

        }


    }

    @Override
    public void getPandaLiveOtherFragent(PandaLiveOtherFragentBean pandaLiveOtherFragentBean) {

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

}
