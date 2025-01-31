package com.mycompany.json;

import org.json.JSONObject;

public class One {

    public static void main(String[] args) {

        JSONObject jo = new JSONObject();

        jo.put("id", 101);
        jo.put("name", "Ramlal");
        jo.put("precentage", 87.4);
        
        System.out.println(jo);
    }

}
