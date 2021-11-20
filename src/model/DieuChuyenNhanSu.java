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
public class DieuChuyenNhanSu {

    private String MaDC;
    private String MaNV;
    private String MaPB1;
    private boolean ChucVu1;
    private Date NgayDieuChuyen;
    private Date NgayBatDau1;
    private Date ThoiGianLamViec;
    private String DonViTruocDo;
    private String MaPB2;
    private Date NgayBatDau2;
    private boolean ChucVu2;
    private String TienNhiem;

    public DieuChuyenNhanSu() {
    }

    public DieuChuyenNhanSu(String MaDC, String MaNV, String MaPB1, boolean ChucVu1, Date NgayDieuChuyen, Date NgayBatDau1, Date ThoiGianLamViec, String DonViTruocDo, String MaPB2, Date NgayBatDau2, boolean ChucVu2, String TienNhiem) {
        this.MaDC = MaDC;
        this.MaNV = MaNV;
        this.MaPB1 = MaPB1;
        this.ChucVu1 = ChucVu1;
        this.NgayDieuChuyen = NgayDieuChuyen;
        this.NgayBatDau1 = NgayBatDau1;
        this.ThoiGianLamViec = ThoiGianLamViec;
        this.DonViTruocDo = DonViTruocDo;
        this.MaPB2 = MaPB2;
        this.NgayBatDau2 = NgayBatDau2;
        this.ChucVu2 = ChucVu2;
        this.TienNhiem = TienNhiem;
    }

    @Override
    public String toString() {
        return "DieuChuyenNhanSu{" + "MaDC=" + MaDC + ", MaNV=" + MaNV + ", MaPB1=" + MaPB1 + ", ChucVu1=" + ChucVu1 + ", NgayDieuChuyen=" + NgayDieuChuyen + ", NgayBatDau1=" + NgayBatDau1 + ", ThoiGianLamViec=" + ThoiGianLamViec + ", DonViTruocDo=" + DonViTruocDo + ", MaPB2=" + MaPB2 + ", NgayBatDau2=" + NgayBatDau2 + ", ChucVu2=" + ChucVu2 + ", TienNhiem=" + TienNhiem + '}';
    }

    public String getMaDC() {
        return MaDC;
    }

    public void setMaDC(String MaDC) {
        this.MaDC = MaDC;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaPB1() {
        return MaPB1;
    }

    public void setMaPB1(String MaPB1) {
        this.MaPB1 = MaPB1;
    }

    public boolean isChucVu1() {
        return ChucVu1;
    }

    public void setChucVu1(boolean ChucVu1) {
        this.ChucVu1 = ChucVu1;
    }

    public Date getNgayDieuChuyen() {
        return NgayDieuChuyen;
    }

    public void setNgayDieuChuyen(Date NgayDieuChuyen) {
        this.NgayDieuChuyen = NgayDieuChuyen;
    }

    public Date getNgayBatDau1() {
        return NgayBatDau1;
    }

    public void setNgayBatDau1(Date NgayBatDau1) {
        this.NgayBatDau1 = NgayBatDau1;
    }

    public Date getThoiGianLamViec() {
        return ThoiGianLamViec;
    }

    public void setThoiGianLamViec(Date ThoiGianLamViec) {
        this.ThoiGianLamViec = ThoiGianLamViec;
    }

    public String getDonViTruocDo() {
        return DonViTruocDo;
    }

    public void setDonViTruocDo(String DonViTruocDo) {
        this.DonViTruocDo = DonViTruocDo;
    }

    public String getMaPB2() {
        return MaPB2;
    }

    public void setMaPB2(String MaPB2) {
        this.MaPB2 = MaPB2;
    }

    public Date getNgayBatDau2() {
        return NgayBatDau2;
    }

    public void setNgayBatDau2(Date NgayBatDau2) {
        this.NgayBatDau2 = NgayBatDau2;
    }

    public boolean isChucVu2() {
        return ChucVu2;
    }

    public void setChucVu2(boolean ChucVu2) {
        this.ChucVu2 = ChucVu2;
    }

    public String getTienNhiem() {
        return TienNhiem;
    }

    public void setTienNhiem(String TienNhiem) {
        this.TienNhiem = TienNhiem;
    }

    
}
