package com.wonically.crudent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.wonically.crudent")
public class CrudentApplication {

    public static void main(String... args) {
        SpringApplication.run(CrudentApplication.class, args);
    }

}
