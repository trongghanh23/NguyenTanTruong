import {Smartphone} from './smartphone';
import {SmartphoneType} from './smartphone-type';
import {ICustomer} from './i-customer';

export interface BookingSmartphone {
  id?: number;
  isDelete?: number;
  timeBookSmartphone?: string;
  status?: number;
  quantity?: number;
  smartphone?: Smartphone;
  customer: ICustomer;
}
