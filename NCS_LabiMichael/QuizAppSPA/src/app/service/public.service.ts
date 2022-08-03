import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class PublicService {

  baseUrl: string = 'http://localhost:8081/abc-university/public';

  constructor(private http:HttpClient) { }



publicLogin(user:User) :Observable<any>
{
  let headers = new HttpHeaders({
    'Content-Type': 'application/json'
  });
  const body = JSON.stringify(user);
  console.log("Public Service - login called");
  return this.http.post(this.baseUrl + "/login",body, {'headers':headers} )
}

publicRegister(user:User):Observable<any>
{
  let headers = new HttpHeaders({
    'Content-Type': 'application/json'
  });
  const body = JSON.stringify(user);
  console.log("Public Service - register called");
  return this.http.post(this.baseUrl + "/register",body, {'headers':headers} )

}

publicValidate(token: string) {
  let headers = new HttpHeaders({
    'Authorization' : token,
    // 'userType' : 'admin'
  })
  return this.http.get(this.baseUrl + '/validate', { 'headers': headers })
}


}
