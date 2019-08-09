import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormControl, Validators, FormGroup, FormBuilder } from '@angular/forms';

import { LoginCheckService,  UserInfo ,LoginInfo} from './services/login-check.service';
import { AuthenticatorService } from './services/authenticator.service';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  
//  loginDetails = new LoginDetails('','');
  

loading = false;
submitted = false;
returnUrl: string;
public emailregex: RegExp = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
loginFormError = false;

loginInfo:LoginInfo = new LoginInfo();
user:UserInfo = new UserInfo();
  


  constructor(private fb: FormBuilder ,
              private router :Router, 
              private loginService : LoginCheckService,
              private authenticateService : AuthenticatorService,
              private snackBar: MatSnackBar
              ) { }

  ngOnInit() {

   this.authenticateService.checkLogin();
   
 }

loginForm : FormGroup   = this.fb.group({
  ipEmail: ['',[Validators.required,Validators.pattern(this.emailregex)]],
  ipPassword: ['',[Validators.required,Validators.minLength(5)]]

});
  
  get f() { return this.loginForm.controls; }

  handleSuccessfulResponse(response)
  {
  
      this.user=response;
      console.log("Inside response handler with response "+this.user.result);

      if(this.user.result === false){
        console.error(" Invalid credentials entered ");
        this.loginFormError = true;
      } 
      
      else if(this.user.result === true )
     {
       if(this.user.roleType != null && this.user.roleType === 1 ){
        
        console.log(" Routing to admin home page ");     
        
        localStorage.setItem("currentUserId",JSON.stringify(this.user.userId));
        localStorage.setItem("currentUserResult",JSON.stringify(this.user.result));
        localStorage.setItem("currentUserRole",JSON.stringify(this.user.roleType));
        localStorage.setItem("currentUserName",(this.user.userName));

        this.router.navigate(['/admin']);
       }

       else if(this.user.roleType != null && this.user.roleType === 2 ){

        console.log(" Routing to distributer home page " );            

        localStorage.setItem("currentUserId",JSON.stringify(this.user.userId));
        localStorage.setItem("currentUserResult",JSON.stringify(this.user.result));
        localStorage.setItem("currentUserRole",JSON.stringify(this.user.roleType));
        localStorage.setItem("currentUserName",(this.user.userName));

        let  a= localStorage.getItem("currentUserId");

        this.router.navigate(['/distributor']);
      }

       else if(this.user.roleType != null && this.user.roleType === 3 ){
        
        console.log(" Routing to retailer home page ");     

        localStorage.setItem("currentUserId",JSON.stringify(this.user.userId));
        localStorage.setItem("currentUserResult",JSON.stringify(this.user.result));
        localStorage.setItem("currentUserRole",JSON.stringify(this.user.roleType));
        localStorage.setItem("currentUserName",(this.user.userName));

        this.router.navigate(['/retailer']);

      }
     
     }
     else{
     
      this.loginFormError= true;
    }
     

  }

  validateSubmit(){
    console.log("Inside validate Login method");
    this.loginInfo.email=this.f.ipEmail.value;
    this.loginInfo.password=this.f.ipPassword.value;
  

    this.loginService.login(this.loginInfo).subscribe(
      response =>this.handleSuccessfulResponse(response),
      err => this.handleSuccessfulResponse(err)
      );
  }

  onSubmit() {
    
    this.validateSubmit();
    
    if(this.user.result === false)
    {
      this.loginFormError = true;
    }

}
    
  }


