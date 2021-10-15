package com.bridgelabz.addressbookapp.constants;
/**
 * Property for defining environment and username property from application context properties
 * @author Aditi
 * @version 0.0.1
 * @since 15-10-2021
 */
public enum Property {
    ENVIRONMENT_PROPERTY("environment"),
    DB_USERNAME_PROPERTY("spring.datasource.username");

    private final String property;

    Property(String property) {
        this.property = property;
    }

    public String getProperty() {
        return property;
    }
}
