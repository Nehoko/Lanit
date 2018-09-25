package ru.lanit.RESTfulTest.tools;

import io.restassured.RestAssured;

public class Settings {

    public void setup(){
        String port = System.getProperty("server.port");
        RestAssured.port = (port==null)? 8080 : Integer.valueOf(port);

        String basePath = System.getProperty("server.base");
        if(basePath==null)
            basePath = "/RESTfulCRUD/api";

        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");
        if(baseHost==null)
            baseHost = "http://localhost";

        RestAssured.baseURI = baseHost;
    }
}
