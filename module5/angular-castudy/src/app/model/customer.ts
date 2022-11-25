import {CustomerType} from './customer-type';

export interface Customer {
  id?: number;
  customerType?: CustomerType;
  name?: string;
  dateOfBirthday?: string;
  gender?: string;
  idCard?: string;
  phoneNumber?: string;
  email?: string;
  address?: string;
}
