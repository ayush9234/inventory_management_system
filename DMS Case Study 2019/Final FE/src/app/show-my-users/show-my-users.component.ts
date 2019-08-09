import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog, MatSnackBar } from '@angular/material';
import {MatTableDataSource} from '@angular/material/table';
import { MatPaginator, PageEvent} from '@angular/material/paginator';
import { MatSort} from '@angular/material/sort';
import { UserDetails, UserProfile } from '../models/UserModels';
import { GetRetailerlistService } from '../distributer/services/get-retailerlist.service';
import { Router } from '@angular/router';

@Component({
  selector: 'show-my-users',
  templateUrl: './show-my-users.component.html',
  styleUrls: ['./show-my-users.component.css']
})
export class ShowMyUsersComponent implements OnInit {
 
  public userName = localStorage.getItem("currentUserName");
  public user : UserProfile;

  addButton = true;  
  addRetailerForm = false;

  displayedColumns : string[] =['userName','email','contactno','area'];
  
  public customersDataSource : MatTableDataSource<any> ;
    
  usr : any;

  public sortedData: UserDetails[];

  pageEvent: PageEvent;
  datasource: null;
  pageIndex:number;
  pageSize:number;
  length:number;

  @ViewChild(MatSort, { static: true }) sort: MatSort;

  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;

  
  constructor(
    private router : Router,
    private snackBar:MatSnackBar,
    private getRetailerList : GetRetailerlistService
  ) { }

  ngOnInit() {
      this.starter();
  }

starter(){ 
  this.fetchUsers ();
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

  public onClickCancel(){
    this.addButton=!this.addButton;
    this.addRetailerForm=!this.addRetailerForm;
  }

  onClickAddRetailer(){
    this.addButton=!this.addButton;
    this.addRetailerForm=!this.addRetailerForm;

  }

  onRowClicked(row) {
    console.log('Row clicked: ', row);
}

fetchUsers(){
    this.getRetailerList.getCustomersList().subscribe(
      response =>this.handleSuccessfulResponse(response),
      err => this.handleSuccessfulResponse(err),
      () => ''
      );
}

pageCaller(){
  
}

  handlePage(e: any) {
    this.pageIndex = e.pageIndex;
    this.pageSize = e.pageSize;
    this.iterator();
  }

handleSuccessfulResponse(response)
{
      this.usr=response;
      this.customersDataSource = new MatTableDataSource(response);
      this.customersDataSource.paginator = this.paginator;
      this.length = this.usr.length;
      this.iterator();

      this.pageIndex = response.pageIndex;
      // this.pageSize = response.pageSize;
      // this.length = response.length;

      this.customersDataSource.sort = this.sort;
      this.customersDataSource.paginator = this.paginator;
}

  private iterator() {
    const end = (this.pageIndex + 1) * this.pageSize;
    const start = this.pageIndex * this.pageSize;
    // const part = this.usr.slice(start, end);
    // this.customersDataSource = part;
  }
  
  public doFilter = (value: string) => {
    this.customersDataSource.filter = value.trim().toLocaleLowerCase();
  }


applyFilter(filterValue: string) {

  this.customersDataSource.filter = filterValue.trim().toLowerCase();
  
  }
  
  

}
