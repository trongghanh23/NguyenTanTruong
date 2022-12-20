import {Component, OnInit} from '@angular/core';
import {SmartphoneDTo} from '../../../dto/smartphone-dto';
import {SmartphoneService} from '../../../service/smartphone.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Title} from '@angular/platform-browser';
import {BehaviorSubject} from 'rxjs';
import {ICustomer} from '../../../model/i-customer';
import {TokenStorageService} from '../../../service/token-storage.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {
  id: number;
  smartphone$: BehaviorSubject<SmartphoneDTo>;
  quantityChoose = 1;
  idUser: number;
  customer: ICustomer[];
  // employee: IEmployee[];
  smartphoneId: number;
  roles: string[] = [];
  isCustomer = false;
  isAdmin = false;
  // isEmployee = false;
  idCustomer: number;
  username: string;
  smartphone: SmartphoneDTo;

  constructor(private smartphoneService: SmartphoneService,
              private activatedRoute: ActivatedRoute,
              private title: Title,
              private router: Router,
              private tokenService: TokenStorageService) {
  }

  ngOnInit(): void {
    this.title.setTitle('chi tiết điện thoại');
    const id = Number(this.activatedRoute.snapshot.params.id);
    this.smartphoneService.findById(id).subscribe(value => {
      this.smartphoneId = value.id;
      this.smartphone = value;
    });
    this.showUsername();
    window.scroll(0, 0);
  }
  showUsername() {
    if (this.tokenService.isLogged()) {
      this.getCustomer();
      this.username = this.tokenService.getUser().username;
      this.roles = this.tokenService.getUser().roles;
      this.isCustomer = this.roles.indexOf('ROLE_CUSTOMER') !== -1;
      this.isAdmin = this.roles.indexOf('ROLE_ADMIN') !== -1;
    }
  }
  getCustomer(): void {
    this.smartphoneService.findByUsername().subscribe(value => {
      this.customer = value;
      if (this.customer != null) {
        this.idUser = value.id;
      }
    });
  }

  addToCart(): void {
    if (this.idUser == null) {
      this.router.navigateByUrl('/login');
    } else {
      this.smartphoneService.addToCart(this.quantityChoose, this.idUser, this.smartphoneId).subscribe(() => {

        const Toast = Swal.mixin({
          toast: true,
          position: 'top-end',
          showConfirmButton: false,
          timer: 2000,
          timerProgressBar: true,
          didOpen: (toast) => {
            toast.addEventListener('mouseenter', Swal.stopTimer);
            toast.addEventListener('mouseleave', Swal.resumeTimer);
          }
        });

        Toast.fire({
          icon: 'success',
          title: 'Thêm vào giỏ hàng thành công!'
        });
        window.setTimeout(this.loadPage, 500);
      }, error => {
      });
    }

  }
  loadPage(): void {
    window.location.replace('/cart');
  }

}
