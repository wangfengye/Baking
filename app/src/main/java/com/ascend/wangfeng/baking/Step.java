package com.ascend.wangfeng.baking;

import java.io.Serializable;

/**
 * Created by fengye on 2017/9/29.
 * email 1040441325@qq.com
 */

public class Step implements Serializable{
    private int mId;
    private String mShortDescription;
    private String mDescription;
    private String mVideoUrl;
    private String mThumbanilUrl;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getShortDescription() {
        return mShortDescription;
    }

    public void setShortDescription(String shortDescription) {
        mShortDescription = shortDescription;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getVideoUrl() {
        return mVideoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        mVideoUrl = videoUrl;
    }

    public String getThumbanilUrl() {
        return mThumbanilUrl;
    }

    public void setThumbanilUrl(String thumbanilUrl) {
        mThumbanilUrl = thumbanilUrl;
    }
}
