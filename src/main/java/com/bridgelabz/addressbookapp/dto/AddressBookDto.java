package com.bridgelabz.addressbookapp.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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
    private String name;
    private String address;
    private long pinCode;
}
