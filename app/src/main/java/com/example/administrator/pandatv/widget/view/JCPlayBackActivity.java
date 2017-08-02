package com.example.administrator.pandatv.widget.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.pandatv.R;
import com.example.administrator.pandatv.base.BaseActivity;
import com.example.administrator.pandatv.utils.VideoPlaybackUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by li on 2017/8/2.
 */

public class JCPlayBackActivity extends BaseActivity {


    @BindView(R.id.culture_tiitle)
    TextView cultureTiitle;
    @BindView(R.id.img1)
    ImageView img1;
    @BindView(R.id.img2)
    ImageView img2;
    @BindView(R.id.culture_jc)
    JCVideoPlayerStandard cultureJc;

    @Override
    public int getLayoutId() {
        return R.layout.activity_playback_sp;
    }

    @Override
    protected void init() {
        String url = getIntent().getStringExtra("url");
        String title = getIntent().getStringExtra("title");
        Log.e("JCPlayBackActivity", "JC"+url);
        Log.e("JCPlayBackActivity", "JC"+title);
//        VideoUtils.getUtils().playVideo(cultureJc, url, "", "");
        cultureJc.setUp(url, JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, title);

        VideoPlaybackUtil.getIn(this,cultureJc).setUp(url, JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, title);
//        cultureJc.thumbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
//        Glide.with(this).load(R.mipmap._no_img).into(cultureJc.thumbImageView);
//        cultureTiitle.setText(title);

    }


//    @Override
//    public void onPause() {
//        super.onPause();
//        JCVideoPlayer.releaseAllVideos();
//    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }

        SharedPreferences.Editor s1 = getSharedPreferences("s1", MODE_PRIVATE).edit();
        s1.putBoolean("bool", false);
        s1.commit();
        super.onBackPressed();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
