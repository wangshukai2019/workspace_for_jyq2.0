package com.jyq.note.https;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.jyq.note.https.responses.BaseRet;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by jingkai on 2017/12/4.
 */

public class SecretJsonConverterFactory extends Converter.Factory {

    /**
     * Create an instance using a default {@link Gson} instance for conversion. Encoding to JSON and
     * decoding from JSON (when no charset is specified by a header) will use UTF-8.
     */
    public static SecretJsonConverterFactory create() {
        return create(new Gson());
    }

    /**
     * Create an instance using {@code gson} for conversion. Encoding to JSON and
     * decoding from JSON (when no charset is specified by a header) will use UTF-8.
     */
    public static SecretJsonConverterFactory create(Gson gson) {
        return new SecretJsonConverterFactory(gson);
    }

    private final Gson gson;

    private SecretJsonConverterFactory(Gson gson) {
        if (gson == null) throw new NullPointerException("gson == null");
        this.gson = gson;
    }

    @Override
    public Converter<ResponseBody, BaseRet> responseBodyConverter(Type type, Annotation[] annotations,
                                                                  Retrofit retrofit) {

        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        TypeToken<?> t = TypeToken.get(type);

        return new JsonResponseBodyConverter(gson, t);
    }

//    @Override
//    public Converter<?, RequestBody> requestBodyConverter(Type type,
//                                                          Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
//        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
//        return new JsonRequestBodyConverter(gson, type1);
//    }
}

