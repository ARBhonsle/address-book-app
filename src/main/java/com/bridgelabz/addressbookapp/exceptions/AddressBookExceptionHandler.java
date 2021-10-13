package com.bridgelabz.addressbookapp.exceptions;

import com.bridgelabz.addressbookapp.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Address Book exception handler handles exception and give response to bad http requests
 *
 * @author Aditi
 * @version 0.0.1
 * @since 13-10-2021
 */
@ControllerAdvice
public class AddressBookExceptionHandler {
    @ExceptionHandler(value = AddressBookException.class)
    public ResponseEntity<ResponseDto> addressBookExceptionHandler(AddressBookException e) {
        ResponseDto responseDto = new ResponseDto(e.getMessage(), null);
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.BAD_REQUEST);
    }
}
