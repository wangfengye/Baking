package com.ascend.wangfeng.baking;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by fengye on 2017/9/30.
 * email 1040441325@qq.com
 */

public class StepAdapter extends RecyclerView.Adapter<StepAdapter.ViewHolder> {
    public static final String KEY_VEDIO = "vedio";
    public static final String KEY_RECIPE = "recipe";
    private List<Step> mSteps;
    private Recipe mRecipe;

    public StepAdapter(Recipe recipe) {
        mRecipe = recipe;
        mSteps = mRecipe.getSteps();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_step, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Step step = mSteps.get(position);
        holder.mTitleTv.setText(step.getShortDescription());
        holder.mDescriptionTv.setText(step.getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (step.getVideoUrl() == null || step.getVideoUrl().length() <= 0) {
                    Snackbar.make(holder.itemView, R.string.no_vedio, Snackbar.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(holder.itemView.getContext(), PlayActivity.class);
                    intent.putExtra(KEY_VEDIO, step.getVideoUrl());
                    intent.putExtra(KEY_RECIPE, mRecipe);
                    holder.itemView.getContext().startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mSteps.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTitleTv;
        TextView mDescriptionTv;

        public ViewHolder(View itemView) {
            super(itemView);
            mTitleTv = itemView.findViewById(R.id.title);
            mDescriptionTv = itemView.findViewById(R.id.description);
        }
    }
}
