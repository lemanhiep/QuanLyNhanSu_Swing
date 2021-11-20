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
public class NhanVien {
    private String MaNV;
    private String MaPB;
    private String MatKhau;
     private String HoTen;
    private String DiaChi;
    private String sdt;
    private Date NgaySinh;
    private String NoiSinh;
    private String CMND;
    private boolean GioiTinh;
    private String Emai;
    private boolean TinhTrangHonNhan;
    private boolean TrangThaiLamViec;
    private String sdt1;
    private String Anh;
    private String GhiChu;
    private boolean ChucVu;

    @Override
    public String toString() {
        return MaNV;
    }

   

    

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaPB() {
        return MaPB;
    }

    public void setMaPB(String MaPB) {
        this.MaPB = MaPB;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getNoiSinh() {
        return NoiSinh;
    }

    public void setNoiSinh(String NoiSinh) {
        this.NoiSinh = NoiSinh;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getEmai() {
        return Emai;
    }

    public void setEmai(String Emai) {
        this.Emai = Emai;
    }

    public boolean isTinhTrangHonNhan() {
        return TinhTrangHonNhan;
    }

    public void setTinhTrangHonNhan(boolean TinhTrangHonNhan) {
        this.TinhTrangHonNhan = TinhTrangHonNhan;
    }

    public boolean isTrangThaiLamViec() {
        return TrangThaiLamViec;
    }

    public void setTrangThaiLamViec(boolean TrangThaiLamViec) {
        this.TrangThaiLamViec = TrangThaiLamViec;
    }

    public String getSdt1() {
        return sdt1;
    }

    public void setSdt1(String sdt1) {
        this.sdt1 = sdt1;
    }

    public String getAnh() {
        return Anh;
    }

    public void setAnh(String Anh) {
        this.Anh = Anh;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public boolean isChucVu() {
        return ChucVu;
    }

    public void setChucVu(boolean ChucVu) {
        this.ChucVu = ChucVu;
    }

  

}