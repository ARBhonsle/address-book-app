package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressBookDto;
import com.bridgelabz.addressbookapp.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * AddressBookController caters to REST Http Requests from clients
 * @author Aditi
 * version 0.0.1
 * @since 13-10-2021
 */
@RestController
@RequestMapping("/address-book")
public class AddressBookController {
    /**
     * Get address book list
     * @return ResponseEntity<ResponseDto>
     */
    @GetMapping(value = "/get-all")
    public ResponseEntity<ResponseDto> getAddressBookList() {
        ResponseDto responseDto = new ResponseDto("GET request successful",null);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    /**
     * Get address book by id
     * @param id url path of http request
     * @return ResponseEntity<ResponseDto>
     */
    @GetMapping(value = "/get/{id}")
    public ResponseEntity<ResponseDto> getAddressBookByID(@PathVariable int id) {
        ResponseDto responseDto = new ResponseDto("GET request successful for id: " + id,null);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    /**
     * Post to store address book
     * @param addressBookDto in RequestBody
     * @return ResponseEntity<ResponseDto>
     */
    @PostMapping(value = "/post")
    public ResponseEntity<ResponseDto> addAddressBook(@RequestBody AddressBookDto addressBookDto) {
        ResponseDto responseDto = new ResponseDto("POST request successful",null);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    /**
     * Update address book by id
     * @param id url path of http request
     * @param addressBookDto in RequestBody
     * @return ResponseEntity<ResponseDto>
     */
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<ResponseDto> updateAddressBook(@PathVariable int id, @RequestBody AddressBookDto addressBookDto) {
        ResponseDto responseDto = new ResponseDto("PUT request successfully updates for id: " + id,null);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }

    /**
     * Delete address book by id
     * @param id url path of http request
     * @return ResponseEntity<ResponseDto>
     */
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<ResponseDto> getAddressBookList(@PathVariable int id) {
        ResponseDto responseDto = new ResponseDto("DELETE request successful for id: " + id,null);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
    }
}
