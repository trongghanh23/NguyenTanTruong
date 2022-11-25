import {Injectable} from '@angular/core';
import {Contract} from '../model/contract';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Customer} from '../model/customer';
import {Facility} from '../model/facility';

@Injectable({
  providedIn: 'root'
})
export class ContractService {
  private API_URL = 'http://localhost:3000/contract';

  constructor(private httpClient: HttpClient) {
  }


  getAll(): Observable<Contract[]> {
    return this.httpClient.get<Contract[]>(this.API_URL);
  }

}
