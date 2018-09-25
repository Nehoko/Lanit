package ru.lanit.RESTfulTest.tools;

import org.testng.Assert;

public class StatusCodeChecker extends Assert {

    public void check(int code, int expected){
        assertEquals(code, expected);
    }
}
