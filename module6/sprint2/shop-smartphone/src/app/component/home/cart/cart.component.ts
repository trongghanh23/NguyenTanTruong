import { Component, OnInit } from '@angular/core';
import {ICart} from '../../../model/i-cart';
import {SmartphoneService} from '../../../service/smartphone.service';
import {Route} from '@angular/router';
import {SmartphoneDTo} from '../../../dto/smartphone-dto';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cart: SmartphoneDTo[];
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
          console.log(value);
          this.smartphoneService.cartCount(customer.id).subscribe(value1 => {
            this.cartCount = value1.cartCount;
          });
          console.log(value);
          this.cart = value;
          for (const item of value) {
            this.totalPrice += Number(item.price) * item.quantity;
            this.finalPrice += Number(item.price)  * item.quantity;
          }
        });
      }
    });
  }

  ascQuantity(id: number): void {
    console.log(id);
    this.smartphoneService.ascQuantity(id).subscribe(value => {
      location.reload();
    });
  }


  descQuantity(id: number): void {
    this.smartphoneService.descQuantity(id).subscribe(value => {
      location.reload();
    });
  }


}
