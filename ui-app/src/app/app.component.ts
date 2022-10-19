import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
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
    this.booksUrl = 'http://localhost:8761/data-service/books/';
  }

  ngOnInit(): void {
  }

  findAll(): void {
    this.http.get(
      this.booksUrl,
      {observe: 'response', headers: {'Content-Type': 'application/json'}}
    )
      .subscribe(response => {
        // You can access status:
        console.log(response.status);

        // Or any other header:
        console.log(response.headers.get(''));
      });
  }
}
