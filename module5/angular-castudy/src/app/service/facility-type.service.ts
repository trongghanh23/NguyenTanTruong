import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {CustomerType} from '../model/customer-type';
import {FacilityType} from '../model/facility-type';

@Injectable({
  providedIn: 'root'
})
export class FacilityTypeService {

  private API_URL = 'http://localhost:3000/facilityType';

  constructor(private httpClient: HttpClient) {
  }


  getAll(): Observable<FacilityType[]> {
    return this.httpClient.get<FacilityType[]>(this.API_URL);
  }
}
