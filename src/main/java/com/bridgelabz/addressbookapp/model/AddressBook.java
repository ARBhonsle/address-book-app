package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.AddressBookDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Address book is object which stores details stored, updated or fetched by clients via http requests
 *
 * @author Aditi
 * version 0.0.1
 * @since 13-10-2021
 */
@Data
@Getter
@Setter
@Entity
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_book_id")
    @NotNull
    private Integer id;
    private String fname;
    private String lname;
    private String address;
    private String pinCode;
    private String city;
    private String state;
    private String phoneNo;
    private String email;

    public AddressBook() {
    }

    public AddressBook(AddressBookDto addressBookDto) {
        this.updateAddressBook(addressBookDto);
    }

    public void updateAddressBook(AddressBookDto addressBookDto) {
        this.fname = addressBookDto.getFname();
        this.lname = addressBookDto.getLname();
        this.address = addressBookDto.getAddress();
        this.pinCode = addressBookDto.getPinCode();
        this.city = addressBookDto.getCity();
        this.state = addressBookDto.getState();
        this.phoneNo = addressBookDto.getPhoneNo();
        this.email = addressBookDto.getEmail();
    }
}
