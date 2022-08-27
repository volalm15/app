package com.vollify.dataservice.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.vollify.dataservice.model.Book;
import com.vollify.dataservice.service.BookService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author : Alois Vollmaier (A199165)
 * @since : 27.08.2022, Sat
 **/
@RestController
@AllArgsConstructor
@Slf4j
public class BookController
  implements BookEndpoint {

  private BookService bookService;

  @Override
  public ResponseEntity<List<Book>> getBooks() {
    log.info("getBooks() called");

    return ResponseEntity.ok(bookService.getBooks());
  }

}
