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

public class InvalidTest {

    @BeforeTest
    public void setup() {
        Settings.setup();
    }

    @Test
    public void beginTest(){

        //404 - request for /personwithcars

        PersonWithCarsGet.getTest("2", 404, "");

        //400 - requests

        //GET /personwitcars begin

        //wrong "id"
        PersonWithCarsGet.getTest("asd", 400, null);

        //"id" is null
        PersonWithCarsGet.getTest(null, 400, null);

        //GET /personwithcars end

        //POST /person begin

        //id can't be parsed to Long
        JSONObject person1 = PersonCreator.createPerson("asd","InvalidPerson","03.08.1995");
        PersonPost.postPersonTest(person1, 400,null);

        //wrong format of birthdate
        person1 = PersonCreator.createPerson("1","Moja", "1995.18.03");
        PersonPost.postPersonTest(person1, 400,null);

        //wrong date (was born is future
        person1 = PersonCreator.createPerson("1","Moja","15.07.2025");
        PersonPost.postPersonTest(person1,400,null);

        //wrong id: that id is busy

        person1 = PersonCreator.createPerson(1L, "ValidPerson1","15.07.1999");
        PersonPost.postPersonTest(person1,200,"");
        JSONObject person2 = PersonCreator.createPerson(1L,"InvalidPerson1", "25.06.1995");
        PersonPost.postPersonTest(person2, 400,null);
        Clean.getRequest(200,"");

        //"id" is null
        person2 = PersonCreator.createPerson((Long) null, "InvalidPerson","03.07.1985");
        PersonPost.postPersonTest(person2,400,null);

        //"name" is null
        person2 = PersonCreator.createPerson(2L, (String) null,"03.07.1985");
        PersonPost.postPersonTest(person2,400,null);

        //"birthdate" is null
        person2 = PersonCreator.createPerson(2L,"InvalidPerson",(String)null);
        PersonPost.postPersonTest(person2,400,null);

        //POST /person end

        //POST /car begin

        //horsepower<0
        PersonPost.postPersonTest(person1,200,"");
        JSONObject car1 = CarCreator.createCar(1L,"BMW-X4",-100,1L);
        CarPost.postTest(car1,400,null);

        //wrong id: that id is busy

        car1 = CarCreator.createCar(1L, "ValidCar-1",250,1L);
        CarPost.postTest(car1, 200,"");
        JSONObject car2 = CarCreator.createCar(1L,"InvalidCar-1",250,1L);
        CarPost.postTest(car2,400,null);

        //wrong model: 2 "-" should be 1

        JSONObject car = CarCreator.createCar(15L,"To-yota-X56",200,1L);
        CarPost.postTest(car, 400,null);

        //wrong owner's age: person i yonger, that 18

        Clean.getRequest(200,"");
        person1 = PersonCreator.createPerson(1L, "Kid", "15.09.2010");
        PersonPost.postPersonTest(person1,200,"");
        CarPost.postTest(car1,400,null);

        //wrong owner's id: it doesn't exists

        JSONObject car3 = CarCreator.createCar(2L, "InvalidCar-3",192,253L);
        CarPost.postTest(car3,400,null);

        //"id" is null
        car3 = CarCreator.createCar((Long)null,"InvalidCar-3",200,1L);
        CarPost.postTest(car3,400,null);

        //"model" is null
        car3 = CarCreator.createCar(2L,(String)null, 200,1L);
        CarPost.postTest(car3,400,null);

        //"horsepower" is null
        car3 = CarCreator.createCar(2L,"InvalidCar-3",(Integer)null,1L);
        CarPost.postTest(car3,400,null);

        //"ownerid" is null
        car3 = CarCreator.createCar(2L,"InvalidCar-3",200, (Long)null);
        CarPost.postTest(car3,400,null);

        //POST /car end
    }
}
