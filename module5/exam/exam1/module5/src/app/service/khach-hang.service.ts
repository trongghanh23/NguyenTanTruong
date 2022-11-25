import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {KhachHang} from "../model/khach-hang";

@Injectable({
  providedIn: 'root'
})
export class KhachHangService {

  private API_URL = 'http://localhost:3000/KhachHang';

  constructor(private httpClient: HttpClient) {
  }

  getAll(): Observable<KhachHang[]> {
    return this.httpClient.get<KhachHang[]>(this.API_URL);
  }
}
