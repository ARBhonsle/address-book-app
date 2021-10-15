package com.bridgelabz.addressbookapp.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Address book is object which stores details stored, updated or fetched by clients via http requests
 * @author Aditi
 * version 0.0.1
 * @since 13-10-2021
 */
@Data
@Entity
@Table(name = "ADDRESS_BOOK")
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String address;
    private String pinCode;
}
