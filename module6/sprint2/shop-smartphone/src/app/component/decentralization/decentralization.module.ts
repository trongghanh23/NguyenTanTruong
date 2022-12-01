import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DecentralizationRoutingModule } from './decentralization-routing.module';
import { FooterComponent } from '../home/footer/footer.component';


@NgModule({
  declarations: [FooterComponent],
  exports: [
    FooterComponent
  ],
  imports: [
    CommonModule,
    DecentralizationRoutingModule
  ]
})
export class DecentralizationModule { }
