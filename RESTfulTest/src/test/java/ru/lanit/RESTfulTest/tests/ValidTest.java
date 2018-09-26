package ru.lanit.RESTfulTest.tests;

import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.lanit.RESTfulTest.parts.CarPost;
import ru.lanit.RESTfulTest.parts.Clean;
import ru.lanit.RESTfulTest.parts.PersonPost;
import ru.lanit.RESTfulTest.parts.PersonWithCarsGet;
import ru.lanit.RESTfulTest.tools.CarCreator;
import ru.lanit.RESTfulTest.tools.PersonCreator;
import ru.lanit.RESTfulTest.tools.Settings;

public class ValidTest {

    @BeforeTest
    public void setup() {
        Settings.setup();
    }

    @Test
    public void startTests(){

        //200 - requests
        Clean.getRequest(200,"");

        JSONObject person = PersonCreator.createPerson(1L, "Eliah", "03.08.1995");

        PersonPost.postPersonTest(person, 200, "");

        JSONObject car1 = CarCreator.createCar(1L, "BMW-X5", 250, 1L);

        CarPost.postCarTest(car1, 200, "");

        PersonWithCarsGet.getPersonWithCarsTest("1", 200,
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

        Clean.getRequest(200,"");
    }
}
