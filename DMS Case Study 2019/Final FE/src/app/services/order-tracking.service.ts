import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { OrderTracking } from '../models/order-tracking';

@Injectable({
  providedIn: 'root'
})
export class OrderTrackingService {

  constructor(private httpClient:HttpClient) { }

  getOrders(sellerId: any){
    let params = new HttpParams();
    let uId = localStorage.getItem("currentUserId");
    console.log(params);

    let url = "http://172.29.57.61:8080/ordertracking?id=" + uId;
    return this.httpClient.get<OrderTracking[]>(url);
  }

  acceptOrder(order: any){
    return this.httpClient.post<any>("http://172.29.57.61:8080/ordertracking/accept",order);
  }

  rejectOrder(order: any){
    return this.httpClient.post<any>("http://172.29.57.61:8080/ordertracking/reject",order);
  }

}
