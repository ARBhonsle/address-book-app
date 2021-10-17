package com.bridgelabz.addressbookapp.builder;

import com.bridgelabz.addressbookapp.dto.AddressBookDto;
import com.bridgelabz.addressbookapp.model.AddressBook;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AddressBookBuilder {
    public AddressBook build(AddressBookDto addressBookDto) {
        AddressBook addressBook = new AddressBook();
        BeanUtils.copyProperties(addressBookDto, addressBook);
        return addressBook;
    }
}

