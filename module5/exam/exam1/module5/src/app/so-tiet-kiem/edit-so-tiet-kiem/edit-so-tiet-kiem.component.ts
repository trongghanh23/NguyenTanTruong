import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import Swal from "sweetalert2";
import {SoTietKiem} from "../../model/so-tiet-kiem";
import {KhachHang} from "../../model/khach-hang";
import {SoTietKiemService} from "../../service/so-tiet-kiem.service";
import {KhachHangService} from "../../service/khach-hang.service";

@Component({
  selector: 'app-edit-so-tiet-kiem',
  templateUrl: './edit-so-tiet-kiem.component.html',
  styleUrls: ['./edit-so-tiet-kiem.component.css']
})
export class EditSoTietKiemComponent implements OnInit {
  soTietKiemFormGroup: FormGroup;
  id: number;
  soTietKiem: SoTietKiem;
  khachHangList: KhachHang[] = [];

  constructor(private soTietKiemService: SoTietKiemService,
              private khachHangService: KhachHangService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
  }


  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(value => {
      this.id = Number(value.get('id'));
    });
    this.soTietKiemService.findById(this.id).subscribe(value => {
      this.soTietKiem = value;
      this.soTietKiemFormGroup.patchValue(this.soTietKiem);
      this.khachHangService.getAll().subscribe(c => {
        this.khachHangList = c;
      });
    });
    this.soTietKiemFormGroup = new FormGroup({
      ngayMoSo: new FormControl(''),
      thoiGianBatDau: new FormControl('', [Validators.required, Validators.pattern('^KH[0-9]+')]),
      kyHan: new FormControl(''),
      soTienGui: new FormControl('', Validators.required),
      laiSuat: new FormControl('', [Validators.required, Validators.pattern('^\\d{9}$|^\\d{12}$')]),
      uuDai: new FormControl('', [Validators.required, Validators.pattern('(0|[(]84[)][+])9[01]\\d{7}')]),
      khachHangList: new FormGroup({
        id: new FormControl(''),
        name: new FormControl('', Validators.required)
      }),
    });
  }



  updateProduct(): void {
    const customer = this.soTietKiemFormGroup.value;
    customer.id = this.soTietKiem.id;
    this.soTietKiemService.editSoTietKiem(customer).subscribe(value => {
      Swal.fire({
        position: 'top',
        icon: 'success',
        title: 'You are successful',
        showConfirmButton: false,
        timer: 1500
      });
      this.router.navigateByUrl('/list/sotietkiem');
    }, e => {
      console.log(e);
    });
  }

}
