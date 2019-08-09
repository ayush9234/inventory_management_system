import { TransactionDetailService } from './../admin/service/transaction-detail.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { TransactionDetail } from '../models/transaction-detail';
import { UserProfile } from '../models/UserModels';
import { GetMyProfileService } from '../distributer/services/get-my-profile.service';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'transaction-details',
  templateUrl: './transaction-details.component.html',
  styleUrls: ['./transaction-details.component.css']
})
export class TransactionDetailsComponent implements OnInit {

  adminSidepanel = false;
  distributorSidePanel = false;
  retailerSidePanel = false;


  transaction: TransactionDetail[];
  public userName = localStorage.getItem("currentUserName");

  public myProfile : UserProfile;
  
  constructor(private route: ActivatedRoute, 
              private router: Router, 
              private snackBar: MatSnackBar,
              private transactiondetails : TransactionDetailService,
              private userProfileService : GetMyProfileService,) { }

  ngOnInit() {
      this.starter();
  
  }

  starter(){
    this.transactiondetails.getTransactionDetail(this.route.queryParams['getValue']()['transactionId']).subscribe(response => this.handle(response));
  }

  tid=this.route.queryParams['getValue']()['transactionId'];
 
  handle(response){
    this.transaction=response;

  }

  displayedColumns: string[] = ['productName', 'quantity', 'cost'];
  dataSource = this.transaction;
            

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

  getProfile(){
    let id = localStorage.getItem("currentUserId");

    console.log("User Id is "+ id);

    this.userProfileService.getUserDetails(id).subscribe(
      res => this.handleSuccessfulResponse(res),
      err => this.handleSuccessfulResponse(err),
      () => ''
    );


  }

  handleSuccessfulResponse(response)
  {
    this.myProfile = response;
    this.userName = this.myProfile.userName;
  }
  
  onClickBack(){

    
      this.router.navigate(['/transactions']);  
    
    
  }


}
