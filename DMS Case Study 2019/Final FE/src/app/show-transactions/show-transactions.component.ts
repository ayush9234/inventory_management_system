import { Component, OnInit, ViewChild } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Transaction } from '../admin/model/transaction';
import { TransactionService } from '../admin/service/transaction.service';
import { UserProfile } from '../models/UserModels';
import { GetMyProfileService } from '../distributer/services/get-my-profile.service';
import { MatSnackBar, MatPaginator, MatTableDataSource, MatSort } from '@angular/material';

@Component({
  selector: 'show-transactions',
  templateUrl: './show-transactions.component.html',
  styleUrls: ['./show-transactions.component.css']
})
export class ShowTransactionsComponent implements OnInit {

  adminSidepanel = false;
  distributorSidePanel = false;
  retailerSidePanel = false;
  public userName = localStorage.getItem("currentUserName");
  
  public user : UserProfile;
  
  transactions: MatTableDataSource<any>;

  @ViewChild(MatSort, { static: true }) sort: MatSort;
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;

  constructor(private route: ActivatedRoute,
              private userProfileService : GetMyProfileService,
              private router: Router,
              private snackBar: MatSnackBar,
              private transactionService: TransactionService) { 
  }

  ngOnInit() {
      this.starter(); 
  }

  starter(){
    this.transactionService.getTransactions().subscribe(
      response =>{
        this.transactions = new MatTableDataSource(response);
        
        this.transactions.sort = this.sort;
        this.transactions.paginator = this.paginator;

      });
   }

 
  handle(response){
    this.transactions = response;
    this.transactions.paginator = this.paginator;
  }

  getTransactionDetail(element){

    let transactionId = element.transactionId;
    this.router.navigate(['/transaction-details'],{queryParams:{transactionId:transactionId}})
  }

  displayedColumns: string[] = [ 'buyerName', 'sellerName', 'totalPrice','transactionStatus', 'creationTime', 'view'];
  dataSource = this.transactions;


  applyFilter(filterValue: string) {
    this.transactions.filter = filterValue.trim().toLowerCase();
  }
  
  
  


}
