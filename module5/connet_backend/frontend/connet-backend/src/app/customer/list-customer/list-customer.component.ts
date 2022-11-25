import { Component, OnInit } from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import {Customer} from '../../model/customer';
import {CustomerService} from '../../service/customer.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {



  delName: string;
  deleteId: number;
  page = 1;
  pageSize = 10;
  name = '';
  total$: Observable<number>;
  customers$: Observable<Customer[]>;

  constructor(private customerService: CustomerService) {
  }

  ngOnInit(): void {
    this.getAllCustomer();
  }

  getAllCustomer() {
    this.customerService.getCustomer(this.name, this.page, this.pageSize).subscribe(value => {
        console.log(value);
        // @ts-ignore
        this.customers$ = new BehaviorSubject<Customer[]>(value.content);
        this.total$ = new BehaviorSubject<number>(value.totalElements);
      },
      error => {
      });
  }

  deleteConfirm(customer: Customer) {
    console.log(customer);
    this.delName = customer.name;
    this.deleteId = customer.id;
  }

  delete() {
    this.customerService.deleteObject(this.deleteId).subscribe(() => {
      Swal.fire({
        position: 'center',
        icon: 'success',
        title: 'Delete successfully!',
        text: 'Customer: ' + this.delName,
        showConfirmButton: false,
        timer: 2500
      });
      this.getAllCustomer();
    });

  }
}
