import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../../service/customer.service';
import {ActivatedRoute, Router} from '@angular/router';
import {CustomerType} from '../../model/customer-type';
import {CustomerTypeService} from '../../service/customer-type.service';
import {Customer} from '../../model/customer';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {
  customerFormGroup: FormGroup;
  customerId: number;
  customer: Customer;
  customerTypeList: CustomerType[] = [];

  constructor(private customerService: CustomerService,
              private customerTypeService: CustomerTypeService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
  }


  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(value => {
      this.customerId = Number(value.get('customerId'));
    });
    this.customerService.findById(this.customerId).subscribe(value => {
      this.customer = value;
      this.customerTypeService.getAll().subscribe(c => {
        this.customerTypeList = c;
        this.customerFormGroup.patchValue(this.customer);
      });
    });
    this.customerFormGroup = new FormGroup({
      id: new FormControl(''),
      name: new FormControl('', [Validators.required, Validators.pattern('^KH[0-9]+')]),
      dateOfBirthday: new FormControl('', this.checkAge18),
      gender: new FormControl('', Validators.required),
      idCard: new FormControl('', [Validators.required, Validators.pattern('^\\d{9}$|^\\d{12}$')]),
      phoneNumber: new FormControl('', [Validators.required, Validators.pattern('(0|[(]84[)][+])9[01]\\d{7}')]),
      email: new FormControl('', [Validators.required, Validators.email]),
      address: new FormControl('', Validators.required),
      customerType: new FormControl('', Validators.required)
    });
  }
  checkAge18(abstractControl: AbstractControl): any {
    const formYear = Number(abstractControl.value.substr(0, 4));
    const curYear = new Date().getFullYear();
    return curYear - formYear >= 18 ? null : {invalid18: true};
  }
  updateProduct(): void {
    const customer = this.customerFormGroup.value;
    customer.id = this.customer.id;
    this.customerService.editCustomer(customer).subscribe(value => {
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
  compareWithId(item1, item2) {
    return item1 && item2 && item1.id === item2.id;
  }
}
