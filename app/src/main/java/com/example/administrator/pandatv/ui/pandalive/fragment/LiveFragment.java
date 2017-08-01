package com.example.administrator.pandatv.ui.pandalive.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.pandatv.R;
import com.example.administrator.pandatv.base.BaseFragment;
import com.example.administrator.pandatv.entity.PandaLiveFragmentBean;
import com.example.administrator.pandatv.entity.PandaLiveFragmentMultiAngleBean;
import com.example.administrator.pandatv.ui.pandalive.fragment.MultiAngleLiveFragment.MuitiangleLiveFragment;
import com.example.administrator.pandatv.ui.pandalive.fragment.WatchAndChatFragment.WatchandChatFragment;
import com.example.administrator.pandatv.widget.view.NonSwipeableViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.example.administrator.pandatv.R.id.pandaLive_livefragment_introduction;
import static com.example.administrator.pandatv.R.id.panda_livefragment_showLinear;

/**
 * Created by li on 2017/7/30.
 */

public class LiveFragment extends BaseFragment implements LiveFragmentContract.View{
    Unbinder unbinder;
    @BindView(R.id.pandaLive_livefragment_pandaFirst)
    ImageView pandaLiveLivefragmentPandaFirst;
    @BindView(R.id.pandaLive_livefragment_detailDown)
    ImageView pandaLiveLivefragmentDetailDown;
    @BindView(R.id.pandaLive_livefragment_detailUp)
    ImageView pandaLiveLivefragmentDetailUp;
    @BindView(R.id.pandaLive_livefragment_showIntroduction)
    RelativeLayout pandaLiveLivefragmentShowIntroduction;
    @BindView(pandaLive_livefragment_introduction)
    TextView pandaLiveLivefragmentIntroduction;
    @BindView(R.id.pandaLive_introductionDV)
    View pandaLiveIntroductionDV;
    @BindView(panda_livefragment_showLinear)
    LinearLayout pandaLivefragmentShowLinear;
    @BindView(R.id.pandaLive_livefragment_bookMark_tab)
    TabLayout pandaLiveLivefragmentBookMarkTab;
    @BindView(R.id.pandaLive_livefragment_mainPager)
    NonSwipeableViewPager pandaLiveLivefragmentMainPager;
    @BindView(R.id.live_main_stick)
    ScrollView liveMainStick;
    private LiveFragmentContract.Presenter presenter;
    private List<PandaLiveFragmentBean.LiveBean> live;
    int x=1;
    @Override
    protected int getLayoutId() {
        return R.layout.livefragment;
    }

    @Override
    protected void init(View view) {
        presenter = new LiveFragmentPresenter(this);
        ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
        MuitiangleLiveFragment muitiangleLiveFragment = new MuitiangleLiveFragment();
        WatchandChatFragment watchandChatFragment = new WatchandChatFragment();
        fragmentArrayList.add(muitiangleLiveFragment);
        fragmentArrayList.add(watchandChatFragment);
        LiveFragmentViewPagerAdapter liveFragmentViewPagerAdapter = new LiveFragmentViewPagerAdapter(getChildFragmentManager(),fragmentArrayList);
        pandaLiveLivefragmentMainPager.setAdapter(liveFragmentViewPagerAdapter);
        pandaLiveLivefragmentBookMarkTab.setupWithViewPager(pandaLiveLivefragmentMainPager);
        pandaLiveLivefragmentBookMarkTab.setTabMode(TabLayout.MODE_FIXED);
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

    @OnClick(R.id.pandaLive_livefragment_showIntroduction)
    public void onViewClicked() {
        if(x%2==1) {
            pandaLivefragmentShowLinear.setVisibility(View.VISIBLE);
            pandaLiveLivefragmentDetailDown.setVisibility(View.GONE);
            pandaLiveLivefragmentDetailUp.setVisibility(View.VISIBLE);
            pandaLiveLivefragmentIntroduction.setText(live.get(0).getBrief());
            x++;
        }else {
            pandaLiveLivefragmentDetailDown.setVisibility(View.VISIBLE);
            pandaLiveLivefragmentDetailUp.setVisibility(View.GONE);
            pandaLivefragmentShowLinear.setVisibility(View.GONE);
            pandaLiveLivefragmentIntroduction.setText("");
            x++;
        }
    }

    @Override
    public void getPandaLiveFragment(PandaLiveFragmentBean pandaLiveFragmentBean) {
        live = pandaLiveFragmentBean.getLive();
        Glide.with(getActivity()).load(live.get(0).getImage()).into(pandaLiveLivefragmentPandaFirst);
    }

    @Override
    public void getPandaLiveFragmentMultiAngle(PandaLiveFragmentMultiAngleBean pandaLiveFragmentMultiAngleBean) {
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
    public void setPresenter(LiveFragmentContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
