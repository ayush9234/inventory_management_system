import { Component, OnInit } from '@angular/core';
import { Transaction } from '../model/transaction';
import { ActivatedRoute, Router } from '@angular/router';
import { TransactionService } from '../service/transaction.service';

@Component({
  selector: 'app-transactions-list',
  templateUrl: './transactions-list.component.html',
  styleUrls: ['./transactions-list.component.css']
})
export class TransactionsListComponent implements OnInit {

  transactions: Transaction[];
  constructor(private route: ActivatedRoute,private router: Router,private transactionService: TransactionService) { 
  }

  ngOnInit() {
    this.transactionService.getTransactions().subscribe(response => this.handle(response));
  }

  handle(response){
    this.transactions = response;
  }

  getTransactionDetail(){
    
  }

  displayedColumns: string[] = ['transactionId','buyerName', 'sellerName', 'totalPrice', 'creationTime'];
  dataSource = this.transactions;
}
