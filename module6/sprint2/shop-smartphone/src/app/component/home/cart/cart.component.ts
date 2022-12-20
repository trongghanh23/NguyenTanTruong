import { Component, OnInit } from '@angular/core';
import {ICart} from '../../../model/i-cart';
import {SmartphoneService} from '../../../service/smartphone.service';
import {Route} from '@angular/router';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cart: ICart[];
  totalPrice = 0;
  finalPrice = 0;
  cartCount: number;
  total: string;
  price: number;
  usd: number;
  action: boolean;

  constructor(private smartphoneService: SmartphoneService) { }

  ngOnInit(): void {
    this.getCustomer();
  }
  getCustomer(): void {
    this.smartphoneService.findByUsername().subscribe(customer => {
      if (customer != null) {
        this.smartphoneService.listCart(customer.id).subscribe(value => {
          // this.smartphoneService.cartCount(customer.id).subscribe(value1 => {
          //   this.cartCount = value1.cartCount;
          // });
          this.cart = value;
          for (const item of value) {
            this.totalPrice += item.price * item.quantity;
            this.finalPrice += item.price * (1 - item.discount / 100) * item.quantity;
          }
        });
      }
    });
  }

}
