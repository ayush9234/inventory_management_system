import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { RegisterUser } from '../models/UserModels';

@Injectable({
  providedIn: 'root'
})
export class AddNewDistributerService {

  constructor(private httpClient : HttpClient) { }

  registerUser(newUser)
  {
    console.log("Call to backend method to register new user" );
    return this.httpClient.post<RegisterUser>('http://172.29.57.69:8080/user/adduser',newUser);
  }
}
