import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { UserProfile } from 'src/app/models/UserModels';

@Injectable({
  providedIn: 'root'
})
export class GetMyProfileService {

  constructor(private httpClient : HttpClient) { }

  getUserDetails(userId)
  {
    let id : number = parseInt(userId);
    console.log("Call to backend method to get current user Details with id "+id );
    
    let param = new HttpParams();
    param = param.set('userId',userId);

    let url = "http://172.29.57.69:8080/user/"+userId;

    return this.httpClient.get<UserProfile>(url);
  }

}
