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

    private String maPM;
    private Date ngayMuon = helper.DateHelper.now();
    private Date ngayTra;
    private String maSV;
    private String maSach;
    private String maNV;
    private boolean trangThai;

    public PhieuMuon() {
    }

    public PhieuMuon(String maPM, Date ngayTra, String maSV, String maSach, String maNV, boolean trangThai) {
        this.maPM = maPM;
        this.ngayTra = ngayTra;
        this.maSV = maSV;
        this.maSach = maSach;
        this.maNV = maNV;
        this.trangThai = trangThai;
    }

    public String getMaPM() {
        return maPM;
    }

    public void setMaPM(String maPM) {
        this.maPM = maPM;
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

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

}
