package com.example.administrator.pandatv.ui.pandaculture;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.pandatv.R;
import com.example.administrator.pandatv.base.BaseActivity;
import com.example.administrator.pandatv.entity.PandaCultureSYSPBean;
import com.example.administrator.pandatv.entity.PandacultureDetailsBean;
import com.example.administrator.pandatv.entity.PandacultureDetailsSPBean;
import com.example.administrator.pandatv.entity.PandacultureListViewBean;
import com.example.administrator.pandatv.utils.ShareUtils;
import com.example.administrator.pandatv.utils.SharedPreferencesUtils;
import com.example.administrator.pandatv.utils.VideoPlaybackUtil;
import com.example.administrator.pandatv.widget.view.CustomDialog;
import com.example.administrator.pandatv.widget.view.JCPlayBackActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCUserAction;
import fm.jiecao.jcvideoplayer_lib.JCUserActionStandard;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
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
    @BindView(R.id.culture_cctv_video)
    JCVideoPlayerStandard jcvideoplayer;
    private PandacultureContract.Presenter presenter;
    int p = 1;
    int x = 1;
    private PandacultureDetailsBean.VideosetBean._$0Bean bean1;
    private ArrayList<PandacultureDetailsBean.VideoBean> arrayList;
    private ArrayList<String> stringArrayList;
    private List<PandacultureDetailsBean.VideoBean> video;
    private PandacultureDetailsAdapter pandacultureDetailsAdapter;
    private String url;
    private String title;


    @Override
    protected int getLayoutId() {
        return R.layout.pandaculture_rollvideo_details;
    }

    @Override
    protected void init() {
        presenter = new PandaculturePresenter(this);
        presenter.getPandacultureDetails("6", "VSET100311356635", p + "", "panda", "1");
        stringArrayList = new ArrayList<>();
        String vid = SharedPreferencesUtils.getString("vid");
        Log.e("PandacultureDetailsActi", "ha666"+vid);
        presenter.getPandacultureDetailsSP(""+vid);
        presenter.start();



        arrayList = new ArrayList<>();
        pandacultureDetailsAdapter = new PandacultureDetailsAdapter(this, arrayList);
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
                p++;
                if (p==2) {
                    presenter.getPandacultureDetails("6", "VSET100311356635", p + "", "panda", "1");
                    pandacultureDetailsAdapter.notifyDataSetChanged();
                }
                if (p==3){
                    Toast.makeText(PandacultureDetailsActivity.this, "没有更多数据了", Toast.LENGTH_SHORT).show();
                    pandacultureDetailsAdapter.notifyDataSetChanged();
                }
                if(p==4) {
                    p--;
                }
                frame.refreshComplete();



            }

            @Override
            //下拉刷新
            public void onRefreshBegin(PtrFrameLayout frame) {
                p = 1;
                presenter.getPandacultureDetails("6", "VSET100311356635", p + "", "panda", "1");
                pandacultureDetailsAdapter.notifyDataSetChanged();
                frame.refreshComplete();
            }
        });

    }


    @Override
    public void getListData(PandacultureListViewBean bean) {
    }

    @Override
    public void getPandacultureDetails(PandacultureDetailsBean bean) {
        arrayList.addAll(bean.getVideo());
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                pandacultureDetailsAdapter.notifyDataSetChanged();
            }
        });
        bean1 = bean.getVideoset().get_$0();
        video = bean.getVideo();
        String vid = video.get(0).getVid();
        SharedPreferencesUtils.putString("vid",vid);

        pandacultureRollvideoDetailsListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SharedPreferencesUtils.putString("vid",video.get(position).getVid());
            }
        });

        Log.d("PandacultureDetailsActi", vid);
//        for (int i=0;i<video.size();i++){
//
////            stringArrayList.add(vid);
//        }
//        presenter.getPandacultureDetailsSP(""+vid);
    }

    @Override
    public void getPandacultureDetailsSP(PandacultureDetailsSPBean bean) {
        Log.d("PandacultureDetailsActi", "+++++"+bean.getColumn());
        url = bean.getVideo().getChapters().get(0).getUrl();
        title = bean.getTitle();
        Log.d("PandacultureDetailsActi","url:"+ url);
        //http://tv.cntv.cn/video/VSET100311356635/e2ce1fa0a295447cb242235167d52ca8
//        jcvideoplayer.setUp(url,JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,title);
////        jcvideoplayer.onStatePlaybackBufferingStart();
//        jcvideoplayer.setJcUserAction(new MyUserActionStandard());
//        jcvideoplayer.startVideo();
                VideoPlaybackUtil.getIn(PandacultureDetailsActivity.this,jcvideoplayer).setUp(url,JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, title);
    }

    @Override
    public void getcultureSP(PandaCultureSYSPBean pandaCultureSYSPBean) {

    }

    @Override
    public void showProgress() {
        CustomDialog.show(this);
    }

    @Override
    public void closeProgress() {
        CustomDialog.dimiss();
    }

    @Override
    public void showMessage(String msg) {
    }

    @Override
    public void setPresenter(PandacultureContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @OnClick({R.id.goback_butt, R.id.pandaculture_rollvideo_details_zi,R.id.share,R.id.collect_no})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.goback_butt:
                break;
            case R.id.pandaculture_rollvideo_details_zi:

                if (x % 2 == 1) {
//                    pandaLivefragmentShowLinear.setVisibility(View.VISIBLE);
                    rollvideoDetailsImageDismiss.setVisibility(View.GONE);
                    rollvideoDetailsImageShow.setVisibility(View.VISIBLE);
                    detilesText.setText(bean1.getDesc());
                    x++;
                } else {
                    rollvideoDetailsImageDismiss.setVisibility(View.VISIBLE);
                    rollvideoDetailsImageShow.setVisibility(View.GONE);
//                    pandaLivefragmentShowLinear.setVisibility(View.GONE);
                    detilesText.setText("");
                    x++;
                }

                break;
            case R.id.share:
                ShareUtils.share(this,"我又帅了","");
                break;
            case R.id.collect_no:
                Intent intent = new Intent(PandacultureDetailsActivity.this, JCPlayBackActivity.class);
                intent.putExtra("url",url);
                intent.putExtra("title",title);
                startActivity(intent);
                break;
        }

    }

    public class MyUserActionStandard implements JCUserActionStandard {

        @Override
        public void onEvent(int type, String url, int screen, Object... objects) {
            switch (type) {
                case JCUserAction.ON_CLICK_START_ICON:
                    Log.i("USER_EVENT", "ON_CLICK_START_ICON" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                case JCUserAction.ON_CLICK_START_ERROR:
                    Log.i("USER_EVENT", "ON_CLICK_START_ERROR" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                case JCUserAction.ON_CLICK_START_AUTO_COMPLETE:
                    Log.i("USER_EVENT", "ON_CLICK_START_AUTO_COMPLETE" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                case JCUserAction.ON_CLICK_PAUSE:
                    Log.i("USER_EVENT", "ON_CLICK_PAUSE" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                case JCUserAction.ON_CLICK_RESUME:
                    Log.i("USER_EVENT", "ON_CLICK_RESUME" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                case JCUserAction.ON_SEEK_POSITION:
                    Log.i("USER_EVENT", "ON_SEEK_POSITION" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                case JCUserAction.ON_AUTO_COMPLETE:
                    Log.i("USER_EVENT", "ON_AUTO_COMPLETE" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                case JCUserAction.ON_ENTER_FULLSCREEN:
                    Log.i("USER_EVENT", "ON_ENTER_FULLSCREEN" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                case JCUserAction.ON_QUIT_FULLSCREEN:
                    Log.i("USER_EVENT", "ON_QUIT_FULLSCREEN" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                case JCUserAction.ON_ENTER_TINYSCREEN:
                    Log.i("USER_EVENT", "ON_ENTER_TINYSCREEN" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                case JCUserAction.ON_QUIT_TINYSCREEN:
                    Log.i("USER_EVENT", "ON_QUIT_TINYSCREEN" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                case JCUserAction.ON_TOUCH_SCREEN_SEEK_VOLUME:
                    Log.i("USER_EVENT", "ON_TOUCH_SCREEN_SEEK_VOLUME" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                case JCUserAction.ON_TOUCH_SCREEN_SEEK_POSITION:
                    Log.i("USER_EVENT", "ON_TOUCH_SCREEN_SEEK_POSITION" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;

                case JCUserActionStandard.ON_CLICK_START_THUMB:
                    Log.i("USER_EVENT", "ON_CLICK_START_THUMB" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                case JCUserActionStandard.ON_CLICK_BLANK:
                    Log.i("USER_EVENT", "ON_CLICK_BLANK" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                default:
                    Log.i("USER_EVENT", "unknow");
                    break;
            }
        }
    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//        JCVideoPlayer.releaseAllVideos();
//    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
