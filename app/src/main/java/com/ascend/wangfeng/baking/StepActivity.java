package com.ascend.wangfeng.baking;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StepActivity extends AppCompatActivity {

    @BindView(R.id.list_step)
    RecyclerView mListStep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step);
        ButterKnife.bind(this);
        Recipe recipe = (Recipe) getIntent().getSerializableExtra(RecipeAdapter.KEY_STEP);
        StepAdapter adapter =new StepAdapter(recipe);
        mListStep.setLayoutManager(new LinearLayoutManager(this));
        mListStep.setAdapter(adapter);
    }


}
