import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Inventory } from '../models/inventory';

@Injectable({
  providedIn: 'root'
})
export class InventoryService {

  constructor(private httpClient: HttpClient) { }

  getInventory(){

    let uId = localStorage.getItem("currentUserId");
    let url = "http://172.29.57.69:8080/inventory/"+uId;

    return this.httpClient.get<Inventory[]>(url);
  }

  // orderInventory(){
  //   return this.httpClient.post<Product[]>("http:172.29.57.69:8080/ordertracking");
  // }
}