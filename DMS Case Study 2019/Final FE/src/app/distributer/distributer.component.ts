import { Component, OnInit, wtfStartTimeRange } from '@angular/core';
import { UserProfile } from '../models/UserModels';
import { GetMyProfileService } from './services/get-my-profile.service';
import { LogoutService } from '../services/logout.service';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material';


@Component({
  selector: 'app-distributer',
  templateUrl: './distributer.component.html',
  styleUrls: ['./distributer.component.css']
})
export class DistributerComponent implements OnInit {

  public userName = localStorage.getItem("currentUserName");
 

  public user : UserProfile;

  public homePage = true;
  public showProfile = false;
  public showRetailer = false;
  public showInventory = false;
  public showRequests = false;
  public showTransactions = false;

  constructor(private userProfileService : GetMyProfileService,
              private router : Router,
              private snackBar: MatSnackBar)
  { }

  ngOnInit() {
    this.starter();  
  }

  starter(){this.isDistributor();
  }

  isDistributor(){
    if( localStorage.getItem("currentUserRole") != null )
    {
      if( localStorage.getItem("currentUserRole") === '1' )
      {
        this.router.navigate(['/admin']);

      }
      else if( localStorage.getItem("currentUserRole") === '2' )
      {
        console.log("User is logged in as Distributor");
      }

      else if( localStorage.getItem("currentUserRole") === '3' )
      {
        this.router.navigate(['/retailer']);
      }
    }
  
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
    this.user = response;
    this.userName = this.user.userName;
    console.log("Current user details fetched");
  }

  onClickProfile(){
    console.log("Profile Panel Clicked");

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

  onClickRetailer(){
    console.log("Retailers Panel Clicked");

    this.homePage = false;
    this.showProfile = false;
    this.showRetailer = true;
    this.showInventory = false;
    this.showRequests = false;  
    this.showTransactions = false;


  }

  onClickInventory(){
    console.log("Inventory Panel Clicked");
 
    this.homePage = false;
    this.showProfile = false;
    this.showRetailer = false;
    this.showInventory = true;
    this.showRequests = false;  
    this.showTransactions = false;
 }

  onClickRequests(){
    console.log("Requests Panel Clicked");

    this.homePage = false;
    this.showProfile = false;
    this.showRetailer = false;
    this.showInventory = false;
    this.showRequests = true;  
    this.showTransactions = false;
  
  }

  onClickTransactions(){
    console.log("Transactions Panel Clicked");

    this.homePage = false;
    this.showProfile = false;
    this.showRetailer = false;
    this.showInventory = false;
    this.showRequests = false;  
    this.showTransactions = true;
}
  


}