package com.jyq.note.https.Responses;

import java.io.Serializable;

public class BaseRet implements Serializable {
    int code;
    String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public boolean isSuccess() {
        if (code == 200) {
            return true;
        } else if (code == 410 || code == 411 || code == 413) {
//            SPUtils.putString( "accessToken", "");
//            //小部件刷新按钮的标记置为false,然后采用回调的方式清除桌面小组件数据
//            SPUtils.putBoolean( "widget", false);
//            SPUtils.putString( "userName", "");
//            SPUtils.putString( "userPassword", "");
//            SPUtils.putString( ConstValue.AUTOLOGINFLAG, "");
//            AlarmReceiver.clear(App.getApp());
//            //取消所有重要提醒闹钟
//            ImportantReceiver.clear(App.getApp());
//            DelayRemindReceiver.clear(App.getApp());
//            Intent intent = new Intent(App.getApp(), LoginActivity_.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            App.getApp().startActivity(intent);
//            CacheActivity.finishActivity();
            return false;
        } else {
//            App.showShort(getMsg());
            return false;
        }
    }


}


