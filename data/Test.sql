Create database Test

use Test

CREATE TABLE XUATXU
(
	ID varchar(10) NOT NULL,
	TenXuatXu NVARCHAR(20) NOT NULL 
	PRIMARY KEY ( ID, TenXuatXu)
)

GO

CREATE TABLE MAUSAC
(
	ID varchar(10)NOT NULL,
	TenMau NVARCHAR(20) NOT NULL 
	PRIMARY KEY ( ID, TenMau)
)
GO

CREATE TABLE SIZE
(
	ID varchar(10) NOT NULL,
	TenSize INT NOT NULL 
	PRIMARY KEY ( ID, TenSize)
)
GO

CREATE TABLE Hang
(
	ID varchar(10) NOT NULL,
	TenHang nvarchar(20) NOT NULL 
	PRIMARY KEY ( ID, TenHang)
)
GO

CREATE TABLE SanPham
(
	ID varchar(10) PRIMARY KEY NOT NULL,
	TenSanPham NVARCHAR(50)NOT NULL,
	GiaTien FLOAT NOT NULL,
	TrangThai BIT,
	HinhAnh NVARCHAR(20),
	IDHang nvarchar(20) NOT NULL,
	IDXuatXu nvarchar(20) NOT NULL,
	IDMauSac nvarchar(20) NOT NULL,
	IDSize int NOT NULL,
	MoTa NVARCHAR(MAX)
)

GO

INSERT INTO XUATXU
                  (ID,TENXUATXU)
VALUES ('XX1',N'M?'),
('XX2',N'Vi?t Nam'),
('XX3',N'Trung Qu?c'),
('XX4',N'Nh?t B?n')

INSERT INTO MAUSAC
                  (id,TENMAU)
VALUES ('M1',N'Xanh lam'),
	('M2',N'??'),
	('M3',N'Tím'),
	('M4',N'Vàng'),
	('M5',N'Xanh da tr?i'),
	('M6',N'?en'),
	('M7',N'tr?ng')

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