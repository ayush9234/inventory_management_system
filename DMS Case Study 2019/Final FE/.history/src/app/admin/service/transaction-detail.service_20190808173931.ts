import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { TransactionDetail } from '../model/transaction-detail';

@Injectable({
  providedIn: 'root'
})
export class TransactionDetailService {

  constructor(private httpClient:HttpClient) { }

  getTransactionDetail(transactionId: string){
    let param = new HttpParams();
    param = param.set('transactionId', transactionId);
    console.log(param);
    return this.httpClient.get<TransactionDetail[]>("http://172.29.57.69:8080/transactiondetails" , {params:param});
  }
}
