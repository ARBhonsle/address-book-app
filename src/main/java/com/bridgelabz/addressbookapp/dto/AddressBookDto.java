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
    @Pattern(regexp = "[A-Z][a-zA-Z]{2,}", message = "Name is invalid")
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    @NotEmpty(message = "Address cannot be empty")
    private String address;
    @Pattern(regexp = "[0-9]{6,}", message = "Pin code is invalid")
    @NotEmpty(message = "Pin code cannot be empty")
    private String pinCode;
}
