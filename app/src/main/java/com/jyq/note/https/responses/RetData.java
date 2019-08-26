package com.jyq.note.https.responses;

import com.jyq.note.https.utils.GsonUtils;

/**
 * Created by jingkai on 2017/12/7.
 */

public class RetData extends BaseRet {
    public static String toJson(int code, String msg, String strData) {
        RetData ret = new RetData();
        ret.code = code;
        ret.msg = msg;
        ret.data = GsonUtils.changeGsonToBean(strData, Object.class);
        String strRet = GsonUtils.createGsonString(ret);
        return strRet;
    }

    Object data;
}
