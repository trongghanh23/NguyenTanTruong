import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {ProductListComponent} from './product/product-list/product-list.component';
import {ProductCreateComponent} from './product/product-create/product-create.component';
// import {ProductUpdateComponent} from './product/product-update/product-update.component';
import {ReactiveFormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import { ProductDeleteComponent } from './product-delete/product-delete.component';
import {HttpClientModule} from "@angular/common/http";
import { ProductUpdateComponent } from './product/product-update/product-update.component';
import { ListCategoryComponent } from './category/list-category/list-category.component';
import { CreateCategoryComponent } from './category/create-category/create-category.component';
import { UpdateCategoryComponent } from './category/update-category/update-category.component';
import { DeleteCategoryComponent } from './category/delete-category/delete-category.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    ProductCreateComponent,
    // ProductUpdateComponent,
    ProductDeleteComponent,
    ProductUpdateComponent,
    ListCategoryComponent,
    CreateCategoryComponent,
    UpdateCategoryComponent,
    DeleteCategoryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    AppRoutingModule,
    RouterModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
