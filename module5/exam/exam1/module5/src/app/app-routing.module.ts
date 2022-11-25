import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListSoTietKiemComponent} from "./so-tiet-kiem/list-so-tiet-kiem/list-so-tiet-kiem.component";
import {EditSoTietKiemComponent} from "./so-tiet-kiem/edit-so-tiet-kiem/edit-so-tiet-kiem.component";


const routes: Routes = [
  {path: '', component: ListSoTietKiemComponent},
  {path: 'list/sotietkiem', component: ListSoTietKiemComponent},
  {path: 'edit/sotietkiem/:id', component: EditSoTietKiemComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
