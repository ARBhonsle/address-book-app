package com.bridgelabz.addressbookapp.services;

import com.bridgelabz.addressbookapp.dto.AddressBookDto;
import com.bridgelabz.addressbookapp.exceptions.AddressBookException;
import com.bridgelabz.addressbookapp.model.AddressBook;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private AddressBookRepository addressBookRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     *  method finds all address book from repository
     * @return List of address book
     */
    public List<AddressBook> findAllAddressBook() {
        return addressBookRepository.findAll();
    }

    /**
     * method finds address book by id
     * @param id identifier in repository
     * @return address book
     * @throws AddressBookException
     */
    public AddressBook findAddressBookById(int id) throws AddressBookException {
        return addressBookRepository.findById(id).orElseThrow(() -> new AddressBookException("Cannot find Address book by id: " + id));
    }

    /**
     * method stores address book into repository
     * @param addressBookDto data stored in repository
     * @return address book
     */
    public AddressBook saveAddressBook(AddressBookDto addressBookDto) {
        AddressBook addressBook = new AddressBook();
        modelMapper.map(addressBookDto, addressBook);
        addressBookRepository.save(addressBook);
        return addressBook;
    }

    /**
     * method updates address book by id
     * @param id identifier in repository
     * @param addressBookDto data stored in repository
     * @return address book
     * @throws AddressBookException
     */
    public AddressBook updateAddressBook(int id, AddressBookDto addressBookDto) throws AddressBookException{
        AddressBook addressBook = this.findAddressBookById(id);
        modelMapper.map(addressBookDto, addressBook);
        addressBookRepository.save(addressBook);
        return addressBook;
    }

    /**
     * method deletes address book by id
     * @param id identifier in repository
     * @return address book
     * @throws AddressBookException
     */
    public String deleteAddressBook(int id) throws AddressBookException {
        AddressBook addressBook = this.findAddressBookById(id);
        addressBookRepository.delete(addressBook);
        return "Successfully deleted address book by id: " + id;
    }
}
