import {KhachHang} from "./khach-hang";

export interface SoTietKiem {
  id?: number;
  idKhachHang?: KhachHang;
  ngayMoSo?: string;
  thoiGianBatDau?: string;
  kyHan?: string;
  soTienGui?: number;
  laiSuat?: string;
  uuDai?: string;

}
