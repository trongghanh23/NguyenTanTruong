import {Customer} from './customer';
import {Facility} from './facility';

export interface Contract {
  id?: number;
  starDate?: string;
  endDate?: string;
  employee?: string;
  customer?: Customer;
  facility?: Facility;
  deposit?: number;
  total?: number;
}
