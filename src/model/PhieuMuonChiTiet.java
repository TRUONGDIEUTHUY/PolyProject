/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ASUS
 */
public class PhieuMuonChiTiet {
    private int maPMCT;
    private int maPM;
    private String maSach;
    private int soLuong;

    public PhieuMuonChiTiet(int maPMCT, int maPM, String maSach, int soLuong) {
        this.maPMCT = maPMCT;
        this.maPM = maPM;
        this.maSach = maSach;
        this.soLuong = soLuong;
    }

    public PhieuMuonChiTiet() {
    }

    @Override
    public String toString() {
        return this.toString();

    }

    public int getMaPMCT() {
        return maPMCT;
    }

    public void setMaPMCT(int maPMCT) {
        this.maPMCT = maPMCT;
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

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
   
}
