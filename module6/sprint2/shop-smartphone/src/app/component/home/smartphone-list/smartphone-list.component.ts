import {Component, Inject, OnInit, VERSION} from '@angular/core';
import {SmartphoneService} from '../../../service/smartphone.service';
import {Title} from '@angular/platform-browser';
import {Router} from '@angular/router';
import {BehaviorSubject, Observable} from 'rxjs';
import {Smartphone} from '../../../model/smartphone';
import {SmartphoneDTo} from '../../../dto/smartphone-dto';
import {HomeService} from '../../../service/home.service';
import {TokenStorageService} from '../../../service/token-storage.service';
import Swal from 'sweetalert2';
import {ICustomer} from '../../../model/i-customer';
import {SmartphoneType} from '../../../model/smartphone-type';
import {DOCUMENT} from '@angular/common';

@Component({
  selector: 'app-smartphone-list',
  templateUrl: './smartphone-list.component.html',
  styleUrls: ['./smartphone-list.component.css']
})
export class SmartphoneListComponent implements OnInit {
  username: string;
  roles: string[] = [];
  isCustomer = false;
  isAdmin = false;
  pageSize = 8;
  smartphoneList$: Observable<SmartphoneDTo[]> | undefined;
  total$: Observable<number>;
  smartphoneNameSearch = '';
  action: boolean;

  content: boolean;

  // movieChoose: IMovieBookingDto;
  idUser: number;
  customer: ICustomer[];
  quantityChoose = 1;
  totalRecord = 0;
  totalPage = 0;
  numberPage = 0;
  nameSearch = '';
  endPrice = 0;
  startPrice = 0;
  price = '';
  smartphoneList: SmartphoneDTo[];
  moreSmartphoneList: SmartphoneDTo[];
  smartphoneTypeList: SmartphoneType[];
  // username = '';
  laptopId: number;
  id: number;
  constructor(
              private homeService: HomeService,
              private tokenService: TokenStorageService,
              private smartphoneService: SmartphoneService,
              private title: Title,
              private router: Router) {
    this.title.setTitle('Trang chủ');
  }
  ngOnInit(): void {
    this.showUsername();
    this.paginate(this.smartphoneNameSearch, this.pageSize);
    window.scroll({
      top: 0,
      left: 0,
      behavior: 'smooth'
    });

  }
  showUsername() {
    this.username = this.tokenService.getUser().username;
    this.roles = this.tokenService.getUser().roles;
    this.isCustomer = this.roles.indexOf('ROLE_CUSTOMER') !== -1;
    this.isAdmin = this.roles.indexOf('ROLE_ADMIN') !== -1;
  }

  paginate(smartphoneNameSearch, pageSize) {
    this.smartphoneService.findAllListSmartphone(smartphoneNameSearch, pageSize).subscribe(data => {
      if (data != null) {
        this.action = true;
        this.smartphoneList$ = new BehaviorSubject<SmartphoneDTo[]>(data.content);
        console.log(this.smartphoneList$);
        this.total$ = new BehaviorSubject<number>(data.totalElements);
      } else {
        this.action = false;
      }
    });
  }

  nextPage() {
    this.pageSize += 4;
    this.paginate(this.smartphoneNameSearch, this.pageSize);
  }
    }
