import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserInfo } from 'src/app/login/services/login-check.service';
import { UserDetails } from 'src/app/models/UserModels';

@Injectable({
  providedIn: 'root'
})
export class GetRetailerlistService {

  constructor(private httpClient : HttpClient) { }

  getCustomersList()
  {
    console.log("Call to backend method to get retailerList as per distributer id" );

   let userId = localStorage.getItem("currentUserId");
   

    let url = "http://172.29.57.61:8080/user/retailers?id="+userId;

    return this.httpClient.get<UserDetails[]>(url);
  }
  
}
