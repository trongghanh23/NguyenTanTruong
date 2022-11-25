import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ProductListComponent} from "./product/product-list/product-list.component";
import {ProductCreateComponent} from "./product/product-create/product-create.component";
import {ProductDeleteComponent} from "./product-delete/product-delete.component";
import {ProductUpdateComponent} from "./product/product-update/product-update.component";
import {ListCategoryComponent} from "./category/list-category/list-category.component";
import {CreateCategoryComponent} from "./category/create-category/create-category.component";
import {UpdateCategoryComponent} from "./category/update-category/update-category.component";
import {DeleteCategoryComponent} from "./category/delete-category/delete-category.component";


const routes: Routes = [
  {path: 'product/list', component: ProductListComponent},
  {path: 'product/create', component: ProductCreateComponent},
  {path: 'product/update/:id', component: ProductUpdateComponent},
  {path: 'product/delete/:id', component: ProductDeleteComponent},
  {path: 'category', component: ListCategoryComponent},
  {path: 'create/category', component: CreateCategoryComponent},
  {path: 'update/category/:id', component: UpdateCategoryComponent},
  {path: 'delete/category/:id', component: DeleteCategoryComponent},
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
