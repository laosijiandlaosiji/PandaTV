package com.example.administrator.pandatv.model.biz.login;


import android.os.Bundle;

import com.example.administrator.pandatv.entity.Register;
import com.example.administrator.pandatv.model.biz.BaseModel;
import com.example.administrator.pandatv.net.callback.MyNetWorkCallback;

public interface IRegisterModel extends BaseModel{
    void loadImgCode(MyNetWorkCallback<Bundle> callback);
    void loadPhoneImg(MyNetWorkCallback<Bundle> callback);
    void emailRegister(String email,String passWord,String cookie,String imgCode,MyNetWorkCallback<Register> callback);
    void phoneVerfiCodeRegister(String phone,String cookie,String imgCode,MyNetWorkCallback<Bundle> callback);
    void phoneRegisers(String phone,String passWord,String verifiCode,MyNetWorkCallback<Bundle> callback);
}
