CREATE DATABASE DA1_FOURSHOES
GO
USE DA1_FOURSHOES
GO

CREATE TABLE KHACHHANG 
(
	ID varchar(10) NOT NULL PRIMARY KEY,
	TenKhachHang NVARCHAR(30) NOT NULL,
	SDT CHAR(10) NOT NULL,
	DiaChi NVARCHAR(100) NOT NULL
)
GO

CREATE TABLE DANGNHAP
(
	ID varchar(10) NOT NULL PRIMARY KEY,
	TaiKhoan NVARCHAR(20) NOT NULL,
	MatKhau NVARCHAR(20) NOT NULL,

)
go

CREATE TABLE NHANVIEN 
(
	ID varchar(10) NOT NULL PRIMARY KEY,
	HoTenNV NVARCHAR(30) NOT NULL,
	Email NVARCHAR(30) NOT NULL,
	TinhTrang BIT NOT NULL,
	VaiTro bit not null,
	IDDangNhap varchar(10) NOT NULL FOREIGN KEY REFERENCES DANGNHAP(ID)
)
GO


CREATE TABLE KHUYENMAI
(
	ID varchar(10) NOT NULL PRIMARY KEY,
	KMPhanTram FLOAT NOT NULL,
	KMTheoGia INT NOT NULL,
	NgayTao DATE,
	NguoiTao varchar(10) NOT NULL FOREIGN KEY REFERENCES NHANVIEN(ID)
)
GO

CREATE TABLE XUATXU
(
	ID varchar(10) PRIMARY KEY NOT NULL,
	TenXuatXu NVARCHAR(20) NOT NULL 
)

GO

CREATE TABLE MAUSAC
(
	ID varchar(10) PRIMARY KEY NOT NULL,
	TenMau NVARCHAR(20) NOT NULL 
)
GO

CREATE TABLE SIZE
(
	ID varchar(10) PRIMARY KEY NOT NULL,
	TenSize INT NOT NULL 
)
GO

CREATE TABLE Hang
(
	ID varchar(10) PRIMARY KEY NOT NULL,
	TenHang nvarchar(50) NOT NULL 
)
GO

CREATE TABLE SanPham
(
	ID varchar(10) PRIMARY KEY NOT NULL,
	TenSanPham NVARCHAR(50)NOT NULL,
	GiaTien FLOAT NOT NULL,
	TrangThai BIT,
	HinhAnh NVARCHAR(20),
	IDHang varchar(10) NOT NULL FOREIGN KEY REFERENCES Hang(ID),
	IDXuatXu varchar(10) NOT NULL FOREIGN KEY REFERENCES XUATXU(ID),
	IDMauSac varchar(10) NOT NULL FOREIGN KEY REFERENCES MAUSAC(ID),
	IDSize varchar(10) NOT NULL FOREIGN KEY REFERENCES SIZE(ID),
	MoTa NVARCHAR(MAX)
)

GO

CREATE TABLE DONHANG
(
	ID varchar(10) PRIMARY KEY NOT NULL,
	IDSanPham varchar(10) NOT NULL FOREIGN KEY REFERENCES SanPham(ID),
	SoLuong INT NOT NULL,
	IDKhuyenMai varchar(10) NOT NULL FOREIGN KEY REFERENCES KHUYENMAI(ID),
	
)
GO

CREATE TABLE HOADON 
(
	ID varchar(10) PRIMARY KEY NOT NULL,
	IDDonHang varchar(10) NOT NULL FOREIGN KEY REFERENCES DONHANG(ID),
	TongTien FLOAT NOT NULL
)
GO 

CREATE TABLE HOADONCHITIET 
(
	ID varchar(10) PRIMARY KEY NOT NULL,
	IDHoaDon varchar(10) NOT NULL FOREIGN KEY REFERENCES HOADON(ID),
	IDSanPham varchar(10) NOT NULL FOREIGN KEY REFERENCES SanPham(ID),
	IDKhachHang varchar(10) NULL FOREIGN KEY REFERENCES KHACHHANG(ID),
	IDNHanVien varchar(10) NOT NULL FOREIGN KEY REFERENCES NHANVIEN(ID),
	SoLuong INT NOT NULL,
	IDKhuyenMai varchar(10) NOT NULL FOREIGN KEY REFERENCES KHUYENMAI(ID),
	TongTien FLOAT NOT NULL
)

go

INSERT INTO XUATXU
                  (ID,TENXUATXU)
VALUES ('XX1',N'Mỹ'),
('XX2',N'Việt Nam'),
('XX3',N'Trung Quốc'),
('XX4',N'Nhật Bản')

INSERT INTO MAUSAC
                  (id,TENMAU)
VALUES ('M1',N'Xanh lam'),
	('M2',N'Đỏ'),
	('M3',N'Tím'),
	('M4',N'Vàng'),
	('M5',N'Xanh da trời'),
	('M6',N'đen'),
	('M7',N'trắng')

INSERT INTO SIZE
                  (id,TENSIZE)
VALUES ('SZ1',36),
	('SZ2',37),
	('SZ3',38),
	('SZ4',39),
	('SZ5',40),
	('SZ6',41),
	('SZ7',42)

Insert Into Hang (id, TenHang)
values ('H1','Gucci'),
('H2','Dior'),
('H3','Adidas'),
('H4','Jordan')

INSERT INTO SANPHAM
                  (ID, TenSanPham, GiaTien, TrangThai, HinhAnh, IDHang, IDXuatXu, IDMauSac, IDSize, MoTa)
VALUES ('SP1', N'Yordan nike', 500000, 1, N'abc.png', 'H1', 'XX2', 'M5', 'SZ4', N'dep trai'),
	('SP2', N'Gucci bẩn', 4500000, 1, N'abc1.png', 'H2', 'XX2', 'M7', 'SZ5', N'dep trai'),
	('SP3', N'Adidas thể thao', 600000, 1, N'abc2.png', 'H3', 'XX1', 'M5', 'SZ4', N'dep trai')


INSERT INTO DANGNHAP
                  (ID, MatKhau, TaiKhoan)
VALUES ('TK1', N'123123', N'tienbao'),
	('TK2', N'123456', N'pbkien'),
	('TK3', N'123789', N'vietanh')


INSERT INTO NHANVIEN
                  (ID, HoTenNV, Email, TinhTrang, IDDangNhap, vaitro)
VALUES ('NV1', N'Nguyễn Tiến Bảo', N'baont@fpt.edu.vn', 1, 'TK1', 1),
('NV2', N'Phùng Bá Kiên', N'kienpb@fpt.edu.vn', 0, 'TK1', 1),
('NV3', N'Nguyễn Tiến Bảo', N'baont@fpt.edu.vn', 1, 'TK1', 1)

INSERT INTO KHUYENMAI
                  (ID, KMPhanTram, KMTheoGia, NgayTao, NguoiTao)
VALUES ('KM1', 0.15, 0, GETDATE(), 'NV1'),
	('KM2', 0, 70000, GETDATE(), 'NV1'),
	('KM3', 0.2, 0, GETDATE(), 'NV1')

INSERT INTO HOADON
                  (ID, IDDonHang, TongTien)
VALUES ('HD1', 'DH2', 5500000),
	('HD2', 'DH1', 67500000),
	('HD3', 'DH3', 5400000)

	
INSERT INTO DONHANG
                  (ID, IDSanPham, SoLuong, IDKhuyenMai)
VALUES ('DH1', 'SP2', 15, 'KM1'),
	('DH2', 'SP1', 11, 'KM2'),
	('DH3', 'SP3', 9, 'KM1')

INSERT INTO KHACHHANG
                  (ID, TenKhachHang, SDT, DiaChi)
VALUES ('KH1', N'Trần Văn Hải', '0987123645', N'12 kiều mai'),
	('KH2', N'Nguyễn Thị Nhài', '0325235221', N'69 Cầu diễn')

INSERT INTO HOADONCHITIET
                  (ID, IDHoaDon, IDSanPham, IDKhachHang, IDNHanVien, SoLuong, IDKhuyenMai, TongTien)
VALUES ('HDCT1', 'HD3','SP3','KH1','NV1',9,'KM1',4590000),
	('HDCT2', 'HD2','SP1','KH2','NV1',11,'KM2',4675000),
	('HDCT3', 'HD1','SP2','KH1','NV2',15,'KM1',66450000)
	

	select * from DANGNHAP
	select * from DONHANG
	select * from HOADON
	select * from HOADONCHITIET
	select * from KHACHHANG
	select * from KHUYENMAI
	select * from MAUSAC
	select * from NHANVIEN
	select * from SanPham
	select * from SIZE
	select * from XUATXU








