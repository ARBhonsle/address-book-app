package com.bridgelabz.addressbookapp.services;

import com.bridgelabz.addressbookapp.constants.Message;
import com.bridgelabz.addressbookapp.dto.AddressBookDto;
import com.bridgelabz.addressbookapp.dto.ResponseDto;
import com.bridgelabz.addressbookapp.exceptions.AddressBookException;
import com.bridgelabz.addressbookapp.model.AddressBook;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

    @Autowired
    private AddressBookRepository addressBookRepository;

    /**
     *  method finds all address book from repository
     * @return List of address book
     */
    public ResponseDto findAllAddressBook() {
        ResponseDto responseDto = new ResponseDto(Message.GET_ALL_SUCCESSFUL.getMessage(), addressBookRepository.findAll());
        return responseDto;
    }

    /**
     * method finds address book by addressBookId
     * @param addressBookId identifier in repository
     * @return address book
     * @throws AddressBookException if findById returns null
     */
    private AddressBook getAddressBookById(int addressBookId) throws AddressBookException {
        return addressBookRepository.findById(addressBookId).orElseThrow(() -> new AddressBookException(Message.EXCEPTION_WHILE_FINDING_ID.getMessage()));
    }

    public ResponseDto findAddressBookById(int addressBookId) throws AddressBookException {
        AddressBook addressBook = this.getAddressBookById(addressBookId);
        ResponseDto responseDto = new ResponseDto(Message.GET_BY_ID_SUCCESSFUL.getMessage(), addressBook);
        return responseDto;
    }

    /**
     * method stores address book into repository
     * @param addressBookDto data stored in repository
     * @return address book
     */
    public ResponseDto saveAddressBook(AddressBookDto addressBookDto) {
        AddressBook addressBook = new AddressBook();
        addressBook.updateAddressBook(addressBookDto);
        modelMapper.map(addressBookDto, addressBook);
        addressBookRepository.save(addressBook);
        ResponseDto responseDto = new ResponseDto(Message.POST_SUCCESSFUL.getMessage(), addressBook);
        return responseDto;
    }

    /**
     * method updates address book by addressBookId
     * @param addressBookId identifier in repository
     * @param addressBookDto data stored in repository
     * @return address book
     * @throws AddressBookException if findById returns null
     */
    public ResponseDto updateAddressBook(int addressBookId, AddressBookDto addressBookDto) throws AddressBookException{
        AddressBook addressBook = this.getAddressBookById(addressBookId);
        modelMapper.map(addressBookDto, addressBook);
        addressBookRepository.save(addressBook);
        ResponseDto responseDto = new ResponseDto(Message.UPDATE_BY_ID_SUCCESSFUL.getMessage(), addressBook);
        return responseDto;
    }

    /**
     * method deletes address book by addressBookId
     * @param addressBookId identifier in list
     * @return address book
     * @throws AddressBookException if findById returns null
     */
    public ResponseDto deleteAddressBook(int addressBookId) throws AddressBookException {
        AddressBook addressBook = this.getAddressBookById(addressBookId);
        addressBookRepository.delete(addressBook);
        ResponseDto responseDto = new ResponseDto(Message.DELETE_SUCCESSFUL.getMessage(), Message.DELETE_SUCCESS_RESPONSE.getMessage());
        return responseDto;
    }
}
