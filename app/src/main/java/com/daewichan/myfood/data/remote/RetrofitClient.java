package com.daewichan.myfood.data.remote;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by daewichan on 3/6/18.
 */

public class RetrofitClient {
    public static Retrofit retrofit=null;

    public static Retrofit getRetrofit(String baseUrl){
        if (retrofit == null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
