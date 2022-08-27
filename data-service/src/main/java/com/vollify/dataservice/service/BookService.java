package com.vollify.dataservice.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vollify.dataservice.model.Book;

/**
 * @author : Alois Vollmaier (A199165)
 * @since : 27.08.2022, Sat
 **/
@Service
public class BookService {

  public List<Book> getBooks() {
    List<Book> books = new ArrayList<>();

    books.add(new Book("Harry Potter", LocalDate.of(1997, 8, 27)));
    books.add(new Book("Lord of the Rings", LocalDate.of(1954, 8, 27)));
    books.add(new Book("The Hobbit", LocalDate.of(1937, 8, 27)));
    books.add(new Book("The Catcher in the Rye", LocalDate.of(1951, 8, 27)));
    return books;
  }

}
