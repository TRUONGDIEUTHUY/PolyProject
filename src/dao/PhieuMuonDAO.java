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
        String sql = "INSERT INTO PhieuMuon ( MaSV, MaNV, NgayMuon, NgayTra, TrangThai) VALUES (?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaSV(),
                model.getMaNV(),
                model.getNgayMuon(),
                model.getNgayTra(),
                model.isTrangThai());
    }

    public void update(PhieuMuon model) {
        String sql = "UPDATE PhieuMuon SET  MaSV=?, MaNV=?,NgayMuon=?, NgayTra=?,TrangThai=? WHERE MaPM =?";
        JdbcHelper.executeUpdate(sql,
                model.getMaSV(),
                model.getMaNV(),
                model.getNgayMuon(),
                model.getNgayTra(),
                model.isTrangThai(),
                model.getMaPM());
    }

    public void delete(int mapm) {
        String sql = "DELETE FROM PhieuMuon WHERE MaPM=?";
        JdbcHelper.executeUpdate(sql, mapm);
    }

    public List<PhieuMuon> select() {
        String sql = "SELECT * FROM PhieuMuon";
        return select(sql);
    }

    public PhieuMuon findById(int mapm) {
        String sql = "SELECT * FROM PhieuMuon WHERE MaPM=?";
        List<PhieuMuon> list = select(sql, mapm);
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
        model.setMaPM(rs.getInt("MaPM"));
        model.setNgayMuon(rs.getDate("NgayMuon"));
        model.setNgayTra(rs.getDate("NgayTra"));
        model.setMaSV(rs.getString("MaSV"));
        model.setMaNV(rs.getString("MaNV"));
        model.setTrangThai(rs.getBoolean("TrangThai"));

        return model;
    }

    public List<PhieuMuon> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM PhieuMuon WHERE MaPM LIKE ?";
        return select(sql, "%" + keyword + "%");
    }
}
