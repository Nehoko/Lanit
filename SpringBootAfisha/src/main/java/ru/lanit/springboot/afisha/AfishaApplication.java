package ru.lanit.springboot.afisha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
public class AfishaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AfishaApplication.class, args);
    }
}
