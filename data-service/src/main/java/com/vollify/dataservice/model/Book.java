package com.vollify.dataservice.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : Alois Vollmaier (A199165)
 * @since : 27.08.2022, Sat
 **/

@Data
@AllArgsConstructor
public class Book {
  String name;
  LocalDate published;
}
