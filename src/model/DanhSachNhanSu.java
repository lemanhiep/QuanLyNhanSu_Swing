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
public class DanhSachNhanSu {
        private String MaNV;
    private String TenNV;
    private String sdt;
    private String email;
    private boolean TinhTrangHonNhan;
    private String MaPB;

    
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

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isTinhTrangHonNhan() {
        return TinhTrangHonNhan;
    }

    public void setTinhTrangHonNhan(boolean TinhTrangHonNhan) {
        this.TinhTrangHonNhan = TinhTrangHonNhan;
    }

    public String getMaPB() {
        return MaPB;
    }

    public void setMaPB(String MaPB) {
        this.MaPB = MaPB;
    }

    @Override
    public String toString() {
        return "DanhSachNhanSu{" + "MaNV=" + MaNV + ", TenNV=" + TenNV + ", sdt=" + sdt + ", email=" + email + ", TinhTrangHonNhan=" + TinhTrangHonNhan + ", MaPB=" + MaPB + '}';
    }

    
    
}
