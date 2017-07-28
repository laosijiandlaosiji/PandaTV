package com.example.administrator.pandatv.widget.manager;

import android.widget.Toast;

import com.example.administrator.pandatv.app.App;


public class ToastManager {

    public static void show(String msg){
        Toast.makeText(App.context,msg,Toast.LENGTH_SHORT).show();
    }
}
