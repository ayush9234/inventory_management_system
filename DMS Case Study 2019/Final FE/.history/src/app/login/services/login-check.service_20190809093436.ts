import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { stringify } from '@angular/compiler/src/util';

@Injectable({
  providedIn: 'root'
})
export class LoginCheckService {

  constructor(private httpClient : HttpClient) { }

  login(loginInfo)
  {
    console.log("Call to backend method to check userEmail and password" );
    return this.httpClient.post<LoginInfo>('http://172.29.57.61:8080/user/login',loginInfo);
  }

}



export class UserInfo{
  

  public  userId: number;
	public  userName: string;
	public  roleType: number;
  public  result: boolean

  
}

export class LoginInfo{
   
    public  email: string;
    public  password: string;
    
 
}