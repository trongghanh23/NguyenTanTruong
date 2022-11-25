import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {SoTietKiem} from "../model/so-tiet-kiem";

@Injectable({
  providedIn: 'root'
})
export class SoTietKiemService {
  private API_URL = 'http://localhost:3000/SoTietKiem';

  constructor(private httpClient: HttpClient) {
  }

  findSoTietKiemPaging(numberRecord: number, curPage: number): Observable<SoTietKiem[]> {
    return this.httpClient.get<SoTietKiem[]>(this.API_URL + '?_page=' + curPage + '&_limit=' + numberRecord);
  }

  getAll(): Observable<SoTietKiem[]> {
    return this.httpClient.get<SoTietKiem[]>(this.API_URL);
  }

  editSoTietKiem(soTietKiem: SoTietKiem): Observable<void> {
    return this.httpClient.patch<void>(this.API_URL + '/' + soTietKiem.id, soTietKiem);
  }

  findById(id: number): Observable<SoTietKiem> {
    return this.httpClient.get<SoTietKiem>(this.API_URL + '/' + id);
  }

  deleteSoTietKiem(id: number): Observable<SoTietKiem> {
    return this.httpClient.delete<SoTietKiem>(this.API_URL + '/' + id);
  }
}
