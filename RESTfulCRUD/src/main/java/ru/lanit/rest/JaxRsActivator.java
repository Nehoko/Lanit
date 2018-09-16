package ru.lanit.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


//add to VM options: --add-modules java.xml.bind
@ApplicationPath("/api")
public class JaxRsActivator extends Application {
}
