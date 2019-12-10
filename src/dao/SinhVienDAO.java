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
import model.SinhVien;

/**
 *
 * @author ASUS
 */
public class SinhVienDAO {

    public void insert(SinhVien model) {
        String sql = "INSERT INTO SinhVien (MaSV, TenSV, NgaySinh, GioiTinh, ChuyenNganh, Email, Lop,Sdt) VALUES( ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaSV(),
                model.getTenSV(),
                model.getNgaySinh(),
                model.isGioiTinh(),
                model.getChuyenNganh(),
                model.getEmail(),
                model.getLop(),
                model.getSdt());
    }

    public void update(SinhVien model) {
        String sql = "UPDATE SinhVien SET TenSV=?, NgaySinh=?, GioiTinh=?, ChuyenNganh=?, Email=?, Lop=?,Sdt=? WHERE MaSV=?";
        JdbcHelper.executeUpdate(sql,
                model.getTenSV(),
                model.getNgaySinh(),
                model.isGioiTinh(),
                model.getChuyenNganh(),
                model.getEmail(),
                model.getLop(),
                model.getSdt(),
                model.getMaSV());
    }

    public void delete(String id) {
        String sql = "DELETE FROM SinhVien WHERE MaSV=?";
        JdbcHelper.executeUpdate(sql, id);
    }

    public List<SinhVien> select() {
        String sql = "SELECT * FROM SinhVien";
        return select(sql);
    }

    public List<SinhVien> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM SinhVien WHERE TenSV LIKE ?";
        return select(sql, "%" + keyword + "%");
    }

    public List<SinhVien> selectByCourse(Integer masv) {
        String sql = "SELECT * FROM SinhVien WHERE MaSV NOT IN (SELECT MaSV FROM HocVien WHERE MaSV=?)";
        return select(sql, masv);
    }

    public SinhVien findById(String masv) {
        String sql = "SELECT * FROM SinhVien WHERE MaSV=?";
        List<SinhVien> list = select(sql, masv);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<SinhVien> select(String sql, Object... args) {
        List<SinhVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    SinhVien model = readFromResultSet(rs);
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

    private SinhVien readFromResultSet(ResultSet rs) throws SQLException {
        SinhVien model = new SinhVien();
        model.setMaSV(rs.getString("MaSV"));
        model.setTenSV(rs.getString("TenSV"));
        model.setNgaySinh(rs.getDate("NgaySinh"));
        model.setGioiTinh(rs.getBoolean("GioiTinh"));
        model.setChuyenNganh(rs.getString("ChuyenNganh"));
        model.setEmail(rs.getString("Email"));
        model.setLop(rs.getString("Lop"));
        model.setSdt(rs.getString("Sdt"));

        return model;
    }

}
