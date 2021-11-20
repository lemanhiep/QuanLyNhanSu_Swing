/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.NhanVien;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import helper.JdbcHelper;

/**
 *
 * @author LENOVO
 */
public class NhanVienDAO extends CSDAO<NhanVien, String> {

    String INSERT_SQL = "INSERT INTO NhanVien (MaNV,MaPB ,MatKhau ,HoTen ,ĐiaChi ,SDT,NgaySinh ,NoiSinh,CMND,GioiTinh,Emai,TinhTrangHonNhan ,TrangThaiLamViec,SDTKhac,Anh,GhiChu,ChucVu ) VALUES (?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    String DELETE_SQL = "DELETE FROM NhanVien WHERE MaNV=?";
    String SELECT_ALL_SQL = "SELECT * FROM NhanVien";
    String SELECT_BY_ID_SQL = "SELECT * FROM NhanVien WHERE MaNV=?";

    @Override
    public void insert(NhanVien entity) {
        JdbcHelper.executeUpdate(INSERT_SQL,
                entity.getMaNV(),
                entity.getMaPB(),
                entity.getMatKhau(),
                entity.getHoTen(),
                entity.getDiaChi(),
                entity.getSdt(),
                entity.getNgaySinh(),
                entity.getNoiSinh(),
                entity.getCMND(),
                entity.isGioiTinh(),
                entity.getEmai(),
                entity.isTinhTrangHonNhan(),
                entity.isTrangThaiLamViec(),
                entity.getSdt1(),
                entity.getAnh(),
                entity.getGhiChu(),
                entity.isChucVu()
        );
    }

    @Override
    public void update(NhanVien entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String key) {
        JdbcHelper.executeUpdate(DELETE_SQL, key);
    }

    @Override
    public NhanVien selectById(String key) {
        List<NhanVien> list = this.selectBySql(SELECT_BY_ID_SQL, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NhanVien> selectAll() {
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    protected List<NhanVien> selectBySql(String sql, Object... agrs) {
        List<NhanVien> list = new ArrayList<NhanVien>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, agrs);
            while (rs.next()) {
                NhanVien entity = new NhanVien();
                entity.setMaNV(rs.getString("MaNV"));
                entity.setMaPB(rs.getString("MaPB"));
                entity.setMatKhau(rs.getString("MatKhau"));
                entity.setHoTen(rs.getString("HoTen"));
                entity.setDiaChi(rs.getString("ĐiaChi"));
                entity.setSdt(rs.getString("SDT"));
                entity.setNgaySinh(rs.getDate("NgaySinh"));
                entity.setNoiSinh(rs.getString("NoiSinh"));
                entity.setCMND(rs.getString("CMND"));
                entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                entity.setEmai(rs.getString("Emai"));
                entity.setTinhTrangHonNhan(rs.getBoolean("TinhTrangHonNhan"));
                entity.setTrangThaiLamViec(rs.getBoolean("TrangThaiLamViec"));
                entity.setSdt1(rs.getString("SDTKhac"));
                entity.setAnh(rs.getString("Anh"));
                entity.setGhiChu(rs.getString("GhiChu"));
                entity.setChucVu(rs.getBoolean("ChucVu"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
