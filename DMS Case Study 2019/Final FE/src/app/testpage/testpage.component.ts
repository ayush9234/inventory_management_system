import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatTableDataSource } from '@angular/material';
import { ProductService } from '../admin/service/product.service';
import { GetAllDistributersService } from '../show-all-distributers/get-all-distributers.service';
import { TransactionService } from '../admin/service/transaction.service';


export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}

const ELEMENT_DATA: PeriodicElement[] = [
  {position: 1, name: 'Hydrogen', weight: 1.0079, symbol: 'H'},
  {position: 2, name: 'Helium', weight: 4.0026, symbol: 'He'},
  {position: 3, name: 'Lithium', weight: 6.941, symbol: 'Li'},
  {position: 4, name: 'Beryllium', weight: 9.0122, symbol: 'Be'},
  {position: 5, name: 'Boron', weight: 10.811, symbol: 'B'},
  {position: 6, name: 'Carbon', weight: 12.0107, symbol: 'C'},
  {position: 7, name: 'Nitrogen', weight: 14.0067, symbol: 'N'},
  {position: 8, name: 'Oxygen', weight: 15.9994, symbol: 'O'},
  {position: 9, name: 'Fluorine', weight: 18.9984, symbol: 'F'},
  {position: 10, name: 'Neon', weight: 20.1797, symbol: 'Ne'},
];


@Component({
  selector: 'testpage',
  templateUrl: './testpage.component.html',
  styleUrls: ['./testpage.component.css']
})
export class TestpageComponent implements OnInit {

  @ViewChild(MatPaginator,{static: true}) paginator: MatPaginator;
  dataSource ;

  constructor(private productService: ProductService, 
    private getDistributerList : GetAllDistributersService,
    private transactionService: TransactionService) 
  
    { }
  

  ngOnInit() {
    this.transactionService.getTransactions().subscribe(
      response =>{
        this.dataSource = new MatTableDataSource(response);
        // this.length = response.length;
        this.dataSource.paginator = this.paginator;
      });
  }

  ngAfterViewInit() {
    // this.dataSource.paginator = this.paginator;
  }

  hideRow=false;

  onRowClicked(row) {
    console.log('Row clicked: ', row);
}

  // displayedColumns: string[] = ['position', 'name', 'weight', 'symbol'];
  displayedColumns : string[] =['userName','email','personalAddress','contactno','area'];

  
}
