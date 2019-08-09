import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Order } from '../models/order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private httpClient:HttpClient) { }

  public placeOrder(order :any){
    console.log("Order Object ", order)
    return this.httpClient.post<Order>("http://172.29.57.69:8080/ordertracking",order);
  }

  public sellOrder(order:any){

    return this.httpClient.post<Order>("http://172.29.57.69:8080/transaction/sell",order);

  }

}
