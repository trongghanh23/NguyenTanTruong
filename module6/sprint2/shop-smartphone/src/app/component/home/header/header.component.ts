import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {HomeService} from '../../../service/home.service';
import {TokenStorageService} from '../../../service/token-storage.service';
import {SmartphoneService} from '../../../service/smartphone.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  username: string;
  roles: string[] = [];
  isCustomer = false;
  isAdmin = false;
  isEmployee = false;
  isLoggedIn = localStorage.getItem('auth-user');

  constructor(private router: Router,
              private homeService: HomeService,
              private tokenService: TokenStorageService,
              private smartphoneService: SmartphoneService) { }
  ngOnInit(): void {
    this.username = '';
    this.showUsername();
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
  whenLogout() {
    Swal.fire({
      position: 'center',
      icon: 'success',
      title: ' Đăng xuất thành công !',
      showConfirmButton: false,
      timer: 1000
    });
    this.tokenService.logOut();
    this.router.navigateByUrl('');
    this.username = '';
    this.isAdmin = false;
  }

}
