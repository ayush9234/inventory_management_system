import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Product } from '../admin/model/product';
import { Order } from '../models/order';
import { ProductService } from '../services/product.service';
import { OrderService } from '../services/order.service';
import { UserProfile } from '../models/UserModels';
import { GetMyProfileService } from '../distributer/services/get-my-profile.service';
import { MatSnackBar, MatTableDataSource, MatPaginator, MatSort } from '@angular/material';

@Component({
  selector: 'order-inventory',
  templateUrl: './order-inventory.component.html',
  styleUrls: ['./order-inventory.component.css']
})
export class OrderInventoryComponent implements OnInit {

  errorInOrder;

  order: Product[] = [];
 
  products: MatTableDataSource<any>;
  product: any;
 
  productJson = [];
  productName:string;
  place: Order;

  distributorSidePanel = false;
  retailerSidePanel = false;

  formOpened= false ;

  public userName = localStorage.getItem("currentUserName");
  
  public myProfile : UserProfile;
 
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort ,{ static:true}) sort :MatSort;

  constructor(private route: ActivatedRoute,private router: Router,
              private productService: ProductService,
              private orderService: OrderService,
              private snackBar: MatSnackBar,
              private userProfileService : GetMyProfileService,) { 
    this.product=new Product();
    this.place=new Order();
  }

  ngOnInit() {
    this.starter();
  }

  starter(){
    
   
    this.productService.getProducts().subscribe(response => this.handle(response));
  
  }
  handle(response){
    this.products = new MatTableDataSource(response);
    this.products.sort = this.sort;
    this.products.paginator = this.paginator;
  }

  

  displayedColumns: string[] = ['productName', 'productCost', 'edit'];
  displayedColumnsOrder: string[] = ['name',  'quantity'];

  addOrder(element){
      console.log(element);

      this.formOpened=true;
      element['isSelected'] = true;
      
      this.order.push(element);
      
  }

  displayedColumnsOL: string[] = ['productName', 'productCost', 'quantity'];


  // placeOrder(event){
  //   console.log(this.order);
  //   console.log("check: ");
  //   console.log(event.target.elements[1].value)
    
  //   this.place.totalPrice = 0;
    
  //   for(var i in this.order){
  //     let json = {};
  //     json[i] = this.productJson.push({"productName":this.order[i].productName, "quantity":event.target.elements[i].value });
  //     this.place.totalPrice += this.order[i].productCost*event.target.elements[i].value;
  //   }
    
  //   console.log(this.place.totalPrice)
  //   console.log("Product JSON", this.productJson)
    
  //   this.place.buyerId = parseInt(localStorage.getItem('currentUserId'));
  //   this.place.placeOrders = this.productJson;
    
  //   console.log(this.place.buyerId)
  //   console.log("Product JSON", this.productJson)
   
  //   this.snackBar.open("New Order Placed", "Close", {
  //     duration: 2000,verticalPosition: 'top',panelClass: ['green-snackbar']
  //   });
  //      /* this.place.placeOrders = this.productJson; 
  //  console.log(this.place.placeOrders)*/
  //   this.orderService.placeOrder(this.place).subscribe(
  //     asd=>{this.router.navigateByUrl('inventory')},
  //     error => this.errorInOrder = true
  //     );
  // }

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
    this.place.placeOrders = this.productJson;
    
    console.log(this.place.buyerId)
    console.log("Product JSON", this.productJson)
   
    this.snackBar.open("New Order Placed", "Close", {
      duration: 2000,verticalPosition: 'top',panelClass: ['green-snackbar']
    });
       /* this.place.placeOrders = this.productJson; 
   console.log(this.place.placeOrders)*/
    this.orderService.placeOrder(this.place).subscribe(asd=>this.router.navigateByUrl('inventory'));
  }


  removeItem(element)
  { 
    
  }

  onClickCancel(){

   this.router.navigate(['/inventory']);
    
  }

  remove(row)
  {
    console.log("Removing row ");
    
    
  }

   

}
