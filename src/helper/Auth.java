/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
import model.NhanVien;



/**
 *
 * @author LENOVO
 */
public class Auth {
public static boolean saveLogo(File file) {
        File dir = new File("logos");
        // Tạo thư mục nếu chưa tồn tại
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File newFile = new File(dir, file.getName());
        try {
            // Copy vào thư mục logos (đè nếu đã tồn tại)
            Path source = Paths.get(file.getAbsolutePath());
            Path destination = Paths.get(newFile.getAbsolutePath());
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    /*
     * Đọc hình ảnh logo chuyên đề
     *
     * @param fileName là tên file logo
     * @return ảnh đọc được
     */
    public static ImageIcon readLogo(String fileName) {
        File path = new File("logos", fileName);
        return new ImageIcon(path.getAbsolutePath());
    }

    /*
 * Đối tượng này chứa thông tin người sử dụng sau khi đăng nhập
     */
    public static NhanVien NV;

    /*
 * Xóa thông tin của người sử dụng khi có yêu cầu đăng xuất
     */
    public static void logoff() {
        Auth.NV = null;
    }

    /*
 * Kiểm tra xem đăng nhập hay chưa
 * @return đăng nhập hay chưa
     */
    public static boolean authenticated() {
        return Auth.NV != null;
    }

//    public boolean vaiTro() {
//        boolean vt = Auth.NV.getVaiTro();
//        if (!vt) {
//            return false;
//        } else {
//            return true;
//        }
//    }
    public static NhanVien user = null;

    public static void clear() {
        Auth.user = null;
    }

    public static boolean isLogin() {
        return Auth.user != null;
    }

    public static boolean isManager() {
        return Auth.isLogin() && user.isChucVu();
    }
}
