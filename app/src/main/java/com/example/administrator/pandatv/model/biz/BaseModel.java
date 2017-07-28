package com.example.administrator.pandatv.model.biz;

import com.example.administrator.pandatv.net.HttpFactroy;
import com.example.administrator.pandatv.net.IHttp;

/**
 * Created by Administrator on 2017/7/28.
 */

public interface BaseModel {
    public static IHttp iHttp = HttpFactroy.create();
}
