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
public class ChamCong {

    private String MaNV;
    private Date CheckIn = helper.DateHelper.now();
    private Date CheckOut;
    private String Thang;
    private String Tong;
    private boolean Status;

    public ChamCong() {
    }

    public ChamCong(String MaNV, Date CheckOut, String Thang, String Tong, boolean Status) {
        this.MaNV = MaNV;
        this.CheckOut = CheckOut;
        this.Thang = Thang;
        this.Tong = Tong;
        this.Status = Status;
    }

    @Override
    public String toString() {
        return "ChamCong{" + "MaNV=" + MaNV + ", CheckIn=" + CheckIn + ", CheckOut=" + CheckOut + ", Thang=" + Thang + ", Tong=" + Tong + ", Status=" + Status + '}';
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public Date getCheckIn() {
        return CheckIn;
    }

    public void setCheckIn(Date CheckIn) {
        this.CheckIn = CheckIn;
    }

    public Date getCheckOut() {
        return CheckOut;
    }

    public void setCheckOut(Date CheckOut) {
        this.CheckOut = CheckOut;
    }

    public String getThang() {
        return Thang;
    }

    public void setThang(String Thang) {
        this.Thang = Thang;
    }

    public String getTong() {
        return Tong;
    }

    public void setTong(String Tong) {
        this.Tong = Tong;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    
}
