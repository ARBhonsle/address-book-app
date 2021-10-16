package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.AddressBookDto;
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
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_book_id")
    private int id;
    @Column(name = "address_book_name")
    private String name;
    private String address;
    private String pinCode;

    public AddressBook() {
    }

    public AddressBook(int id, AddressBookDto addressBookDto) {
        this.id = id;
        this.name = addressBookDto.getName();
        this.address = addressBookDto.getAddress();
        this.pinCode = addressBookDto.getPinCode();
    }
}
