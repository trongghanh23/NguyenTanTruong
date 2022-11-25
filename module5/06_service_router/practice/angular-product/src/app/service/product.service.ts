import {Injectable} from '@angular/core';
import {Product} from "../model/product";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private API_URL = 'http://localhost:3000/products';

  constructor(private httpClient: HttpClient) {
  }


  getAll(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.API_URL);
  }

  saveCreateProduct(product: Product): Observable<void> {
    return this.httpClient.post<void>(this.API_URL, product)
  }

  findById(id: number): Observable<Product> {
    return this.httpClient.get<Product>(this.API_URL + '/' + id);
  }

  deleteProduct(id: number): Observable<void> {
    return this.httpClient.delete<void>(this.API_URL + '/' + id)
  }

  updateProduct(product: Product): Observable<void> {
    return this.httpClient.patch<void>(this.API_URL + '/' + product.id,product);
  }


}
