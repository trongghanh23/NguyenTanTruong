import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeRoutingModule } from './home-routing.module';
import {DetailsComponent} from './details/details.component';
import {CartComponent} from './cart/cart.component';
import {SmartphoneListComponent} from './smartphone-list/smartphone-list.component';
import {FormsModule} from '@angular/forms';



@NgModule({
  declarations: [
    DetailsComponent,
    SmartphoneListComponent,
    CartComponent

  ],
    exports: [
    ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    FormsModule,
  ]

})
export class HomeModule { }
