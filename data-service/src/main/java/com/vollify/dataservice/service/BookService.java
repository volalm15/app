package com.vollify.dataservice.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.stereotype.Service;

import com.vollify.dataservice.model.Book;

import lombok.AllArgsConstructor;

/**
 * @author : Alois Vollmaier (A199165)
 * @since : 27.08.2022, Sat
 **/
@Service
@AllArgsConstructor
public class BookService {

  ServerProperties props;

  public List<Book> getBooks() {

    List<Book> books = new ArrayList<>();
    int port = props.getPort();

    books.add(new Book("Harry Potter from Server: " + port, LocalDate.of(1997, 8, 27)));
    books.add(new Book("Lord of the Rings", LocalDate.of(1954, 8, 27)));
    books.add(new Book("The Hobbit", LocalDate.of(1937, 8, 27)));
    books.add(new Book("The Catcher in the Rye", LocalDate.of(1951, 8, 27)));
    return books;
  }

}
