package com.jyq.note.https;

import com.jyq.note.consts.ConstValue;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

public class ApiRetrofit {
    public static synchronized ApiRetrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new ApiRetrofit();
        }
        return retrofit;
    }

    private ApiRetrofit() {
        initRetrofit();
    }

    public static Retrofit initRetrofit() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        OkHttpClient apiClientClient = builder.connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(new RequestHeaderInterceptor())
                .addInterceptor(new RequestEncryptInterceptor())
                .build();

        Retrofit apiRetrofit = new Retrofit.Builder()
                .baseUrl(ConstValue.SERVR_URL)
                .addConverterFactory(SecretJsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(apiClientClient)
                .build();

        mApiService = apiRetrofit.create(ApiService.class);
        return apiRetrofit;
    }

    private static ApiRetrofit retrofit;

    private static ApiService mApiService;

    public ApiService getApiService() {
        return mApiService;
    }
}
