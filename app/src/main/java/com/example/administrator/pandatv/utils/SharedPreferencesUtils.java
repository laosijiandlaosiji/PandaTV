package com.example.administrator.pandatv.utils;


import android.content.Context;
import android.content.SharedPreferences;

import com.example.administrator.pandatv.app.App;

public class SharedPreferencesUtils {


    public static void putString(String key,String value){
        SharedPreferences sharedPreferences = App.context.getSharedPreferences("accent", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(key,value);
        edit.commit();
    }

    public static void putBoolean(String key,boolean value){
        SharedPreferences sharedPreferences = App.context.getSharedPreferences("accent", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean(key,value);
        edit.commit();
    }

    public static String getString(String key){
        SharedPreferences sharedPreferences = App.context.getSharedPreferences("accent", Context.MODE_PRIVATE);
        String string = sharedPreferences.getString(key,"");
        return string;
    }

    public static boolean getBoolean(String key){
        SharedPreferences sharedPreferences = App.context.getSharedPreferences("accent", Context.MODE_PRIVATE);
        boolean aBoolean = sharedPreferences.getBoolean(key, false);
        return aBoolean;
    }
}
