package com.ldsk.ecommerce.komorebi.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/testing")
public class TestingController {

    @GetMapping
    public ResponseEntity<String> getTest() {

        log.debug("Estou debugando.");

        log.info("Estou lhe informando algo.");

        return ResponseEntity.status(HttpStatus.OK).body("Requisição recebida!");
    }
}
