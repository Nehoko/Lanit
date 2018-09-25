package ru.lanit.RESTfulTest.tests.run;

import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.lanit.RESTfulTest.tests.CarPostTest;
import ru.lanit.RESTfulTest.tests.CleanTest;
import ru.lanit.RESTfulTest.tests.PersonPostTest;
import ru.lanit.RESTfulTest.tests.PersonWithCarsGetTest;
import ru.lanit.RESTfulTest.tools.Settings;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RunTests {

    private CarPostTest carPostTest;
    private CleanTest cleanTest;
    private PersonPostTest personPostTest;
    private PersonWithCarsGetTest personWithCarsGetTest;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    private Settings settings = new Settings();

    @BeforeTest
    public void setup() {
        settings.setup();
    }

    @Test
    public void startTests() throws ParseException {

        //200 - requests
        cleanTest = new CleanTest(200,"");
        cleanTest.getRequest();

        JSONObject person = createPerson(1L, "Eliah", sdf.parse("03.08.1995"));

        personPostTest = new PersonPostTest(person, 200, "");
        personPostTest.postPersonTest();

        JSONObject car1 = createCar(1L, "BMW-X5", 250, 1L);
        carPostTest = new CarPostTest(car1, 200, "");
        carPostTest.postCarTest();

        personWithCarsGetTest = new PersonWithCarsGetTest("1", 200,
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
        personWithCarsGetTest.getPersonWithCarsTest();

        cleanTest = new CleanTest(200,"");
        cleanTest.getRequest();

        //404 - request for /personwithcars

        personWithCarsGetTest = new PersonWithCarsGetTest("2", 404, "");
        personWithCarsGetTest.getPersonWithCarsTest();

        //400 - requests

        JSONObject person1 = createInvalidPerson("asd","InvalidPerson","1995.18.03");
        personPostTest = new PersonPostTest(person1, 400,"");

        JSONObject car = createInvalidCar("15","BMW-X4");
        carPostTest = new CarPostTest(car,400,"");

        personWithCarsGetTest = new PersonWithCarsGetTest("asd", 400, "");
        personWithCarsGetTest.getPersonWithCarsTest();

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

    private JSONObject createInvalidPerson(String id, String name, String birthdate){
        JSONObject requestBody = new JSONObject();
        requestBody.put("id",id);
        requestBody.put("name",name);
        requestBody.put("birthdate",birthdate);
        return requestBody;
    }

    private JSONObject createInvalidCar(String id, String model){
        JSONObject requestBody = new JSONObject();
        requestBody.put("id",id);
        requestBody.put("model",model);
        return requestBody;
    }
}
