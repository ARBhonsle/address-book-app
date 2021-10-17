package com.bridgelabz.addressbookapp.exceptions;

import com.bridgelabz.addressbookapp.constants.Message;
import com.bridgelabz.addressbookapp.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<ResponseDto> addressBookExceptionHandler(AddressBookException addressBookException) {
        ResponseDto responseDto = new ResponseDto(Message.EXCEPTION_WHILE_REST_REQUEST.getMessage(), addressBookException.getMessage());
        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> methodArgNotValidExceptionHandler(MethodArgumentNotValidException methodArgumentNotValidException) {
        List<ObjectError> errorList = methodArgumentNotValidException.getBindingResult().getAllErrors();
        List<String> errMsg = errorList.stream().map(objErr -> objErr.getDefaultMessage()).collect(Collectors.toList());
        ResponseDto responseDto = new ResponseDto(Message.EXCEPTION_WHILE_REST_REQUEST.getMessage(), errMsg);
        return new ResponseEntity<>(responseDto, HttpStatus.BAD_REQUEST);
    }
}
