package com.ascend.wangfeng.baking;

import java.io.Serializable;

/**
 * Created by fengye on 2017/9/29.
 * email 1040441325@qq.com
 */

public class Ingredient implements Serializable{
    private double mQuantity;
    private String mMeasure;
    private String mIngredient;

    public double getQuantity() {
        return mQuantity;
    }

    public void setQuantity(double quantity) {
        mQuantity = quantity;
    }

    public String getMeasure() {
        return mMeasure;
    }

    public void setMeasure(String measure) {
        mMeasure = measure;
    }

    public String getIngredient() {
        return mIngredient;
    }

    public void setIngredient(String ingredient) {
        mIngredient = ingredient;
    }
}
