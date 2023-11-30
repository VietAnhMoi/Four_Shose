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
	ID int identity(1,1) PRIMARY KEY NOT NULL,
	SoLuong INT NOT NULL,
	TongGiaTri float not null,
	IDKhuyenMai varchar(10) null FOREIGN KEY REFERENCES Khuyenmai(ID),
)

GO

CREATE TABLE CHITIETDONHANG
(
	ID int identity(1,1) primary key not null,
	IDDonHang int null FOREIGN KEY REFERENCES DonHang(ID),
	SoLuong int not null,
	GiaBan float not null,
	ThanhTien float not null,
	IDSanPham varchar(10) NOT NULL FOREIGN KEY REFERENCES SanPham(ID),	
)

CREATE TABLE HOADON 
(
	ID int identity(1,1) PRIMARY KEY NOT NULL,
	TrangThai bit not null,
	NgayLap date not null,
	IDDonHang int NOT NULL FOREIGN KEY REFERENCES DONHANG(ID),
	TongTien FLOAT NOT NULL
)
GO 

CREATE TABLE CHITIETHOADON
(
	ID int identity(1,1) PRIMARY KEY NOT NULL,
	IDHoaDon int NOT NULL FOREIGN KEY REFERENCES HOADON(ID),
	IDSanPham varchar(10) NOT NULL FOREIGN KEY REFERENCES SanPham(ID),
	IDKhachHang varchar(10) NULL FOREIGN KEY REFERENCES KHACHHANG(ID),
	IDNHanVien varchar(10) NOT NULL FOREIGN KEY REFERENCES NHANVIEN(ID),
	SoLuong INT NOT NULL,
	TongTien FLOAT NOT NULL,
	IDCTDonHang int NULL FOREIGN KEY REFERENCES ChiTietDonHang(ID)
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
	('M5',N'Xanh'),
	('M6',N'Đen'),
	('M7',N'Trắng')

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
                  (ID, TenSanPham, GiaTien, TrangThai, HinhAnh, IDHang, IDXuatXu, IDMauSac, IDSize, MoTa,soluong)
VALUES ('SP1', N'Yordan nike', 500000, 1, N'abc.png', 'H1', 'XX2', 'M5', 'SZ4', N'dep trai',5),
	('SP2', N'Gucci bẩn', 4500000, 1, N'abc1.png', 'H2', 'XX2', 'M7', 'SZ5', N'dep trai',7),
	('SP3', N'Adidas thể thao', 600000, 1, N'abc2.png', 'H3', 'XX1', 'M5', 'SZ4', N'dep trai',2)






	
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

-- lệnh xóa hóa đơn

create proc SP_deleteHoaDon
@maHD int
as
begin 
	if	exists (select IDHoaDon from CHITIETHOADON where @maHD = IDHoaDon)
		begin 
			delete from CHITIETHOADON where @maHD = IDHoaDon
		end
	if exists (select id from HOADON where @maHD = id)
		begin 
			delete from HOADON where  @maHD = id
		end
end

-- lệnh xóa đơn hàng 
create proc SP_deleteDonHang
 @maDH int
as
 begin
	if exists (select IDDonHang from HOADON where @maDH = IDDonHang )
		begin
			delete from HOADON where IDDonHang = @maDH
		end
	if exists (select IDDonHang from CHITIETDONHANG where @maDH = IDDonHang )
		begin 
			delete from CHITIETDONHANG where IDDonHang = @maDH
		end
	if exists (select id from DONHANG where @maDH = id )
		begin 
			delete from DONHANG where id = @maDH
		end
 end
-- sửa
/*
delete  from CHITIETHOADON
delete  from chitietdonhang
delete from HOADON
delete from donhang

drop table CHITIETHOADON
drop table CHITIETDONHANG
drop table HOADON
drop table DONHANG 
*/




