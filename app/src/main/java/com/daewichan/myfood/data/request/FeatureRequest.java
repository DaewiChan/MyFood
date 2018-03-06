package com.daewichan.myfood.data.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by daewichan on 3/6/18.
 */

public class FeatureRequest {

    @Expose
    @SerializedName("access_token")
    private String accessToken;

    @Expose
    @SerializedName("page")
    private String page;

    public FeatureRequest(String accessToken, String page) {
        this.accessToken = accessToken;
        this.page = page;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getPage() {
        return page;
    }
}
