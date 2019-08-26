package com.jyq.note.utils;

import android.content.Intent;

import com.jyq.note.https.responses.BaseRet;

public class CallbackUtils {

    /*** 网络请求回调**/
    public interface ResponseCallback{
        public void setOnResponseCallback(String method, BaseRet baseRet);
    }

    private static ResponseCallback mResponseCallback;

    public static void setCallback(ResponseCallback callback){
        mResponseCallback = callback;
    }

    public static void doResponseCallBackMethod(String method,BaseRet baseRet){
        if(mResponseCallback != null){
            mResponseCallback.setOnResponseCallback(method,baseRet);
        }
    }


    /*** 页面回传数据回调**/
    public interface OnActivityCallBack {
        public void onActivityResult(int requestCode, int resultCode, Intent data);
    }

    public static OnActivityCallBack mOnActivityCallBack;

    public static void setOnActivityCallBack(OnActivityCallBack onActivityCallBack) {
        mOnActivityCallBack = onActivityCallBack;
    }

    public static void doResponseCallback(int requestCode, int resultCode, Intent data){
        if(mOnActivityCallBack != null){
            mOnActivityCallBack.onActivityResult(requestCode,resultCode,data);
        }
    }

    /*** 操作MainActivity界面bottom回调**/
    public interface OnBottomSelectListener {
        void setOnBottomSelectListener(int position);
    }

    public static OnBottomSelectListener mOnBottomSelectListener;

    public static void setOnBottomSelectListener(OnBottomSelectListener bottomSelectListener){
        mOnBottomSelectListener = bottomSelectListener;
    }

    public static void doBottomSelectCallback(int position){
        if(mOnBottomSelectListener != null){
            mOnBottomSelectListener.setOnBottomSelectListener(position);
        }
    }

    public interface OnExitListener {
        void setOnExitListener(String code);
    }

    public static OnExitListener mOnExitListener;

    public static void setOnExitListener(OnExitListener onExitListener){
        mOnExitListener = onExitListener;
    }

    public static void doExitCallback(String code){
        if(mOnExitListener != null){
            mOnExitListener.setOnExitListener(code);
        }
    }

}
