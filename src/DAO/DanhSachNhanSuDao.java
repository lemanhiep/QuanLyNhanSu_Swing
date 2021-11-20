/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import helper.JdbcHelper;
import java.util.List;
import model.DanhSachNhanSu;
import java.sql.ResultSet;
import java.util.ArrayList;

        

/**
 *
 * @author viphn
 */
public class DanhSachNhanSuDao extends CSDAO<DanhSachNhanSu, String>{
String INSERT_SQL = "INSERT INTO NHANVIEN ( MaNV, HoTen,Emai, SDT,MaPB,TinhTrangHonNhan) VALUES (?, ?, ?, ?, ?,?)";
   
    @Override
    public void insert(DanhSachNhanSu entity) {
               JdbcHelper.executeUpdate(INSERT_SQL,
                entity.getMaNV(),
                entity.getTenNV(),
                entity.getEmail(),
                entity.getSdt(),
                entity.getMaPB(),
                entity.isTinhTrangHonNhan()
        );
    }

    @Override
    public void update(DanhSachNhanSu entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DanhSachNhanSu> selectAll() {
             String SELECT_ALL_SQL = "SELECT * FROM NHANVIEN";
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public DanhSachNhanSu selectById(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<DanhSachNhanSu> selectBySql(String sql, Object... agrs) {
      List<DanhSachNhanSu> list = new ArrayList <DanhSachNhanSu>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, agrs);
            while (rs.next()) {
                DanhSachNhanSu entity = new DanhSachNhanSu();
                entity.setMaNV(rs.getString("MaNV"));
                entity.setTenNV(rs.getString("HoTen"));
                entity.setEmail(rs.getString("Emai"));
                entity.setSdt(rs.getString("SDT"));
                entity.setMaPB(rs.getString("MaPB"));
                entity.setTinhTrangHonNhan(rs.getBoolean("TinhTrangHonNhan"));
               
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }   
    }

}
