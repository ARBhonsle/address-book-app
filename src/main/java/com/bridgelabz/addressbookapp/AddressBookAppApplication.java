package com.bridgelabz.addressbookapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootApplication
public class AddressBookAppApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AddressBookAppApplication.class, args);
        log.info("Employee Payroll Spring App Started");
        log.info("Environment", context.getEnvironment().getProperty("environment"));
        log.info("Employee DB username is {}", context.getEnvironment().getProperty("spring.datasource.username"));
    }

}
