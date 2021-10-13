package com.bridgelabz.addressbookapp.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Response Dto transfers data to object of response to http request to clients
 * @author Aditi
 * version 0.0.1
 * @since 13-10-2021
 */
@Getter
@Setter
public class ResponseDto {
    private String message;
    private Object data;

    public ResponseDto(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}
