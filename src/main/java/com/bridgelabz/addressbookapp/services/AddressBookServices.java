package com.bridgelabz.addressbookapp.services;

import com.bridgelabz.addressbookapp.dto.AddressBookDto;
import com.bridgelabz.addressbookapp.dto.ResponseAddressBookDto;
import com.bridgelabz.addressbookapp.exceptions.AddressBookException;
import com.bridgelabz.addressbookapp.model.AddressBook;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
     * method finds all address book from repository
     *
     * @return ResponseAddressBookDto
     */
    public List<AddressBookDto> findAllAddressBook() {
        return addressBookRepository.findAll().stream()
                .map(addressBookDO -> modelMapper.map(addressBookDO, AddressBookDto.class))
                .collect(Collectors.toList());
    }

    private AddressBook getAddressBookById(int addressBookId) throws AddressBookException{
        return addressBookRepository.findById(addressBookId).orElseThrow(() -> new AddressBookException("Cannot find Address book by addressBookId: " + addressBookId));
    }

    /**
     * method finds address book by addressBookId
     *
     * @param addressBookId identifier in repository
     * @return ResponseAddressBookDto
     * @throws AddressBookException
     */
    public ResponseAddressBookDto findAddressBookById(int addressBookId) throws AddressBookException {
        ResponseAddressBookDto responseAddressBookDto = new ResponseAddressBookDto();
        AddressBook addressBook = this.getAddressBookById(addressBookId);
        modelMapper.map(addressBook,responseAddressBookDto);
        return responseAddressBookDto;
    }

    /**
     * method stores address book into repository
     *
     * @param addressBookDto data stored in repository
     * @return ResponseAddressBookDto
     */
    public ResponseAddressBookDto saveAddressBook(AddressBookDto addressBookDto) {
        ResponseAddressBookDto responseAddressBookDto = new ResponseAddressBookDto();
        AddressBook addressBook = new AddressBook();
        modelMapper.map(addressBookDto, addressBook);
        addressBookRepository.save(addressBook);
        modelMapper.map(addressBook,responseAddressBookDto);
        return responseAddressBookDto;
    }

    /**
     * method updates address book by addressBookId
     *
     * @param addressBookId  identifier in repository
     * @param addressBookDto data stored in repository
     * @return ResponseAddressBookDto
     * @throws AddressBookException
     */
    public ResponseAddressBookDto updateAddressBook(int addressBookId, AddressBookDto addressBookDto) throws AddressBookException {
        ResponseAddressBookDto responseAddressBookDto = new ResponseAddressBookDto();
        AddressBook addressBook = this.getAddressBookById(addressBookId);
        modelMapper.map(addressBookDto, addressBook);
        addressBookRepository.save( addressBook);
        modelMapper.map(addressBook,responseAddressBookDto);
        return responseAddressBookDto;
    }

    /**
     * method deletes address book by addressBookId
     *
     * @param addressBookId identifier in repository
     * @return ResponseAddressBookDto
     * @throws AddressBookException
     */
    public ResponseAddressBookDto deleteAddressBook(int addressBookId) throws AddressBookException {
        AddressBook addressBook = this.getAddressBookById(addressBookId);
        addressBookRepository.delete(addressBook);
        return null;
    }
}
