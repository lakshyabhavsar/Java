package com.mycompany.json;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class Two {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("roll", "101");
        map.put("name", "Ramlal");
        map.put("percent", "12.3");

        JSONObject jo = new JSONObject(map);
        System.out.println(jo);
    }
}
