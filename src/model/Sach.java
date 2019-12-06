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
public class Sach {
private String maSach;
private String tenSach;
private String nhaXB;
private String tacGia;
private int soLuong;
private int giaTien;

    @Override
    public String toString() {
        return this.tenSach;
    }



private Date ngayNK=helper.DateHelper.now();

    public Sach() {
    }

    public Sach(String maSach, String tenSach, String nhaXB, String tacGia, int soLuong, int giaTien) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.nhaXB = nhaXB;
        this.tacGia = tacGia;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getNhaXB() {
        return nhaXB;
    }

    public void setNhaXB(String nhaXB) {
        this.nhaXB = nhaXB;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(int giaTien) {
        this.giaTien = giaTien;
    }

    public Date getNgayNK() {
        return ngayNK;
    }

    public void setNgayNK(Date ngayNK) {
        this.ngayNK = ngayNK;
    }

    
}
