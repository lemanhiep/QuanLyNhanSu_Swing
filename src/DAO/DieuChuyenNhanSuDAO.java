/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import helper.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.DieuChuyenNhanSu;

/**
 *
 * @author LENOVO
 */
public class DieuChuyenNhanSuDAO extends CSDAO<DieuChuyenNhanSu, String> {
 String INSERT_SQL = "INSERT INTO DieuChuyenNhanSu (MaDC, MaNV, MaPB1,ChucVu1, NgayDieuChuyen,ThoiGianBatDau1,ThoiGianLamViec,DonViTruocDo,MaPB2 ,ThoiGianBatDau2,ChucVu2,TienNhiem) VALUES (?, ?, ?, ?, ?, ?,?,?,?,?,?,?)";
    @Override
    public void insert(DieuChuyenNhanSu entity) {
        JdbcHelper.executeUpdate(INSERT_SQL,
                entity.getMaNV(),
                entity.getMaPB1(),
                entity.isChucVu1(),
                entity.getNgayDieuChuyen(),
                entity.getNgayBatDau1(),
                entity.getThoiGianLamViec(),
                entity.getDonViTruocDo(),
                entity.getMaPB2(),
                entity.getNgayBatDau2(),
                entity.isChucVu2(),
                entity.getTienNhiem()      
        );
    }

    @Override
    public void update(DieuChuyenNhanSu entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DieuChuyenNhanSu> selectAll() {
        String SELECT_ALL_SQL = "SELECT * FROM DieuChuyenNhanSu";
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public DieuChuyenNhanSu selectById(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<DieuChuyenNhanSu> selectBySql(String sql, Object... agrs) {
      List<DieuChuyenNhanSu> list = new ArrayList <DieuChuyenNhanSu>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, agrs);
            while (rs.next()) {
                DieuChuyenNhanSu entity = new DieuChuyenNhanSu();
                entity.setMaDC(rs.getString("MaDC"));
                entity.setMaNV(rs.getString("MaNV"));
                entity.setMaPB1(rs.getString("MaPB1"));
                entity.setChucVu1(rs.getBoolean("ChucVu1"));
                entity.setNgayDieuChuyen(rs.getDate("NgayDieuChuyen"));
                entity.setNgayBatDau1(rs.getDate("ThoiGianBatDau1"));
                entity.setThoiGianLamViec(rs.getDate("ThoiGianLamViec"));
                entity.setDonViTruocDo(rs.getString("DonViTruocDo"));
                entity.setMaPB2(rs.getString("MaPB2"));
                entity.setNgayBatDau2(rs.getDate("ThoiGianBatDau2"));
                entity.setChucVu2(rs.getBoolean("ChucVu2"));
                entity.setTienNhiem(rs.getString("TienNhiem"));
               
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }   
    }
}
