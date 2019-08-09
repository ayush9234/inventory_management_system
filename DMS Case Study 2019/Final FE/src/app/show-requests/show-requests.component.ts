import { MatTableDataSource } from '@angular/material/table';
import { Component, OnInit, ViewChild } from '@angular/core';
import { OrderTracking } from '../models/order-tracking';
import { ActivatedRoute, Router } from '@angular/router';
import { OrderTrackingService } from '../services/order-tracking.service';
import { UserProfile } from '../models/UserModels';
import { GetMyProfileService } from '../distributer/services/get-my-profile.service';
import { MatSnackBar, MatPaginator, MatSort, MatDialogRef, MatDialog } from '@angular/material';

@Component({
  selector: 'show-requests',
  templateUrl: './show-requests.component.html',
  styleUrls: ['./show-requests.component.css']
})
export class ShowRequestsComponent implements OnInit {

  adminSidepanel = false;
  distributorSidePanel = false;
  retailerSidePanel = false;
  public userName = localStorage.getItem("currentUserName");
  
  lessInventory=false;

  public user : UserProfile;
  orders:MatTableDataSource<any>;
  distributorId  = localStorage.getItem('currentUserId');

  @ViewChild(MatSort, { static: true }) sort: MatSort;
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;

  constructor(private userProfileService : GetMyProfileService,
              private route: ActivatedRoute,private router: Router,
              private orderTracking : OrderTrackingService,
              private snackBar: MatSnackBar,
              private dialog : MatDialog) { 
  }

  ngOnInit() {
    this.starter();
  }

starter(){
   this.orderTracking.getOrders(this.distributorId).subscribe(response => this.handle(response));

}



  handle(response){
    this.orders = new MatTableDataSource(response);
    this.orders.sort = this.sort;
    this.orders.paginator = this.paginator;
  }

  displayedColumns: string[] = ['buyerName', 'totalPrice', 'creationTime', 'view', 'accept' , 'reject'];
  dataSource = this.orders;

  getOrderDetail(element){
    console.log("getTransactionDetail"+element.transactionId)
    let transactionId = element.transactionId;
    this.router.navigate(['/order-details'],{queryParams:{transactionId:transactionId}})
  }



  public acceptOrder(element){
    
    console.log("Order Accepted");
    console.log(element);

    // const dialogRef = this.dialog.open(AcceptDialog, {
    //   width: '30%',
      
    // });

    element.updationTime = null;
    this.orderTracking.acceptOrder(element).subscribe(
      response => { 
        this.ngOnInit();
        this.snackBar.open("Request Accepted", "Close", {
          duration: 4000,verticalPosition: 'top',panelClass: ['green-snackbar']
        });
      },
      error => { this.lessInventory = true; }
    );
    
    
   

    // window.location.reload();

  }

  rejectOrder(element)
  {
    console.log("Reject clicked");

    this.orderTracking.rejectOrder(element).subscribe(
      response => { 
        this.ngOnInit();
        this.snackBar.open("Request Rejected", "Close", {
          duration: 4000,verticalPosition: 'top',panelClass: ['green-snackbar']
        });
      },
      error => {  }
    );

    // const dialogRef = this.dialog.open(RejectDialog, {
    //   width: '30%',
      
    // });



  }

  applyFilter(filterValue: string) {

    this.orders.filter = filterValue.trim().toLowerCase();
    
    }
    
    

}



@Component({
  selector: 'accept-dialog',
  templateUrl: 'accept-dialog.html',
})
export class AcceptDialog {

  constructor(
    public dialogRef: MatDialogRef<AcceptDialog>,
    private snackBar: MatSnackBar,
    private router : Router,

    ) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

  onAcceptClick()
  {
    this.dialogRef.close();

    

  }

}


@Component({
  selector: 'reject-dialog',
  templateUrl: 'reject-dialog.html',
})
export class RejectDialog {

  constructor(
    public dialogRef: MatDialogRef<RejectDialog>,
    private snackBar: MatSnackBar,
    private router : Router,

    ) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

  onRejectClick()
  {
    this.dialogRef.close();

    
  

  }

}