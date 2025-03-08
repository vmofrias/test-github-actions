package com.ldsk.ecommerce.komorebi.handler;

import com.ldsk.ecommerce.komorebi.exception.ProdutoException;
import com.ldsk.ecommerce.komorebi.vo.ApiExceptionVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ProdutoException.class)
    public ResponseEntity<ApiExceptionVo> handleProdutoException(ProdutoException produtoException) {

        return ResponseEntity.status(produtoException.getHttpStatus())
                .body(new ApiExceptionVo(produtoException.getMessage()));
    }

}
