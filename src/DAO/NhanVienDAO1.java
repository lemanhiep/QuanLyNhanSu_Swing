/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.NXV;
import model.NhanVien;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import helper.JdbcHelper;
import java.sql.SQLException;


/**
 *
 * @author LENOVO
 */
public class NhanVienDAO1{

    String INSERT = "INSERT INTO NhanVien (MaNV ,HoTen ,ĐiaChi ,SDT,NgaySinh ,NoiSinh,CMND,GioiTinh,Emai,TinhTrangHonNhan ,TrangThaiLamViec,SDTKhac,Anh,GhiChu ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    String DELETE_SQL = "DELETE FROM NhanVien WHERE MaNV=?";
    String SELECT_ALL_SQL = "SELECT * FROM NhanVien";
    String SELECT_BY_ID_SQL = "SELECT * FROM NhanVien WHERE MaNV=?";
String UPDATE ="UPDATE NhanVien set HoTen=? ĐiaChi=? SDT=? NgaySinh=? NoiSinh=? CMND=? GioiTinh=? Emai=? TinhTrangHonNhan=? TrangThaiLamViec=? SDTKhac=? Anh=? GhiChu=? WHERE MaNV=?";
    

    public void insert(NXV model) {
        String INSERT = "INSERT INTO NhanVien (MaNV ,HoTen ,ĐiaChi ,SDT,NgaySinh ,NoiSinh,CMND,GioiTinh,Emai,TinhTrangHonNhan ,TrangThaiLamViec,SDTKhac,Anh,GhiChu ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

                JdbcHelper.executeUpdate(INSERT,
                model.getMaNV(),
                model.getTenNV(),
                model.getDiaChi(),
                model.getSdt(),
                model.getNgaySinh(),
                model.getNoiSinh(),
                model.getCMND(),
                model.isGioiTinh(),
                model.getEmail(),
                model.getTinhTrangHonNhan(),
                model.getTrangThaiLamViec(),
                model.getSdt1(),
                model.getAnh(),
                model.getGhiChu()
        );
    }

    public void update(NXV model) {
        String UPDATE ="UPDATE NhanVien set HoTen=? ,ĐiaChi=? ,SDT=? ,NgaySinh=? ,NoiSinh=? ,CMND=?, GioiTinh=? ,Emai=?,TinhTrangHonNhan=?,TrangThaiLamViec=?, SDTKhac=? ,Anh=? ,GhiChu=? WHERE MaNV=?";
   
              JdbcHelper.executeUpdate(UPDATE,
                model.getTenNV(),
                model.getDiaChi(),
                model.getSdt(),
                model.getNgaySinh(),
                model.getNoiSinh(),
                model.getCMND(),
                model.isGioiTinh(),
                model.getEmail(),
                model.getTinhTrangHonNhan(),
                model.getTrangThaiLamViec(),
                model.getSdt1(),
                model.getAnh(),
                model.getGhiChu());
    }
    

    public void delete(String key) {
      JdbcHelper.executeUpdate(DELETE_SQL, key);
    }
    public List<NXV> select() {
        String sql = "select * from NhanVien";
        return select(sql);
    }    

        public NXV findById(String MaNV) {
        String sql = "SELECT * FROM NhanVien WHERE MaNV=?";
        List<NXV> list = select(sql,MaNV );
        return list.size() > 0 ? list.get(0) : null;
    }

    protected List<NXV> selectBySql(String sql, Object... agrs) {
        List<NXV> list = new ArrayList<NXV>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, agrs);
            while (rs.next()) {
                NXV entity = new NXV();
                entity.setMaNV(rs.getString("MaNV"));
                entity.setMaPB(rs.getString("MaPB"));
                entity.setTenNV(rs.getString("HoTen"));
                entity.setDiaChi(rs.getString("ĐiaChi"));
                entity.setSdt(rs.getString("SDT"));
                entity.setNgaySinh(rs.getDate("NgaySinh"));
                entity.setNoiSinh(rs.getString("NoiSinh"));
                entity.setCMND(rs.getString("CMND"));
                entity.setGioiTinh(rs.getBoolean("GioiTinh"));
                entity.setEmail(rs.getString("Emai"));
                entity.setTinhTrangHonNhan(0);
                entity.setTrangThaiLamViec(0);
                entity.setSdt1(rs.getString("SDTKhac"));
                entity.setAnh(rs.getString("Anh"));
                entity.setGhiChu(rs.getString("GhiChu"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private List<NXV> select(String sql, Object... args) {
        List<NXV> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    NXV model = readFromResultSet(rs);
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

    private NXV readFromResultSet(ResultSet rs) throws SQLException {
         NXV model = new NXV();
                model.setMaNV(rs.getString("MaNV"));
                model.setMaPB(rs.getString("MaPB"));
                model.setTenNV(rs.getString("HoTen"));
                model.setDiaChi(rs.getString("ĐiaChi"));
                model.setSdt(rs.getString("SDT"));
                model.setNgaySinh(rs.getDate("NgaySinh"));
                model.setNoiSinh(rs.getString("NoiSinh"));
                model.setCMND(rs.getString("CMND"));
                model.setGioiTinh(rs.getBoolean("GioiTinh"));
                model.setEmail(rs.getString("Emai"));
                model.setSdt1(rs.getString("SDTKhac"));
                model.setAnh(rs.getString("Anh"));
                model.setGhiChu(rs.getString("GhiChu"));
                
        return model;
    }

}
