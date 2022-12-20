import {Injectable} from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {SmartphoneType} from '../model/smartphone-type';
import {SearchResult} from '../model/search-result';
import {Smartphone} from '../model/smartphone';
import {SmartphoneDTo} from '../dto/smartphone-dto';
import {ICart} from '../model/i-cart';

@Injectable({
  providedIn: 'root'
})
export class SmartphoneService {
  URL_API = `${environment.api_url}`;
  httpOptions: any;

  constructor(private httpClient: HttpClient) {

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

  listCart(id: number): Observable<ICart[]> {
    return this.httpClient.get<ICart[]>(this.URL_API + '/smartphone/booking/list/cart/' + id);
  }
  findByUsername(): Observable<any> {
    return this.httpClient.get<any>(this.URL_API + '/smartphone/get/customer/', this.httpOptions);
  }
  cartCount(id: number): Observable<any> {
    return this.httpClient.get<any>(this.URL_API + '/smartphone/booking/cart/count/' + id);
  }
  addToCart(quantity: number, customerId: number, laptopId: number): Observable<void> {
    return this.httpClient.get<void>(this.URL_API + 'smartphone/booking/add/cart/' + quantity + '&' + customerId + '&' + laptopId);
  }
}
