import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Result } from '../model/result';
import { ResultResponseDTO } from '../model/resultDTO';

@Injectable({
  providedIn: 'root'
})
export class ResultService {

  baseUrl: string =
    'http://localhost:8085/abc-university/result';

    date1: string ="";
    date2: string ="";
    
  constructor(private httpClient: HttpClient) { }

  getAllResults(): Observable<ResultResponseDTO[]> {
    console.log("Result Service - Get result called");
    return this.httpClient.get<ResultResponseDTO[]>(this.baseUrl + '/allResults');
  }


  getByUserId(userId: number): Observable<Result[]> {
    console.log("Result Service - Get result called");
    return this.httpClient.get<Result[]>(this.baseUrl + '/getByUserId/' + userId);
  }

 getByMarks(marks: number): Observable<Result[]> {
    console.log("Result Service - Get result called");
    return this.httpClient.get<Result[]>(this.baseUrl + '/getByMarks/' + marks);
  }

  getByCategory(category: string): Observable<Result[]> {
    console.log("Result Service - Get result called");
    return this.httpClient.get<Result[]>(this.baseUrl + '/getByCategory/' + category);
  }

  getByDateRange(date:string)
  : Observable<Result[]> {
let params = new HttpParams();
    params.set('date1',this.date1);
    params.set('date2',this.date2);
    console.log("Result Service - Get result called");
    return this.httpClient.get<Result[]>(this.baseUrl + '/date/date?date1=' + this.date1 + "date2=" + this.date2);
  }


  submitQuiz(userId: number): Observable<any> {
    return this.httpClient.post(this.baseUrl + '/' + userId, "/submitQuiz");
  }


  updateResult(result: Result): Observable<any> {
    return this.httpClient.put(this.baseUrl + '/update', result);
  }


  deleteResult(testId: number):
    Observable<any> {
    return this.httpClient.delete(this.baseUrl + '/result/' + testId);
  }


}//end of service

