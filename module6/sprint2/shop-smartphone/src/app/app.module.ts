import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './component/decentralization/login/login.component';
import { HeaderComponent } from './component/home/header/header.component';
import {FooterComponent} from './component/home/footer/footer.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {HomeModule} from './component/home/home.module';
import {DecentralizationModule} from './component/decentralization/decentralization.module';

import {HttpClient, HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';



@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    HeaderComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbModule,
    HomeModule,
    DecentralizationModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
