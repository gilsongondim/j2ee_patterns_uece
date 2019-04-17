import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable, throwError} from "rxjs";
import {Question} from "./question";
import {catchError, retry} from "rxjs/operators";
import {Answer} from "./answer";

@Injectable({
  providedIn: 'root'
})
export class RestApiService {

  apiURL= 'http://localhost:3000';

  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':'application/json'
    })
  }

  getQuestions(): Observable<Question>{
    return this.http.get<Question>(this.apiURL+'/questions')
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  getQuestion(id): Observable<Question> {
    return this.http.get<Question>(this.apiURL+'/questions/'+id)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  createQuestion(Question):Observable<Question>{
    return this.http.post<Question>(this.apiURL+'/questions',JSON.stringify(question), this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  updateQuestion(id, question): Observable<Question>{
    return this.http.put<Question>(this.apiURL+'/questions/'+id, JSON.stringify(question), this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  deleteQuestion(id){
    return this.http.delete<Question>(this.apiURL+'/questions/'+id, this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  //
  getAnswers(): Observable<Answer>{
    return this.http.get<Answer>(this.apiURL+'/answers')
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  getAnswer(id): Observable<Answer> {
    return this.http.get<Answer>(this.apiURL+'/answers/'+id)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  createAnswer(Answer):Observable<Answer>{
    return this.http.post<Answer>(this.apiURL+'/answers',JSON.stringify(answer), this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  updateAnswer(id, answer): Observable<Answer>{
    return this.http.put<Answer>(this.apiURL+'/answers/'+id, JSON.stringify(answer), this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }

  deleteAnswer(id){
    return this.http.delete<Answer>(this.apiURL+'/answers/'+id, this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
      )
  }


  private handleError(error) {
    let errorMessage = '';
    if(error.error instanceof  ErrorEvent){
      errorMessage = error.error.message;
    } else {
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    window.alert(errorMessage);
    return throwError(errorMessage);

  }
}
