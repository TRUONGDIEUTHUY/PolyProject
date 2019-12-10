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
import model.Sach;

/**
 *
 * @author ASUS
 */
public class SachDAO {

    public void insert(Sach model) {
        String sql = "INSERT INTO Sach (MaSach, TenSach, NhaXB, TacGia, SoLuong, GiaTien,NgayNK) VALUES (?, ?, ?, ?, ?, ?,?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaSach(),
                model.getTenSach(),
                model.getNhaXB(),
                model.getTacGia(),
                model.getSoLuong(),
                model.getGiaTien(),
                model.getNgayNK());
    }

    public void update(Sach model) {
        String sql = "UPDATE Sach SET TenSach=?, NhaXB=?, TacGia=?, SoLuong=?, GiaTien=?,NgayNK=? WHERE MaSach=?";
        JdbcHelper.executeUpdate(sql,
                model.getTenSach(),
                model.getNhaXB(),
                model.getTacGia(),
                model.getSoLuong(),
                model.getGiaTien(),
                model.getNgayNK(),
                model.getMaSach());
    }

    public void delete(String MaSach) {
        String sql = "DELETE FROM Sach WHERE MaSach=?";
        JdbcHelper.executeUpdate(sql, MaSach);
    }

    public List<Sach> select() {
        String sql = "SELECT * FROM Sach";
        return select(sql);
    }

    public Sach findById(String masach) {
        String sql = "SELECT * FROM Sach WHERE MaSach=?";
        List<Sach> list = select(sql, masach);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<Sach> select(String sql, Object... args) {
        List<Sach> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    Sach model = readFromResultSet(rs);
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

    private Sach readFromResultSet(ResultSet rs) throws SQLException {
        Sach model = new Sach();
        model.setMaSach(rs.getString("MaSach"));
        model.setTenSach(rs.getString("TenSach"));
        model.setNhaXB(rs.getString("NhaXB"));
        model.setTacGia(rs.getString("TacGia"));
        model.setSoLuong(rs.getInt("SoLuong"));
        model.setGiaTien(rs.getInt("GiaTien"));
        model.setNgayNK(rs.getDate("NgayNK"));
        return model;
    }

    public List<Sach> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM Sach WHERE TenSach LIKE ?";
        return select(sql, "%" + keyword + "%");
    }

    public List<Sach> selectByCourse(Integer masach) {
        String sql = "SELECT * FROM Sach WHERE MaSach NOT IN (SELECT MaSach FROM HocVien WHERE MaSach=?)";
        return select(sql, masach);
    }
}
