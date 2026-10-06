package com.example.store;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        //env configuration
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load(); // create an obj of env that ingnore if sonthing is missing
        dotenv.entries().forEach((
                entry) -> System.setProperty(
                        entry.getKey() , entry.getValue()
        ));
        SpringApplication.run(StoreApplication.class, args);
    }
}
