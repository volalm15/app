package com.vollify.dataservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.vollify.dataservice.model.Book;

/**
 * @author : Alois Vollmaier (A199165)
 * @since : 27.08.2022, Sat
 **/

@RequestMapping(value = "/api/v1/books", produces = "application/json")
public interface BookEndpoint {

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  ResponseEntity<List<Book>> getBooks()
    throws InterruptedException;
}
