package com.example.administrator.pandatv.ui.livechina;


import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.administrator.pandatv.R;
import com.example.administrator.pandatv.base.BaseFragment;
import com.example.administrator.pandatv.entity.LiveChinaBean;
import com.example.administrator.pandatv.entity.SceneryBean;
import com.example.administrator.pandatv.ui.livechina.adapter.XrecyclerviewAdapter;
import com.example.administrator.pandatv.widget.manager.ToastManager;
import com.example.administrator.pandatv.widget.view.CustomDialog;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class LiveFragment extends BaseFragment implements LiveChinaContract.View{
    @BindView(R.id.liveChina_xRecycler)
    XRecyclerView liveChinaXRecycler;
    String s;
    private XrecyclerviewAdapter xrecyclerviewAdapter;
    private ArrayList<LiveChinaBean.LiveBean> liveBeen;
    private LiveChinaContract.Presenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.livechinafragment;
    }

    @Override
    protected void init(View view) {
        liveBeen = new ArrayList<>();
        xrecyclerviewAdapter = new XrecyclerviewAdapter(getActivity(), liveBeen);
        liveChinaXRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        liveChinaXRecycler.setAdapter(xrecyclerviewAdapter);
    }

    @Override
    protected void loadData() {
        presenter.onLoad(s);
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
        ToastManager.show(msg);
    }

    @Override
    public void setPresenter(LiveChinaContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setLiveChina(LiveChinaBean netBean) {
        List<LiveChinaBean.LiveBean> lives = netBean.getLive();
        liveBeen.addAll(lives);
        xrecyclerviewAdapter.notifyDataSetChanged();
    }

    @Override
    public void setScenery(SceneryBean netBean) {

    }
}
