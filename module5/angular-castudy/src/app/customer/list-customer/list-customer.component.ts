import {Component, Input, OnInit} from '@angular/core';
import {Customer} from '../../model/customer';
import {CustomerService} from '../../service/customer.service';
import {Observable} from 'rxjs';
import Swal from 'sweetalert2';
import {Router} from '@angular/router';


@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {
  customerNameDelete: string;
  customerIdDelete: number;
  customerListPaging: Customer[];
  numberRecord = 3;
  curPage = 1;
  totalPage: number;

  constructor(private customerService: CustomerService,
              private router: Router) {
  }

  ngOnInit() {
    this.customerService.getAll().subscribe(value => {
      this.totalPage = Math.ceil(value.length / this.numberRecord);
    }, error => {
    }, () => {
    });
    this.customerService.findCustomerSearchPaging(this.numberRecord, this.curPage).subscribe(pagingList => {
      this.customerListPaging = pagingList;
    }, error => {
      console.log(error);
    }, () => {
      console.log('Hiển thị khách hàng ở trang ' + this.curPage);
    });
  }

  next(): void {
    this.curPage++;
    this.ngOnInit();
  }

  previos(): void {
    this.curPage--;
    this.ngOnInit();
  }


  getInfoCustomerDelete(customerName: string, customerId: number): void {
    this.customerNameDelete = customerName;
    this.customerIdDelete = customerId;
  }

  deleteCustomer(): void {
    this.customerService.deleteCustomer(this.customerIdDelete).subscribe(() => {
      this.ngOnInit();
      Swal.fire({
        position: 'top',
        icon: 'success',
        title: 'You are successful',
        showConfirmButton: false,
        timer: 1500
      });
      this.router.navigateByUrl('/list/customer');
    }, e => {
      console.log(e);
    });
  }
}
