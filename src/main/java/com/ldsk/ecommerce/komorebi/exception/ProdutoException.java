package com.ldsk.ecommerce.komorebi.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ProdutoException extends RuntimeException {

    private HttpStatus httpStatus;
    private String message;

    public ProdutoException() {}

    public ProdutoException(HttpStatus httpStatus, String message) {

        this.httpStatus = httpStatus;
        this.message = message;
    }
}
