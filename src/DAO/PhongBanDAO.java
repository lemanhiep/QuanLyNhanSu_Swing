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
import model.PhongBan;

/**
 *
 * @author LENOVO
 */
public class PhongBanDAO extends CSDAO<PhongBan, String> {

    @Override
    public void insert(PhongBan entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(PhongBan entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PhongBan> selectAll() {
        String SELECT_ALL_SQL = "SELECT * FROM PhongBan";
        return this.selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public PhongBan selectById(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected List<PhongBan> selectBySql(String sql, Object... agrs) {

        List<PhongBan> list = new ArrayList<PhongBan>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, agrs);
            while (rs.next()) {
                PhongBan entity = new PhongBan();
                entity.setMaPB(rs.getString("MaPB"));
                entity.setTenPB(rs.getString("TenPB"));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
