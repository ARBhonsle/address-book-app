package com.bridgelabz.addressbookapp;

import com.bridgelabz.addressbookapp.constants.Message;
import com.bridgelabz.addressbookapp.constants.Property;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * AddressBookApplication runs application
 * @author Aditi
 * @version 0.0.1
 * @since 15-10-2021
 */
@Slf4j
@SpringBootApplication
public class AddressBookAppApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AddressBookAppApplication.class, args);
        log.info(Message.APP_STARTED_SUCCESSFULLY.getMessage());
        log.info(Message.ENVIRONMENT.getMessage(), context.getEnvironment().getProperty(Property.ENVIRONMENT_PROPERTY.getProperty()));
        log.info(Message.EMPLOYEE_DB_USERNAME.getMessage(), context.getEnvironment().getProperty(Property.DB_USERNAME_PROPERTY.getProperty()));
    }

}
