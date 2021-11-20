/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import DAO.ChamCongDao;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import java.sql.*;
import helper.JdbcHelper;
import helper.MsgBox;
import java.awt.Color;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.ChiTietCong;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Cao Do
 */
public class ChamCong extends javax.swing.JInternalFrame {

    /**
     * Creates new form ChamCong
     */
    Connection cn;
    ChamCongDao dao = new ChamCongDao();
    long count, sotrang, trang = 1;
    int doDaiTrang;
    int index;
//    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

    ArrayList<ChiTietCong> listCtc = new ArrayList<>();

    public ChamCong() {
        initComponents();
        countdb();
        if (count % 5 == 0) {
            sotrang = count / 5;
        } else {
            sotrang = count / 5 + 1;
        }
//        load(1);
        number.setText("1/" + sotrang);
        jTable1.setAutoCreateRowSorter(true);
//D1AM.setBackground(Color.red);
        D1AM.setOpaque(true);
        D2AM.setOpaque(true);
        D3AM.setOpaque(true);
        D4AM.setOpaque(true);
        D5AM.setOpaque(true);
        D6AM.setOpaque(true);
        D7AM.setOpaque(true);
        D8AM.setOpaque(true);
        D9AM.setOpaque(true);
        D10AM.setOpaque(true);
        D11AM.setOpaque(true);
        D12AM.setOpaque(true);
        D13AM.setOpaque(true);
        D14AM.setOpaque(true);
        D15AM.setOpaque(true);
        D16AM.setOpaque(true);
        D17AM.setOpaque(true);
        D18AM.setOpaque(true);
        D19AM.setOpaque(true);
        D20AM.setOpaque(true);
        D21AM.setOpaque(true);
        D22AM.setOpaque(true);
        D23AM.setOpaque(true);
        D24AM.setOpaque(true);
        D25AM.setOpaque(true);
        D26AM.setOpaque(true);
        D27AM.setOpaque(true);
        D28AM.setOpaque(true);
        D29AM.setOpaque(true);
        D30AM.setOpaque(true);
        D31AM.setOpaque(true);

        D1PM.setOpaque(true);
        D2PM.setOpaque(true);
        D3PM.setOpaque(true);
        D4PM.setOpaque(true);
        D5PM.setOpaque(true);
        D6PM.setOpaque(true);
        D7PM.setOpaque(true);
        D8PM.setOpaque(true);
        D9PM.setOpaque(true);
        D10PM.setOpaque(true);
        D11PM.setOpaque(true);
        D12PM.setOpaque(true);
        D13PM.setOpaque(true);
        D14PM.setOpaque(true);
        D15PM.setOpaque(true);
        D16PM.setOpaque(true);
        D17PM.setOpaque(true);
        D18PM.setOpaque(true);
        D19PM.setOpaque(true);
        D20PM.setOpaque(true);
        D21PM.setOpaque(true);
        D22PM.setOpaque(true);
        D23PM.setOpaque(true);
        D24PM.setOpaque(true);
        D25PM.setOpaque(true);
        D26PM.setOpaque(true);
        D27PM.setOpaque(true);
        D28PM.setOpaque(true);
        D29PM.setOpaque(true);
        D30PM.setOpaque(true);
        D31PM.setOpaque(true);

//D1AM.setBackground(Color.red);
    }

    public void save() {
        model.ChamCong model = new model.ChamCong();
        for (int i = 0; i <= jTable1.getRowCount(); i++) {
            String manv = (String) jTable1.getValueAt(i, 0);
            java.util.Date checkin = model.getCheckIn();
            String thang = (String) jTable1.getValueAt(i, 2);
            int tong = (int) jTable1.getValueAt(i, 35);
            String a = String.valueOf(tong);
            try {
                model.setMaNV(manv);
                model.setCheckIn(checkin);
                model.setThang(thang);
                model.setTong(a);
                dao.insert(model);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void load(long trang) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        model.setColumnIdentifiers(new Object[]{
            "MaNV", "Họ tên", "Tháng", "Tổng"
        });
        try {
            long so = trang * 5 - 2;
            String sql = "select top 5 CHAMCONG2.*, NHANVIEN.HoTen FROM CHAMCONG2\n"
                    + "left join NHANVIEN on CHAMCONG2.MaNV = NHANVIEN.MaNV  where CHAMCONG.MaNV not in (select top" + so + " CHAMCONG.MaNV FROM CHAMCONG)";
            ResultSet rs = JdbcHelper.executeQuery(sql);
            while (rs.next()) {
                Object[] row = {
                    rs.getString("MaNV"), rs.getString("HoTen"), rs.getString("Thang"), rs.getString("tong"),};
                model.addRow(row);
            }
//            for (model.ChamCong cc : list) {
//                Object[] row = {
//                    cc.getMaNV(), cc.getHoten(), cc.getThang(), cc.getNam(), cc.getD1(), cc.getD2(), cc.getD3(), cc.getD4(),
//                    cc.getD5(), cc.getD6(), cc.getD7(), cc.getD8(), cc.getD9(), cc.getD10(), cc.getD11(), cc.getD12(),
//                    cc.getD13(), cc.getD14(), cc.getD15(), cc.getD16(), cc.getD17(), cc.getD18(), cc.getD19(), cc.getD20(),
//                    cc.getD21(), cc.getD22(), cc.getD23(), cc.getD24(), cc.getD25(), cc.getD26(), cc.getD27(), cc.getD28(),
//                    cc.getD29(), cc.getD30(), cc.getD31()
//                };
//                model.addRow(row);
//            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi Truy vấn dữ liệu");
            e.printStackTrace();
        }
    }

    void SelectFromCbb() {
        try {
            String sql = "SELECT * FROM CHAMCONG where Thang like '%?%' and Nam = ?";
            PreparedStatement pstm = cn.prepareStatement(sql);

        } catch (Exception e) {
        }
    }

    public void countdb() {
        try {
            String sql = "select count(*) from CHAMCONG";
            ResultSet rs = JdbcHelper.executeQuery(sql);
            while (rs.next()) {
                count = rs.getLong(1);
            }
            rs.close();
        } catch (Exception e) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabs = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        preview = new javax.swing.JButton();
        first = new javax.swing.JButton();
        next = new javax.swing.JButton();
        last = new javax.swing.JButton();
        number = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        D1AM = new javax.swing.JLabel();
        D1PM = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        D2AM = new javax.swing.JLabel();
        D2PM = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        D3AM = new javax.swing.JLabel();
        D3PM = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        D4AM = new javax.swing.JLabel();
        D4PM = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        D5AM = new javax.swing.JLabel();
        D5PM = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        D6AM = new javax.swing.JLabel();
        D6PM = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        D7AM = new javax.swing.JLabel();
        D7PM = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        D8AM = new javax.swing.JLabel();
        D8PM = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        D9AM = new javax.swing.JLabel();
        D9PM = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        D10AM = new javax.swing.JLabel();
        D10PM = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        D11AM = new javax.swing.JLabel();
        D11PM = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        D12AM = new javax.swing.JLabel();
        D12PM = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        D13AM = new javax.swing.JLabel();
        D13PM = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        D14AM = new javax.swing.JLabel();
        D14PM = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        D15AM = new javax.swing.JLabel();
        D15PM = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        D16AM = new javax.swing.JLabel();
        D16PM = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        D17AM = new javax.swing.JLabel();
        D17PM = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        D18AM = new javax.swing.JLabel();
        D18PM = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        D19AM = new javax.swing.JLabel();
        D19PM = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        D20AM = new javax.swing.JLabel();
        D20PM = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        D21AM = new javax.swing.JLabel();
        D21PM = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        D22AM = new javax.swing.JLabel();
        D22PM = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        D23AM = new javax.swing.JLabel();
        D23PM = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        D24AM = new javax.swing.JLabel();
        D24PM = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        D25AM = new javax.swing.JLabel();
        D25PM = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        D26AM = new javax.swing.JLabel();
        D26PM = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        D27AM = new javax.swing.JLabel();
        D27PM = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        D28AM = new javax.swing.JLabel();
        D28PM = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        D29AM = new javax.swing.JLabel();
        D29PM = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        D30AM = new javax.swing.JLabel();
        D30PM = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        D31AM = new javax.swing.JLabel();
        D31PM = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NV", "Tên NV", "Tháng", "Năm", "Số buổi đi", "Số buổi nghỉ", "Tổng"
            }
        ));
        jTable1.setInheritsPopupMenu(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        preview.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        preview.setText("<<");
        preview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewActionPerformed(evt);
            }
        });

        first.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        first.setText("|<");
        first.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstActionPerformed(evt);
            }
        });

        next.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        next.setText(">>");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        last.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        last.setText(">|");
        last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastActionPerformed(evt);
            }
        });

        number.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        number.setText("jLabel1");

        jButton2.setText("Mở");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Save");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setText("Import");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(first)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(preview)
                .addGap(41, 41, 41)
                .addComponent(number)
                .addGap(86, 86, 86)
                .addComponent(next)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(last)
                .addGap(299, 299, 299))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jButton1)
                    .addGap(216, 216, 216)
                    .addComponent(jButton2)
                    .addGap(18, 18, 18)
                    .addComponent(jButton3)
                    .addContainerGap(1013, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(preview)
                    .addComponent(first)
                    .addComponent(next)
                    .addComponent(last)
                    .addComponent(number))
                .addGap(0, 27, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(627, 627, 627)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2)
                        .addComponent(jButton3))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        tabs.addTab("tab2", jPanel2);

        jPanel3.setLayout(new java.awt.GridLayout(4, 8, 10, 10));

        jPanel33.setLayout(new java.awt.GridLayout(2, 0, 5, 5));

        D1AM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D1AM.setText("D1 - AM");
        jPanel33.add(D1AM);

        D1PM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D1PM.setText("D1 - PM");
        jPanel33.add(D1PM);

        jPanel3.add(jPanel33);

        jPanel38.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        D2AM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D2AM.setText("D2 - AM");
        jPanel38.add(D2AM);

        D2PM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D2PM.setText("D2 - PM");
        jPanel38.add(D2PM);

        jPanel3.add(jPanel38);

        jPanel37.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        D3AM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D3AM.setText("D3 - AM");
        jPanel37.add(D3AM);

        D3PM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D3PM.setText("D3 - PM");
        jPanel37.add(D3PM);

        jPanel3.add(jPanel37);

        jPanel31.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        D4AM.setText("D4 - AM");
        jPanel31.add(D4AM);

        D4PM.setText("D4 - PM");
        jPanel31.add(D4PM);

        jPanel3.add(jPanel31);

        jPanel35.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        D5AM.setText("D5 - AM");
        jPanel35.add(D5AM);

        D5PM.setText("D5 - PM");
        jPanel35.add(D5PM);

        jPanel3.add(jPanel35);

        jPanel36.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        D6AM.setText("D6 - AM");
        jPanel36.add(D6AM);

        D6PM.setText("D6 - PM");
        jPanel36.add(D6PM);

        jPanel3.add(jPanel36);

        jPanel39.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        D7AM.setText("D7 - AM");
        jPanel39.add(D7AM);

        D7PM.setText("D7 - PM");
        jPanel39.add(D7PM);

        jPanel3.add(jPanel39);

        jPanel32.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        D8AM.setText("D8 -AM");
        jPanel32.add(D8AM);

        D8PM.setText("D8 - PM");
        jPanel32.add(D8PM);

        jPanel3.add(jPanel32);

        jPanel34.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        D9AM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D9AM.setText("D9 - AM");
        jPanel34.add(D9AM);

        D9PM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D9PM.setText("D9 - PM");
        jPanel34.add(D9PM);

        jPanel3.add(jPanel34);

        jPanel25.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        D10AM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D10AM.setText("D10 - AM");
        jPanel25.add(D10AM);

        D10PM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D10PM.setText("D10 - PM");
        jPanel25.add(D10PM);

        jPanel3.add(jPanel25);

        jPanel29.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        D11AM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D11AM.setText("D11 - AM");
        jPanel29.add(D11AM);

        D11PM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D11PM.setText("D11 - PM");
        jPanel29.add(D11PM);

        jPanel3.add(jPanel29);

        jPanel23.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        D12AM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D12AM.setText("D12 - AM");
        jPanel23.add(D12AM);

        D12PM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D12PM.setText("D12 - PM");
        jPanel23.add(D12PM);

        jPanel3.add(jPanel23);

        jPanel22.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        D13AM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D13AM.setText("D13 - AM");
        jPanel22.add(D13AM);

        D13PM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D13PM.setText("D13 - PM");
        jPanel22.add(D13PM);

        jPanel3.add(jPanel22);

        jPanel28.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        D14AM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D14AM.setText("D14 - AM");
        jPanel28.add(D14AM);

        D14PM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D14PM.setText("D14 - PM");
        jPanel28.add(D14PM);

        jPanel3.add(jPanel28);

        jPanel27.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        D15AM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D15AM.setText("D15 - AM");
        jPanel27.add(D15AM);

        D15PM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D15PM.setText("D15 - PM");
        jPanel27.add(D15PM);

        jPanel3.add(jPanel27);

        jPanel24.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        D16AM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D16AM.setText("D16 - AM");
        jPanel24.add(D16AM);

        D16PM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D16PM.setText("D16 - PM");
        jPanel24.add(D16PM);

        jPanel3.add(jPanel24);

        jPanel26.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        D17AM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D17AM.setText("D17 - AM");
        jPanel26.add(D17AM);

        D17PM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D17PM.setText("D17 - PM");
        jPanel26.add(D17PM);

        jPanel3.add(jPanel26);

        jPanel30.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        D18AM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D18AM.setText("D18 - AM");
        jPanel30.add(D18AM);

        D18PM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D18PM.setText("D18 - PM");
        jPanel30.add(D18PM);

        jPanel3.add(jPanel30);

        jPanel19.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        D19AM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D19AM.setText("D19 - AM");
        jPanel19.add(D19AM);

        D19PM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D19PM.setText("D19 - PM");
        jPanel19.add(D19PM);

        jPanel3.add(jPanel19);

        jPanel11.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        D20AM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D20AM.setText("D20 - AM");
        jPanel11.add(D20AM);

        D20PM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D20PM.setText("D20 - PM");
        jPanel11.add(D20PM);

        jPanel3.add(jPanel11);

        jPanel14.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        D21AM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D21AM.setText("D21 - AM");
        jPanel14.add(D21AM);

        D21PM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D21PM.setText("D21 - PM");
        jPanel14.add(D21PM);

        jPanel3.add(jPanel14);

        jPanel13.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        D22AM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D22AM.setText("D22 - AM");
        jPanel13.add(D22AM);

        D22PM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D22PM.setText("D22 - PM");
        jPanel13.add(D22PM);

        jPanel3.add(jPanel13);

        jPanel10.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        D23AM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D23AM.setText("D23 - AM");
        jPanel10.add(D23AM);

        D23PM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D23PM.setText("D23 - PM");
        jPanel10.add(D23PM);

        jPanel3.add(jPanel10);

        jPanel21.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        D24AM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D24AM.setText("D24 - AM");
        jPanel21.add(D24AM);

        D24PM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D24PM.setText("D24 - PM");
        jPanel21.add(D24PM);

        jPanel3.add(jPanel21);

        jPanel18.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        D25AM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D25AM.setText("D25 - AM");
        jPanel18.add(D25AM);

        D25PM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D25PM.setText("D25 - PM");
        jPanel18.add(D25PM);

        jPanel3.add(jPanel18);

        jPanel17.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        D26AM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D26AM.setText("D26 - AM");
        jPanel17.add(D26AM);

        D26PM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D26PM.setText("D26 - PM");
        jPanel17.add(D26PM);

        jPanel3.add(jPanel17);

        jPanel9.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        D27AM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D27AM.setText("D27 - AM");
        jPanel9.add(D27AM);

        D27PM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D27PM.setText("D27 - PM");
        jPanel9.add(D27PM);

        jPanel3.add(jPanel9);

        jPanel15.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        D28AM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D28AM.setText("D28 - AM");
        jPanel15.add(D28AM);

        D28PM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D28PM.setText("D28 - PM");
        jPanel15.add(D28PM);

        jPanel3.add(jPanel15);

        jPanel7.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        D29AM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D29AM.setText("D29 - AM");
        jPanel7.add(D29AM);

        D29PM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D29PM.setText("D29 - PM");
        jPanel7.add(D29PM);

        jPanel3.add(jPanel7);

        jPanel8.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        D30AM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D30AM.setText("D30 - AM");
        jPanel8.add(D30AM);

        D30PM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D30PM.setText("D30 - PM");
        jPanel8.add(D30PM);

        jPanel3.add(jPanel8);

        jPanel6.setLayout(new java.awt.GridLayout(2, 0, 0, 5));

        D31AM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D31AM.setText("D31 - AM");
        jPanel6.add(D31AM);

        D31PM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        D31PM.setText("D31 - PM");
        jPanel6.add(D31PM);

        jPanel3.add(jPanel6);

        jPanel5.setLayout(new java.awt.GridLayout());
        jPanel3.add(jPanel5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1424, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        tabs.addTab("tab1", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 1265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
//        this.countdb();
//        this.load(trang);
    }//GEN-LAST:event_formInternalFrameOpened

    private void firstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstActionPerformed
        trang = 1;
        load(trang);
        number.setText("1 /" + sotrang);
    }//GEN-LAST:event_firstActionPerformed

    private void previewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewActionPerformed
        if (trang > 1) {
            trang--;
            load(trang);
            number.setText(trang + "/" + sotrang);
        }
    }//GEN-LAST:event_previewActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        if (trang < sotrang) {
            trang++;
            load(trang);
            number.setText(trang + "/" + sotrang);
        }
    }//GEN-LAST:event_nextActionPerformed

    private void lastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastActionPerformed
        trang = sotrang;
        load(trang);
        number.setText(sotrang + "/" + sotrang);
    }//GEN-LAST:event_lastActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        FileInputStream excelFis = null;
        BufferedInputStream excelBis = null;
        XSSFWorkbook excelJTableImportWorkBook = null;

        String currenntDirectoryPath = "G:\\";
        JFileChooser excelFileChooseImport = new JFileChooser(currenntDirectoryPath);
//        filter only excel files
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlxs", "xlsm");
        excelFileChooseImport.setFileFilter(fnef);
        excelFileChooseImport.setDialogTitle("Select excel fiel");
        int excelChoose = excelFileChooseImport.showOpenDialog(null);
        if (excelChoose == JFileChooser.APPROVE_OPTION) {

            try {
                File excelFile = excelFileChooseImport.getSelectedFile();
                excelFis = new FileInputStream(excelFile);
                excelBis = new BufferedInputStream(excelFis);
                excelJTableImportWorkBook = new XSSFWorkbook(excelBis);
                XSSFSheet excelSheet = excelJTableImportWorkBook.getSheetAt(0);

                ChiTietCong modelCtc = new ChiTietCong();
                for (int row = 1; row <= excelSheet.getLastRowNum(); row++) {
                    XSSFRow excelRow = excelSheet.getRow(row);
                    XSSFCell excelMa = excelRow.getCell(0);
                    String manv = excelMa.toString();
                    modelCtc.setMaNV(manv);
                    XSSFCell excelTen = excelRow.getCell(1);
                    XSSFCell excelThang = excelRow.getCell(2);
                    String thang = excelThang.toString();
                    XSSFCell excelNam = excelRow.getCell(3);
                    XSSFCell excelD1 = excelRow.getCell(4);
                    String D1 = excelD1.toString();
                    modelCtc.setD1(D1);
                    int d1;
                    if (D1.equalsIgnoreCase("VV") || D1.equalsIgnoreCase("C") || D1.equalsIgnoreCase("p")) {
                        d1 = 2;
                    } else if (D1.equalsIgnoreCase("x")) {
                        d1 = 0;
                    } else if (D1.equalsIgnoreCase("am") || D1.equalsIgnoreCase("pm")) {
                        d1 = 1;
                    } else {
                        d1 = 0;
                    }
                    XSSFCell excelD2 = excelRow.getCell(5);
                    String D2 = excelD2.toString();
                    modelCtc.setD2(D2);
                    int d2;
                    if (D2.equalsIgnoreCase("VV") || D2.equalsIgnoreCase("C") || D2.equalsIgnoreCase("p")) {
                        d2 = 2;
                    } else if (D2.equalsIgnoreCase("x")) {
                        d2 = 0;
                    } else if (D2.equalsIgnoreCase("am") || D2.equalsIgnoreCase("pm")) {
                        d2 = 1;
                    } else {
                        d2 = 0;
                    }
                    XSSFCell excelD3 = excelRow.getCell(6);
                    String D3 = excelD3.toString();
                    modelCtc.setD3(D3);
                    int d3;
                    if (D3.equalsIgnoreCase("VV") || D3.equalsIgnoreCase("C") || D3.equalsIgnoreCase("p")) {
                        d3 = 2;
                    } else if (D3.equalsIgnoreCase("x")) {
                        d3 = 0;
                    } else if (D3.equalsIgnoreCase("am") || D3.equalsIgnoreCase("pm")) {
                        d3 = 1;
                    } else {
                        d3 = 0;
                    }
                    XSSFCell excelD4 = excelRow.getCell(7);
                    String D4 = excelD4.toString();
                    modelCtc.setD4(D4);
                    int d4;
                    if (D4.equalsIgnoreCase("VV") || D4.equalsIgnoreCase("C") || D4.equalsIgnoreCase("p")) {
                        d4 = 2;
                    } else if (D4.equalsIgnoreCase("x")) {
                        d4 = 0;
                    } else if (D4.equalsIgnoreCase("am") || D4.equalsIgnoreCase("pm")) {
                        d4 = 1;
                    } else {
                        d4 = 0;
                    }
                    XSSFCell excelD5 = excelRow.getCell(8);
                    String D5 = excelD5.toString();
                    modelCtc.setD5(D5);
                    int d5;
                    if (D5.equalsIgnoreCase("VV") || D5.equalsIgnoreCase("C") || D5.equalsIgnoreCase("p")) {
                        d5 = 2;
                    } else if (D5.equalsIgnoreCase("x")) {
                        d5 = 0;
                    } else if (D5.equalsIgnoreCase("am") || D5.equalsIgnoreCase("pm")) {
                        d5 = 1;
                    } else {
                        d5 = 0;
                    }
                    XSSFCell excelD6 = excelRow.getCell(9);
                    String D6 = excelD6.toString();
                    modelCtc.setD6(D6);
                    int d6;
                    if (D6.equalsIgnoreCase("VV") || D6.equalsIgnoreCase("C") || D6.equalsIgnoreCase("p")) {
                        d6 = 2;
                    } else if (D6.equalsIgnoreCase("x")) {
                        d6 = 0;
                    } else if (D6.equalsIgnoreCase("am") || D6.equalsIgnoreCase("pm")) {
                        d6 = 1;
                    } else {
                        d6 = 0;
                    }
                    XSSFCell excelD7 = excelRow.getCell(10);
                    String D7 = excelD7.toString();
                    modelCtc.setD7(D7);
                    int d7;
                    if (D7.equalsIgnoreCase("VV") || D7.equalsIgnoreCase("C") || D7.equalsIgnoreCase("p")) {
                        d7 = 2;
                    } else if (D7.equalsIgnoreCase("x")) {
                        d7 = 0;
                    } else if (D7.equalsIgnoreCase("am") || D7.equalsIgnoreCase("pm")) {
                        d7 = 1;
                    } else {
                        d7 = 0;
                    }
                    XSSFCell excelD8 = excelRow.getCell(11);
                    String D8 = excelD8.toString();
                    modelCtc.setD8(D8);
                    int d8;
                    if (D8.equalsIgnoreCase("VV") || D8.equalsIgnoreCase("C") || D8.equalsIgnoreCase("p")) {
                        d8 = 2;
                    } else if (D8.equalsIgnoreCase("x")) {
                        d8 = 0;
                    } else if (D8.equalsIgnoreCase("am") || D8.equalsIgnoreCase("pm")) {
                        d8 = 1;
                    } else {
                        d8 = 0;
                    }
                    XSSFCell excelD9 = excelRow.getCell(12);
                    String D9 = excelD9.toString();
                    modelCtc.setD9(D9);
                    int d9;
                    if (D9.equalsIgnoreCase("VV") || D9.equalsIgnoreCase("C") || D9.equalsIgnoreCase("p")) {
                        d9 = 2;
                    } else if (D9.equalsIgnoreCase("x")) {
                        d9 = 0;
                    } else if (D9.equalsIgnoreCase("am") || D9.equalsIgnoreCase("pm")) {
                        d9 = 1;
                    } else {
                        d9 = 0;
                    }
                    XSSFCell excelD10 = excelRow.getCell(13);
                    String D10 = excelD10.toString();
                    modelCtc.setD10(D10);
                    int d10;
                    if (D10.equalsIgnoreCase("VV") || D10.equalsIgnoreCase("C") || D10.equalsIgnoreCase("p")) {
                        d10 = 2;
                    } else if (D10.equalsIgnoreCase("x")) {
                        d10 = 0;
                    } else if (D10.equalsIgnoreCase("am") || D10.equalsIgnoreCase("pm")) {
                        d10 = 1;
                    } else {
                        d10 = 0;
                    }
                    XSSFCell excelD11 = excelRow.getCell(14);
                    String D11 = excelD11.toString();
                    modelCtc.setD11(D11);
                    int d11;
                    if (D11.equalsIgnoreCase("VV") || D11.equalsIgnoreCase("C") || D11.equalsIgnoreCase("p")) {
                        d11 = 2;
                    } else if (D11.equalsIgnoreCase("x")) {
                        d11 = 0;
                    } else if (D11.equalsIgnoreCase("am") || D11.equalsIgnoreCase("pm")) {
                        d11 = 1;
                    } else {
                        d11 = 0;
                    }
                    XSSFCell excelD12 = excelRow.getCell(15);
                    String D12 = excelD12.toString();
                    modelCtc.setD12(D12);
                    int d12;
                    if (D12.equalsIgnoreCase("VV") || D12.equalsIgnoreCase("C") || D12.equalsIgnoreCase("p")) {
                        d12 = 2;
                    } else if (D12.equalsIgnoreCase("x")) {
                        d12 = 0;
                    } else if (D12.equalsIgnoreCase("am") || D12.equalsIgnoreCase("pm")) {
                        d12 = 1;
                    } else {
                        d12 = 0;
                    }
                    XSSFCell excelD13 = excelRow.getCell(16);
                    String D13 = excelD13.toString();
                    modelCtc.setD13(D13);
                    int d13;
                    if (D13.equalsIgnoreCase("VV") || D13.equalsIgnoreCase("C") || D13.equalsIgnoreCase("p")) {
                        d13 = 2;
                    } else if (D13.equalsIgnoreCase("x")) {
                        d13 = 0;
                    } else if (D13.equalsIgnoreCase("am") || D13.equalsIgnoreCase("pm")) {
                        d13 = 1;
                    } else {
                        d13 = 0;
                    }
                    XSSFCell excelD14 = excelRow.getCell(17);
                    String D14 = excelD14.toString();
                    modelCtc.setD14(D14);
                    int d14;
                    if (D14.equalsIgnoreCase("VV") || D14.equalsIgnoreCase("C") || D14.equalsIgnoreCase("p")) {
                        d14 = 2;
                    } else if (D14.equalsIgnoreCase("x")) {
                        d14 = 0;
                    } else if (D14.equalsIgnoreCase("am") || D14.equalsIgnoreCase("pm")) {
                        d14 = 1;
                    } else {
                        d14 = 0;
                    }
                    XSSFCell excelD15 = excelRow.getCell(18);
                    String D15 = excelD15.toString();
                    modelCtc.setD15(D15);
                    int d15;
                    if (D15.equalsIgnoreCase("VV") || D15.equalsIgnoreCase("C") || D15.equalsIgnoreCase("p")) {
                        d15 = 2;
                    } else if (D15.equalsIgnoreCase("x")) {
                        d15 = 0;
                    } else if (D15.equalsIgnoreCase("am") || D15.equalsIgnoreCase("pm")) {
                        d15 = 1;
                    } else {
                        d15 = 0;
                    }
                    XSSFCell excelD16 = excelRow.getCell(19);
                    String D16 = excelD16.toString();
                    modelCtc.setD16(D16);
                    int d16;
                    if (D16.equalsIgnoreCase("VV") || D16.equalsIgnoreCase("C") || D16.equalsIgnoreCase("p")) {
                        d16 = 2;
                    } else if (D16.equalsIgnoreCase("x")) {
                        d16 = 0;
                    } else if (D16.equalsIgnoreCase("am") || D16.equalsIgnoreCase("pm")) {
                        d16 = 1;
                    } else {
                        d16 = 0;
                    }
                    XSSFCell excelD17 = excelRow.getCell(20);
                    String D17 = excelD17.toString();
                    modelCtc.setD17(D17);
                    int d17;
                    if (D17.equalsIgnoreCase("VV") || D17.equalsIgnoreCase("C") || D17.equalsIgnoreCase("p")) {
                        d17 = 2;
                    } else if (D17.equalsIgnoreCase("x")) {
                        d17 = 0;
                    } else if (D17.equalsIgnoreCase("am") || D17.equalsIgnoreCase("pm")) {
                        d17 = 1;
                    } else {
                        d17 = 0;
                    }
                    XSSFCell excelD18 = excelRow.getCell(21);
                    String D18 = excelD18.toString();
                    modelCtc.setD18(D18);
                    int d18;
                    if (D18.equalsIgnoreCase("VV") || D18.equalsIgnoreCase("C") || D18.equalsIgnoreCase("p")) {
                        d18 = 2;
                    } else if (D18.equalsIgnoreCase("x")) {
                        d18 = 0;
                    } else if (D18.equalsIgnoreCase("am") || D18.equalsIgnoreCase("pm")) {
                        d18 = 1;
                    } else {
                        d18 = 0;
                    }
                    XSSFCell excelD19 = excelRow.getCell(22);
                    String D19 = excelD19.toString();
                    modelCtc.setD19(D19);
                    int d19;
                    if (D19.equalsIgnoreCase("VV") || D19.equalsIgnoreCase("C") || D19.equalsIgnoreCase("p")) {
                        d19 = 2;
                    } else if (D19.equalsIgnoreCase("x")) {
                        d19 = 0;
                    } else if (D19.equalsIgnoreCase("am") || D19.equalsIgnoreCase("pm")) {
                        d19 = 1;
                    } else {
                        d19 = 0;
                    }
                    XSSFCell excelD20 = excelRow.getCell(23);
                    String D20 = excelD20.toString();
                    modelCtc.setD20(D20);
                    int d20;
                    if (D20.equalsIgnoreCase("VV") || D20.equalsIgnoreCase("C") || D20.equalsIgnoreCase("p")) {
                        d20 = 2;
                    } else if (D20.equalsIgnoreCase("x")) {
                        d20 = 0;
                    } else if (D20.equalsIgnoreCase("am") || D20.equalsIgnoreCase("pm")) {
                        d20 = 1;
                    } else {
                        d20 = 0;
                    }
                    XSSFCell excelD21 = excelRow.getCell(24);
                    String D21 = excelD21.toString();
                    modelCtc.setD21(D21);
                    int d21;
                    if (D21.equalsIgnoreCase("VV") || D21.equalsIgnoreCase("C") || D21.equalsIgnoreCase("p")) {
                        d21 = 2;
                    } else if (D21.equalsIgnoreCase("x")) {
                        d21 = 0;
                    } else if (D21.equalsIgnoreCase("am") || D21.equalsIgnoreCase("pm")) {
                        d21 = 1;
                    } else {
                        d21 = 0;
                    }
                    XSSFCell excelD22 = excelRow.getCell(25);
                    String D22 = excelD22.toString();
                    modelCtc.setD22(D22);
                    int d22;
                    if (D22.equalsIgnoreCase("VV") || D22.equalsIgnoreCase("C") || D22.equalsIgnoreCase("p")) {
                        d22 = 2;
                    } else if (D22.equalsIgnoreCase("x")) {
                        d22 = 0;
                    } else if (D22.equalsIgnoreCase("am") || D22.equalsIgnoreCase("pm")) {
                        d22 = 1;
                    } else {
                        d22 = 0;
                    }
                    XSSFCell excelD23 = excelRow.getCell(26);
                    String D23 = excelD23.toString();
                    modelCtc.setD23(D23);
                    int d23;
                    if (D23.equalsIgnoreCase("VV") || D23.equalsIgnoreCase("C") || D23.equalsIgnoreCase("p")) {
                        d23 = 2;
                    } else if (D23.equalsIgnoreCase("x")) {
                        d23 = 0;
                    } else if (D23.equalsIgnoreCase("am") || D23.equalsIgnoreCase("pm")) {
                        d23 = 1;
                    } else {
                        d23 = 0;
                    }
                    XSSFCell excelD24 = excelRow.getCell(27);
                    String D24 = excelD24.toString();
                    modelCtc.setD24(D24);
                    int d24;
                    if (D24.equalsIgnoreCase("VV") || D24.equalsIgnoreCase("C") || D24.equalsIgnoreCase("p")) {
                        d24 = 2;
                    } else if (D24.equalsIgnoreCase("x")) {
                        d24 = 0;
                    } else if (D24.equalsIgnoreCase("am") || D24.equalsIgnoreCase("pm")) {
                        d24 = 1;
                    } else {
                        d24 = 0;
                    }
                    XSSFCell excelD25 = excelRow.getCell(28);
                    String D25 = excelD25.toString();
                    modelCtc.setD25(D25);
                    int d25;
                    if (D25.equalsIgnoreCase("VV") || D25.equalsIgnoreCase("C") || D25.equalsIgnoreCase("p")) {
                        d25 = 2;
                    } else if (D25.equalsIgnoreCase("x")) {
                        d25 = 0;
                    } else if (D25.equalsIgnoreCase("am") || D25.equalsIgnoreCase("pm")) {
                        d25 = 1;
                    } else {
                        d25 = 0;
                    }
                    XSSFCell excelD26 = excelRow.getCell(29);
                    String D26 = excelD26.toString();
                    modelCtc.setD26(D26);
                    int d26;
                    if (D26.equalsIgnoreCase("VV") || D26.equalsIgnoreCase("C") || D26.equalsIgnoreCase("p")) {
                        d26 = 2;
                    } else if (D26.equalsIgnoreCase("x")) {
                        d26 = 0;
                    } else if (D26.equalsIgnoreCase("am") || D26.equalsIgnoreCase("pm")) {
                        d26 = 1;
                    } else {
                        d26 = 0;
                    }
                    XSSFCell excelD27 = excelRow.getCell(30);
                    String D27 = excelD27.toString();
                    modelCtc.setD27(D27);
                    int d27;
                    if (D27.equalsIgnoreCase("VV") || D27.equalsIgnoreCase("C") || D27.equalsIgnoreCase("p")) {
                        d27 = 2;
                    } else if (D27.equalsIgnoreCase("x")) {
                        d27 = 0;
                    } else if (D27.equalsIgnoreCase("am") || D27.equalsIgnoreCase("pm")) {
                        d27 = 1;
                    } else {
                        d27 = 0;
                    }
                    XSSFCell excelD28 = excelRow.getCell(31);
                    String D28 = excelD28.toString();
                    modelCtc.setD28(D28);
                    int d28;
                    if (D28.equalsIgnoreCase("VV") || D28.equalsIgnoreCase("C") || D28.equalsIgnoreCase("p")) {
                        d28 = 2;
                    } else if (D28.equalsIgnoreCase("x")) {
                        d28 = 0;
                    } else if (D28.equalsIgnoreCase("am") || D28.equalsIgnoreCase("pm")) {
                        d28 = 1;
                    } else {
                        d28 = 0;
                    }
                    XSSFCell excelD29 = excelRow.getCell(32);
                    String D29 = excelD29.toString();
                    modelCtc.setD29(D29);
                    int d29;
                    if (D29.equalsIgnoreCase("VV") || D29.equalsIgnoreCase("C") || D29.equalsIgnoreCase("p")) {
                        d29 = 2;
                    } else if (D29.equalsIgnoreCase("x")) {
                        d29 = 0;
                    } else if (D29.equalsIgnoreCase("am") || D29.equalsIgnoreCase("pm")) {
                        d29 = 1;
                    } else {
                        d29 = 0;
                    }
                    XSSFCell excelD30 = excelRow.getCell(33);
                    String D30 = excelD30.toString();
                    modelCtc.setD30(D30);
                    int d30;
                    if (D2.equalsIgnoreCase("VV") || D30.equalsIgnoreCase("C") || D30.equalsIgnoreCase("p")) {
                        d30 = 2;
                    } else if (D30.equalsIgnoreCase("x")) {
                        d30 = 0;
                    } else if (D30.equalsIgnoreCase("am") || D30.equalsIgnoreCase("pm")) {
                        d30 = 1;
                    } else {
                        d30 = 0;
                    }
                    XSSFCell excelD31 = excelRow.getCell(34);
                    String D31 = excelD31.toString();
                    modelCtc.setD31(D31);
                    int d31;
                    if (D31.equalsIgnoreCase("VV") || D31.equalsIgnoreCase("C") || D31.equalsIgnoreCase("p")) {
                        d31 = 2;
                    } else if (D31.equalsIgnoreCase("x")) {
                        d31 = 0;
                    } else if (D31.equalsIgnoreCase("am") || D31.equalsIgnoreCase("pm")) {
                        d31 = 1;
                    } else {
                        d31 = 0;
                    }
                    listCtc.add(new ChiTietCong(manv, D1, D2, D3, D4, D5, D6, D7, D8, D9, D10, D11, D12, D13, D14, D15, D16, D17, D18, D19, D20, D21, D22, D23, D24, D25, D26, D27, D28, D29, D30, D31));
                    int tong = d1 + d2 + d3 + d4 + d5 + d6 + d7 + d8 + d9 + d10 + d11 + d12 + d13 + d14 + d15 + d16 + d17 + d18 + d19 + d20 + d21
                            + d22 + d23 + d24 + d25 + d26 + d27 + d28 + d29 + d30 + d31;
                    model.addRow(new Object[]{manv, excelTen, thang, excelNam, null, null, tong / 2
                    });

                    //                    for (int column = 0; column < excelRow.getLastCellNum(); column++) {
                    //                        XSSFCell excelCell = excelRow.getCell(column);
                    //                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ChamCong.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ChamCong.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (excelFis != null) {
                        excelFis.close();
                    }
                    if (excelBis != null) {
                        excelBis.close();
                    }
                    if (excelJTableImportWorkBook != null) {
                        excelJTableImportWorkBook.close();
                    }
                } catch (IOException e) {
                }
            }

        }
        for (ChiTietCong sheet : listCtc) {
            System.out.println(sheet);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new BangCong().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.save();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 2) {
            this.index = jTable1.rowAtPoint(evt.getPoint());
            if (this.index >= 0) {
                tabs.setSelectedIndex(0);
//                MsgBox.alert(null, index + "");
//                listCtc.get(index);
                ChiTietCong ct = listCtc.get(index);
//                d1
                if (ct.getD1().equalsIgnoreCase("VV") || ct.getD1().equalsIgnoreCase("c") || ct.getD1().equalsIgnoreCase("p")) {
                    D1AM.setBackground(Color.GREEN );
                    D1PM.setBackground(Color.GREEN );
                } else if (ct.getD1().equalsIgnoreCase("am")) {
                    D1AM.setBackground(Color.GREEN );
                    D1PM.setBackground(Color.RED);
                } else if (ct.getD1().equalsIgnoreCase("pm")) {
                    D1AM.setBackground(Color.RED);
                    D1PM.setBackground(Color.GREEN );
                } else {
                    D1AM.setBackground(Color.RED);
                    D1PM.setBackground(Color.RED);
                }
//                d2
                if (ct.getD2().equalsIgnoreCase("VV") || ct.getD2().equalsIgnoreCase("c") || ct.getD2().equalsIgnoreCase("p")) {
                    D2AM.setBackground(Color.GREEN );
                    D2PM.setBackground(Color.GREEN );
                } else if (ct.getD2().equalsIgnoreCase("am")) {
                    D2AM.setBackground(Color.GREEN );
                    D2PM.setBackground(Color.RED);
                } else if (ct.getD2().equalsIgnoreCase("pm")) {
                    D2AM.setBackground(Color.RED);
                    D2PM.setBackground(Color.GREEN );
                } else {
                    D2AM.setBackground(Color.RED);
                    D2PM.setBackground(Color.RED);
                }
//                d3
                if (ct.getD3().equalsIgnoreCase("VV") || ct.getD3().equalsIgnoreCase("c") || ct.getD3().equalsIgnoreCase("p")) {
                    D3AM.setBackground(Color.GREEN );
                    D3PM.setBackground(Color.GREEN );
                } else if (ct.getD3().equalsIgnoreCase("am")) {
                    D3AM.setBackground(Color.GREEN );
                    D3PM.setBackground(Color.RED);
                } else if (ct.getD3().equalsIgnoreCase("pm")) {
                    D3AM.setBackground(Color.RED);
                    D3PM.setBackground(Color.GREEN );
                } else {
                    D3AM.setBackground(Color.RED);
                    D3PM.setBackground(Color.RED);
                }
//                d4
                if (ct.getD4().equalsIgnoreCase("VV") || ct.getD4().equalsIgnoreCase("c") || ct.getD4().equalsIgnoreCase("p")) {
                    D4AM.setBackground(Color.GREEN );
                    D4PM.setBackground(Color.GREEN );
                } else if (ct.getD4().equalsIgnoreCase("am")) {
                    D4AM.setBackground(Color.GREEN );
                    D4PM.setBackground(Color.RED);
                } else if (ct.getD4().equalsIgnoreCase("pm")) {
                    D4AM.setBackground(Color.RED);
                    D4PM.setBackground(Color.GREEN );
                } else {
                    D4AM.setBackground(Color.RED);
                    D4PM.setBackground(Color.RED);
                }
//                d5
                if (ct.getD5().equalsIgnoreCase("VV") || ct.getD5().equalsIgnoreCase("c") || ct.getD5().equalsIgnoreCase("p")) {
                    D5AM.setBackground(Color.GREEN );
                    D5PM.setBackground(Color.GREEN );
                } else if (ct.getD5().equalsIgnoreCase("am")) {
                    D5AM.setBackground(Color.GREEN );
                    D5PM.setBackground(Color.RED);
                } else if (ct.getD5().equalsIgnoreCase("pm")) {
                    D5AM.setBackground(Color.RED);
                    D5PM.setBackground(Color.GREEN );
                } else {
                    D5AM.setBackground(Color.RED);
                    D5PM.setBackground(Color.RED);
                }
//                d6
                if (ct.getD6().equalsIgnoreCase("VV") || ct.getD6().equalsIgnoreCase("c") || ct.getD6().equalsIgnoreCase("p")) {
                    D6AM.setBackground(Color.GREEN );
                    D6PM.setBackground(Color.GREEN );
                } else if (ct.getD6().equalsIgnoreCase("am")) {
                    D6AM.setBackground(Color.GREEN );
                    D6PM.setBackground(Color.RED);
                } else if (ct.getD6().equalsIgnoreCase("pm")) {
                    D6AM.setBackground(Color.RED);
                    D6PM.setBackground(Color.GREEN );
                } else {
                    D6AM.setBackground(Color.RED);
                    D6PM.setBackground(Color.RED);
                }
//                d7
                if (ct.getD7().equalsIgnoreCase("VV") || ct.getD7().equalsIgnoreCase("c") || ct.getD7().equalsIgnoreCase("p")) {
                    D7AM.setBackground(Color.GREEN );
                    D7PM.setBackground(Color.GREEN );
                } else if (ct.getD7().equalsIgnoreCase("am")) {
                    D7AM.setBackground(Color.GREEN );
                    D7PM.setBackground(Color.RED);
                } else if (ct.getD7().equalsIgnoreCase("pm")) {
                    D7AM.setBackground(Color.RED);
                    D7PM.setBackground(Color.GREEN );
                } else {
                    D7AM.setBackground(Color.RED);
                    D7PM.setBackground(Color.RED);
                }
//d8
                if (ct.getD8().equalsIgnoreCase("VV") || ct.getD8().equalsIgnoreCase("c") || ct.getD8().equalsIgnoreCase("p")) {
                    D8AM.setBackground(Color.GREEN );
                    D8PM.setBackground(Color.GREEN );
                } else if (ct.getD8().equalsIgnoreCase("am")) {
                    D8AM.setBackground(Color.GREEN );
                    D8PM.setBackground(Color.RED);
                } else if (ct.getD8().equalsIgnoreCase("pm")) {
                    D8AM.setBackground(Color.RED);
                    D8PM.setBackground(Color.GREEN );
                } else {
                    D8AM.setBackground(Color.RED);
                    D8PM.setBackground(Color.RED);
                }
//d9
                if (ct.getD9().equalsIgnoreCase("VV") || ct.getD9().equalsIgnoreCase("c") || ct.getD9().equalsIgnoreCase("p")) {
                    D9AM.setBackground(Color.GREEN );
                    D9PM.setBackground(Color.GREEN );
                } else if (ct.getD9().equalsIgnoreCase("am")) {
                    D9AM.setBackground(Color.GREEN );
                    D9PM.setBackground(Color.RED);
                } else if (ct.getD9().equalsIgnoreCase("pm")) {
                    D9AM.setBackground(Color.RED);
                    D9PM.setBackground(Color.GREEN );
                } else {
                    D9AM.setBackground(Color.RED);
                    D9PM.setBackground(Color.RED);
                }
//d10
                if (ct.getD10().equalsIgnoreCase("VV") || ct.getD10().equalsIgnoreCase("c") || ct.getD10().equalsIgnoreCase("p")) {
                    D10AM.setBackground(Color.GREEN );
                    D10PM.setBackground(Color.GREEN );
                } else if (ct.getD10().equalsIgnoreCase("am")) {
                    D10AM.setBackground(Color.GREEN );
                    D10PM.setBackground(Color.RED);
                } else if (ct.getD10().equalsIgnoreCase("pm")) {
                    D10AM.setBackground(Color.RED);
                    D10PM.setBackground(Color.GREEN );
                } else {
                    D10AM.setBackground(Color.RED);
                    D10PM.setBackground(Color.RED);
                }
//                d11
                if (ct.getD11().equalsIgnoreCase("VV") || ct.getD11().equalsIgnoreCase("c") || ct.getD11().equalsIgnoreCase("p")) {
                    D11AM.setBackground(Color.GREEN );
                    D11PM.setBackground(Color.GREEN );
                } else if (ct.getD11().equalsIgnoreCase("am")) {
                    D11AM.setBackground(Color.GREEN );
                    D11PM.setBackground(Color.RED);
                } else if (ct.getD11().equalsIgnoreCase("pm")) {
                    D11AM.setBackground(Color.RED);
                    D11PM.setBackground(Color.GREEN );
                } else {
                    D11AM.setBackground(Color.RED);
                    D11PM.setBackground(Color.RED);
                }
//d12
                if (ct.getD12().equalsIgnoreCase("VV") || ct.getD12().equalsIgnoreCase("c") || ct.getD12().equalsIgnoreCase("p")) {
                    D12AM.setBackground(Color.GREEN );
                    D12PM.setBackground(Color.GREEN );
                } else if (ct.getD12().equalsIgnoreCase("am")) {
                    D12AM.setBackground(Color.GREEN );
                    D12PM.setBackground(Color.RED);
                } else if (ct.getD12().equalsIgnoreCase("pm")) {
                    D12AM.setBackground(Color.RED);
                    D12PM.setBackground(Color.GREEN );
                } else {
                    D12AM.setBackground(Color.RED);
                    D12PM.setBackground(Color.RED);
                }
//d13
                if (ct.getD13().equalsIgnoreCase("VV") || ct.getD13().equalsIgnoreCase("c") || ct.getD13().equalsIgnoreCase("p")) {
                    D13AM.setBackground(Color.GREEN );
                    D13PM.setBackground(Color.GREEN );
                } else if (ct.getD13().equalsIgnoreCase("am")) {
                    D13AM.setBackground(Color.GREEN );
                    D13PM.setBackground(Color.RED);
                } else if (ct.getD13().equalsIgnoreCase("pm")) {
                    D13AM.setBackground(Color.RED);
                    D13PM.setBackground(Color.GREEN );
                } else {
                    D13AM.setBackground(Color.RED);
                    D13PM.setBackground(Color.RED);
                }
//d14
                if (ct.getD14().equalsIgnoreCase("VV") || ct.getD14().equalsIgnoreCase("c") || ct.getD14().equalsIgnoreCase("p")) {
                    D14AM.setBackground(Color.GREEN );
                    D14PM.setBackground(Color.GREEN );
                } else if (ct.getD14().equalsIgnoreCase("am")) {
                    D14AM.setBackground(Color.GREEN );
                    D14PM.setBackground(Color.RED);
                } else if (ct.getD14().equalsIgnoreCase("pm")) {
                    D14AM.setBackground(Color.RED);
                    D14PM.setBackground(Color.GREEN );
                } else {
                    D14AM.setBackground(Color.RED);
                    D14PM.setBackground(Color.RED);
                }
//                d15
                if (ct.getD15().equalsIgnoreCase("VV") || ct.getD15().equalsIgnoreCase("c") || ct.getD15().equalsIgnoreCase("p")) {
                    D15AM.setBackground(Color.GREEN );
                    D15PM.setBackground(Color.GREEN );
                } else if (ct.getD15().equalsIgnoreCase("am")) {
                    D15AM.setBackground(Color.GREEN );
                    D15PM.setBackground(Color.RED);
                } else if (ct.getD15().equalsIgnoreCase("pm")) {
                    D15AM.setBackground(Color.RED);
                    D15PM.setBackground(Color.GREEN );
                } else {
                    D15AM.setBackground(Color.RED);
                    D15PM.setBackground(Color.RED);
                }
//d16
                if (ct.getD16().equalsIgnoreCase("VV") || ct.getD16().equalsIgnoreCase("c") || ct.getD16().equalsIgnoreCase("p")) {
                    D16AM.setBackground(Color.GREEN );
                    D16PM.setBackground(Color.GREEN );
                } else if (ct.getD16().equalsIgnoreCase("am")) {
                    D16AM.setBackground(Color.GREEN );
                    D16PM.setBackground(Color.RED);
                } else if (ct.getD16().equalsIgnoreCase("pm")) {
                    D16AM.setBackground(Color.RED);
                    D16PM.setBackground(Color.GREEN );
                } else {
                    D16AM.setBackground(Color.RED);
                    D16PM.setBackground(Color.RED);
                }
//d17
                if (ct.getD17().equalsIgnoreCase("VV") || ct.getD17().equalsIgnoreCase("c") || ct.getD17().equalsIgnoreCase("p")) {
                    D17AM.setBackground(Color.GREEN );
                    D17PM.setBackground(Color.GREEN );
                } else if (ct.getD17().equalsIgnoreCase("am")) {
                    D17AM.setBackground(Color.GREEN );
                    D17PM.setBackground(Color.RED);
                } else if (ct.getD17().equalsIgnoreCase("pm")) {
                    D17AM.setBackground(Color.RED);
                    D17PM.setBackground(Color.GREEN );
                } else {
                    D17AM.setBackground(Color.RED);
                    D17PM.setBackground(Color.RED);
                }
//d18
                if (ct.getD18().equalsIgnoreCase("VV") || ct.getD18().equalsIgnoreCase("c") || ct.getD18().equalsIgnoreCase("p")) {
                    D18AM.setBackground(Color.GREEN );
                    D18PM.setBackground(Color.GREEN );
                } else if (ct.getD18().equalsIgnoreCase("am")) {
                    D18AM.setBackground(Color.GREEN );
                    D18PM.setBackground(Color.RED);
                } else if (ct.getD18().equalsIgnoreCase("pm")) {
                    D18AM.setBackground(Color.RED);
                    D18PM.setBackground(Color.GREEN );
                } else {
                    D18AM.setBackground(Color.RED);
                    D18PM.setBackground(Color.RED);
                }
//d19
                if (ct.getD19().equalsIgnoreCase("VV") || ct.getD19().equalsIgnoreCase("c") || ct.getD19().equalsIgnoreCase("p")) {
                    D19AM.setBackground(Color.GREEN );
                    D19PM.setBackground(Color.GREEN );
                } else if (ct.getD19().equalsIgnoreCase("am")) {
                    D19AM.setBackground(Color.GREEN );
                    D19PM.setBackground(Color.RED);
                } else if (ct.getD19().equalsIgnoreCase("pm")) {
                    D19AM.setBackground(Color.RED);
                    D19PM.setBackground(Color.GREEN );
                } else {
                    D19AM.setBackground(Color.RED);
                    D19PM.setBackground(Color.RED);
                }
//d20
                if (ct.getD20().equalsIgnoreCase("VV") || ct.getD20().equalsIgnoreCase("c") || ct.getD20().equalsIgnoreCase("p")) {
                    D20AM.setBackground(Color.GREEN );
                    D20PM.setBackground(Color.GREEN );
                } else if (ct.getD20().equalsIgnoreCase("am")) {
                    D20AM.setBackground(Color.GREEN );
                    D20PM.setBackground(Color.RED);
                } else if (ct.getD20().equalsIgnoreCase("pm")) {
                    D20AM.setBackground(Color.RED);
                    D20PM.setBackground(Color.GREEN );
                } else {
                    D20AM.setBackground(Color.RED);
                    D20PM.setBackground(Color.RED);
                }
//d21
                if (ct.getD21().equalsIgnoreCase("VV") || ct.getD21().equalsIgnoreCase("c") || ct.getD21().equalsIgnoreCase("p")) {
                    D21AM.setBackground(Color.GREEN );
                    D21PM.setBackground(Color.GREEN );
                } else if (ct.getD21().equalsIgnoreCase("am")) {
                    D21AM.setBackground(Color.GREEN );
                    D21PM.setBackground(Color.RED);
                } else if (ct.getD21().equalsIgnoreCase("pm")) {
                    D21AM.setBackground(Color.RED);
                    D21PM.setBackground(Color.GREEN );
                } else {
                    D21AM.setBackground(Color.RED);
                    D21PM.setBackground(Color.RED);
                }
//d22
                if (ct.getD22().equalsIgnoreCase("VV") || ct.getD22().equalsIgnoreCase("c") || ct.getD22().equalsIgnoreCase("p")) {
                    D22AM.setBackground(Color.GREEN );
                    D22PM.setBackground(Color.GREEN );
                } else if (ct.getD22().equalsIgnoreCase("am")) {
                    D22AM.setBackground(Color.GREEN );
                    D22PM.setBackground(Color.RED);
                } else if (ct.getD22().equalsIgnoreCase("pm")) {
                    D22AM.setBackground(Color.RED);
                    D22PM.setBackground(Color.GREEN );
                } else {
                    D22AM.setBackground(Color.RED);
                    D22PM.setBackground(Color.RED);
                }
//d23
                if (ct.getD23().equalsIgnoreCase("VV") || ct.getD23().equalsIgnoreCase("c") || ct.getD23().equalsIgnoreCase("p")) {
                    D23AM.setBackground(Color.GREEN );
                    D23PM.setBackground(Color.GREEN );
                } else if (ct.getD23().equalsIgnoreCase("am")) {
                    D23AM.setBackground(Color.GREEN );
                    D23PM.setBackground(Color.RED);
                } else if (ct.getD2().equalsIgnoreCase("pm")) {
                    D23AM.setBackground(Color.RED);
                    D23PM.setBackground(Color.GREEN );
                } else {
                    D23AM.setBackground(Color.RED);
                    D23PM.setBackground(Color.RED);
                }
//d24
                if (ct.getD24().equalsIgnoreCase("VV") || ct.getD24().equalsIgnoreCase("c") || ct.getD24().equalsIgnoreCase("p")) {
                    D24AM.setBackground(Color.GREEN );
                    D24PM.setBackground(Color.GREEN );
                } else if (ct.getD24().equalsIgnoreCase("am")) {
                    D24AM.setBackground(Color.GREEN );
                    D24PM.setBackground(Color.RED);
                } else if (ct.getD2().equalsIgnoreCase("pm")) {
                    D24AM.setBackground(Color.RED);
                    D24PM.setBackground(Color.GREEN );
                } else {
                    D24AM.setBackground(Color.RED);
                    D24PM.setBackground(Color.RED);
                }
//d25
                if (ct.getD25().equalsIgnoreCase("VV") || ct.getD25().equalsIgnoreCase("c") || ct.getD25().equalsIgnoreCase("p")) {
                    D25AM.setBackground(Color.GREEN );
                    D25PM.setBackground(Color.GREEN );
                } else if (ct.getD25().equalsIgnoreCase("am")) {
                    D25AM.setBackground(Color.GREEN );
                    D25PM.setBackground(Color.RED);
                } else if (ct.getD25().equalsIgnoreCase("pm")) {
                    D25AM.setBackground(Color.RED);
                    D25PM.setBackground(Color.GREEN );
                } else {
                    D25AM.setBackground(Color.RED);
                    D25PM.setBackground(Color.RED);
                }
//d26
                if (ct.getD26().equalsIgnoreCase("VV") || ct.getD26().equalsIgnoreCase("c") || ct.getD26().equalsIgnoreCase("p")) {
                    D26AM.setBackground(Color.GREEN );
                    D26PM.setBackground(Color.GREEN );
                } else if (ct.getD26().equalsIgnoreCase("am")) {
                    D26AM.setBackground(Color.GREEN );
                    D26PM.setBackground(Color.RED);
                } else if (ct.getD26().equalsIgnoreCase("pm")) {
                    D26AM.setBackground(Color.RED);
                    D26PM.setBackground(Color.GREEN );
                } else {
                    D26AM.setBackground(Color.RED);
                    D26PM.setBackground(Color.RED);
                }
//d27
                if (ct.getD27().equalsIgnoreCase("VV") || ct.getD27().equalsIgnoreCase("c") || ct.getD27().equalsIgnoreCase("p")) {
                    D27AM.setBackground(Color.GREEN );
                    D27PM.setBackground(Color.GREEN );
                } else if (ct.getD27().equalsIgnoreCase("am")) {
                    D27AM.setBackground(Color.GREEN );
                    D27PM.setBackground(Color.RED);
                } else if (ct.getD27().equalsIgnoreCase("pm")) {
                    D27AM.setBackground(Color.RED);
                    D27PM.setBackground(Color.GREEN );
                } else {
                    D27AM.setBackground(Color.RED);
                    D27PM.setBackground(Color.RED);
                }
//d28
                if (ct.getD28().equalsIgnoreCase("VV") || ct.getD28().equalsIgnoreCase("c") || ct.getD28().equalsIgnoreCase("p")) {
                    D28AM.setBackground(Color.GREEN );
                    D28PM.setBackground(Color.GREEN );
                } else if (ct.getD28().equalsIgnoreCase("am")) {
                    D28AM.setBackground(Color.GREEN );
                    D28PM.setBackground(Color.RED);
                } else if (ct.getD28().equalsIgnoreCase("pm")) {
                    D28AM.setBackground(Color.RED);
                    D28PM.setBackground(Color.GREEN );
                } else {
                    D28AM.setBackground(Color.RED);
                    D28PM.setBackground(Color.RED);
                }
//d29
                if (ct.getD29().equalsIgnoreCase("VV") || ct.getD29().equalsIgnoreCase("c") || ct.getD29().equalsIgnoreCase("p")) {
                    D29AM.setBackground(Color.GREEN );
                    D29PM.setBackground(Color.GREEN );
                } else if (ct.getD29().equalsIgnoreCase("am")) {
                    D29AM.setBackground(Color.GREEN );
                    D29PM.setBackground(Color.RED);
                } else if (ct.getD29().equalsIgnoreCase("pm")) {
                    D29AM.setBackground(Color.RED);
                    D29PM.setBackground(Color.GREEN );
                } else {
                    D29AM.setBackground(Color.RED);
                    D29PM.setBackground(Color.RED);
                }
//d30
                if (ct.getD30().equalsIgnoreCase("VV") || ct.getD30().equalsIgnoreCase("c") || ct.getD30().equalsIgnoreCase("p")) {
                    D30AM.setBackground(Color.GREEN );
                    D30PM.setBackground(Color.GREEN );
                } else if (ct.getD30().equalsIgnoreCase("am")) {
                    D30AM.setBackground(Color.GREEN );
                    D30PM.setBackground(Color.RED);
                } else if (ct.getD30().equalsIgnoreCase("pm")) {
                    D30AM.setBackground(Color.RED);
                    D30PM.setBackground(Color.GREEN );
                } else {
                    D30AM.setBackground(Color.RED);
                    D30PM.setBackground(Color.RED);
                }
//d31
                if (ct.getD31().equalsIgnoreCase("VV") || ct.getD31().equalsIgnoreCase("c") || ct.getD31().equalsIgnoreCase("p")) {
                    D31AM.setBackground(Color.GREEN );
                    D31PM.setBackground(Color.GREEN );
                } else if (ct.getD31().equalsIgnoreCase("am")) {
                    D31AM.setBackground(Color.GREEN );
                    D31PM.setBackground(Color.RED);
                } else if (ct.getD31().equalsIgnoreCase("pm")) {
                    D31AM.setBackground(Color.RED);
                    D31PM.setBackground(Color.GREEN );
                } else {
                    D31AM.setBackground(Color.RED);
                    D31PM.setBackground(Color.RED);
                }
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel D10AM;
    private javax.swing.JLabel D10PM;
    private javax.swing.JLabel D11AM;
    private javax.swing.JLabel D11PM;
    private javax.swing.JLabel D12AM;
    private javax.swing.JLabel D12PM;
    private javax.swing.JLabel D13AM;
    private javax.swing.JLabel D13PM;
    private javax.swing.JLabel D14AM;
    private javax.swing.JLabel D14PM;
    private javax.swing.JLabel D15AM;
    private javax.swing.JLabel D15PM;
    private javax.swing.JLabel D16AM;
    private javax.swing.JLabel D16PM;
    private javax.swing.JLabel D17AM;
    private javax.swing.JLabel D17PM;
    private javax.swing.JLabel D18AM;
    private javax.swing.JLabel D18PM;
    private javax.swing.JLabel D19AM;
    private javax.swing.JLabel D19PM;
    private javax.swing.JLabel D1AM;
    private javax.swing.JLabel D1PM;
    private javax.swing.JLabel D20AM;
    private javax.swing.JLabel D20PM;
    private javax.swing.JLabel D21AM;
    private javax.swing.JLabel D21PM;
    private javax.swing.JLabel D22AM;
    private javax.swing.JLabel D22PM;
    private javax.swing.JLabel D23AM;
    private javax.swing.JLabel D23PM;
    private javax.swing.JLabel D24AM;
    private javax.swing.JLabel D24PM;
    private javax.swing.JLabel D25AM;
    private javax.swing.JLabel D25PM;
    private javax.swing.JLabel D26AM;
    private javax.swing.JLabel D26PM;
    private javax.swing.JLabel D27AM;
    private javax.swing.JLabel D27PM;
    private javax.swing.JLabel D28AM;
    private javax.swing.JLabel D28PM;
    private javax.swing.JLabel D29AM;
    private javax.swing.JLabel D29PM;
    private javax.swing.JLabel D2AM;
    private javax.swing.JLabel D2PM;
    private javax.swing.JLabel D30AM;
    private javax.swing.JLabel D30PM;
    private javax.swing.JLabel D31AM;
    private javax.swing.JLabel D31PM;
    private javax.swing.JLabel D3AM;
    private javax.swing.JLabel D3PM;
    private javax.swing.JLabel D4AM;
    private javax.swing.JLabel D4PM;
    private javax.swing.JLabel D5AM;
    private javax.swing.JLabel D5PM;
    private javax.swing.JLabel D6AM;
    private javax.swing.JLabel D6PM;
    private javax.swing.JLabel D7AM;
    private javax.swing.JLabel D7PM;
    private javax.swing.JLabel D8AM;
    private javax.swing.JLabel D8PM;
    private javax.swing.JLabel D9AM;
    private javax.swing.JLabel D9PM;
    private javax.swing.JButton first;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton last;
    private javax.swing.JButton next;
    private javax.swing.JLabel number;
    private javax.swing.JButton preview;
    private javax.swing.JTabbedPane tabs;
    // End of variables declaration//GEN-END:variables

}
