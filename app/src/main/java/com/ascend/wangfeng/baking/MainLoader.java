package com.ascend.wangfeng.baking;


import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengye on 2017/9/29.
 * email 1040441325@qq.com
 */

public class MainLoader extends AsyncTaskLoader<List<Recipe>> {
    private static final String BASE_URL = "https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/baking.json";

    public MainLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public List<Recipe> loadInBackground() {
        HttpURLConnection conn = null;
        BufferedReader in = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            URL url = new URL(BASE_URL);
            conn = (HttpURLConnection) url.openConnection();
            conn.connect();
            if (conn.getResponseCode() == 200) {
                in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    stringBuilder.append(inputLine);
                }
                in.close();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return convert(stringBuilder.toString());
    }

    private List<Recipe> convert(String s) {
        if (s == null) return null;
        ArrayList<Recipe> recipes = new ArrayList<>();
        try {
            JSONArray data = new JSONArray(s);
            Log.i("1", "convert: "+data.length());
            for (int i = 0; i < data.length(); i++) {
                Recipe recipe = new Recipe();
                JSONObject recipeJson = data.getJSONObject(i);
                recipe.setId(recipeJson.getInt("id"));
                recipe.setName(recipeJson.getString("name"));
                recipe.setServings(recipeJson.getInt("servings"));
                recipe.setImage(recipeJson.getString("image"));
                ArrayList<Ingredient> ingredients = new ArrayList<>();
                JSONArray ingredientJsonArray = recipeJson.getJSONArray("ingredients");
                for (int j = 0; j < ingredientJsonArray.length(); j++) {
                    JSONObject ingredientJson = ingredientJsonArray.getJSONObject(j);
                    Ingredient ingredient = new Ingredient();
                    ingredient.setQuantity(ingredientJson.getDouble("quantity"));
                    ingredient.setMeasure(ingredientJson.getString("measure"));
                    ingredient.setIngredient(ingredientJson.getString("ingredient"));
                    ingredients.add(ingredient);
                }
                recipe.setIngredients(ingredients);
                ArrayList<Step> steps = new ArrayList<>();
                JSONArray stepJsonArray = recipeJson.getJSONArray("steps");
                for (int j = 0; j < stepJsonArray.length(); j++) {
                    JSONObject stepJson = stepJsonArray.getJSONObject(j);
                    Step step = new Step();
                    step.setId(stepJson.getInt("id"));
                    step.setShortDescription(stepJson.getString("shortDescription"));
                    step.setDescription(stepJson.getString("description"));
                    step.setVideoUrl(stepJson.getString("videoURL"));
                    step.setThumbanilUrl(stepJson.getString("thumbnailURL"));
                    steps.add(step);
                }
                recipe.setSteps(steps);
                recipes.add(recipe);
            }

        } catch (JSONException e) {
            Log.i("2", "convert: "+e.getMessage());
        }
        Log.i("test", "convert: "+recipes.size());
        return recipes;
    }
}
