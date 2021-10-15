package com.bridgelabz.addressbookapp.services;

import com.bridgelabz.addressbookapp.dto.AddressBookDto;
import com.bridgelabz.addressbookapp.exceptions.AddressBookException;
import com.bridgelabz.addressbookapp.model.AddressBook;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Address book Service has methods used by controller class
 *
 * @author Aditi
 * version 0.0.1
 * @since 13-10-2021
 */
@Service
public class AddressBookServices {

    @Autowired
    private ModelMapper modelMapper;

    // list of employees
    private static List<AddressBook> addressBookList = new ArrayList<>();

    /**
     *  method finds all address book from repository
     * @return List of address book
     */
    public List<AddressBook> findAllAddressBook() {
        return addressBookList;
    }

    /**
     * method finds address book by addressBookId
     * @param addressBookId identifier in repository
     * @return address book
     * @throws AddressBookException
     */
    public AddressBook findAddressBookById(int addressBookId) throws AddressBookException {
        return addressBookList.stream().filter(addressBookData->addressBookData.getId()==addressBookId).findFirst().orElseThrow(() -> new AddressBookException("Cannot find Address book by addressBookId: " + addressBookId));
    }

    /**
     * method stores address book into repository
     * @param addressBookDto data stored in repository
     * @return address book
     */
    public AddressBook saveAddressBook(AddressBookDto addressBookDto) {
        AddressBook addressBook = new AddressBook(addressBookList.size() + 1,addressBookDto);
        modelMapper.map(addressBookDto, addressBook);
        addressBookList.add(addressBook);
        return addressBook;
    }

    /**
     * method updates address book by addressBookId
     * @param addressBookId identifier in repository
     * @param addressBookDto data stored in repository
     * @return address book
     * @throws AddressBookException
     */
    public AddressBook updateAddressBook(int addressBookId, AddressBookDto addressBookDto) throws AddressBookException{
        AddressBook addressBook = this.findAddressBookById(addressBookId);
        modelMapper.map(addressBookDto, addressBook);
        addressBookList.set(addressBookId - 1, addressBook);
        return addressBook;
    }

    /**
     * method deletes address book by addressBookId
     * @param addressBookId identifier in repository
     * @return address book
     * @throws AddressBookException
     */
    public String deleteAddressBook(int addressBookId) throws AddressBookException {
        AddressBook addressBook = this.findAddressBookById(addressBookId);
        addressBookList.remove(addressBook);
        return "Successfully deleted address book by addressBookId: " + addressBookId;
    }
}
