import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {DetailsComponent} from './details/details.component';
import {CartComponent} from './cart/cart.component';
import {SmartphoneListComponent} from './smartphone-list/smartphone-list.component';
import {LoginComponent} from '../decentralization/login/login.component';
import {AuthGuard} from '../decentralization/auth.guard';
import {HistoryComponent} from './history/history.component';


const routes: Routes = [
  {
    path: '', component: SmartphoneListComponent
  },
  {
    path: 'login', component: LoginComponent
  },
  {
    path: 'history', component: HistoryComponent
  },
  {
    path: 'detail/:id', component: DetailsComponent
  },
  {
    path: 'cart', canActivate: [AuthGuard],
   data: {
   roles: ['ROLE_CUSTOMER']
 },
    component: CartComponent
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule {
}
