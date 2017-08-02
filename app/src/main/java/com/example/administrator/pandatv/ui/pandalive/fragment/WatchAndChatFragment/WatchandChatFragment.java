package com.example.administrator.pandatv.ui.pandalive.fragment.WatchAndChatFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.administrator.pandatv.R;
import com.example.administrator.pandatv.base.BaseFragment;
import com.example.administrator.pandatv.entity.PandaLiveFragmentBean;
import com.example.administrator.pandatv.entity.PandaLiveFragmentMultiAngleBean;
import com.example.administrator.pandatv.entity.WatchandChatBean;
import com.example.administrator.pandatv.ui.pandalive.fragment.LiveFragmentContract;
import com.example.administrator.pandatv.ui.pandalive.fragment.LiveFragmentPresenter;
import com.example.administrator.pandatv.widget.view.CustomDialog;
import com.example.administrator.pandatv.widget.view.MyListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import in.srain.cube.views.ptr.PtrClassicDefaultFooter;
import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by li on 2017/7/31.
 */

public class WatchandChatFragment extends BaseFragment implements LiveFragmentContract.View {

    @BindView(R.id.watchChat_edit)
    EditText watchChatEdit;
    @BindView(R.id.watchChat_send)
    Button watchChatSend;
    @BindView(R.id.watchChatdCha_listview)
    MyListView watchChatdChaListview;
    @BindView(R.id.watchChatdCha_ptr)
    PtrFrameLayout ptr;
    Unbinder unbinder;
    private LiveFragmentContract.Presenter presenter;
    private int page = 1;
    private ArrayList<WatchandChatBean.DataBean.ContentBean> arrayList;
    private WatchAndChatFragmentListAdapter watchAndChatFragmentListAdapter;
    private String total;
    private int time;
    @Override
    protected int getLayoutId() {
        return R.layout.watchchatfragment;
    }

    @Override
    protected void init(View view) {
        presenter = new LiveFragmentPresenter(this);
        presenter.getWatchChat("ipandaApp", "zhiboye_chat", "1", "" + page);

        arrayList = new ArrayList();
        watchAndChatFragmentListAdapter = new WatchAndChatFragmentListAdapter(getActivity(),arrayList,total,time);
        watchChatdChaListview.setAdapter(watchAndChatFragmentListAdapter);

        setListViewHeight(watchChatdChaListview);
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
                page++;
                presenter.getWatchChat("ipandaApp", "zhiboye_chat", "1", "" + page);
                frame.refreshComplete();
            }
            //
            @Override
            //下拉刷新
            public void onRefreshBegin(PtrFrameLayout frame) {
                page=1;
                presenter.getWatchChat("ipandaApp", "zhiboye_chat", "1", "" + page);
                frame.refreshComplete();
            }
        });

    }

    /**
     * 重新计算ListView的高度，解决ScrollView和ListView两个View都有滚动的效果，在嵌套使用时起冲突的问题
     * @param listView
     */
    public void setListViewHeight(ListView listView) {

        // 获取ListView对应的Adapter

        ListAdapter listAdapter = listView.getAdapter();

        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) { // listAdapter.getCount()返回数据项的数目
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0); // 计算子项View 的宽高
            totalHeight += listItem.getMeasuredHeight(); // 统计所有子项的总高度
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    @Override
    protected void loadData() {
        presenter.start();
    }

    @Override
    public void getPandaLiveFragment(PandaLiveFragmentBean pandaLiveFragmentBean) {

    }

    @Override
    public void getPandaLiveFragmentMultiAngle(PandaLiveFragmentMultiAngleBean pandaLiveFragmentMultiAngleBean) {

    }

    @Override
    public void getWatchandChatBean(WatchandChatBean watchandChatBean) {
        total=watchandChatBean.getData().getTotal();
        time=watchandChatBean.getTime();
        Log.e("WatchandChatFragment", "watchandChatBean.getTime():" + watchandChatBean.getTime());
        arrayList.addAll(watchandChatBean.getData().getContent());
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                watchAndChatFragmentListAdapter.notifyDataSetChanged();
            }
        });
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
    public void setPresenter(LiveFragmentContract.Presenter presenter) {
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

    @OnClick(R.id.watchChat_send)
    public void onViewClicked() {
    }
}
