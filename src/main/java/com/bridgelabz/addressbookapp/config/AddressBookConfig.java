package com.bridgelabz.addressbookapp.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AddressBookConfig sets up configuration of additional beans required in application
 * @author Aditi
 * version 0.0.1
 * @since 13-10-2021
 */
@Configuration
public class AddressBookConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
