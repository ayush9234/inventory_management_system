import { Component, OnInit } from '@angular/core';
import { UserProfile } from '../models/UserModels';
import { Router } from '@angular/router';
import { GetMyProfileService } from '../distributer/services/get-my-profile.service';
import { MatSnackBar } from '@angular/material';
import { Product } from '../admin/model/product';
import { Order } from '../models/order';
import { OrderService } from '../services/order.service';
import { ProductService } from '../admin/service/product.service';

@Component({
  selector: 'my-sales',
  templateUrl: './my-sales.component.html',
  styleUrls: ['./my-sales.component.css']
})
export class MySalesComponent implements OnInit {

  order: Product[] = [];
  products: Product[];
  product: Product;
  productJson = [];
  productName:string;
  place: Order= new Order();

  isDisabled = false;
  formOpened= false ;

  displayedColumns: string[] = ['productName', 'productCost', 'edit'];
  displayedColumnsOrder: string[] = ['name',  'quantity'];

  lessInventory = false;

  adminSidepanel = false;
  distributorSidePanel = false; 
  retailerSidePanel = false;

  public userName = localStorage.getItem("currentUserName");
  
  public user : UserProfile;
  
  constructor(private userProfileService : GetMyProfileService,
              private productService: ProductService,
              private orderService: OrderService,
              private router : Router,
              private snackBar: MatSnackBar){}

  ngOnInit() {
    this.activeSidePanel();
    this.starter();
  }

  starter(){this.activeSidePanel();
   
    this.productService.getProducts().subscribe(response => this.handle(response));
  }

  handle(response){
    this.products = response;
  }

  addOrder(element){
    console.log(element);
    
    element['isSelected'] = true;
    this.formOpened = true;

    this.order.push(element);
    this.isDisabled = false;
}

removeItem(element)
{

}

displayedColumnsOL: string[] = ['productName', 'productCost', 'quantity'];

placeOrder(event){
  console.log(this.order)
  console.log("check: ")
  console.log(event.target.elements[0].value)
  console.log(event.target.elements[1].value)
  
  this.place.totalPrice = 0;
  
  for(var i in this.order){
    let json = {};
    json[i] = this.productJson.push({"productName":this.order[i].productName, "quantity":event.target.elements[i].value });
    this.place.totalPrice += this.order[i].productCost*event.target.elements[i].value;
  }

  console.log(this.place.totalPrice)
  console.log("Product JSON", this.productJson)
  
  this.place.buyerId = parseInt(localStorage.getItem('currentUserId'));
  this.place.sellerId = 1;
  this.place.placeOrders = this.productJson;
  
  console.log(this.place.buyerId)
  console.log("Product JSON", this.productJson)
 
  this.orderService.sellOrder(this.place).subscribe(
    asd=>{
      this.snackBar.open("Products Sold", "Close", {
      duration: 2000,verticalPosition: 'top',panelClass: ['green-snackbar']
      });
      this.router.navigateByUrl('inventory');},
    error => {this.lessInventory = true;}
    );

  this.isDisabled=true;
}


  activeSidePanel(){
    let userRole = localStorage.getItem("currentUserRole");
    
    if(userRole === '1')
    {
      this.adminSidepanel = true;
    }
    else if(userRole === '2')
    {
      this.distributorSidePanel = true;
    }
    else if(userRole === '3')
    {
      this.retailerSidePanel = true;
    }

  }

  onClickProfile(){
    
    this.router.navigate(['/my_profile']);

  }

  onClickLogout(){
    console.log("Logout Clicked");
    
      console.log("cleared User Id "+localStorage.getItem("currentUserId") );
      localStorage.clear();

      this.snackBar.open("User Logged Out", "Close", {
        duration: 2000,verticalPosition: 'top',panelClass: ['green-snackbar']
      });

      this.router.navigate(['']);
    
  }

  onClickCancel(){

    this.formOpened = false;
     
   }


   hide(index)
   {
      this.isDisabled=true;
   }

}
