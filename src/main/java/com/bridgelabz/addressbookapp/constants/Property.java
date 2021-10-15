package com.bridgelabz.addressbookapp.constants;

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
