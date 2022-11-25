import {Injectable} from '@angular/core';
import {Facility} from '../model/facility';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {CustomerType} from '../model/customer-type';
import {Customer} from '../model/customer';

@Injectable({
  providedIn: 'root'
})
export class FacilityService {

  private API_URL = 'http://localhost:3000/facility';

  constructor(private httpClient: HttpClient) {
  }


  getAll(): Observable<Facility[]> {
    return this.httpClient.get<Facility[]>(this.API_URL);
  }


  saveCreateFacility(facility: Facility): Observable<void> {
    return this.httpClient.post<void>(this.API_URL, facility);
  }
  editFacility(facility: Facility): Observable<void> {
    return this.httpClient.patch<void>(this.API_URL + '/' + facility.id, facility);
  }

  findById(id: number): Observable<Facility> {
    return this.httpClient.get<Facility>(this.API_URL + '/' + id);
  }
  deleteFacility(id: number): Observable<Facility> {
    return this.httpClient.delete<Facility>(this.API_URL + '/' + id);
  }
}
