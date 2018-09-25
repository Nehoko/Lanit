package ru.lanit.RESTfulTest.tools;

import org.testng.Assert;

public class BodyChecker extends Assert {
    public void check(String body, String bodyExpected){
        assertEquals(body, bodyExpected);
    }
}
