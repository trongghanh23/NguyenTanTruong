import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {CustomerType} from '../model/customer-type';
import {RentFacility} from '../model/rent-facility';

@Injectable({
  providedIn: 'root'
})
export class RentFacilityService {

  private API_URL = 'http://localhost:3000/rentFacility';

  constructor(private httpClient: HttpClient) {
  }


  getAll(): Observable<RentFacility[]> {
    return this.httpClient.get<RentFacility[]>(this.API_URL);
  }
}
