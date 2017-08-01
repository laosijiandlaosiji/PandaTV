package com.example.administrator.pandatv.app;

import android.app.Application;
import android.util.Log;

import com.example.administrator.pandatv.base.BaseActivity;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * Created by Administrator on 2017/7/27.
 */

public class App extends Application {

    public static BaseActivity context = null;

    {
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("1106323606", "OcbBhTQtuMR5Eu4j");
        PlatformConfig.setSinaWeibo("3851680363", "13903bb1ff884458342f65a758fa51a8", "http://sns.whalecloud.com");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Config.DEBUG=true;
        UMShareAPI.get(this);

        PushAgent mPushAgent = PushAgent.getInstance(this);
//注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                Log.e("APP","LYH"+deviceToken);
                //注册成功会返回device token
            }

            @Override
            public void onFailure(String s, String s1) {

            }
        });
    }
}
