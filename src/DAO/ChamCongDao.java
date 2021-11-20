/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import helper.JdbcHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.ChamCong;

/**
 *
 * @author Cao Do
 */
public class ChamCongDao {
 public void insert(ChamCong model) {
        String sql = "INSERT INTO CHAMCONG2 (MANV,CHECKIN,THANG,TONG) VALUES (?,?,?,?)";
        JdbcHelper.executeUpdate(sql,
                model.getMaNV(),
                model.getCheckIn(),
                model.getThang(),
                model.getTong());
    }
  public List<ChamCong> select() {
        String sql = "SELECT * FROM Chamcong2";
        return select(sql);
    }
    private List<ChamCong> select(String sql, Object... args) {
        List<ChamCong> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    ChamCong model = readFromResultSet(rs);
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

    private ChamCong readFromResultSet(ResultSet rs) throws SQLException {
        ChamCong model = new ChamCong();
        model.setMaNV(rs.getString("MaNv"));
        model.setCheckIn(rs.getDate("checkin"));
        model.setThang(rs.getString("thang"));
        model.setTong(rs.getString("tong"));
        return model;
    }
}
