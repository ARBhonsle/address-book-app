package com.bridgelabz.addressbookapp.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * AddressBookDto is used to transfer data to objects in service methods
 * @author Aditi
 * version 0.0.1
 * @since 13-10-2021
 */
@Data
@Getter
@Setter
public class AddressBookDto {
    @Pattern(regexp = "[A-Z][a-zA-Z]{2,}", message = "First Name is invalid")
    @NotEmpty(message = "First Name cannot be empty")
    private String fname;
    @Pattern(regexp = "[A-Z][a-zA-Z]{2,}", message = "Last Name is invalid")
    @NotEmpty(message = "Last Name cannot be empty")
    private String lname;
    @NotEmpty(message = "Address cannot be empty")
    private String address;
    @Pattern(regexp = "[1-9]\\d{5}", message = "Pin code is invalid")
    @NotEmpty(message = "Pin code cannot be empty")
    private String pinCode;
    @NotEmpty(message = "City cannot be empty")
    private String city;
    @NotEmpty(message = "State cannot be empty")
    private String state;
    @Pattern(regexp = "[6-9][0-9]{9}", message = "Phone number is invalid")
    @NotEmpty(message = "Phone number cannot be empty")
    private String phoneNo;
    @Pattern(regexp =  "[a-zA-Z0-9]+[-.+]?[a-z0-9]*@[a-z0-9]+[.][a-z]{2,3}[.]?[a-z]{0,3}", message = "Email is invalid")
    @NotEmpty(message = "Email cannot be empty")
    private String email;
}
