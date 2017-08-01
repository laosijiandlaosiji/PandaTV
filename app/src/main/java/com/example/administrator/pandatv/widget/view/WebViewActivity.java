package com.example.administrator.pandatv.widget.view;

import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.administrator.pandatv.R;
import com.example.administrator.pandatv.base.BaseActivity;

import butterknife.BindView;

public class WebViewActivity extends BaseActivity {

    @BindView(R.id.webview)
    WebView webview;
    private WebSettings settings;
    private String url;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_web_view;
    }

    @Override
    protected void init() {
        url = getIntent().getStringExtra("url");

        settings = webview.getSettings();

        settings.setJavaScriptEnabled(true);
//        将图片控制到适合webview的大小
        settings.setUseWideViewPort(true);
//        缩放至屏幕大小
        settings.setLoadWithOverviewMode(true);

        settings.setSupportZoom(true);

        settings.setBuiltInZoomControls(true);

        settings.setDisplayZoomControls(false);

        webview.loadUrl(url);
    }
}
