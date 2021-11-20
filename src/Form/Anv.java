/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import DAO.DanhSachNhanSuDao;
import DAO.DieuChuyenNhanSuDAO;
import DAO.NhanVienDAO;
import DAO.NhanVienDAO1;
import DAO.PhongBanDAO;
import model.NXV;
import helper.DateHelper;
import helper.MsgBox;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import model.NhanVien;

/**
 *
 * @author viphn
 */
public class Anv extends javax.swing.JInternalFrame {

    List<NXV> lstA = new ArrayList<>();
    int index = 0;

    public Anv() {
        initComponents();
        load();
//        this.setStatus(true, vaitro);
        tblDSNS.setDefaultEditor(Object.class, null);
    }
    NhanVienDAO nvdao = new NhanVienDAO();
    NhanVienDAO1 nvdao1 = new NhanVienDAO1();
    PhongBanDAO pbdao = new PhongBanDAO();
    DieuChuyenNhanSuDAO dcnsdao = new DieuChuyenNhanSuDAO();
    DanhSachNhanSuDao dsdao = new DanhSachNhanSuDao();

    public void load() {
        DefaultTableModel model = (DefaultTableModel) tblDSNS.getModel();
        model.setRowCount(0);
        try {
            lstA = nvdao1.select();
            for (NXV dsns : lstA) {
                model.addRow(new Object[]{
                    dsns.getMaNV(),
                    dsns.getTenNV(),
                    dsns.getEmail(),
                    dsns.getSdt(),
                    dsns.getMaPB(),
                    dsns.getTinhTrangHonNhan(),
                    dsns.getDiaChi(),
                    DateHelper.toString(dsns.getNgaySinh(), "dd/MM/yyyy"),
                    dsns.getNoiSinh(),
                    dsns.getCMND(),
                    dsns.getSdt1(),
                    dsns.isGioiTinh() ? "Nam" : "Nữ",
                    dsns.getTrangThaiLamViec() ,
                    dsns.getAnh(),
                    dsns.getGhiChu()});
                
            }
        } catch (Exception e) {
            MsgBox.alert(this, "lỗi truy vấn dữ liệu.");
            e.printStackTrace();
        }
    }
//                public void setStatus(boolean insertalbe,boolean vaitro){
//        txtManv.setEditable(insertalbe);
//        btLuu.setEnabled(insertalbe);
//        btXoa.setEnabled(!insertalbe && vaitro);
//        
//        boolean first=this.index >0;
//        boolean last=this.index <tblDSNS.getRowCount()-1;
//        btFirst.setEnabled(!insertalbe && first);
//        btNext.setEnabled(!insertalbe && first);
//        btNext.setEnabled(!insertalbe && last);
//        btLast.setEnabled(!insertalbe && last);
//    }

    NXV getModel() {
        NXV model = new NXV();
        model.setMaNV(txtManv.getText());
        model.setTenNV(txtTennv.getText());
        model.setEmail(txtEmail.getText());
        model.setSdt(txtSDT.getText());
        model.setDiaChi(txtDiachi.getText());
        model.setNgaySinh(DateHelper.toDate(txtNgaySinh.getText()));
        model.setNoiSinh(txtNoiSinh.getText());
        model.setCMND(txtCMND.getText());
        model.setSdt1(txtSDT1.getText());
        model.setGioiTinh(Boolean.valueOf(rdNam.getText()));
        model.setGhiChu(taGhichu.getText());
        model.setAnh(lbAnh.getToolTipText());
        return model;
    }

    public void setModel(NXV na) {
        txtManv.setText(na.getMaNV());
        txtTennv.setText(na.getTenNV());
        txtDiachi.setText(na.getDiaChi());
        txtSDT.setText(na.getSdt());
        txtNgaySinh.setText(DateHelper.toString(na.getNgaySinh(), "dd/MM/YYYY"));
        txtNoiSinh.setText(na.getNoiSinh());
        txtCMND.setText(na.getCMND());
        txtSDT1.setText(na.getSdt1());
        if (na.isGioiTinh()) {
            rdNam.setSelected(true);
        } else {
            rdNu.setSelected(true);
        }
        txtEmail.setText(na.getEmail());
        cbTTHN.setSelectedItem(na.getTinhTrangHonNhan());
        CBTTLV.setSelectedItem(na.getTrangThaiLamViec());
        taGhichu.setText(na.getGhiChu());
        if (na.getAnh() != null) {
            lbAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/" + na.getAnh())));
        }
    }

    public void edit() {
        try {
            String manv = (String) tblDSNS.getValueAt(this.index, 0);
            NXV na = nvdao1.findById(manv);
            if (na != null) {
                this.setModel(na);
                //  this.setStatus(false, vaitro);
            }
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu");
        }
    }

    public void updateA() {
        NXV model = this.getModel();
        try {
            nvdao1.update(model);
            this.load();
            MsgBox.alert(this, "Sửa thành công");
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Sửa thất bại");
        }

    }

    private void insertTTNV() {
        NXV model = getModel();

        try {
            nvdao1.insert(model);
            this.clear();
            load();
            MsgBox.alert(this, "Thêm mới thành công");

        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Thêm mới thất bại");
        }
    }

    public void clear() {
        txtManv.setText("");
        txtTennv.setText("");
        txtDiachi.setText("");
        txtSDT.setText("");
        txtNgaySinh.setText("");
        txtNoiSinh.setText("");
        txtCMND.setText("");
        txtSDT1.setText("");
        taGhichu.setText("");
        txtEmail.setText("");
    }
    public void delete(){ //do csdl vs hopdong
                if(MsgBox.comfirm(this, "Bạn thật sự muốn xóa Chuyên đề này")){
            try {
                nvdao1.delete(txtManv.getText());
                this.load();
                this.clear();
                MsgBox.alert(this, "Xóa thành công");
            } catch (Exception e) {
                e.printStackTrace();
                MsgBox.alert(this, "Xóa thất bại");
            }
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
        jPanel1 = new javax.swing.JPanel();
        txtNgaySinh = new javax.swing.JTextField();
        txtNoiSinh = new javax.swing.JTextField();
        rdNu = new javax.swing.JRadioButton();
        txtCMND = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtSDT1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        cbTTHN = new javax.swing.JComboBox<>();
        btAnh = new javax.swing.JButton();
        CBTTLV = new javax.swing.JComboBox<>();
        btUpdate = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        lbAnh = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taGhichu = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btFirst = new javax.swing.JButton();
        btPrev = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btNext = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btLast = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lbstt = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btLuu = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        btClear = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        btXoa = new javax.swing.JButton();
        txtManv = new javax.swing.JTextField();
        btDSNV = new javax.swing.JButton();
        txtTennv = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtDiachi = new javax.swing.JTextField();
        rdNam = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDSNS = new javax.swing.JTable();

        txtNgaySinh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtNoiSinh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        rdNu.setText("Nữ");
        rdNu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtCMND.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel13.setText("Tình trạng hôn nhân");

        txtSDT1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel14.setText("Trạng thái làm việc");

        txtEmail.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cbTTHN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã kết hôn", "Chưa kết hôn" }));
        cbTTHN.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btAnh.setText("Chọn ảnh");
        btAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAnhActionPerformed(evt);
            }
        });

        CBTTLV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang làm việc", "Chưa làm việc" }));
        CBTTLV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btUpdate.setText("Update");
        btUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateActionPerformed(evt);
            }
        });

        jLabel15.setText("Ảnh hồ sơ");

        lbAnh.setBackground(new java.awt.Color(255, 255, 255));
        lbAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAnh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbAnh.setOpaque(true);
        lbAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbAnhMouseClicked(evt);
            }
        });

        jLabel17.setText("Ghi chú");

        jLabel1.setText("Mã nhân viên");

        taGhichu.setColumns(20);
        taGhichu.setRows(5);
        jScrollPane1.setViewportView(taGhichu);

        jLabel2.setText("Tên nhân viên");

        jLabel3.setText("Địa chỉ");

        jLabel4.setText("Số điện thoại");

        btFirst.setText("|<");
        btFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFirstActionPerformed(evt);
            }
        });

        btPrev.setText("<<");
        btPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPrevActionPerformed(evt);
            }
        });

        jLabel5.setText("Ngày sinh");

        btNext.setText(">>");
        btNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNextActionPerformed(evt);
            }
        });

        jLabel6.setText("Nơi sinh");

        btLast.setText(">|");
        btLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLastActionPerformed(evt);
            }
        });

        jLabel7.setText("Giới tính");

        lbstt.setText("STT: 1/???");

        jLabel8.setText("Email");

        btLuu.setText("Lưu");
        btLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLuuActionPerformed(evt);
            }
        });

        jLabel10.setText("CMND");

        btClear.setText("Clear");
        btClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClearActionPerformed(evt);
            }
        });

        jLabel11.setText("SĐT Khác");

        btXoa.setText("Xóa");
        btXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaActionPerformed(evt);
            }
        });

        txtManv.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btDSNV.setText("Danh Sách Nhân Viên");
        btDSNV.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btDSNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDSNVActionPerformed(evt);
            }
        });

        txtTennv.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtSDT.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtDiachi.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        rdNam.setSelected(true);
        rdNam.setText("Nam");
        rdNam.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNoiSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtSDT)
                                .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCMND)
                                .addComponent(txtSDT1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdNam)
                                .addGap(30, 30, 30)
                                .addComponent(rdNu))
                            .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel15)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btAnh))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtManv)
                            .addComponent(txtTennv, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
                        .addGap(146, 146, 146)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbTTHN, 0, 177, Short.MAX_VALUE)
                            .addComponent(CBTTLV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(36, 36, 36))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btLuu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btClear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btXoa)
                                .addGap(81, 81, 81))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btUpdate)
                                .addGap(156, 156, 156)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btDSNV, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbstt)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(315, 315, 315)
                        .addComponent(btFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(btPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(btNext, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addComponent(btLast, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtManv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(cbTTHN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTennv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(CBTTLV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNoiSinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSDT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(rdNam)
                            .addComponent(rdNu))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(43, 43, 43)
                            .addComponent(jLabel17)
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btFirst)
                        .addComponent(btPrev)
                        .addComponent(btLast)
                        .addComponent(btNext))
                    .addComponent(btAnh))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btLuu)
                            .addComponent(btClear)
                            .addComponent(btXoa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btUpdate))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbstt)
                        .addGap(18, 18, 18)
                        .addComponent(btDSNV, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        tabs.addTab("tab1", jPanel1);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 0, 204));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("DANH SÁCH NHÂN SỰ");

        tblDSNS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Nhân Viên", "Họ Tên", "Email", "SDT", "Phòng Ban", "Tình Trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSNS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSNSMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDSNS);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(464, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabs.addTab("tab2", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabs)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAnhActionPerformed
        JFileChooser chon = new JFileChooser();
if(chon.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
    File file = chon.getSelectedFile();
    if(helper.Auth.saveLogo(file)){
        lbAnh.setIcon(helper.Auth.readLogo(file.getName()));
        lbAnh.setToolTipText(file.getName());
    }
}
        //        chon.setFileFilter(new FileNameExtensionFilter("Nhận các đuôi JPG,PNG", "jpg","png"));
//        int chonanh = chon.showOpenDialog(this);
//        if (chonanh == JFileChooser.APPROVE_OPTION) {
//            File file = chon.getSelectedFile();
//            lbAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/" + file.getName())));
//        }
    }//GEN-LAST:event_btAnhActionPerformed

    private void btUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateActionPerformed
        this.updateA();
    }//GEN-LAST:event_btUpdateActionPerformed

    private void lbAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAnhMouseClicked
        JFileChooser chon = new JFileChooser();

        //        chon.setFileFilter(new FileNameExtensionFilter("Nhận các đuôi JPG,PNG", "jpg","png"));
        int chonanh = chon.showOpenDialog(this);
        if (chonanh == JFileChooser.APPROVE_OPTION) {
            File file = chon.getSelectedFile();
            lbAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/" + file.getName())));
        }
    }//GEN-LAST:event_lbAnhMouseClicked

    private void btFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFirstActionPerformed
        index = 0;
        this.edit();
    }//GEN-LAST:event_btFirstActionPerformed

    private void btPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPrevActionPerformed
        index--;
        this.edit();
    }//GEN-LAST:event_btPrevActionPerformed

    private void btNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNextActionPerformed
        index++;
        this.edit();
    }//GEN-LAST:event_btNextActionPerformed

    private void btLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLastActionPerformed
        index = lstA.size() - 1;
        this.edit();
    }//GEN-LAST:event_btLastActionPerformed

    private void btLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLuuActionPerformed
        this.insertTTNV();
    }//GEN-LAST:event_btLuuActionPerformed

    private void btClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClearActionPerformed
        this.clear();
    }//GEN-LAST:event_btClearActionPerformed

    private void btXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaActionPerformed
        this.delete();
    }//GEN-LAST:event_btXoaActionPerformed

    private void btDSNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDSNVActionPerformed
        new DANHSACHNHANSU().setVisible(true);
    }//GEN-LAST:event_btDSNVActionPerformed

    private void tblDSNSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSNSMouseClicked
                if(evt.getClickCount()==2){
            this.index=tblDSNS.rowAtPoint(evt.getPoint());
            if(this.index>=0){
                this.edit();
                tabs.setSelectedIndex(0);
            }
        }
    }//GEN-LAST:event_tblDSNSMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBTTLV;
    private javax.swing.JButton btAnh;
    private javax.swing.JButton btClear;
    private javax.swing.JButton btDSNV;
    private javax.swing.JButton btFirst;
    private javax.swing.JButton btLast;
    private javax.swing.JButton btLuu;
    private javax.swing.JButton btNext;
    private javax.swing.JButton btPrev;
    private javax.swing.JButton btUpdate;
    private javax.swing.JButton btXoa;
    private javax.swing.JComboBox<String> cbTTHN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbAnh;
    private javax.swing.JLabel lbstt;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JTextArea taGhichu;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblDSNS;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtDiachi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtManv;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtNoiSinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSDT1;
    private javax.swing.JTextField txtTennv;
    // End of variables declaration//GEN-END:variables
}
