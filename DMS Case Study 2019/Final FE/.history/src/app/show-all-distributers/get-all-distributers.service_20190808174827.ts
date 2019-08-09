import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserDetails } from '../models/UserModels';

@Injectable({
  providedIn: 'root'
})
export class GetAllDistributersService {

  constructor(private httpClient : HttpClient) { }

  getAllDistributersList()
  {
    console.log("Call to backend method to get list of all distributors" );
    return this.httpClient.get<UserDetails[]>('http://172.29.57.69:8080/user/distributor');
  }

}
