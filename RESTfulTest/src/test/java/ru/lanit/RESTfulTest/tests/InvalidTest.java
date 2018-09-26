package ru.lanit.RESTfulTest.tests;

import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.lanit.RESTfulTest.parts.CarPost;
import ru.lanit.RESTfulTest.parts.PersonPost;
import ru.lanit.RESTfulTest.parts.PersonWithCarsGet;
import ru.lanit.RESTfulTest.tools.CarCreator;
import ru.lanit.RESTfulTest.tools.PersonCreator;
import ru.lanit.RESTfulTest.tools.Settings;

public class InvalidTest {

    @BeforeTest
    public void setup() {
        Settings.setup();
    }

    @Test
    public void beginTest(){

        //404 - request for /personwithcars

        PersonWithCarsGet.getPersonWithCarsTest("2", 404, "");

        //400 - requests

        JSONObject person1 = PersonCreator.createPerson("asd","InvalidPerson","1995.18.03");
        PersonPost.postPersonTest(person1, 400,null);

//        JSONObject car = createInvalidCar("15","BMW-X4");
//        CarPost = new CarPost(car,400,"");
//        CarPost.postCarTest();

        PersonWithCarsGet.getPersonWithCarsTest("asd", 400, null);

        person1 = PersonCreator.createPerson("1","Moja", "1995.18.03");
        PersonPost.postPersonTest(person1, 400,null);

        JSONObject car = CarCreator.createCar(15L,"To-yota-X56",200,1L);
        CarPost.postCarTest(car, 400,null);
    }
}
