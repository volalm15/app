import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError, retry} from 'rxjs/operators';

class Book {
  title: string;

  constructor(title: string) {
    this.title = title;
  }
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  booksUrl: string;

  constructor(private http: HttpClient) {
    this.booksUrl = 'http://localhost:8761/data-service/books';
  }

  ngOnInit(): void {
  }


  findAll(): void {
    fetch(this.booksUrl, {
      method: 'GET',
      mode: 'no-cors',
    })
      .then((response) => {
        console.log(response);
        if (response.redirected) {
          window.location.href = response.url;
        }
      })
      .then((data) => {
        console.log(data);
      })
      .catch((error) => {
        console.error(error);
      });
  };
}
