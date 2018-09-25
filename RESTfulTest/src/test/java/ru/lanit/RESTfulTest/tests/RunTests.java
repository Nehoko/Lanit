package ru.lanit.RESTfulTest.tests;

import io.restassured.RestAssured;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RunTests {

    private CarPostTest carPostTest;
    private CleanTest cleanTest;
    private PersonPostTest personPostTest;
    private PersonWithCarsGetTest personWithCarsGetTest;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    @BeforeTest
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

    @BeforeTest
    public void initTests(){
        carPostTest = new CarPostTest();
        cleanTest = new CleanTest();
        personPostTest = new PersonPostTest();
        personWithCarsGetTest = new PersonWithCarsGetTest();
    }

    @Test
    public void startTests() throws ParseException {
        cleanTest.getRequest(200,"");

        JSONObject person1 = createPerson(1L, "Eliah", sdf.parse("03.08.1995"));

        personPostTest.postPersonTest(person1, 200, "");

        JSONObject car1 = createCar(1L, "BMW-X5", 250, 1L);
        carPostTest.postCarTest(car1, 200, "");

        personWithCarsGetTest.getPersonWithCarsTest(1L, 200,
                "{" +
                        "\"id\":1," +
                        "\"name\":\"Eliah\"," +
                        "\"birthdate\":\"03.08.1995\"," +
                        "\"cars\":" +
                            "[{" +
                            "\"id\":1," +
                            "\"model\":\"BMW-X5\"," +
                            "\"horsepower\":250," +
                            "\"ownerId\":1" +
                            "}]" +
                        "}");

        cleanTest.getRequest(200,"");
    }

    private JSONObject createPerson(Long id, String name, Date birthdate){
        JSONObject requestBody = new JSONObject();
        requestBody.put("id", id);
        requestBody.put("name", name);
        requestBody.put("birthdate", sdf.format(birthdate));

        return requestBody;
    }

    private JSONObject createCar(Long id, String model, Integer horsepower, Long ownerId){
        JSONObject requestBody = new JSONObject();
        requestBody.put("id",id);
        requestBody.put("model",model);
        requestBody.put("horsepower",horsepower);
        requestBody.put("ownerId",ownerId);
        return requestBody;
    }
}
