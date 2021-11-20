/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import helper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.TN;

/**
 *
 * @author ASUS
 */
public class ThanNhanDao {

    private TN readFromResultSet(ResultSet rs) throws SQLException {
       TN entity = new TN();
       entity.setMaTN(rs.getString("MaTN"));
       entity.setHoTenBo(rs.getString("HoTenBo"));
       entity.setTuoiBo(rs.getString("TuoiBo"));
       entity.setNgheNghiepBo(rs.getString("NgheNghiepBo"));
       entity.setHoTenMe(rs.getString("HoTenMe"));
       entity.setTuoiMe(rs.getString("TuoiMe"));
       entity.setNgheNghiepMe(rs.getString("NgheNghiepMe"));
       entity.setHoTenACE(rs.getString("HoTenACE"));
       entity.setTuoiACE(rs.getString("TuoiACE"));
       entity.setNgheNghiepACE(rs.getString("NgheNghiepACE"));
       entity.setHoTenOB(rs.getString("HoTenOB"));
       entity.setTuoiOB(rs.getString("TuoiOB"));
       entity.setNgheNghiepOB(rs.getString("NgheNghiepOB"));
       return entity;
    }

    public List<TN> select(String sql, Object... args) {
        List<TN> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    list.add(readFromResultSet(rs));
                }
            } finally {
                rs.getStatement().getConnection().close();
            }

        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return list;
    }
    public void insert(TN entity)
    {
        String sql = "INSERT INTO THANNHAN (HoTenBo, TuoiBo, NgheNghiepBo, HoTenMe, TuoiMe, NgheNghiepMe, HoTenACE, TuoiACE, NgheNghiepACE, HoTenOB, TuoiOB, NgheNghiepOB, MaNV) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql,
                entity.getHoTenBo(),
                entity.getTuoiBo(),
                entity.getNgheNghiepBo(),
                entity.getHoTenMe(),
                entity.getTuoiMe(),
                entity.getNgheNghiepMe(),
                entity.getHoTenOB(),
                entity.getTuoiOB(),
                entity.getNgheNghiepOB(),
                entity.getMaNV()
        );
    }
    
    public void update(TN model)
    {
        String sql = "UPDATE THANNHAN SET HoTenBo=?, TuoiBo=?, NgheNghiepBo=?, HoTenMe=?, TuoiMe=?, NgheNghiepMe=?, HoTenACE=?, TuoiACE=?, NgheNghiepACE=?, HoTenOB=?, TuoiOB=?, NgheNghiepOB=?, MaNV=? WHERE MaTN=?";
        JdbcHelper.executeUpdate(sql, 
                model.getHoTenBo(),
                model.getTuoiBo(),
                model.getNgheNghiepBo(),
                model.getHoTenMe(),
                model.getTuoiMe(),
                model.getNgheNghiepMe(),
                model.getHoTenACE(),
                model.getTuoiACE(),
                model.getNgheNghiepACE(),
                model.getHoTenOB(),
                model.getTuoiOB(),
                model.getNgheNghiepOB(),
                model.getMaNV(),
                model.getMaTN()
        );
    }
    
    public void delete(String id)
    {
      String sql = "DELETE FROM THANNHAN WHERE MaNV = ?";
      JdbcHelper.executeUpdate(sql, id);
    }
    
    public List<TN> select()
    {
      String sql = "SELECT * FROM THANNHAN";
      return select(sql);
    }
    
    public TN findById(String matn)
    {
     String sql = "SELECT * FROM THANNHAN WHERE MaTN = ?";
     List<TN> list = select(sql, matn);
     return list.size() > 0 ? list.get(0) : null;
    }
}
