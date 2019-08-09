import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AdminComponent } from './admin/admin.component';
import { RetailerComponent } from './retailer/retailer.component';
import { DistributerComponent } from './distributer/distributer.component';
import { AuthGaurdService } from './services/auth-gaurd-service.service';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { MyProfileComponent } from './my-profile/my-profile.component';
import { AddProductComponent } from './admin/add-product/add-product.component';
import { AddNewDistributerComponent } from './add-new-distributer/add-new-distributer.component';
import { EditProductComponent } from './admin/edit-product/edit-product.component';
import { OrderInventoryComponent } from './order-inventory/order-inventory.component';
import { ShowAllDistributersComponent } from './show-all-distributers/show-all-distributers.component';
import { GetRetailerlistService } from './distributer/services/get-retailerlist.service';
import { ShowMyUsersComponent } from './show-my-users/show-my-users.component';
import { ProductsComponent } from './products/products.component';
import { ShowRequestsComponent } from './show-requests/show-requests.component';
import { ShowTransactionsComponent } from './show-transactions/show-transactions.component';
import { ShowInventoryComponent } from './show-inventory/show-inventory.component';
import { MySalesComponent } from './my-sales/my-sales.component';
import { TransactionDetail } from './admin/model/transaction-detail';
import { TransactionDetailsComponent } from './transaction-details/transaction-details.component';
import { AddNewRetailerComponent } from './add-new-retailer/add-new-retailer.component';
import { UpdatePasswordComponent } from './my-profile/update-password/update-password.component';
import { OrderDetailsComponent } from './order-details/order-details.component';


const routes: Routes = [
  {path: "", component: LoginComponent},
  {path: 'login' , component: LoginComponent},
  {path: 'admin' , component: AdminComponent,canActivate:[AuthGaurdService]},
  {path: 'distributor' , component: DistributerComponent,canActivate:[AuthGaurdService]},
  {path: 'distributors-list' , component: ShowAllDistributersComponent,canActivate:[AuthGaurdService]},
  {path: 'retailer' , component: RetailerComponent,canActivate:[AuthGaurdService]},
  {path: 'retailers-list' , component: ShowMyUsersComponent,canActivate:[AuthGaurdService]},
  {path: 'my_profile' , component: MyProfileComponent,canActivate:[AuthGaurdService]},
  {path: 'update-password' , component: UpdatePasswordComponent,canActivate:[AuthGaurdService]},
  {path: 'add-product' , component: AddProductComponent,canActivate:[AuthGaurdService]},
  {path: 'edit-product' , component: EditProductComponent,canActivate:[AuthGaurdService]},
  {path: 'transaction-details' , component: TransactionDetailsComponent,canActivate:[AuthGaurdService]},
  {path: 'order-details' , component: OrderDetailsComponent,canActivate:[AuthGaurdService]},
  {path: 'order-inventory' , component: OrderInventoryComponent,canActivate:[AuthGaurdService]},
  {path: 'add-distributor' , component: AddNewDistributerComponent,canActivate:[AuthGaurdService]},
  {path: 'add-retailer' , component: AddNewRetailerComponent,canActivate:[AuthGaurdService]},
  {path: 'products' , component: ProductsComponent,canActivate:[AuthGaurdService]},
  {path: 'inventory' , component: ShowInventoryComponent,canActivate:[AuthGaurdService]},
  {path: 'requests' , component: ShowRequestsComponent,canActivate:[AuthGaurdService]},
  {path: 'transactions' , component: ShowTransactionsComponent,canActivate:[AuthGaurdService]},
  {path: 'sales' , component: MySalesComponent,canActivate:[AuthGaurdService]},
  {path: 'page-not-found' , component: PageNotFoundComponent},
  {path: '**' ,redirectTo: ('/page-not-found')},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

export const RoutingComponents = [LoginComponent,
                                  AdminComponent,
                                  DistributerComponent,
                                  RetailerComponent];