import {SmartphoneType} from './smartphone-type';

export interface Smartphone {
  id?: number;
  price?: string;
  insurance?: string;
  producer?: string;
  typeSmartphoneId?: SmartphoneType;

}
