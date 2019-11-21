/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import helper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.PhieuMuon;

/**
 *
 * @author ASUS
 */
public class PhieuMuonDAO {

    public void insert(PhieuMuon model) {
        String sql = "INSERT INTO PhieuMuon (MaPM, NgayMuon, NgayTra, MaSV, MaSach, MaNV,TrangThai) VALUES (?, ?, ?, ?, ?,?,?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaPM(),
                model.getNgayMuon(),
                model.getNgayTra(),
                model.getMaSV(),
                model.getMaSach(),
                model.getMaNV(),
                model.isTrangThai());
    }

    public void update(PhieuMuon model) {
        String sql = "UPDATE PhieuMuon SET MaPM=?, NgayMuon=?, NgayTra=?, MaSV=?, MaSach=?, MaNV=?,TrangThai=? WHERE MaPM =?";
        JdbcHelper.executeUpdate(sql,
                model.getNgayMuon(),
                model.getNgayTra(),
                model.getMaSV(),
                model.getMaSach(),
                model.getMaNV(),
                model.isTrangThai(),
                model.getMaPM());
    }

    public void delete(Integer MaKH) {
        String sql = "DELETE FROM PhieuMuon WHERE MaKH=?";
        JdbcHelper.executeUpdate(sql, MaKH);
    }

    public List<PhieuMuon> select() {
        String sql = "SELECT * FROM PhieuMuon";
        return select(sql);
    }

    public PhieuMuon findById(Integer makh) {
        String sql = "SELECT * FROM PhieuMuon WHERE MaKH=?";
        List<PhieuMuon> list = select(sql, makh);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<PhieuMuon> select(String sql, Object... args) {
        List<PhieuMuon> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    PhieuMuon model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    private PhieuMuon readFromResultSet(ResultSet rs) throws SQLException {
        PhieuMuon model = new PhieuMuon();
        model.setMaPM(rs.getString("MaPM"));
        model.setNgayMuon(rs.getDate("NgayMuon"));
        model.setNgayTra(rs.getDate("NgayTra"));
        model.setMaSV(rs.getString("MaSV"));
        model.setMaSach(rs.getString("MaSach"));
        model.setMaNV(rs.getString("MaNV"));
        model.setTrangThai(rs.getBoolean("TrangThai"));

        return model;
    }
}

