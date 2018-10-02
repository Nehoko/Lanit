package ru.lanit.rest.service.tests;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.*;
import ru.lanit.rest.service.tools.*;

public class CarServiceTest extends Assert {

    @Before
    public void beforeTest(){
        Settings.setup();
    }

    @Test
    public void postCar() {

        JSONObject person = PersonCreator.createPerson(1L,"TestCar","03.03.1993");

        RequestSpecification requestP = RequestSetter.post(person);
        requestP.post("/person");

        JSONObject car = CarCreator.createCar(1L,"BMW-X5",250,1L);

        RequestSpecification request = RequestSetter.post(car);

        Response response = request.post("/car");

        int code = response.getStatusCode();
        String body = response.asString();

        assertEquals(code, 200);
        assertEquals(body, "");
    }

    @AfterClass
    public static void clear(){
        Response response = ResponseSetter.get("/clear");
    }
}