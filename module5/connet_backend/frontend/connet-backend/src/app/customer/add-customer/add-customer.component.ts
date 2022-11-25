import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {CustomerType} from '../../model/customer-type';
import {CustomerService} from '../../service/customer.service';
import {CustomerTypeService} from '../../service/customer-type.service';

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent implements OnInit {

  formAdd: FormGroup;
  ranks: CustomerType[] = [];

  constructor(private fb: FormBuilder,
              private customerService: CustomerService,
              private rankService: CustomerTypeService) {
  }

  ngOnInit(): void {
    this.formAdd = this.fb.group({
      name: [],
      birthday: [],
      gender: [],
      idNum: [],
      phone: [],
      email: [],
      address: [],
      rank: []
    });
    this.getAllRank();
  }

  getAllRank() {
    this.rankService.getAll().subscribe(value => {
      this.ranks = value;
    });
  }

  addNewCustomer() {
    const customer = this.formAdd.value;
    console.log(customer);
    this.customerService.addNew(customer).subscribe(() => {
      this.formAdd.reset();
    });
  }
}
