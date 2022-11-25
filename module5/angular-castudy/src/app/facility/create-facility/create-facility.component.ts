import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';;
import {Router} from '@angular/router';
import {RentFacility} from '../../model/rent-facility';
import {FacilityType} from '../../model/facility-type';
import {FacilityService} from '../../service/facility.service';
import {FacilityTypeService} from '../../service/facility-type.service';
import {RentFacilityService} from '../../service/rent-facility.service';

@Component({
  selector: 'app-create-facility',
  templateUrl: './create-facility.component.html',
  styleUrls: ['./create-facility.component.css']
})
export class CreateFacilityComponent implements OnInit {

  facilityFormGroup: FormGroup = new FormGroup({
    name: new FormControl('', [Validators.required, Validators.pattern('^KH[0-9]+')]),
    image: new FormControl(''),
    area: new FormControl('', Validators.required),
    cost: new FormControl('', [Validators.required, Validators.pattern('^\\d{9}$|^\\d{12}$')]),
    maxPeople: new FormControl('', [Validators.required, Validators.pattern('(0|[(]84[)][+])9[01]\\d{7}')]),
    facilityType: new FormControl('', [Validators.required, Validators.email]),
    standardRoom: new FormControl('', Validators.required),
    rentType: new FormControl('', Validators.required),
    description: new FormControl('', Validators.required),
    poolArea: new FormControl('', Validators.required),
    numberFloors: new FormControl('', Validators.required),
    facilityFree: new FormControl('', Validators.required)
  });
  facilityTypeList: FacilityType[] = [];
  rentFacility: RentFacility[] = [];

  constructor(private facilityService: FacilityService,
              protected facilityTypeService: FacilityTypeService,
              protected rentFacilityService: RentFacilityService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.facilityTypeService.getAll().subscribe(value => {
      this.facilityTypeList = value;
    }),
    this.rentFacilityService.getAll().subscribe(value => {
      this.rentFacility = value;
    });
  }
  createFacility(): void {
    const facility = this.facilityFormGroup.value;
    this.facilityService.saveCreateFacility(facility).subscribe(value => {
      alert('Tạo thành công');
      this.router.navigateByUrl('/list/facility');
    }, e => {
      console.log(e);
    });
  }
}
