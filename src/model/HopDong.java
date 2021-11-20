/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Cao Do
 */
public class HopDong {
    private String MaHD;
    private Date NgayKy;
    private boolean LoaiHopDong;
    private Date NgayBatDau;
    private Date NgayKetThuc;
    private Date ThuViecTu;
    private Date ThuViecDen;
    private int ChucVu;
    private String CongViecLam;
    private String DungCu;
    private String MaNV;

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public Date getNgayKy() {
        return NgayKy;
    }

    public void setNgayKy(Date NgayKy) {
        this.NgayKy = NgayKy;
    }

    public boolean isLoaiHopDong() {
        return LoaiHopDong;
    }

    public void setLoaiHopDong(boolean LoaiHopDong) {
        this.LoaiHopDong = LoaiHopDong;
    }

    public Date getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(Date NgayBatDau) {
        this.NgayBatDau = NgayBatDau;
    }

    public Date getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(Date NgayKetThuc) {
        this.NgayKetThuc = NgayKetThuc;
    }

    public Date getThuViecTu() {
        return ThuViecTu;
    }

    public void setThuViecTu(Date ThuViecTu) {
        this.ThuViecTu = ThuViecTu;
    }

    public Date getThuViecDen() {
        return ThuViecDen;
    }

    public void setThuViecDen(Date ThuViecDen) {
        this.ThuViecDen = ThuViecDen;
    }

    public int getChucVu() {
        return ChucVu;
    }

    public void setChucVu(int ChucVu) {
        this.ChucVu = ChucVu;
    }

    public String getCongViecLam() {
        return CongViecLam;
    }

    public void setCongViecLam(String CongViecLam) {
        this.CongViecLam = CongViecLam;
    }

    public String getDungCu() {
        return DungCu;
    }

    public void setDungCu(String DungCu) {
        this.DungCu = DungCu;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }
}
