package com.example.administrator.pandatv.ui.pandalive.fragment.MultiAngleLiveFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.administrator.pandatv.R;
import com.example.administrator.pandatv.base.BaseFragment;
import com.example.administrator.pandatv.entity.PandaLiveFragmentBean;
import com.example.administrator.pandatv.entity.PandaLiveFragmentMultiAngleBean;
import com.example.administrator.pandatv.entity.WatchandChatBean;
import com.example.administrator.pandatv.ui.pandalive.fragment.LiveFragmentContract;
import com.example.administrator.pandatv.ui.pandalive.fragment.LiveFragmentPresenter;
import com.example.administrator.pandatv.widget.view.CustomDialog;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by li on 2017/7/31.
 */
//
public class MuitiangleLiveFragment extends BaseFragment implements LiveFragmentContract.View{
    @BindView(R.id.muitianglelivefragment_gridview)
    GridView muitianglelivefragmentGridview;
    Unbinder unbinder;
    private LiveFragmentContract.Presenter presenter;
    private ArrayList<PandaLiveFragmentMultiAngleBean.ListBean> list;
    private MuitiangleLiveFragmentAdapter muitiangleLiveFragmentAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.muitianglelivefragment;
    }

    @Override
    protected void init(View view) {
        presenter = new LiveFragmentPresenter(this);
        list = new ArrayList();
        muitiangleLiveFragmentAdapter = new MuitiangleLiveFragmentAdapter(getActivity(),list);
        muitianglelivefragmentGridview.setAdapter(muitiangleLiveFragmentAdapter);
    }

    @Override
    protected void loadData() {
        presenter.start();
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

    @Override
    public void getPandaLiveFragment(PandaLiveFragmentBean pandaLiveFragmentBean) {

    }

    @Override
    public void getPandaLiveFragmentMultiAngle(PandaLiveFragmentMultiAngleBean pandaLiveFragmentMultiAngleBean) {
        list.addAll(pandaLiveFragmentMultiAngleBean.getList());
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                muitiangleLiveFragmentAdapter.notifyDataSetChanged();
            }
        });
        Log.e("TAG","JJJ"+pandaLiveFragmentMultiAngleBean.getList().get(0).getTitle());
    }

    @Override
    public void getWatchandChatBean(WatchandChatBean watchandChatBean) {

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
}
