package com.daewichan.myfood.data.remote;

/**
 * Created by daewichan on 3/6/18.
 */

public class AppUtility {
    //http://padcmyanmar.com/padc-3/burpple-food-places/apis/v1/getFeatured.php
    public static final String BASE_URL="http://padcmyanmar.com/padc-3/burpple-food-places/apis/v1/";

    public static ApiService getService(){
        return RetrofitClient.getRetrofit(BASE_URL).create(ApiService.class);

    }
}
