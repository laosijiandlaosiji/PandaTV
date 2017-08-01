package com.example.administrator.pandatv.ui.pandaculture;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.pandatv.R;
import com.example.administrator.pandatv.base.BaseFragment;
import com.example.administrator.pandatv.entity.PandacultureDetailsBean;
import com.example.administrator.pandatv.entity.PandacultureListViewBean;
import com.example.administrator.pandatv.widget.view.BannerImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import in.srain.cube.views.ptr.PtrClassicDefaultFooter;
import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

/**
 * Created by Administrator on 2017/7/28.
 */

public class PandaCultureFragment extends BaseFragment implements PandacultureContract.View {
//    @BindView(R.id.pandaculture_image)
//    ImageView pandacultureImage;
    Unbinder unbinder;
    @BindView(R.id.pandaculture_xrecycler)
    ListView pandacultureXrecycler;
        @BindView(R.id.pandaculture_ptr)
    PtrFrameLayout ptr;
    private PandacultureContract.Presenter pan;
    private ArrayList<PandacultureListViewBean.ListBean> arrayList;
    private PandacultureXrecyClerAdapter adapter;
    private ArrayList<String> bannerlist;
    private Banner banner;
    private ArrayList<String> bannertitlelist;
    private List<PandacultureListViewBean.ListBean> livelist;

    @Override
    protected int getLayoutId() {
        return R.layout.pandaculturefragment;
    }

    @Override
    protected void init(View view) {
        pan = new PandaculturePresenter(this);
        arrayList = new ArrayList<>();
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.panda_culture_headerview, null);
        banner = (Banner) inflate.findViewById(R.id.banner);
        bannerlist = new ArrayList();
        bannertitlelist = new ArrayList<>();
        pandacultureXrecycler.addHeaderView(inflate);
        adapter = new PandacultureXrecyClerAdapter(getActivity(), arrayList);
        pandacultureXrecycler.setAdapter(adapter);
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
        ptr.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                arrayList.clear();

                loadData();
                adapter.notifyDataSetChanged();
                frame.refreshComplete();
            }
        });
        pandacultureXrecycler.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(livelist.get(0).getType().equals("2")) {
                        Intent intent = new Intent(getActivity(),PandacultureDetailsActivity.class);
                        startActivity(intent);
                    }
            }
        });
//

//        ptr.setPtrHandler(new PtrDefaultHandler2() {
//            @Override
//            //上拉加载
//            public void onLoadMoreBegin(PtrFrameLayout frame) {
//            }
//
//            @Override
//            //下拉刷新
//            public void onRefreshBegin(PtrFrameLayout frame) {
//                arrayList.clear();
//                loadData();
//                adapter.notifyDataSetChanged();
//                frame.refreshComplete();
//            }
//        });

    }

            public void getBanner(){

            }


    @Override
    protected void loadData() {
        pan.start();
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
    public void getListData(PandacultureListViewBean bean) {

        livelist = bean.getList();

//        Glide.with(getActivity()).load(bean.getBigImg().get(0).getImage()).into(pandacultureImage);
        arrayList.addAll(bean.getList());

        List<PandacultureListViewBean.BigImgBean> bigImg = bean.getBigImg();
        for (int i = 0;i<bigImg.size();i++){
            bannerlist.add(bigImg.get(i).getImage());
            bannertitlelist.add(bigImg.get(i).getTitle());
        }
        banner.setImageLoader(new BannerImageLoader());
        banner.isAutoPlay(true);
        banner.setDelayTime(2000);
        banner.setImages(bannerlist);
        banner.setBannerTitles(bannertitlelist);
        banner.start();

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void getPandacultureDetails(PandacultureDetailsBean bean) {

    }

    @Override
    public void getErreo(String m) {

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
    public void setPresenter(PandacultureContract.Presenter presenter) {
        this.pan = presenter;
    }
}
