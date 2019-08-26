package com.jyq.note.https;


import com.jyq.note.BuildConfig;
import com.jyq.note.consts.ConstValue;
import com.jyq.note.utils.SPUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class RequestHeaderInterceptor implements Interceptor {
    public RequestHeaderInterceptor() {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request originalRequest = chain.request();
        final long time = System.currentTimeMillis();
        Request updateRequest = originalRequest.newBuilder()
                .header("contentType", ConstValue.MetaTypeJson)
                .header("appId", ConstValue.APPID)
                .header("accessToken", SPUtils.getString(ConstValue.accessToken, ""))
                .header("signature", ConstValue.APPID)
                .header("clientVersion", BuildConfig.VERSION_NAME)
                .header("timestamp", String.valueOf(time))
                .build();

        return chain.proceed(updateRequest);
    }
}
