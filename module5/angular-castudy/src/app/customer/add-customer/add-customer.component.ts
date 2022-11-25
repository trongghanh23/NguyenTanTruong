import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormGroup, FormControl, Validators} from '@angular/forms';
import {CustomerType} from '../../model/customer-type';
import {CustomerService} from '../../service/customer.service';
import {CustomerTypeService} from '../../service/customer-type.service';
import {Router} from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent implements OnInit {
  customerFormGroup: FormGroup = new FormGroup({
    name: new FormControl('', [Validators.required, Validators.pattern('^KH[0-9]+')]),
    dateOfBirthday: new FormControl('', this.checkAge18),
    gender: new FormControl('', Validators.required),
    idCard: new FormControl('', [Validators.required, Validators.pattern('^\\d{9}$|^\\d{12}$')]),
    phoneNumber: new FormControl('', [Validators.required, Validators.pattern('(0|[(]84[)][+])9[01]\\d{7}')]),
    email: new FormControl('', [Validators.required, Validators.email]),
    address: new FormControl('', Validators.required),
    customerType: new FormControl('', Validators.required)
  });
  customerTypeList: CustomerType[] = [];

  constructor(private customerService: CustomerService,
              protected customerTypeService: CustomerTypeService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.customerTypeService.getAll().subscribe(value => {
      this.customerTypeList = value;
    });
  }
  checkAge18(abstractControl: AbstractControl): any {
    const formYear = Number(abstractControl.value.substr(0, 4));
    const curYear = new Date().getFullYear();
    return curYear - formYear >= 18 ? null : {invalid18: true};
  }
  createCustomer(): void {
    const customer = this.customerFormGroup.value;
    this.customerService.saveCreateProduct(customer).subscribe(value => {
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
