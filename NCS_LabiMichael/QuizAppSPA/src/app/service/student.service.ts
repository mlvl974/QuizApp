import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class StudentService {


  
  baseUrl: string = 'http://localhost:8084/abc-university/student';

  constructor(private httpClient:HttpClient) { }

















}

