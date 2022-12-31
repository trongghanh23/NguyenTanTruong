import {Component, OnInit} from '@angular/core';
import {ICart} from '../../../model/i-cart';
import {SmartphoneService} from '../../../service/smartphone.service';
import {Route} from '@angular/router';
import {SmartphoneDTo} from '../../../dto/smartphone-dto';
import {render} from 'creditcardpayments/creditcardpayments';
import Swal from 'sweetalert2';

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

  constructor(private smartphoneService: SmartphoneService) {
  }

  ngOnInit(): void {
    this.getCart();
  }

  getCart(): void {
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
            this.finalPrice += Number(item.price) * item.quantity;
          }
        });
      }
    });
  }

  ascQuantity(id: number): void {
    console.log(id);
    this.smartphoneService.ascQuantity(id).subscribe(value => {
      this.getCart();
    });
  }


  descQuantity(id: number): void {
    this.smartphoneService.descQuantity(id).subscribe(value => {
      this.getCart();
    });
  }
  submit(price: number) {
    if (!this.action) {
      this.action = true;
      this.usd = price / 25000;
      this.total = this.usd.toString();
      render(
        {
          id: '#myPaypal',
          value: this.total,
          currency: 'USD',
          onApprove: (details) => {
            this.paySmartphone();
          }
        }
      );

    } else {
      this.action = false;
    }
  }

  paySmartphone(): void {
    this.smartphoneService.findByUsername().subscribe(customer => {
      this.smartphoneService.paySmartphone(customer.id).subscribe(value => {
      });
      Swal.fire({
        position: 'center',
        icon: 'success',
        text: 'Cảm ơn quý khách !',
        title: 'Đã thanh toán thành công',
        showConfirmButton: false,
      });
      window.setTimeout(this.loadPage, 500);
    }, error => {
      Swal.fire({
        position: 'center',
        icon: 'error',
        text: 'Xin lỗi quý khách !',
        title: 'Thanh toán thất bại !',
        showConfirmButton: false,
      });
    });
  }
  loadPage(): void {
    window.location.replace('/cart');
  }
  deleteCart(id: number): void {
    Swal.fire({
      title: 'Bạn có chắc?',
      text: 'Xóa sản phẩm này khỏi giỏ hàng!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Có, tôi muốn xóa!',
      cancelButtonText: 'Đóng'
    }).then((result) => {
      if (result.isConfirmed) {
        this.smartphoneService.deleteCart(id).subscribe(() => {
          const Toast = Swal.mixin({
            toast: true,
            position: 'top-end',
            showConfirmButton: false,
            timer: 1500,
            timerProgressBar: true,
            didOpen: (toast) => {
              toast.addEventListener('mouseenter', Swal.stopTimer);
              toast.addEventListener('mouseleave', Swal.resumeTimer);
            }
          });

          Toast.fire({
            icon: 'success',
            title: 'Xóa khỏi giỏ hàng thành công!'
          });

          location.reload();
        }, error => {
        });
      }
    });
  }


}
