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
import {GoogleLoginProvider, SocialAuthServiceConfig} from 'angularx-social-login';

const googleLoginOptions = {
  scope: 'profile email',
  plugin_name: 'login'
};


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
  providers: [
    {
      provide: 'SocialAuthServiceConfig',
      useValue: {
        autoLogin: false,
        providers: [
          {
            id: GoogleLoginProvider.PROVIDER_ID,
            provider: new GoogleLoginProvider(
              '612774287153-uthnsrl25on17doe8413il68ebv9c969.apps.googleusercontent.com',
              googleLoginOptions
            )
          },
        ]
      } as SocialAuthServiceConfig,
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
