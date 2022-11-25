import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import Swal from "sweetalert2";
import {SoTietKiem} from "../../model/so-tiet-kiem";
import {SoTietKiemService} from "../../service/so-tiet-kiem.service";

@Component({
  selector: 'app-list-so-tiet-kiem',
  templateUrl: './list-so-tiet-kiem.component.html',
  styleUrls: ['./list-so-tiet-kiem.component.css']
})
export class ListSoTietKiemComponent implements OnInit {

  idDelete: number;
  listPaging: SoTietKiem[];
  numberRecord = 3;
  curPage = 1;
  totalPage: number;


  constructor(private soTietKiemService: SoTietKiemService,
              private router: Router) {
  }

  ngOnInit() {
    this.soTietKiemService.getAll().subscribe(value => {
      this.totalPage = Math.ceil(value.length / this.numberRecord);
    }, error => {
    }, () => {
    });
    this.soTietKiemService.findSoTietKiemPaging(this.numberRecord, this.curPage).subscribe(pagingList => {
      this.listPaging = pagingList;
    }, error => {
      console.log(error);
    }, () => {
      console.log('Hiển thị sổ tiết kiệm ở trang ' + this.curPage);
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


  getDelete( idDelete: number): void {
    this.idDelete = idDelete;
  }

  deleteCustomer(): void {
    this.soTietKiemService.deleteSoTietKiem(this.idDelete).subscribe(() => {
      this.ngOnInit();
      Swal.fire({
        position: 'top',
        icon: 'success',
        title: 'successfully added new',
        showConfirmButton: false,
        timer: 1500
      });
      this.router.navigateByUrl('');
    }, e => {
      console.log(e);
    });
  }
}
