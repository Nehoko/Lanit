package ru.lanit.RESTfulTest.tools;

import org.json.JSONObject;

public class CarCreator {

    public static JSONObject createCar(String id, String model, String horsepower, String ownerId){
        JSONObject requestBody = new JSONObject();
        requestBody.put("id",id);
        requestBody.put("model",model);
        requestBody.put("horsepower",horsepower);
        requestBody.put("ownerId",ownerId);
        return requestBody;
    }

    public static JSONObject createCar(Long id, String model, Integer horsepower, Long ownerId){
        JSONObject requestBody = new JSONObject();
        requestBody.put("id",id);
        requestBody.put("model",model);
        requestBody.put("horsepower",horsepower);
        requestBody.put("ownerId",ownerId);
        return requestBody;
    }
}
