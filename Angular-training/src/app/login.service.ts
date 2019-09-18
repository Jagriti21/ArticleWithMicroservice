import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { login } from './login.model';
const login_url='http://localhost:9087/user/login';
const httpOptions={
  headers: new HttpHeaders({
      'Content-Type' : 'application/json'
  })
};
@Injectable({
  providedIn: 'root'
})
export class LoginService {
  log(userl: login) {
    throw new Error("Method not implemented.");
  }
  constructor(private http: HttpClient) { }
  private extractData(res : Response){
    let contents=res;
    //check if contents are not null
    return contents || { };
  }
  loginCheck(login: login):Observable<any>{
    console.log(login.password);
    console.log(login.username);
    return this.http.post(login_url,JSON.stringify(login),httpOptions).pipe(map(this.extractData))
  
  }
}
