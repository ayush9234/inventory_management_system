import { ShowMyUsersComponent } from './../show-my-users/show-my-users.component';
import { Router } from '@angular/router';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { RegisterUser, UserProfile } from '../models/UserModels';
import { RegisterNewUserService } from '../services/register-new-user.service';
import { MatSnackBar } from '@angular/material';
import { GetMyProfileService } from '../distributer/services/get-my-profile.service';

@Component({
  selector: 'add-new-retailer',
  templateUrl: './add-new-retailer.component.html',
  styleUrls: ['./add-new-retailer.component.css']
})
export class AddNewRetailerComponent implements OnInit {

  formError=false;

  loading =false;

  public userName = localStorage.getItem("currentUserName");

  public users : UserProfile;

  public emailregex: RegExp = /[a-zA-Z0-9.-_]{1,}@[a-zA-Z.-]{2,}[.]{1}[a-zA-Z]{2,5}/;
  public stringRegex : RegExp = /^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$/ ;

  public myProfile : UserProfile;
  public user : RegisterUser = new RegisterUser();

  constructor(private fb: FormBuilder ,
              private router :Router, 
              private userProfileService : GetMyProfileService,
              private regNewUserService : RegisterNewUserService,
              private snackBar: MatSnackBar) { }

  ngOnInit() {
      this.starter();
  }

  starter(){
    this.getProfile();
  }

  getProfile(){
    let id = localStorage.getItem("currentUserId");

    console.log("User Id is "+ id);

    this.userProfileService.getUserDetails(id).subscribe(
      res => this.handleResponse(res),
      err => this.handleResponse(err),
      () => ''
    );


  }

  handleResponse(response)
  {
    this.myProfile = response;
    this.userName = this.myProfile.userName;

  }


  addRetailerForm : FormGroup = this.fb.group({
    retName : ['',[Validators.required,Validators.pattern(this.stringRegex)]],
    retEmail: ['',[Validators.required,Validators.pattern(this.emailregex)]],
    retPassword: ['',[Validators.required,Validators.minLength(6)]],
    retAddress : ['',[Validators.required]],
    retContact : ['',[Validators.required,Validators.minLength(10),
                      Validators.maxLength(10),Validators.pattern("[1-9]{1}[0-9]{9}")]],
    retStatus : ['Active',[Validators.required]],
    retRole : ['3',[Validators.required]],
    retArea : ['',[Validators.required,Validators.pattern(this.stringRegex)]],
  });

  get f() { return this.addRetailerForm.controls; }

  onSubmit(){
   
    this.loading=true;

    this.user.userName = this.f.retName.value;
    this.user.email = this.f.retEmail.value;
    this.user.password = this.f.retPassword.value;
    this.user.personalAddress = this.f.retAddress.value;
    this.user.contactno = this.f.retContact.value;
    this.user.roleType = 3;
    this.user.area = this.myProfile.area;

    this.regNewUserService.registerUser(this.user).subscribe(
      response =>
            {this.handleSuccessfulResponse(response);
             this.loading=false;
            },
      err =>
            {this.errorResponse(err);
              this.loading=false;
            }
    );

  }

  handleSuccessfulResponse(response){
    let resp = response;

    console.log("Responce : " + resp);

    this.snackBar.open("User Added", "Close", {
      duration: 5000,verticalPosition: 'top',panelClass: ['green-snackbar']
    });

    this.router.navigate(['/retailers-list']);

  }

  errorResponse(error)
  {
    this.formError=true;
    console.error("Error in submission"+error);
  }


}
