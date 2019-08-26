package com.jyq.note.utils;

import android.util.Log;

import com.jyq.note.consts.ConstValue;


public class LogUtils {

    public static void print(String msg){
        if(ConstValue.flag){
            Log.i("123456",msg);
        }
    }
}
