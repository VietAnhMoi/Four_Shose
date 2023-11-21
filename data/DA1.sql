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


CREATE TABLE NHANVIEN 
(
	ID varchar(10) NOT NULL PRIMARY KEY,
	HoTenNV NVARCHAR(30) NOT NULL,
	Email NVARCHAR(30) NOT NULL,
	Matkhau varchar(30) not null,
	TinhTrang BIT NOT NULL,
	VaiTro bit not null,
)
GO


CREATE TABLE KHUYENMAI
(
	ID varchar(10) NOT NULL PRIMARY KEY,
	KMPhanTram FLOAT NOT NULL,
	KMTheoGia INT NOT NULL,
	NgayTao DATE not null,
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
	SoLuong int not null,
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
	SoLuong INT NOT NULL,
	TongGiaTri float not null,
	IDKhuyenMai varchar(10) NOT NULL FOREIGN KEY REFERENCES KHUYENMAI(ID),	
)
GO

CREATE TABLE CHITIETDONHANG
(
	ID varchar(10) primary key not null,
	IDDonHang varchar(10) not null FOREIGN KEY REFERENCES DonHang(ID),
	SoLuong int not null,
	GiaBan float not null,
	ThanhTien float not null,
	IDSanPham varchar(10) NOT NULL FOREIGN KEY REFERENCES SanPham(ID),
	IDKhuyenMai varchar(10) null FOREIGN KEY REFERENCES KHUYENMAI(ID),	
)

CREATE TABLE HOADON 
(
	ID varchar(10) PRIMARY KEY NOT NULL,
	TrangThai bit not null,
	NgayLap date not null,
	IDDonHang varchar(10) NOT NULL FOREIGN KEY REFERENCES DONHANG(ID),
	TongTien FLOAT NOT NULL
)
GO 

CREATE TABLE CHITIETHOADON
(
	ID varchar(10) PRIMARY KEY NOT NULL,
	IDHoaDon varchar(10) NOT NULL FOREIGN KEY REFERENCES HOADON(ID),
	IDSanPham varchar(10) NOT NULL FOREIGN KEY REFERENCES SanPham(ID),
	IDKhachHang varchar(10) NULL FOREIGN KEY REFERENCES KHACHHANG(ID),
	IDNHanVien varchar(10) NOT NULL FOREIGN KEY REFERENCES NHANVIEN(ID),
	SoLuong INT NOT NULL,
	IDKhuyenMai varchar(10) NULL FOREIGN KEY REFERENCES KHUYENMAI(ID),
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

INSERT INTO NHANVIEN
                  (ID, HoTenNV, Email, TinhTrang, Matkhau, vaitro)
VALUES ('NV1', N'Nguyễn Tiến Bảo', N'baont@fpt.edu.vn', 1, '123', 1),
('NV2', N'Phùng Bá Kiên', N'kienpb@fpt.edu.vn', 0, '123456', 1),
('NV3', N'Nguyễn Tiến Bảo', N'baont@fpt.edu.vn', 1, '1230', 1)

INSERT INTO KHUYENMAI
                  (ID, KMPhanTram, KMTheoGia, NgayTao, NguoiTao)
VALUES ('KM1', 0.15, 0, GETDATE(), 'NV1'),
	('KM2', 0, 70000, GETDATE(), 'NV1'),
	('KM3', 0.2, 0, GETDATE(), 'NV1')

INSERT INTO SANPHAM
                  (ID, TenSanPham, GiaTien, TrangThai, HinhAnh, IDHang, IDXuatXu, IDMauSac, IDSize, MoTa,soluong)
VALUES ('SP1', N'Yordan nike', 500000, 1, N'abc.png', 'H1', 'XX2', 'M5', 'SZ4', N'dep trai',5),
	('SP2', N'Gucci bẩn', 4500000, 1, N'abc1.png', 'H2', 'XX2', 'M7', 'SZ5', N'dep trai',7),
	('SP3', N'Adidas thể thao', 600000, 1, N'abc2.png', 'H3', 'XX1', 'M5', 'SZ4', N'dep trai',2)

INSERT INTO DONHANG
                  (ID, SoLuong, TongGiaTri, IDKhuyenMai)
	VALUES ('DH1', 10, 10000000, 'KM1'),
	('DH2', 7, 7000000, 'KM1'),
	('DH3', 5, 5000000, 'KM2')

INSERT INTO HOADON
                  (ID, TrangThai, NgayLap, IDDonHang, TongTien)
VALUES ('HD1', 1, CONVERT(DATETIME, '2023-11-19 00:00:00', 102), 'DH1',9124124),
	('HD2', 0, CONVERT(DATETIME, '2023-11-12 00:00:00', 102), 'DH2',1284124),
	('HD3', 0, CONVERT(DATETIME, '2023-10-16 00:00:00', 102), 'DH3',1241244)

INSERT INTO KHACHHANG
                  (ID, TenKhachHang, SDT, DiaChi)
VALUES ('KH1', N'Trần Văn Hải', '0987123645', N'12 kiều mai'),
	('KH2', N'Nguyễn Thị Nhài', '0325235221', N'69 Cầu diễn')

INSERT INTO CHITIETDONHANG
                  (ID, IDDonHang, SoLuong, GiaBan, ThanhTien, IDSanPham, IDKhuyenMai)
VALUES ('CTDH1', 'DH1', 10, 1000000, 10000000, 'SP1', 'KM2'),
	('CTDH2', 'DH2', 5, 1000000, 5000000, 'SP2', 'KM2'),
	('CTDH3', 'DH1', 2, 1000000, 2000000, 'SP1', 'KM2')

INSERT INTO CHITIETHOADON
                  (ID, IDHoaDon, IDSanPham, IDKhachHang, IDNHanVien, SoLuong, IDKhuyenMai, TongTien)
VALUES ('CTHD1', 'HD1', 'SP1', 'KH1', 'NV1', 10, 'KM1', 10000000),
	('CTHD2', 'HD2', 'SP1', 'KH2', 'NV1', 2, 'KM2', 2000000),
	('CTHD3', 'HD3', 'SP3',null, 'NV2', 5, 'KM1', 5000000)


	
	select * from DONHANG
	select * from HOADON
	select * from SanPham
	select *from CHITIETDONHANG
	select * from KHACHHANG
	select * from KHUYENMAI
	select * from MAUSAC
	select * from NHANVIEN
	select * from SIZE
	select * from XUATXU
	select *from CHITIETHOADON








