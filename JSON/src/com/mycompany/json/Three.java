package com.mycompany.json;

import org.json.JSONArray;
import org.json.JSONObject;

public class Three {

    public static void main(String[] args) {

        JSONObject jo1 = new JSONObject();

        jo1.put("id", 101);
        jo1.put("name", "Ramlal");
        jo1.put("salary", 1200);
        JSONObject jo2 = new JSONObject();

        jo2.put("id", 102);
        jo2.put("name", "Shamlal");
        jo2.put("salary", 1500);

        JSONArray ja = new JSONArray();
        ja.put(jo1);
        ja.put(jo2);
        System.out.println(ja);

    }
}
