package com.jyq.note.utils;

import android.widget.Toast;

import com.jyq.note.App;

/**
 * Created by pc on 2019/8/22.
 */

public class ToastUtils {

    public static void showShort(String text){
        try {
            Toast.makeText(App.getApp(),text,Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            LogUtils.print("Exception === "+ e.toString());
        }
    }

    public static void showShort(int resId){
        try {
            Toast.makeText(App.getApp(), App.getApp().getResources().getString(resId),Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            LogUtils.print("Exception === "+ e.toString());
        }
    }

    public static void showLong(String text){
        try {
            Toast.makeText(App.getApp(),text,Toast.LENGTH_LONG).show();
        }catch (Exception e){
            LogUtils.print("Exception === "+ e.toString());
        }
    }

    public static void showLong(int resId){
        try {
            Toast.makeText(App.getApp(), App.getApp().getResources().getString(resId),Toast.LENGTH_LONG).show();
        }catch (Exception e){
            LogUtils.print("Exception === "+ e.toString());
        }
    }

}
