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
import model.PhieuMuonChiTiet;



/**
 *
 * @author ASUS
 */
public class PhieuMuonChiTietDAO {
    public void insert(PhieuMuonChiTiet model) {
        String sql = "INSERT INTO PhieuMuonChiTiet(MaPM, MaSach, SoLuong) VALUES(?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaPM(),
                model.getMaSach(),
                model.getSoLuong());
    }

    public void update(PhieuMuonChiTiet model) {
        String sql = "UPDATE PhieuMuonChiTiet SET MaPM=?, MaSach=?, SoLuong=? WHERE MaPMCT=?";
        JdbcHelper.executeUpdate(sql,
                model.getMaPM(),
                model.getMaSach(),
                model.getSoLuong(),
                model.getMaPMCT());
    }

    public void delete(Integer MaPMCT) {
        String sql = "DELETE FROM PhieuMuonChiTiet WHERE MaPMCT=?";
        JdbcHelper.executeUpdate(sql, MaPMCT);
    }

    public List<PhieuMuonChiTiet> select() {
        String sql = "SELECT * FROM PhieuMuonChiTiet";
        return select(sql);
    }

    public PhieuMuonChiTiet findById(Integer mapmct) {
        String sql = "SELECT * FROM PhieuMuonChiTiet WHERE MaHV=?";
        List<PhieuMuonChiTiet> list = select(sql, mapmct);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<PhieuMuonChiTiet> select(String sql, Object... args) {
        List<PhieuMuonChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    PhieuMuonChiTiet model = readFromResultSet(rs);
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

    private PhieuMuonChiTiet readFromResultSet(ResultSet rs) throws SQLException {
        PhieuMuonChiTiet model = new PhieuMuonChiTiet();
        model.setMaPMCT(rs.getInt("MaPMCT"));
        model.setMaPM(rs.getInt("PM"));
        model.setMaSach(rs.getString("MaSach"));
        model.setSoLuong(rs.getInt("SoLuong"));
        return model;
    }
}

