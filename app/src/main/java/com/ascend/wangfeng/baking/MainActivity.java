package com.ascend.wangfeng.baking;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Recipe>> {

    private static final int LOADER_MAIN_ID = 0;
    @BindView(R.id.list_recipe)
    RecyclerView mListRecipe;
    private RecipeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        getSupportLoaderManager().restartLoader(LOADER_MAIN_ID, null, this);
        Snackbar.make(mListRecipe, R.string.loading,Snackbar.LENGTH_INDEFINITE).show();
    }

    private void initView() {
        adapter = new RecipeAdapter();
        mListRecipe = findViewById(R.id.list_recipe);
        mListRecipe.setLayoutManager(new LinearLayoutManager(this));
        mListRecipe.setAdapter(adapter);
    }

    @Override
    public Loader<List<Recipe>> onCreateLoader(int id, Bundle args) {
        return new MainLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<List<Recipe>> loader, List<Recipe> data) {
        //更新ui
        if (data == null || data.size() == 0) {
            Snackbar.make(mListRecipe, R.string.internet_error, Snackbar.LENGTH_INDEFINITE).show();
            return;
        }
        adapter.setRecipes(data);
        Snackbar.make(mListRecipe, R.string.success, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onLoaderReset(Loader<List<Recipe>> loader) {

    }
}
