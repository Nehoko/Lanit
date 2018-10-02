package ru.lanit.rest.service.tools;

import org.json.JSONObject;

public class PersonCreator {

    public static JSONObject createPerson(Long id, String name, String birthdate){
        JSONObject requestBody = new JSONObject();
        requestBody.put("id", id);
        requestBody.put("name", name);
        requestBody.put("birthdate", birthdate);

        return requestBody;
    }
}
