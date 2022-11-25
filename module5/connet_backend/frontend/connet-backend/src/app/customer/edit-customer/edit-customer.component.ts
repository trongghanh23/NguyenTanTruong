import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {Customer} from '../../model/customer';
import {CustomerType} from '../../model/customer-type';
import {CustomerService} from '../../service/customer.service';
import {CustomerTypeService} from '../../service/customer-type.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {

  formEdit: FormGroup;
  customer: Customer;
  birthday: string;
  ranks: CustomerType[] = [];

  constructor(private customerService: CustomerService,
              private rankService: CustomerTypeService,
              private activatedRoute: ActivatedRoute,
              private router: Router,
              private fb: FormBuilder) {
  }

  ngOnInit(): void {
    const id = this.activatedRoute.snapshot.params.idUpdate;
    this.customerService.findById(id).subscribe(value => {
      this.customer = value;
      this.birthday = value.dateOfBirth;
      console.log(value);
      this.formEdit.patchValue(this.customer);
    });
    this.formEdit = this.fb.group({
      id: [],
      name: [],
      birthday: [],
      gender: [],
      idNum: [],
      phone: [],
      email: [],
      address: [],
      rank: []
    });
    this.getRank();
  }


  getRank() {
    this.rankService.getAll().subscribe(value => {
      this.ranks = value;
    });
  }

  compareWithId(item1, item2) {
    return item1 && item2 && item1.id === item2.id;
  }

  saveEditing() {
    const customer = this.formEdit.value;
    this.customerService.editObject(customer).subscribe(() => {
      this.router.navigateByUrl('/customer/list');
    });
  }
}
