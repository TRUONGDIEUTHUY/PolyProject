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

/**
 *
 * @author ASUS
 */
public class ThongKeDAO {

    public List<Object[]> getPMDT(int mapm) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call sp_PhieuMuonDT(?)}";
                rs = JdbcHelper.executeQuery(sql, mapm);
                while (rs.next()) {
                    Object[] model = {
                        rs.getInt("MaPM"),
                        rs.getString("MaNV"),
                        rs.getString("MaSV"),
                        rs.getDate("NgayMuon"),
                        rs.getDate("NgayTra")
                    };
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Object[]> getPMCT(int mapm) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call sp_PhieuMuonCT(?)}";
                rs = JdbcHelper.executeQuery(sql, mapm);
                while (rs.next()) {
                    Object[] model = {
                        rs.getInt("MaPM"),
                        rs.getString("MaNV"),
                        rs.getString("MaSV"),
                        rs.getDate("NgayMuon"),
                        rs.getDate("NgayTra")
                    };
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
