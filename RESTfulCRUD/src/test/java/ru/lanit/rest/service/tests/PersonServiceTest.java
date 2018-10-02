package ru.lanit.rest.service.tests;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.lanit.rest.service.tools.PersonCreator;
import ru.lanit.rest.service.tools.RequestSetter;
import ru.lanit.rest.service.tools.ResponseSetter;
import ru.lanit.rest.service.tools.Settings;

public class PersonServiceTest extends Assert {

    @Before
    public void beforeTest(){
        Settings.setup();
    }

    @Test
    public void postPerson(){
        JSONObject person = PersonCreator.createPerson(1L,"Eliah","03.08.1995");

        RequestSpecification request = RequestSetter.post(person);

        Response response = request.post("/person");

        int code = response.getStatusCode();
        String body = response.asString();

        assertEquals(code, 200);
        assertEquals(body, "");
    }

    @After
    public void afterTest(){
        Response response = ResponseSetter.get("/clear");
    }
}
