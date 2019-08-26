package com.jyq.note.https;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jyq.note.https.utils.GsonUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by jingkai on 2017/12/4.
 */

public class JsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    TypeToken<?> m_t;


    public JsonResponseBodyConverter(Gson gson, TypeToken<?> t) {
        if (gson == null) throw new NullPointerException("gson == null");
        this.gson = gson;
        m_t = t;
    }

    @Override
    public T convert(ResponseBody responseBody) throws IOException {
        String response = responseBody.string();

        String strResult = response.substring(0, response.length());
        Map datamap = GsonUtils.changeGsonToMaps(strResult);

        if (datamap != null) {
            String msg = (String) datamap.get("msg");
            String code = String.valueOf((Double) datamap.get("code"));
            if (!"200.0".equals(code)) {
                try {
                    Map hashMap = new HashMap();
                    hashMap.put("code", code);
                    hashMap.put("msg", msg);
                    strResult = gson.toJson(hashMap);
                    T pageBean = (T) gson.fromJson(strResult, m_t.getType());
                    return pageBean;
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        } else {
            return null;
        }
        T pageBean = (T) gson.fromJson(strResult, m_t.getType());
        return pageBean;
    }

}
