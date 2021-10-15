package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.constants.Message;
import com.bridgelabz.addressbookapp.dto.AddressBookDto;
import com.bridgelabz.addressbookapp.dto.ResponseDto;
import com.bridgelabz.addressbookapp.exceptions.AddressBookException;
import com.bridgelabz.addressbookapp.model.AddressBook;
import com.bridgelabz.addressbookapp.services.AddressBookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * AddressBookController caters to REST Http Requests from clients
 *
 * @author Aditi
 * version 0.0.1
 * @since 13-10-2021
 */
@RestController
@RequestMapping("/address-book")
public class AddressBookController {

    @Autowired
    private AddressBookServices addressBookServices;

    /**
     * Get address book list
     *
     * @return ResponseEntity<ResponseDto>
     */
    @GetMapping(value = "/get-all")
    public ResponseEntity<ResponseDto> getAddressBookList() {
        List<AddressBook> addressBookList = addressBookServices.findAllAddressBook();
        ResponseDto responseDto = new ResponseDto(Message.GET_ALL_SUCCESSFUL.getMessage(), addressBookList);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    /**
     * Get address book by id
     *
     * @param id url path of http request
     * @return ResponseEntity<ResponseDto>
     * @throws AddressBookException
     */
    @GetMapping(value = "/get/{id}")
    public ResponseEntity<ResponseDto> getAddressBookByID(@PathVariable int id) {
        AddressBook addressBook = addressBookServices.findAddressBookById(id);
        ResponseDto responseDto = new ResponseDto(Message.GET_BY_ID_SUCCESSFUL.getMessage(), addressBook);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    /**
     * Post to store address book
     *
     * @param addressBookDto in RequestBody
     * @return ResponseEntity<ResponseDto>
     */
    @PostMapping(value = "/post")
    public ResponseEntity<ResponseDto> addAddressBook(@Valid @RequestBody AddressBookDto addressBookDto) {
        AddressBook addressBook = addressBookServices.saveAddressBook(addressBookDto);
        ResponseDto responseDto = new ResponseDto(Message.POST_SUCCESSFUL.getMessage(), addressBook);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    /**
     * Update address book by id
     *
     * @param id url path of http request
     * @param addressBookDto in RequestBody
     * @return ResponseEntity<ResponseDto>
     * @throws AddressBookException
     */
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<ResponseDto> updateAddressBook(@PathVariable int id,@Valid @RequestBody AddressBookDto addressBookDto) {
        AddressBook addressBook = addressBookServices.updateAddressBook(id, addressBookDto);
        ResponseDto responseDto = new ResponseDto(Message.UPDATE_BY_ID_SUCCESSFUL.getMessage(), addressBook);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    /**
     * Delete address book by id
     *
     * @param id url path of http request
     * @return ResponseEntity<ResponseDto>
     * @throws AddressBookException
     */
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<ResponseDto> getAddressBookList(@PathVariable int id) {
        String response = addressBookServices.deleteAddressBook(id);
        ResponseDto responseDto = new ResponseDto(Message.DELETE_SUCCESSFUL.getMessage(), response);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
