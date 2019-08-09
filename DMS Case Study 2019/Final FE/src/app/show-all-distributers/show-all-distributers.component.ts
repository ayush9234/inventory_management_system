import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { MatSnackBar, MatPaginator, MatTableDataSource, MatSort } from '@angular/material';
import { GetAllDistributersService } from './get-all-distributers.service';

@Component({
  selector: 'show-all-distributers',
  templateUrl: './show-all-distributers.component.html',
  styleUrls: ['./show-all-distributers.component.css']
})
export class ShowAllDistributersComponent implements OnInit {

  public userName = localStorage.getItem("currentUserName");
  addButton = true;
  
  @ViewChild(MatSort, { static: true }) sort: MatSort;
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  
  constructor(private router : Router,
              private snackBar: MatSnackBar,
              private getDistributerList : GetAllDistributersService,
    ) { }

  displayedColumns : string[] =['userName','email','contactno','area'];
  dataSource ;
  

  ngOnInit() {
    this.getDistributerList.getAllDistributersList().subscribe(
      response =>{
        this.dataSource = new MatTableDataSource(response);
        // this.length = response.length;
        this.dataSource.sort=this.sort;
        this.dataSource.paginator = this.paginator;
      });
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


  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  
  

}
