import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import { FooterComponent } from './footer/footer.component';
import { ListSoTietKiemComponent } from './so-tiet-kiem/list-so-tiet-kiem/list-so-tiet-kiem.component';
import { EditSoTietKiemComponent } from './so-tiet-kiem/edit-so-tiet-kiem/edit-so-tiet-kiem.component';
import {RouterModule} from "@angular/router";
import {ReactiveFormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    ListSoTietKiemComponent,
    EditSoTietKiemComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
