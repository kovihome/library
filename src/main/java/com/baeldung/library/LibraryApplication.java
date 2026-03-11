package com.baeldung.library;

import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class LibraryApplication {

    private final Logger logger = LoggerFactory.getLogger(LibraryApplication.class);

    @Component
    class DataSetup implements ApplicationRunner {
        @Override
        public void run(@NonNull ApplicationArguments args) {
            logger.info("Starting library Application ...");
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
    }

}
