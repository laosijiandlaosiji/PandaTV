package com.example.administrator.pandatv.ui.pandaculture;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.pandatv.R;
import com.example.administrator.pandatv.base.BaseActivity;
import com.example.administrator.pandatv.entity.PandacultureDetailsBean;
import com.example.administrator.pandatv.entity.PandacultureListViewBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import in.srain.cube.views.ptr.PtrClassicDefaultFooter;
import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by li on 2017/7/31.
 */

public class PandacultureDetailsActivity extends BaseActivity implements PandacultureContract.View {
    @BindView(R.id.goback_butt)
    ImageView gobackButt;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.rollvideo_time_text)
    TextView rollvideoTimeText;
    @BindView(R.id.rollvideo_details_image_dismiss)
    ImageView rollvideoDetailsImageDismiss;
    @BindView(R.id.rollvideo_details_image_show)
    ImageView rollvideoDetailsImageShow;
    @BindView(R.id.pandaculture_rollvideo_details_zi)
    RelativeLayout pandacultureRollvideoDetailsZi;
    @BindView(R.id.pandaculture_rollvideo_details_listview)
    ListView pandacultureRollvideoDetailsListview;
    @BindView(R.id.pandaculture_rollvideo_details_ptr)
    PtrFrameLayout ptr;
    @BindView(R.id.collect_no)
    ImageView collectNo;
    @BindView(R.id.culture_insiad_probar)
    ProgressBar cultureInsiadProbar;
    @BindView(R.id.culture_insiad_relalayout)
    RelativeLayout cultureInsiadRelalayout;
    @BindView(R.id.rollvideo_jieshao_text)
    TextView rollvideoJieshaoText;
    @BindView(R.id.detiles_text)
    TextView detilesText;
    @BindView(R.id.share)
    ImageView share;
    private PandacultureContract.Presenter presenter;
    int p = 1;
    int x = 1;
    private PandacultureDetailsBean.VideosetBean._$0Bean bean1;
    private ArrayList<PandacultureDetailsBean.VideoBean> arrayList;

    @Override
    protected int getLayoutId() {
        return R.layout.pandaculture_rollvideo_details;
    }

    @Override
    protected void init() {
        presenter = new PandaculturePresenter(this);

        presenter.getPandacultureDetails("6", "VSET100311356635", p + "", "panda", "1");
        presenter.start();


        arrayList = new ArrayList<>();
        final PandacultureDetailsAdapter pandacultureDetailsAdapter = new PandacultureDetailsAdapter(this,arrayList);
        pandacultureRollvideoDetailsListview.setAdapter(pandacultureDetailsAdapter);
        PtrClassicDefaultHeader header = new PtrClassicDefaultHeader(this);
        header.setPadding(0, 15, 0, 10);
        PtrClassicDefaultFooter footer = new PtrClassicDefaultFooter(this);
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

                if(x<3) {
                    p+=1;
                    presenter.getPandacultureDetails("6", "VSET100311356635", p + "", "panda", "1");
                    presenter.start();
                    pandacultureDetailsAdapter.notifyDataSetChanged();
                }else {
                    Toast.makeText(PandacultureDetailsActivity.this, "没有更多数据了", Toast.LENGTH_SHORT).show();
                }
                frame.refreshComplete();
            }

            @Override
            //下拉刷新
            public void onRefreshBegin(PtrFrameLayout frame) {
                p=1;
                presenter.getPandacultureDetails("6", "VSET100311356635", p + "", "panda", "1");
                presenter.start();
                pandacultureDetailsAdapter.notifyDataSetChanged();
                frame.refreshComplete();
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void getListData(PandacultureListViewBean bean) {
    }

    @Override
    public void getPandacultureDetails(PandacultureDetailsBean bean) {
        arrayList.addAll(bean.getVideo());
        bean1 = bean.getVideoset().get_$0();
        Glide.with(this).load(bean.getVideoset().get_$0().getImg()).into(imageView);

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
        this.presenter = presenter;
    }

    @OnClick({R.id.goback_butt, R.id.pandaculture_rollvideo_details_zi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.goback_butt:
                break;
            case R.id.pandaculture_rollvideo_details_zi:

                if(x%2==1) {
//                    pandaLivefragmentShowLinear.setVisibility(View.VISIBLE);
                    rollvideoDetailsImageDismiss.setVisibility(View.GONE);
                    rollvideoDetailsImageShow.setVisibility(View.VISIBLE);
                    detilesText.setText(bean1.getDesc());
                    x++;
                }else {
                    rollvideoDetailsImageDismiss.setVisibility(View.VISIBLE);
                    rollvideoDetailsImageShow.setVisibility(View.GONE);
//                    pandaLivefragmentShowLinear.setVisibility(View.GONE);
                    detilesText.setText("");
                    x++;
                }

                break;
        }
    }
}
