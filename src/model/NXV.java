/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author viphn
 */
public class NXV {
   private String MaNV;
    private String TenNV;
    private String DiaChi;
    private String sdt;
    private Date NgaySinh;
    private String NoiSinh;
    private String CMND;
    private boolean GioiTinh;
    private String email;
    private int TinhTrangHonNhan;
    private int TrangThaiLamViec;
    private String sdt1;
    private String Anh;
    private String GhiChu;
    private String MaPB;

    public NXV() {
    }

    public NXV(String MaNV, String TenNV, String DiaChi, String sdt, Date NgaySinh, String NoiSinh, String CMND, boolean GioiTinh, String email, int TinhTrangHonNhan, int TrangThaiLamViec, String sdt1, String Anh, String GhiChu, String MaPB) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.DiaChi = DiaChi;
        this.sdt = sdt;
        this.NgaySinh = NgaySinh;
        this.NoiSinh = NoiSinh;
        this.CMND = CMND;
        this.GioiTinh = GioiTinh;
        this.email = email;
        this.TinhTrangHonNhan = TinhTrangHonNhan;
        this.TrangThaiLamViec = TrangThaiLamViec;
        this.sdt1 = sdt1;
        this.Anh = Anh;
        this.GhiChu = GhiChu;
        this.MaPB = MaPB;
    }


    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTinhTrangHonNhan() {
        return TinhTrangHonNhan;
    }

    public void setTinhTrangHonNhan(int TinhTrangHonNhan) {
        this.TinhTrangHonNhan = TinhTrangHonNhan;
    }

    public int getTrangThaiLamViec() {
        return TrangThaiLamViec;
    }

    public void setTrangThaiLamViec(int TrangThaiLamViec) {
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

    public String getMaPB() {
        return MaPB;
    }

    public void setMaPB(String MaPB) {
        this.MaPB = MaPB;
    }

    @Override
    public String toString() {
        return "NXV{" + "MaNV=" + MaNV + ", TenNV=" + TenNV + ", DiaChi=" + DiaChi + ", sdt=" + sdt + ", NgaySinh=" + NgaySinh + ", NoiSinh=" + NoiSinh + ", CMND=" + CMND + ", GioiTinh=" + GioiTinh + ", email=" + email + ", TinhTrangHonNhan=" + TinhTrangHonNhan + ", TrangThaiLamViec=" + TrangThaiLamViec + ", sdt1=" + sdt1 + ", Anh=" + Anh + ", GhiChu=" + GhiChu + ", MaPB=" + MaPB + '}';
    }

    
}
