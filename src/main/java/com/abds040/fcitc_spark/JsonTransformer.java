/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.abds040.fcitc_spark;

import com.google.gson.Gson;
import spark.ResponseTransformer;

public class JsonTransformer implements ResponseTransformer {

    private Gson gson = new Gson();

    @Override
    public String render(Object model) {
        return gson.toJson(model);
    }

}
