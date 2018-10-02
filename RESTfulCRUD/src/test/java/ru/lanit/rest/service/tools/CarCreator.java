package ru.lanit.rest.service.tools;

import org.json.JSONObject;

public class CarCreator {

    public static JSONObject createCar(Long id, String model, Integer horsepower, Long ownerId){
        JSONObject requestBody = new JSONObject();
        requestBody.put("id",id);
        requestBody.put("model",model);
        requestBody.put("horsepower",horsepower);
        requestBody.put("ownerId",ownerId);
        return requestBody;
    }
}
