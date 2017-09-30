package com.ascend.wangfeng.baking;

import android.content.Intent;
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

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder>{
    public static final String KEY_STEP = "step";
    private List<Recipe> mRecipes;

    public RecipeAdapter() {
        mRecipes=new ArrayList<>();
    }
    public void setRecipes(List<Recipe> recipes){
        mRecipes.clear();
        mRecipes.addAll(recipes);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recipe,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Recipe recipe = mRecipes.get(position);
        holder.mTitleTv.setText(recipe.getName());
        holder.mServingTv.setText("servings:"+recipe.getServings());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(),StepActivity.class);
                intent.putExtra(KEY_STEP,recipe);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mRecipes.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTitleTv;
        TextView mServingTv;
        TextView mStepsTv;
        public ViewHolder(View itemView) {
            super(itemView);
            mTitleTv=itemView.findViewById(R.id.title);
            mServingTv=itemView.findViewById(R.id.servings);
            mStepsTv=itemView.findViewById(R.id.steps);

    }}
}
