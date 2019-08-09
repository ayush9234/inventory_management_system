import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule,NoopAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule ,ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgxLoadingModule } from 'ngx-loading';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { MaterialModule } from '../material.module';
import { AdminComponent } from './admin/admin.component';
import { DistributerComponent } from './distributer/distributer.component';
import { RetailerComponent } from './retailer/retailer.component';
import { ShowInventoryComponent } from './show-inventory/show-inventory.component';
import { ShowRequestsComponent,AcceptDialog,RejectDialog } from './show-requests/show-requests.component';
import { ShowMyUsersComponent } from './show-my-users/show-my-users.component';
import { ShowTransactionsComponent } from './show-transactions/show-transactions.component';
import { MyProfileComponent } from './my-profile/my-profile.component';
import { MySalesComponent } from './my-sales/my-sales.component';
import { ShowAllDistributersComponent } from './show-all-distributers/show-all-distributers.component';
import { AddNewRetailerComponent } from './add-new-retailer/add-new-retailer.component';
import { ProductsComponent } from './products/products.component';
import { AddNewDistributerComponent } from './add-new-distributer/add-new-distributer.component';
import { AddProductComponent } from './admin/add-product/add-product.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { EditProductComponent } from './admin/edit-product/edit-product.component';
import { TransactionDetailsComponent } from './transaction-details/transaction-details.component';
import { OrderInventoryComponent } from './order-inventory/order-inventory.component';
import { UpdatePasswordComponent } from './my-profile/update-password/update-password.component';
import { TestpageComponent } from './testpage/testpage.component';
import { OrderDetailsComponent } from './order-details/order-details.component';
import { HeaderComponent,DialogOverviewExampleDialog } from './header/header.component';
import { SidenavbarComponent } from './sidenavbar/sidenavbar.component';
import { LogoutDialogComponent } from './header/logout-dialog/logout-dialog.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { MyPendingOrdersComponent } from './my-pending-orders/my-pending-orders.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AdminComponent,
    DistributerComponent,
    RetailerComponent, 
    ShowInventoryComponent,   
    ShowRequestsComponent,AcceptDialog,RejectDialog ,
    ShowMyUsersComponent,    
    ShowTransactionsComponent, MyProfileComponent, MySalesComponent,
    ShowAllDistributersComponent, AddNewRetailerComponent, 
    ProductsComponent, AddNewDistributerComponent, AddProductComponent, 
    PageNotFoundComponent, EditProductComponent, TransactionDetailsComponent, 
    OrderInventoryComponent, UpdatePasswordComponent, TestpageComponent, 
    OrderDetailsComponent, HeaderComponent, DialogOverviewExampleDialog,  
    SidenavbarComponent, LogoutDialogComponent, MyPendingOrdersComponent, 
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    MaterialModule,
    NoopAnimationsModule,
    NgbModule,
    NgxLoadingModule.forRoot({})
    
  ],
  entryComponents: [DialogOverviewExampleDialog , AcceptDialog, RejectDialog ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }