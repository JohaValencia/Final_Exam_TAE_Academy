package com.finalExam.utils.data;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class WebData {
    private static final String JSON_FILE_PATH = "src/test/resources/web_data.json";
    private static final JsonParser parser = new JsonParser();

    public static String returnData(String neededData) {
        return getJsonDataProperty(neededData);
    }

    private static String getJsonDataProperty(String property) {
        try {
            Object obj = parser.parse(new FileReader(JSON_FILE_PATH));
            JsonObject jsonObject = (JsonObject) obj;
            return jsonObject.get(property)
                    .getAsString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }



}
