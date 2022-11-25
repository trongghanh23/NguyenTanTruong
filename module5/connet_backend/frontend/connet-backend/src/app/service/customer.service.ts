import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Customer} from '../model/customer';
const URL_API = `${environment.url}`;

class DataResult<T> {
  content: string;
  totalElements: number;
}

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  constructor(private http: HttpClient) {
  }

  getAll(page: number, pageSize: number): Observable<DataResult<Customer>> {
    console.log(URL_API + '/list?page=' + (page - 1) + '&size=' + pageSize);
    return this.http.get<DataResult<Customer>>(URL_API + '/list?page=' + (page - 1) + '&size=' + pageSize);
  }

  getCustomer(name: string, page: number, pageSize: number): Observable<DataResult<Customer>> {
    console.log(URL_API + '/list?name=' + name + '&page=' + (page - 1) + '&size=' + pageSize);
    return this.http.get<DataResult<Customer>>(URL_API + '/list?name=' + name + '&page=' + (page - 1) + '&size=' + pageSize);
  }

  findById(id: number): Observable<Customer> {
    return this.http.get<Customer>(URL_API + '/' + id);
  }

  addNew(customer: Customer): Observable<void> {
    return this.http.post<void>(URL_API + '/add', customer);
  }

  editObject(customer: Customer): Observable<void> {
    console.log(customer);
    return this.http.patch<void>(URL_API + '/edit/' + customer.id, customer);
  }

  deleteObject(id: number): Observable<void> {
    return this.http.delete<void>(URL_API + '/delete/' + id);
  }
}
