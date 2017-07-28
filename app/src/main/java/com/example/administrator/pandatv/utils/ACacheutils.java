package com.example.administrator.pandatv.utils;

import com.example.administrator.pandatv.app.App;
import com.example.administrator.pandatv.widget.manager.ACache;

/**
 * Created by Administrator on 2017/7/28.
 */

public class ACacheutils {

    public static void save(String key,String value){
        ACache aCache = ACache.get(App.context);
        aCache.put(key,value);
    }
}
