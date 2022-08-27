package com.vollify.dataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
public class DataServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(DataServiceApplication.class, args);
  }

}
