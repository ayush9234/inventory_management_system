import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../model/product';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private httpClient:HttpClient) { }
    
  getProducts(){
    return this.httpClient.get<Product[]>("http://172.29.57.69:8080/product");
  }
  
  getProductById(productId){
    return this.httpClient.get<Product>("http://172.29.57.69:8080/product/"+productId);
  }
  
  public save(product:Product){
    return this.httpClient.post<Product>("http://172.29.57.69:8080/product",product);
  }
  
  public updateProduct (product:Product){
  
    return this.httpClient.put<Product>("http://172.29.57.69:8080/product/", product);
  }
}