import {Injectable} from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {SmartphoneType} from '../model/smartphone-type';
import {SearchResult} from '../model/search-result';
import {Smartphone} from '../model/smartphone';
import {SmartphoneDTo} from '../dto/smartphone-dto';
import {ICart} from '../model/i-cart';
import {TokenStorageService} from './token-storage.service';
import {IHistory} from '../model/i-history';
import {IHistoryDto} from '../dto/i-history-dto';

@Injectable({
  providedIn: 'root'
})
export class SmartphoneService {
  URL_API = `${environment.api_url}`;
  httpOptions: any;

  constructor(private httpClient: HttpClient, private tokenService: TokenStorageService) {
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + this.tokenService.getToken()
      }),
      'Access-Control-Allow-Origin': 'http://localhost:4200',
      'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,PATCH,OPTIONS'
    };
  }

  getAllSmartphoneType(): Observable<SmartphoneType[]> {
    console.log(this.URL_API + 'smartphone/smartphoneType');
    return this.httpClient.get<SmartphoneType[]>(this.URL_API + '/smartphone/smartphoneType');
  }

  findAllListSmartphone(name: string, size: number): Observable<SearchResult<SmartphoneDTo>> {
    const API_URL_HOME = this.URL_API + '/smartphone/list/home?name=' + name + '&size=' + size;
    return this.httpClient.get<SearchResult<SmartphoneDTo>>(API_URL_HOME);
  }

  findById(id: number): Observable<SmartphoneDTo> {
    return this.httpClient.get<SmartphoneDTo>(this.URL_API + '/smartphone/detail/' + id);
  }

  listCart(id: number): Observable<SmartphoneDTo[]> {
    return this.httpClient.get<SmartphoneDTo[]>(this.URL_API + '/booking/list/cart/' + id);
  }

  findByUsername(): Observable<any> {
    return this.httpClient.get<any>(this.URL_API + '/smartphone/get/customer/', this.httpOptions);
  }

  cartCount(id: number): Observable<any> {
    return this.httpClient.get<any>(this.URL_API + '/booking/cart/count/' + id);
  }

  addToCart(quantity: number, customerId: number, smartphoneId: number): Observable<void> {
    return this.httpClient.get<void>(this.URL_API + '/booking/add/cart/' + quantity + '&' + customerId + '&' + smartphoneId);
  }

  ascQuantity(id: number): Observable<void> {
    console.log(this.URL_API + '/booking/asc/quantity/' + id);
    return this.httpClient.get<void>(this.URL_API + '/booking/asc/quantity/' + id);
  }

  descQuantity(id: number): Observable<void> {
    return this.httpClient.get<void>(this.URL_API + '/booking/desc/quantity/' + id);
  }


  paySmartphone(id: number): Observable<void> {
    return this.httpClient.get<void>(this.URL_API + '/booking/pay/smartphone/' + id);
  }

  deleteCart(id: number): Observable<void> {
    return this.httpClient.get<void>(this.URL_API + '/booking/delete/cart/' + id);
  }
  findAllCustomer(username: string): Observable<any> {
    return this.httpClient.get(this.URL_API + '/smartphone/find/all/customer/' + username);
  }
  getAllHistory(curPage: number, numberRecord: number, username: string): Observable<SearchResult<IHistory>> {
    console.log(this.URL_API + 'laptop/history/' + username
      + '?page=' + (curPage - 1) + '&size=' + numberRecord);
    return this.httpClient.get<SearchResult<IHistory>>(this.URL_API + '/smartphone/history/' + username
      + '?page=' + (curPage - 1) + '&size=' + numberRecord);
  }
}
