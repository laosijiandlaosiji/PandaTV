package com.example.administrator.pandatv.utils;


import android.widget.Toast;

import com.example.administrator.pandatv.base.BaseActivity;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

public class ShareUtils {


    public  static void share(final BaseActivity context, String sting, String imgUrl){
        new ShareAction(context)
                .withText("hello")
                .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                .setCallback(new UMShareListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {

                    }

                    @Override
                    public void onResult(SHARE_MEDIA share_media) {
                        Toast.makeText(context,"成功了",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, Throwable throwable) {
                        Toast.makeText(context,"失败"+throwable.getMessage(),Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media) {
                            Toast.makeText(context,"取消了",Toast.LENGTH_LONG).show();
                    }
                })
                .open();
    }
}
