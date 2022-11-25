import {Injectable} from '@angular/core';
import {Customer} from '../model/customer';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private API_URL = 'http://localhost:3000/customer';

  constructor(private httpClient: HttpClient) {
  }

  findCustomerSearchPaging(numberRecord: number, curPage: number): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(this.API_URL + '?_page=' + curPage + '&_limit=' + numberRecord);
  }

  getAll(): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(this.API_URL);
  }

  saveCreateProduct(customer: Customer): Observable<void> {
    return this.httpClient.post<void>(this.API_URL, customer);
  }

  editCustomer(customer: Customer): Observable<void> {
    return this.httpClient.patch<void>(this.API_URL + '/' + customer.id, customer);
  }

  findById(id: number): Observable<Customer> {
    return this.httpClient.get<Customer>(this.API_URL + '/' + id);
  }

  deleteCustomer(id: number): Observable<Customer> {
    return this.httpClient.delete<Customer>(this.API_URL + '/' + id);
  }
}
