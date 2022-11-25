import {Component, OnInit} from '@angular/core';
import {Facility} from '../../model/facility';
import {FacilityService} from '../../service/facility.service';
import {Customer} from '../../model/customer';
import {CustomerService} from '../../service/customer.service';
import Swal from "sweetalert2";

@Component({
  selector: 'app-list-facility',
  templateUrl: './list-facility.component.html',
  styleUrls: ['./list-facility.component.css']
})
export class ListFacilityComponent implements OnInit {
  facility: Facility[] = [];
  facilityNameDelete: string;
  facilityIdDelete: number;

  constructor(private facilityService: FacilityService) {
  }

  ngOnInit() {
    this.getAll();

  }

  getAll() {
    this.facilityService.getAll().subscribe(value => {
      this.facility = value;
    }, error => {
    }, () => {
    });
  }
  getInfoFacilityDelete(facilityName: string, facilityId: number): void {
    this.facilityNameDelete = facilityName;
    this.facilityIdDelete = facilityId;
  }
  deleteFacility(): void {
    this.facilityService.deleteFacility(this.facilityIdDelete).subscribe(() => {
      Swal.fire({
        position: 'top',
        icon: 'success',
        title: 'You are successful',
        showConfirmButton: false,
        timer: 1500
      });
      this.ngOnInit();
    }, error => {
      console.log(error);
    }, () => {
      console.log('Xóa dịch vụ thành công!');
    });
  }
}
