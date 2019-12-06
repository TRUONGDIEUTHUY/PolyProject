/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class PhieuMuon {

    private int maPM;
    private String maSach;
    private String maSV;
    private String maNV;
    private Date ngayMuon = helper.DateHelper.now();
    private Date ngayTra;
    private boolean trangThai;

    public PhieuMuon() {
    }

    public PhieuMuon(int maPM, String maSach, String maSV, String maNV, Date ngayTra, boolean trangThai) {
        this.maPM = maPM;
        this.maSach = maSach;
        this.maSV = maSV;
        this.maNV = maNV;
        this.ngayTra = ngayTra;
        this.trangThai = trangThai;
    }

    public int getMaPM() {
        return maPM;
    }

    public void setMaPM(int maPM) {
        this.maPM = maPM;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    

}