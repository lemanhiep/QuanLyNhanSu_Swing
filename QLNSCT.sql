CREATE DATABASE QLNSCT
GO
USE QLNSCT
GO

CREATE TABLE PhongBan(
MaPB nvarchar(50) not null,
TenPB nvarchar(50) not null,
PRIMARY KEY(MaPB)
)
GO
CREATE TABLE NHANVIEN(
MaNV nvarchar(50) not null,
MaPB nvarchar(50) not null,
MatKhau nvarchar(50) NOT NULL,
HoTen nvarchar(50) NOT NULL,
ĐiaChi nvarchar(150) not null,
SDT nvarchar(15) not null,
NgaySinh Date not null,
NoiSinh nvarchar(150) not null,
CMND nvarchar(15) not null,
GioiTinh bit NOT NULL DEFAULT 0,
Emai nvarchar(100) not null ,
TinhTrangHonNhan int not null,
TrangThaiLamViec int not null,
SDTKhac nvarchar(10) ,
Anh nvarchar(50) not null,
GhiChu nvarchar(225),
ChucVu bit NOT NULL DEFAULT 0,
PRIMARY KEY(MaNV),
FOREIGN KEY (MaPB) REFERENCES PhongBan(MaPB)ON UPDATE CASCADE

)
GO
CREATE TABLE HOPDONG(
MaHD nvarchar(50) not null,
NgayKy Date not null,
HoTen nvarchar(50)not null,
LoaiHopDong int not null,
NgayBatDau Date not null,
NgayKetThuc Date not null,
ThuViecTu Date not null,
ThuViecDen Date not null,
ChucVu int not null,
CongViecLam nvarchar(500) not null,
DungCu nvarchar(225) ,
TrinhDo nvarchar (50) null,
MaNV nvarchar(50) not null, 
PRIMARY KEY(MaHD),
FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV)ON UPDATE CASCADE

)
GO
CREATE TABLE NGUOIXINVIEC(
MaNXV nvarchar(50) not null,
TenNXV nvarchar(50) not null,
ĐiaChi nvarchar(150) not null,
SDT nvarchar(10) not null,
NgaySinh Date not null,
NoiSinh nvarchar(150) not null,
CMND nvarchar(15) not null,
GioiTinh bit NOT NULL DEFAULT 0,
Emai nvarchar(100) not null ,
TinhTrangHonNhan int not null,
TrangThaiLamViec int not null,
SDTKhac nvarchar(10) ,
Anh nvarchar(50) not null,
GhiChu nvarchar(225)
)
GO
CREATE TABLE DONNGHIPHEP(
MaNghiPhep int IDENTITY(1,1) NOT NULL,
MaNV nvarchar(50)not null,
PhongBan nvarchar(50) not null,
NgayXinNghi Date not null,
Loai nvarchar(150) not null,
PRIMARY KEY(MaNghiPhep),
FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV)
)
GO
CREATE TABLE CHAMCONG(
MACHAMCONG int IDENTITY(1,1) NOT NULL,
MaNV nvarchar(50)not null,
Thang int not null,
Nam int not null,
D1 int not null,
D2 int not null,
D3 int not null,
D4 int not null,
D5 int not null,
D6 int not null,
D7 int not null,
D8 int not null,
D9 int not null,
D10 int not null,
D11 int not null,
D12 int not null,
D13 int not null,
D14 int not null,
D15 int not null,
D16 int not null,
D17 int not null,
D18 int not null,
D19 int not null,
D20 int not null,
D21 int not null,
D22 int not null,
D23 int not null,
D24 int not null,
D25 int not null,
D26 int not null,
D27 int not null,
D28 int not null,
D29 int not null,
D30 int not null,
D31 int not null,
PRIMARY KEY(MACHAMCONG),
FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV)
)
GO
CREATE TABLE THANNHAN(
MaTN int IDENTITY(1,1) NOT NULL,
HoTenBo nvarchar(50) not null,
TuoiBo INT not null,
NgheNghiepBo nvarchar(50) not null,
HoTenMe nvarchar(50)not null,
TuoiMe INT not null,
NgheNghiepMe nvarchar(50) not null,
HoTenACE nvarchar(50),
TuoiACE INT ,
NgheNghiepACE nvarchar(50) ,
HoTenOB nvarchar(50) ,
TuoiOB INT,
NgheNghiepOB nvarchar(50) ,
MaNV nvarchar(50) , 
PRIMARY KEY(MaTN),
FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV)ON UPDATE CASCADE
)
GO

CREATE TABLE DieuChuyenNhanSu(
MaDC int IDENTITY(1,1) NOT NULL,
MaNV nvarchar(50) not null,
MaPB1 nvarchar(50)not null,
ChucVu1 int not null,
NgayDieuChuyen Date not null,
ThoiGianBatDau1 Date not null,
ThoiGianLamViec Date not null,
DonViTruocDo nvarchar(50) not null,
MaPB2 nvarchar(50) not null,
ThoiGianBatDau2 Date not null,
ChucVu2 int not null,
TienNhiem nvarchar(50)
PRIMARY KEY(MaDC),
FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV)
)
GO
CREATE TABLE BaoHiem(
MaBH int IDENTITY(1,1) NOT NULL,
MaNV nvarchar(50) not null,
LoaiBaoHiem int not null,
SoTien float NOT NULL DEFAULT 0,
PRIMARY KEY(MaBH),
FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV)ON UPDATE CASCADE
)
GO
CREATE TABLE NGHIPHEP(
MANGHIPHEP int IDENTITY(1,1) NOT NULL,
MaNV nvarchar(50)not null,
Nam int not null,
D1 int not null,
D2 int not null,
D3 int not null,
D4 int not null,
D5 int not null,
D6 int not null,
D7 int not null,
D8 int not null,
D9 int not null,
D10 int not null,
D11 int not null,
D12 int not null,
PRIMARY KEY(MANGHIPHEP),
FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV)
)
GO
INSERT INTO PhongBan VALUES('A001','P201');
INSERT INTO PhongBan VALUES('A002','P202');
INSERT INTO PhongBan VALUES('A003','P203');
INSERT INTO PhongBan VALUES('A004','P204');
INSERT INTO PhongBan VALUES('A005','P205');

INSERT INTO NHANVIEN VALUES('B001','A001','12345',N'Trịnh Đình Phong',N'Quận Hoàng Mai,Hà Nội','0919234543','2/3/1995',N'Hà Nội','1123239874630',1,N'phongtd@gmail.com',1,2,'0192324973','anh1.jpg',N'Nhân viên hạng A',1);
INSERT INTO NHANVIEN VALUES('B002','A002','12345',N'Trịnh Thuần Minh',N'Quận Đống Đa,Hà Nội','0919234543','2/7/1990',N'Lạng Sơn','1123239874630',1,N'minhtt@gmail.com',1,2,'0192324932','anh2.jpg',N'Nhân viên hạng A',1);
INSERT INTO NHANVIEN VALUES('B003','A003','12345',N'Mai Mỹ Tâm',N'Quận Hoàng Mai,Hà Nội','0919234543','1/1/2000',N'Đà Nẵng','1123239874633',1,N'tammm@gmail.com',1,2,'0321324973','anh3.jpg',N'Nhân viên hạng A',0);
INSERT INTO NHANVIEN VALUES('B004','A004','12345',N'Cố Đình Phong',N'Quận 2,Hải Dương','0919234543','5/4/1992',N'Khánh Hòa','3029339874630',1,N'phongcd@gmail.com',1,2,'0998324973','anh4.jpg',N'Nhân viên hạng A',1);
INSERT INTO NHANVIEN VALUES('B005','A005','12345',N'Lưu Ly Kiếm',N'Quận Hoàng Mai,Hà Nội','0919234543','3/2/1999',N'Thanh Hóa','2132239874630',1,N'kiemll@gmail.com',1,2,'0192324932','anh5.jpg',N'Nhân viên hạng A',0);

INSERT INTO HOPDONG VALUES('C001','2/2/2020',N'Trịnh Đình Phong',2,'3/2/2020','3/2/2023','3/2/2020','3/3/2020',1,N'thực hiện dự án',N'máy tính',N'Đại Học','B001');
INSERT INTO HOPDONG VALUES('C002','2/2/2020',N'Trịnh Thuẩn Minh',2,'3/2/2020','3/2/2023','3/2/2020','3/3/2020',1,N'thực hiện dự án',N'máy tính',N'Cao Đẳng','B002');
INSERT INTO HOPDONG VALUES('C003','2/2/2020',N'Mai Mỹ Tâm',2,'3/2/2020','3/2/2023','3/2/2020','3/3/2020',1,N'thực hiện dự án',N'máy tính',N'Đại Học','B003');
INSERT INTO HOPDONG VALUES('C004','2/2/2020',N'Cố Đình Phong',2,'3/2/2020','3/2/2023','3/2/2020','3/3/2020',1,N'thực hiện dự án',N'máy tính',N'Cao Đẳng','B004');
INSERT INTO HOPDONG VALUES('C005','2/2/2020',N'Lưu Ly Kiếm',2,'3/2/2020','3/2/2023','3/2/2020','3/3/2020',1,N'thực hiện dự án',N'máy tính',N'Đại Học','B005');

INSERT INTO DONNGHIPHEP VALUES('B001','A001','7/5/2020',N'Có Phép');
INSERT INTO DONNGHIPHEP VALUES('B002','A002','1/10/2020',N'Không Phép');
INSERT INTO DONNGHIPHEP VALUES('B003','A003','10/10/2020',N'Có Phép');
INSERT INTO DONNGHIPHEP VALUES('B004','A004','7/5/2020',N'Có Phép');
INSERT INTO DONNGHIPHEP VALUES('B005','A005','5/5/2020',N'Có Phép');

INSERT INTO CHAMCONG VALUES('B001',2,2020,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
INSERT INTO CHAMCONG VALUES('B002',2,2020,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
INSERT INTO CHAMCONG VALUES('B003',2,2020,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
INSERT INTO CHAMCONG VALUES('B004',2,2020,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);
INSERT INTO CHAMCONG VALUES('B005',2,2020,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);

INSERT INTO THANNHAN VALUES(N'Nguyễn Quang Khải',37,N'Nông dân',N'Nguyễn Thị Hoa',35,N'Nông dân',null,null,null,null,null,null,'B001');
INSERT INTO THANNHAN VALUES(N'Nguyễn Chí Tài',37,N'Bác Sĩ',N'Nguyễn Thị Linh ',35,N'Nội trợ',null,null,null,null,null,null,'B002');
INSERT INTO THANNHAN VALUES(N'Nguyễn Quang Vũ',40,N'Nông dân',N'Lâm Thị Dạ',35,N'Nông dân',null,null,null,null,null,null,'B003');
INSERT INTO THANNHAN VALUES(N'Nguyễn Văn Lam',32,N'Nông dân',N'Nguyễn Thị Hi',35,N'Nông dân',null,null,null,null,null,null,'B004');
INSERT INTO THANNHAN VALUES(N'Phạm Đình Vũ',37,N'Nông dân',N'Nguyễn Thị Kiều',35,N'Nông dân',null,null,null,null,null,null,'B005');

INSERT INTO DieuChuyenNhanSu  VALUES('B001','A001',1,'2/11/2020','2/3/2020','1/11/2020','A001','A002','4/11/2020',1,'A001');

INSERT INTO BaoHiem VALUES('B001',1,20000000000000);
INSERT INTO BaoHiem VALUES('B002',0,90000000000000);
INSERT INTO BaoHiem VALUES('B003',1,20000000000000);
INSERT INTO BaoHiem VALUES('B004',1,20000000000000);
INSERT INTO BaoHiem VALUES('B005',1,20000000000000);

INSERT INTO NGHIPHEP VALUES('B001',2020,0,0,1,0,0,0,2,0,0,0,0,2);
INSERT INTO NGHIPHEP VALUES('B002',2020,0,0,0,0,0,1,1,0,0,0,0,2);
INSERT INTO NGHIPHEP VALUES('B003',2020,0,0,1,0,0,0,2,0,0,0,0,2);
INSERT INTO NGHIPHEP VALUES('B004',2020,0,0,0,0,0,0,1,0,0,0,0,2);
INSERT INTO NGHIPHEP VALUES('B005',2020,0,0,0,0,0,1,0,0,0,0,1,0);

select * from THANNHAN