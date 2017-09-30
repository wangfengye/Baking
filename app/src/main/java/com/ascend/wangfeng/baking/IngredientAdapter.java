package com.ascend.wangfeng.baking;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengye on 2017/9/30.
 * email 1040441325@qq.com
 */

public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.ViewHolder>{
    private List<Ingredient> mIngredients;

    public IngredientAdapter() {
        mIngredients= new ArrayList<>();
    }
    public void setIngredients(List<Ingredient> ingredients){
        mIngredients.clear();
        mIngredients.addAll(ingredients);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_ingredients,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Ingredient ingredient = mIngredients.get(position);
        holder.mIngredientTv.setText(ingredient.getIngredient());
        holder.mQuantityTv.setText(String.valueOf(ingredient.getQuantity()));
        holder.mMeasure.setText(ingredient.getMeasure());
    }

    @Override
    public int getItemCount() {
        return mIngredients.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mIngredientTv;
        TextView mQuantityTv;
        TextView mMeasure;
        public ViewHolder(View itemView) {
            super(itemView);
            mIngredientTv =itemView.findViewById(R.id.ingredient);
            mQuantityTv =itemView.findViewById(R.id.quantity);
            mMeasure =itemView.findViewById(R.id.measure);
        }
    }
}
