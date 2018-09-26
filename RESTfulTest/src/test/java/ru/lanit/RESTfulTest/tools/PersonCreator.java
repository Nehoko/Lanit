package ru.lanit.RESTfulTest.tools;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonCreator {

    public static JSONObject createPerson(String id, String name, String birthdate){
        JSONObject requestBody = new JSONObject();
        requestBody.put("id", id);
        requestBody.put("name", name);
        requestBody.put("birthdate", birthdate);

        return requestBody;
    }

    public static JSONObject createPerson(Long id, String name, Date birthdate){
        final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        JSONObject requestBody = new JSONObject();
        requestBody.put("id", id);
        requestBody.put("name", name);
        requestBody.put("birthdate", sdf.format(birthdate));

        return requestBody;
    }

    public static JSONObject createPerson(Long id, String name, String birthdate){
        JSONObject requestBody = new JSONObject();
        requestBody.put("id", id);
        requestBody.put("name", name);
        requestBody.put("birthdate", birthdate);

        return requestBody;
    }
}
