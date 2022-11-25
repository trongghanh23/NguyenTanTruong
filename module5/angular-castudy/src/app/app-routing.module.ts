import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ListCustomerComponent} from './customer/list-customer/list-customer.component';
import {ListFacilityComponent} from './facility/list-facility/list-facility.component';
import {HomeComponent} from './home/home.component';
import {ListContractComponent} from './contract/list-contract/list-contract.component';
import {AddCustomerComponent} from './customer/add-customer/add-customer.component';
import {EditCustomerComponent} from './customer/edit-customer/edit-customer.component';
import {CreateFacilityComponent} from './facility/create-facility/create-facility.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'list/customer', component: ListCustomerComponent},
  {path: 'add/customer', component: AddCustomerComponent},
  {path: 'edit/customer/:customerId', component: EditCustomerComponent},
  {path: 'list/facility', component: ListFacilityComponent},
  {path: 'add/facility', component: CreateFacilityComponent},
  {path: 'list/contract', component: ListContractComponent},
  {path: 'edit/contract/:id', component: EditCustomerComponent},
  ];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {
}
