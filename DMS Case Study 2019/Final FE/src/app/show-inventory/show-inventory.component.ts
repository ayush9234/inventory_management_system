import { MatTableDataSource } from '@angular/material/table';
import { PlaceOrder } from './../models/place-order';
import { GetMyProfileService } from 'src/app/distributer/services/get-my-profile.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Inventory } from '../models/inventory';
import { ActivatedRoute, Router } from '@angular/router';
import { InventoryService } from '../services/inventory.service';
import { UserProfile } from '../models/UserModels';
import { MatSnackBar, MatPaginator, MatSort } from '@angular/material';

@Component({
  selector: 'show-inventory',
  templateUrl: './show-inventory.component.html',
  styleUrls: ['./show-inventory.component.css']
})
export class ShowInventoryComponent implements OnInit {

  noInventory;

  public userName = localStorage.getItem("currentUserName");
  ;
  public user : UserProfile;

  @ViewChild(MatSort, { static: true }) sort: MatSort;
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;

  inventories: MatTableDataSource<any>;
  
  inventory : any;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private snackBar: MatSnackBar,
              private inventoryService: InventoryService,
              private userProfileService : GetMyProfileService,) { }


  ngOnInit() {
    this.starter();   
  }

  starter(){ this.inventoryService.getInventory().subscribe(response => this.handle(response));
    
 }

 

  handle(response){
    this.inventory = response;
    this.inventories = new MatTableDataSource(this.inventory);
    this.inventories.sort = this.sort;
    this.inventories.paginator = this.paginator;
    this.noProducts();
  }

  noProducts()
  {
    if(this.inventory.length === 0)
    {
      console.log("No Inventory in account ");     
      this.noInventory=true;
    }
    else
    {
      this.inventory.forEach(prod => {
        if(prod.quantity != 0 )
        {
          this.noInventory=false;
        }
      });

    }
  }

  displayedColumns: string[] = ['productName','productQuantity'];

}
