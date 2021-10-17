package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDto;
import com.bridgelabz.addressbookapp.dto.ResponseDto;
import com.bridgelabz.addressbookapp.exceptions.AddressBookException;
import com.bridgelabz.addressbookapp.services.AddressBookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
        ResponseDto responseDto = addressBookServices.findAllAddressBook();
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
        ResponseDto responseDto = addressBookServices.findAddressBookById(id);
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
        ResponseDto responseDto = addressBookServices.saveAddressBook(addressBookDto);
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
        ResponseDto responseDto = addressBookServices.updateAddressBook(id, addressBookDto);
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
        ResponseDto responseDto = addressBookServices.deleteAddressBook(id);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
