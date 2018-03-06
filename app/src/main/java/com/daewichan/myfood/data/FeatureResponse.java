package com.daewichan.myfood.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by daewichan on 3/6/18.
 */

public class FeatureResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("page")
    private int page;

    @SerializedName("featured")
    private List<FeatureVO> featured;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public int getPage() {
        return page;
    }

    public List<FeatureVO> getFeatured() {
        return featured;
    }
}
