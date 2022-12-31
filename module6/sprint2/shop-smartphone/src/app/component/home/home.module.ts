import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeRoutingModule } from './home-routing.module';
import {DetailsComponent} from './details/details.component';
import {CartComponent} from './cart/cart.component';
import {SmartphoneListComponent} from './smartphone-list/smartphone-list.component';
import {FormsModule} from '@angular/forms';
import {HistoryComponent} from './history/history.component';
import {NgbPaginationModule} from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    DetailsComponent,
    SmartphoneListComponent,
    CartComponent,
    HistoryComponent
  ],
    exports: [
    ],
  imports: [
    CommonModule,
    HomeRoutingModule,
    FormsModule,
    NgbPaginationModule,
  ]

})
export class HomeModule { }
