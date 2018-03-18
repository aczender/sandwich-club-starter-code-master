package com.udacity.sandwichclub.utils;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {


    //Array is needed for ingredients and Alsoknownas
    public static Sandwich parseSandwichJson(String json) {


        if (TextUtils.isEmpty(json)) {
            return null;
        }

        try {

            JSONObject root = new JSONObject(json);
            JSONObject name = root.getJSONObject("name");

            String mainName = name.getString("mainName");

            JSONArray alsoKnownAs = name.getJSONArray("alsoKnownAs");
            ArrayList<String> anList = new ArrayList<>();
            for (int i = 0; i < alsoKnownAs.length(); i++) {
                anList.add(alsoKnownAs.getString(i));
            }

            String placeOfOrigin = root.getString("placeOfOrigin");
            String description = root.getString("description");
            String image = root.getString("image");

            JSONArray ingredients = root.getJSONArray("ingredients");
            ArrayList<String> inList = new ArrayList<>();
            for (int i = 0; i < alsoKnownAs.length(); i++) {
                inList.add(ingredients.getString(i));
            }

            return new Sandwich(mainName, anList, placeOfOrigin, description, image,
                    inList);

        } catch (JSONException e) {
            Log.e("JsonUtils", "Problem parsing the sandwich JSON results", e);
        }
        return null;
    }
}
