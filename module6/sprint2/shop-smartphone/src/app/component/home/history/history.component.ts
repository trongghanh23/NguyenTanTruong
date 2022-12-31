import { Component, OnInit } from '@angular/core';
import {TokenStorageService} from '../../../service/token-storage.service';
import {SmartphoneService} from '../../../service/smartphone.service';
import {BehaviorSubject, Observable} from 'rxjs';
import {IHistoryDto} from '../../../dto/i-history-dto';
import {ICustomer} from '../../../model/i-customer';
import {HomeService} from '../../../service/home.service';
import {Title} from '@angular/platform-browser';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {
  roles: string[] = [];
  isCustomer = false;
  isAdmin = false;
  isEmployee = false;
  username = '';
  idCustomer: number;
  historyDto$: Observable<IHistoryDto[]>;
  action: boolean;
  customerName = '';
  image = '';
  total$: Observable<number>;
  page = 1;
  pageSize = 5;

  id: number;
  price: number;
  quantity: number;
  dayBooking = '';
  status: number;
  isDelete: number;
  name = '';


  constructor(private tokenService: TokenStorageService,
              private smartphone: SmartphoneService,
              private title: Title) {
    title.setTitle('Lịch sủ');
  }

  ngOnInit(): void {
    this.showUsername();
    this.getAllHistory();
    this.getAllCustomer();
    window.scroll(0, 0);

  }

  showUsername() {
    if (this.tokenService.isLogged()) {
      this.username = this.tokenService.getUser().username;
      this.roles = this.tokenService.getUser().roles;
      this.isCustomer = this.roles.indexOf('ROLE_CUSTOMER') !== -1;
      this.isEmployee = this.roles.indexOf('ROLE_EMPLOYEE') !== -1;
      this.isAdmin = this.roles.indexOf('ROLE_ADMIN') !== -1;
    }
  }

  getAllHistory() {
    this.smartphone.getAllHistory(this.page, this.pageSize, this.username).subscribe(value => {
      console.log(value);
      if (value != null) {
        this.action = true;
        this.historyDto$ = new BehaviorSubject<IHistoryDto[]>(value.content);
        this.total$ = new BehaviorSubject<number>(value.totalElements);
      } else {
        console.log('a');
        this.action = false;
      }
    });
  }

  getAllCustomer() {
    this.smartphone.findAllCustomer(this.username).subscribe(value => {
      this.customerName = value.name;
      this.image = value.image;
    });
  }

}
