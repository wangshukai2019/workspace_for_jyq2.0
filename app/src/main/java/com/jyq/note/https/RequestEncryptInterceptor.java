package com.jyq.note.https;


import com.jyq.note.https.responses.RetData;
import com.jyq.note.https.responses.RetSecret;
import com.jyq.note.utils.LogUtils;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

public class RequestEncryptInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        String sKey = "";
        try {
            sKey = CJsonSecret.getKey(request.url().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        RequestBody body = request.body();

        if (null != body) {
            Buffer buffer = new Buffer();
            body.writeTo(buffer);
            Charset charset = Charset.forName("UTF-8");
            MediaType contentType = body.contentType();
            if (contentType != null) {
                //add by wangsk 表单文件不能往下走
                if (contentType.toString().startsWith("multipart/")) {
                    return chain.proceed(request);
                }//end
                charset = contentType.charset(charset);
            }
            String paramsStr = buffer.readString(charset);
            try {
                paramsStr = AESUtils.Encrypt(paramsStr, sKey);
            } catch (Exception e) {
            }
            RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), paramsStr);
            request = request.newBuilder().post(requestBody).build();
        }

        Response response = chain.proceed(request);
        response = decrypt(response, sKey);
        return response;
    }

    private Response decrypt(Response response, String sKey) throws IOException {
        if (response.isSuccessful()) { //the response data
            ResponseBody body = response.body();
            BufferedSource source = body.source();
            source.request(Long.MAX_VALUE); // Buffer the entire body.
            Buffer buffer = source.buffer();
            Charset charset = Charset.defaultCharset();
            MediaType contentType = body.contentType();
            if (contentType != null) {
                charset = contentType.charset(charset);
            }
            String strResult = buffer.clone().readString(charset);
            RetSecret retSecret = RetSecret.parse(strResult);
            if (retSecret != null && retSecret.isNeedDecrypt()) {
                String data = AESUtils.Decrypt(retSecret.data, sKey);
                strResult = RetData.toJson(200, retSecret.getMsg(), data);
                LogUtils.print("服务器返回数据  "+ strResult);
            }

            ResponseBody responseBody = ResponseBody.create(contentType, strResult);
            response = response.newBuilder().body(responseBody).build();
        }
        return response;
    }

}
