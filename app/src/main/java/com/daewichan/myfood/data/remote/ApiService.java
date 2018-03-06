package com.daewichan.myfood.data.remote;

import com.daewichan.myfood.data.FeatureResponse;
import com.daewichan.myfood.data.request.FeatureRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by daewichan on 3/6/18.
 */

public interface ApiService {

//    @POST("getFeatured.php")
//    Call<FeatureResponse> getFood(@Body FeatureRequest featureRequest);

    @FormUrlEncoded
    @POST("getFeatured.php")
    Call<FeatureResponse> getFood(@Field("page") int page,
                                              @Field("access_token") String accessToken);
}
