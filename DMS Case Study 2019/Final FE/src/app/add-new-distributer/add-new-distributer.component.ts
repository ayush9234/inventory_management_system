import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { RegisterUser, UserProfile } from '../models/UserModels';
import { MatSnackBar } from '@angular/material';
import { RegisterNewUserService } from '../services/register-new-user.service';
import { AddNewDistributerService } from './add-new-distributer.service';
import { GetMyProfileService } from '../distributer/services/get-my-profile.service';

@Component({
  selector: 'add-new-distributer',
  templateUrl: './add-new-distributer.component.html',
  styleUrls: ['./add-new-distributer.component.css']
})
export class AddNewDistributerComponent implements OnInit {

  loading=false;

  public emailregex: RegExp = /[a-zA-Z0-9.-_]{1,}@[a-zA-Z.-]{2,}[.]{1}[a-zA-Z]{2,5}/;
  public stringRegex : RegExp = /^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$/ ;

  formError=false;

  public user : RegisterUser = new RegisterUser();
  public userName = localStorage.getItem("currentUserName");
  
  public myProfile : UserProfile;

  constructor(private fb: FormBuilder ,
              private router :Router, 
              private userProfileService : GetMyProfileService,
              private regNewUserService : AddNewDistributerService,
              private snackBar: MatSnackBar) { }

  ngOnInit() {

  }

  onClickProfile(){
    
    this.router.navigate(['/my_profile']);

  }

  onClickLogout(){
    console.log("Logout Clicked");
    
      console.log("cleared User Id "+localStorage.getItem("currentUserId") );
      localStorage.clear();

      this.snackBar.open("User Logged Out", "Close", {
        duration: 5000,verticalPosition: 'top',panelClass: ['green-snackbar']
      });

      this.router.navigate(['']);

      

  }

  onClickCancel(){
    this.router.navigate(['/distributors-list']);
  }

  addUserForm : FormGroup = this.fb.group({
    retName : ['',[Validators.required,Validators.pattern(this.stringRegex)]],
    retEmail: ['',[Validators.required,Validators.pattern(this.emailregex)]],
    retPassword: ['',[Validators.required,Validators.minLength(6)]],
    retAddress : ['',[Validators.required]],
    retContact : ['',[Validators.required,Validators.minLength(10),
                      Validators.maxLength(10),Validators.pattern("[1-9]{1}[0-9]{9}")]],
    retStatus : ['Active',[Validators.required]],
    retRole : [2,[Validators.required]],
    retArea : ['',[Validators.required,Validators.pattern(this.stringRegex)]],
  });

  get f() { return this.addUserForm.controls; }

  onSubmit(){
   
    this.loading=true;

    this.user.userName = this.f.retName.value;
    this.user.email = this.f.retEmail.value;
    this.user.password = this.f.retPassword.value;
    this.user.personalAddress = this.f.retAddress.value;
    this.user.contactno = this.f.retContact.value;
    this.user.area = this.f.retArea.value;
    this.user.roleType = 2;

    console.log(this.user);

    this.regNewUserService.registerUser(this.user).subscribe(
      response =>{
        this.loading=false;
        this.handleSuccessfulResponse(response);
        },
      err => {
        this.loading=false;
        this.errorResponse(err);
        }
    );

  }

  handleSuccessfulResponse(response){
    let resp = response;

    console.log("Responce : " + resp);

    this.snackBar.open("User Added", "Close", {
      duration: 5000,verticalPosition: 'top',panelClass: ['green-snackbar']
    });

    this.router.navigate(['/distributors-list']);
  }

  errorResponse(error)
  {
    this.formError=true;
    console.error("Error in submission"+error);
  }

}
