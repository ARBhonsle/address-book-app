package com.bridgelabz.addressbookapp.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Address book is object which stores details stored, updated or fetched by clients via http requests
 * @author Aditi
 * version 0.0.1
 * @since 13-10-2021
 */
@Data
@Entity
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String address;
    private long pinCode;
}
