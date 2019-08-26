package com.jyq.note.https.responses;

import com.jyq.note.https.utils.GsonUtils;

public class RetSecret extends BaseRet {
    public RetSecret() {
        code = -1;
    }

    public static RetSecret parse(String strVal) {
        RetSecret obj = GsonUtils.changeGsonToBean(strVal, RetSecret.class);
        return obj;
    }


    public boolean isNeedDecrypt() {
        return isSuccess() && (data != null && data.length() > 0);
    }

    public String data;

    @Override
    public String toString() {
        return "RetSecret{super=${super.toString()} data =}" + data;
    }
}
