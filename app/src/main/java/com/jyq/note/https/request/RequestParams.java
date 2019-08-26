package com.jyq.note.https.request;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.jyq.note.https.utils.GsonUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.lang.reflect.Field;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * @author VurtneWk
 * 18/5/17.
 */
public class RequestParams {

    // 请求的具体参数对象
    private JSONObject mJSONObject;

    public RequestParams() {
        mJSONObject = new JSONObject();
    }


    public RequestParams put(String key, String value) {
        try {
            mJSONObject.put(key, value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public RequestParams put(String key, int value) {
        try {
            mJSONObject.put(key, value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public RequestParams set(JSONObject jsonObj) {
        try {
            mJSONObject = jsonObj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public RequestParams put(String key, JsonObject value) {
        try {
            mJSONObject.put(key, value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }


    public RequestParams put(String key, List<? extends Object> list) {
        try {
            JSONArray mJSONArray = new JSONArray();
            for (int i = 0; i < list.size(); i++) {
                Object obj = list.get(i);
                Field[] fields = obj.getClass().getDeclaredFields();
                JSONObject jsonObj = new JSONObject();

                for (Field field : fields) {
                    field.setAccessible(true);
                    jsonObj.put(field.getName(), field.get(obj));
                }
                mJSONArray.put(jsonObj);
            }
            mJSONObject.put(key, mJSONArray);
        } catch (IllegalAccessException | IllegalArgumentException | JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public RequestParams put(String key, JsonArray value) {
        try {
            mJSONObject.put(key, value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public RequestParams put(String key, Object value) {
        try {
            mJSONObject.put(key, value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }


    public RequestParams put(String key, double value) {
        try {
            mJSONObject.put(key, value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }


    public RequestBody getBody() {
        return getBody("application/json; charset=utf-8");
    }

    public RequestBody getBody(String mMediaType) {
        return RequestBody.create(MediaType.parse(mMediaType), mJSONObject.toString());
    }

    public RequestBody getBody(String mMediaType, String json) {
        return RequestBody.create(MediaType.parse(mMediaType), json);
    }

    public RequestBody getBody(Object bean) {
        String gson = GsonUtils.createGsonString(bean);
        return RequestBody.create(MediaType.parse("application/json; charset=utf-8"), gson);
    }


    public MultipartBody.Part getUploadBody(File file) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        String name = file.getName();
        String prefix = name.substring(name.lastIndexOf(".") + 1);
        return MultipartBody.Part.createFormData("FilePath", "userHead." + prefix, requestBody);
    }

    public JSONObject getmJSONObject() {
        return mJSONObject;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("").append(mJSONObject);
        return sb.toString();
    }
}
