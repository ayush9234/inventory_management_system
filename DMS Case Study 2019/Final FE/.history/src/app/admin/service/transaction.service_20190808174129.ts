import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Transaction } from '../model/transaction';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  constructor(private httpClient:HttpClient) { }

  getTransactions(){

    let uId = localStorage.getItem("currentUserId");
  //   let url ="http://172.29.57.69:8080/transaction/seller?userId=" +uId;

  //   return this.httpClient.get<Transaction[]>(url);
  // 
  let params = new HttpParams();
  params = params.append('id', uId);
  return this.httpClient.get<Transaction[]>("http://172.29.57.69:8080/transaction/user",{params:params});
  }
}
