import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HeaderComponent} from './header/header.component';
import {FooterComponent} from './footer/footer.component';
import {HomeComponent} from './home/home.component';
import {NavbarComponent} from './navbar/navbar.component';
import {AddContractComponent} from './contract/add-contract/add-contract.component';
import {ListCustomerComponent} from './customer/list-customer/list-customer.component';
import {ListFacilityComponent} from './facility/list-facility/list-facility.component';
import {ListContractComponent} from './contract/list-contract/list-contract.component';
import {RouterModule} from '@angular/router';
import {AddCustomerComponent} from './customer/add-customer/add-customer.component';
import {HttpClientModule} from '@angular/common/http';
import {EditCustomerComponent} from './customer/edit-customer/edit-customer.component';
import {CreateFacilityComponent} from './facility/create-facility/create-facility.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    NavbarComponent,
    AddContractComponent,
    ListCustomerComponent,
    ListFacilityComponent,
    CreateFacilityComponent,
    ListContractComponent,
    AddCustomerComponent,
    EditCustomerComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
