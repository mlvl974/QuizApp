import { HttpClient } from '@angular/common/http';
import { Injectable } from "@angular/core";
import { Observable } from 'rxjs';
import { User } from '../model/user';



@Injectable({
  providedIn: 'root'
})
export class UserService
{
  //
  baseUrl: string = 'http://localhost:8082/abc-university/admin';

  constructor(private httpClient:HttpClient) { }


getAllUser(): Observable<User[]>
{
console.log("User Service - Get user called");
return this.httpClient.get<User[]>(this.baseUrl+ '/allUsers');
}

getUserById(userId:number): Observable<User>
{
console.log("User Service - Get user called");
return this.httpClient.get<User>(this.baseUrl+ '/user/' + userId);
}

addUser(user:User) :Observable<any>
{
return this.httpClient.post(this.baseUrl, user);
}



deleteUser(userId:number): Observable<any>
{
  return this.httpClient.delete(this.baseUrl+ '/user/' + userId);
}

}//end of service