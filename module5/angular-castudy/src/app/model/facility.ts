import {RentFacility} from './rent-facility';
import {FacilityType} from './facility-type';

export interface Facility {
  id?: number;
  name?: string;
  image?: string;
  area?: number;
  cost?: number;
  maxPeople?: number;
  rentType?: RentFacility;
  facilityType?: FacilityType;
  standardRoom?: string;
  description?: string;
  poolArea?: number;
  numberFloors?: number;
  facilityFree?: string;
}
