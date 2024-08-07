create database DA1_FOURSHOES
go
USE [DA1_FOURSHOES]
GO
/****** Object:  Table [dbo].[CHITIETDONHANG]    Script Date: 03/12/2023 4:22:46 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CHITIETDONHANG](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[IDDonHang] [int] NULL,
	[SoLuong] [int] NOT NULL,
	[GiaBan] [float] NOT NULL,
	[ThanhTien] [float] NOT NULL,
	[IDSanPham] [varchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CHITIETHOADON]    Script Date: 03/12/2023 4:22:46 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CHITIETHOADON](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[IDHoaDon] [int] NOT NULL,
	[IDSanPham] [varchar](10) NOT NULL,
	[IDKhachHang] [varchar](10) NULL,
	[IDNHanVien] [varchar](10) NOT NULL,
	[SoLuong] [int] NOT NULL,
	[TongTien] [float] NOT NULL,
	[IDCTDonHang] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DONHANG]    Script Date: 03/12/2023 4:22:46 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DONHANG](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[SoLuong] [int] NOT NULL,
	[TongGiaTri] [float] NOT NULL,
	[IDKhuyenMai] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Hang]    Script Date: 03/12/2023 4:22:46 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Hang](
	[ID] [varchar](10) NOT NULL,
	[TenHang] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HOADON]    Script Date: 03/12/2023 4:22:46 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HOADON](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[TrangThai] [bit] NOT NULL,
	[NgayLap] [date] NOT NULL,
	[IDDonHang] [int] NOT NULL,
	[TongTien] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KHACHHANG]    Script Date: 03/12/2023 4:22:46 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KHACHHANG](
	[ID] [varchar](10) NOT NULL,
	[TenKhachHang] [nvarchar](30) NOT NULL,
	[SDT] [char](10) NOT NULL,
	[DiaChi] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KHUYENMAI]    Script Date: 03/12/2023 4:22:46 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KHUYENMAI](
	[ID] [varchar](10) NOT NULL,
	[KMPhanTram] [float] NOT NULL,
	[KMTheoGia] [int] NOT NULL,
	[NgayTao] [date] NOT NULL,
	[NguoiTao] [varchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MAUSAC]    Script Date: 03/12/2023 4:22:46 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MAUSAC](
	[ID] [varchar](10) NOT NULL,
	[TenMau] [nvarchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NHANVIEN]    Script Date: 03/12/2023 4:22:46 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NHANVIEN](
	[ID] [varchar](10) NOT NULL,
	[HoTenNV] [nvarchar](30) NOT NULL,
	[Email] [nvarchar](30) NOT NULL,
	[Matkhau] [varchar](30) NOT NULL,
	[TinhTrang] [bit] NOT NULL,
	[VaiTro] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 03/12/2023 4:22:46 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[ID] [varchar](10) NOT NULL,
	[TenSanPham] [nvarchar](50) NOT NULL,
	[GiaTien] [float] NOT NULL,
	[SoLuong] [int] NOT NULL,
	[TrangThai] [bit] NULL,
	[HinhAnh] [nvarchar](20) NULL,
	[IDHang] [varchar](10) NOT NULL,
	[IDXuatXu] [varchar](10) NOT NULL,
	[IDMauSac] [varchar](10) NOT NULL,
	[IDSize] [varchar](10) NOT NULL,
	[MoTa] [nvarchar](max) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SIZE]    Script Date: 03/12/2023 4:22:46 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SIZE](
	[ID] [varchar](10) NOT NULL,
	[TenSize] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[XUATXU]    Script Date: 03/12/2023 4:22:46 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[XUATXU](
	[ID] [varchar](10) NOT NULL,
	[TenXuatXu] [nvarchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[CHITIETDONHANG] ON 

INSERT [dbo].[CHITIETDONHANG] ([ID], [IDDonHang], [SoLuong], [GiaBan], [ThanhTien], [IDSanPham]) VALUES (6, 2, 1, 4500000, 4500000, N'SP2')
INSERT [dbo].[CHITIETDONHANG] ([ID], [IDDonHang], [SoLuong], [GiaBan], [ThanhTien], [IDSanPham]) VALUES (7, 2, 1, 600000, 600000, N'SP3')
INSERT [dbo].[CHITIETDONHANG] ([ID], [IDDonHang], [SoLuong], [GiaBan], [ThanhTien], [IDSanPham]) VALUES (10, 2, 1, 600000, 600000, N'SP4')
INSERT [dbo].[CHITIETDONHANG] ([ID], [IDDonHang], [SoLuong], [GiaBan], [ThanhTien], [IDSanPham]) VALUES (12, 2, 1, 500000, 500000, N'SP1')
SET IDENTITY_INSERT [dbo].[CHITIETDONHANG] OFF
GO
SET IDENTITY_INSERT [dbo].[DONHANG] ON 

INSERT [dbo].[DONHANG] ([ID], [SoLuong], [TongGiaTri], [IDKhuyenMai]) VALUES (2, 3, 5700000, NULL)
INSERT [dbo].[DONHANG] ([ID], [SoLuong], [TongGiaTri], [IDKhuyenMai]) VALUES (3, 5, 6700000, NULL)
INSERT [dbo].[DONHANG] ([ID], [SoLuong], [TongGiaTri], [IDKhuyenMai]) VALUES (5, 5, 5695000, NULL)
INSERT [dbo].[DONHANG] ([ID], [SoLuong], [TongGiaTri], [IDKhuyenMai]) VALUES (6, 7, 6715000, NULL)
INSERT [dbo].[DONHANG] ([ID], [SoLuong], [TongGiaTri], [IDKhuyenMai]) VALUES (7, 4, 2200000, NULL)
INSERT [dbo].[DONHANG] ([ID], [SoLuong], [TongGiaTri], [IDKhuyenMai]) VALUES (8, 6, 7200000, NULL)
INSERT [dbo].[DONHANG] ([ID], [SoLuong], [TongGiaTri], [IDKhuyenMai]) VALUES (9, 3, 1445000, NULL)
INSERT [dbo].[DONHANG] ([ID], [SoLuong], [TongGiaTri], [IDKhuyenMai]) VALUES (10, 4, 1870000, NULL)
INSERT [dbo].[DONHANG] ([ID], [SoLuong], [TongGiaTri], [IDKhuyenMai]) VALUES (11, 5, 6700000, NULL)
INSERT [dbo].[DONHANG] ([ID], [SoLuong], [TongGiaTri], [IDKhuyenMai]) VALUES (12, 4, 6200000, NULL)
INSERT [dbo].[DONHANG] ([ID], [SoLuong], [TongGiaTri], [IDKhuyenMai]) VALUES (13, 4, 6200000, NULL)
INSERT [dbo].[DONHANG] ([ID], [SoLuong], [TongGiaTri], [IDKhuyenMai]) VALUES (14, 1, 0, NULL)
INSERT [dbo].[DONHANG] ([ID], [SoLuong], [TongGiaTri], [IDKhuyenMai]) VALUES (15, 2, 5100000, NULL)
SET IDENTITY_INSERT [dbo].[DONHANG] OFF
GO
INSERT [dbo].[Hang] ([ID], [TenHang]) VALUES (N'H1', N'Gucci')
INSERT [dbo].[Hang] ([ID], [TenHang]) VALUES (N'H2', N'Dior')
INSERT [dbo].[Hang] ([ID], [TenHang]) VALUES (N'H3', N'Adidas')
INSERT [dbo].[Hang] ([ID], [TenHang]) VALUES (N'H4', N'Jordan')
GO
SET IDENTITY_INSERT [dbo].[HOADON] ON 

INSERT [dbo].[HOADON] ([ID], [TrangThai], [NgayLap], [IDDonHang], [TongTien]) VALUES (2, 1, CAST(N'2023-11-30' AS Date), 2, 5700000)
SET IDENTITY_INSERT [dbo].[HOADON] OFF
GO
INSERT [dbo].[KHUYENMAI] ([ID], [KMPhanTram], [KMTheoGia], [NgayTao], [NguoiTao]) VALUES (N'KM1', 0.15, 0, CAST(N'2023-11-30' AS Date), N'admin')
INSERT [dbo].[KHUYENMAI] ([ID], [KMPhanTram], [KMTheoGia], [NgayTao], [NguoiTao]) VALUES (N'KM2', 0, 500000, CAST(N'2023-11-30' AS Date), N'admin')
GO
INSERT [dbo].[MAUSAC] ([ID], [TenMau]) VALUES (N'M1', N'Xanh lam')
INSERT [dbo].[MAUSAC] ([ID], [TenMau]) VALUES (N'M2', N'Đỏ')
INSERT [dbo].[MAUSAC] ([ID], [TenMau]) VALUES (N'M3', N'Tím')
INSERT [dbo].[MAUSAC] ([ID], [TenMau]) VALUES (N'M4', N'Vàng')
INSERT [dbo].[MAUSAC] ([ID], [TenMau]) VALUES (N'M5', N'Xanh')
INSERT [dbo].[MAUSAC] ([ID], [TenMau]) VALUES (N'M6', N'Đen')
INSERT [dbo].[MAUSAC] ([ID], [TenMau]) VALUES (N'M7', N'Trắng')
GO
INSERT [dbo].[NHANVIEN] ([ID], [HoTenNV], [Email], [Matkhau], [TinhTrang], [VaiTro]) VALUES (N'admin', N'Ngu?i Qu?n Lý', N'quanly123@gmail.com', N'123', 1, 1)
INSERT [dbo].[NHANVIEN] ([ID], [HoTenNV], [Email], [Matkhau], [TinhTrang], [VaiTro]) VALUES (N'nv1', N'nguyễn Tiến Bảo', N'quanly123@gmail.com', N'123', 1, 1)
GO
INSERT [dbo].[SanPham] ([ID], [TenSanPham], [GiaTien], [SoLuong], [TrangThai], [HinhAnh], [IDHang], [IDXuatXu], [IDMauSac], [IDSize], [MoTa]) VALUES (N'SP1', N'Yordan nike', 500000, 2, 1, N'abc.png', N'H1', N'XX2', N'M5', N'SZ4', N'dep trai')
INSERT [dbo].[SanPham] ([ID], [TenSanPham], [GiaTien], [SoLuong], [TrangThai], [HinhAnh], [IDHang], [IDXuatXu], [IDMauSac], [IDSize], [MoTa]) VALUES (N'SP2', N'Gucci bẩn', 4500000, 1, 1, N'abc1.png', N'H2', N'XX2', N'M7', N'SZ5', N'dep trai')
INSERT [dbo].[SanPham] ([ID], [TenSanPham], [GiaTien], [SoLuong], [TrangThai], [HinhAnh], [IDHang], [IDXuatXu], [IDMauSac], [IDSize], [MoTa]) VALUES (N'SP3', N'Adidas thể thao', 600000, 2, 1, N'abc2.png', N'H3', N'XX1', N'M5', N'SZ4', N'dep trai')
INSERT [dbo].[SanPham] ([ID], [TenSanPham], [GiaTien], [SoLuong], [TrangThai], [HinhAnh], [IDHang], [IDXuatXu], [IDMauSac], [IDSize], [MoTa]) VALUES (N'SP4', N'Adidas Leo núi', 600000, 3, 1, N'jordan.png', N'H3', N'XX3', N'M2', N'SZ5', N'dep trai')
INSERT [dbo].[SanPham] ([ID], [TenSanPham], [GiaTien], [SoLuong], [TrangThai], [HinhAnh], [IDHang], [IDXuatXu], [IDMauSac], [IDSize], [MoTa]) VALUES (N'SP5', N'Yordan 1', 500000, 2, 1, N'abc.png', N'H4', N'XX4', N'M6', N'SZ5', N'dep trai')
GO
INSERT [dbo].[SIZE] ([ID], [TenSize]) VALUES (N'SZ1', 36)
INSERT [dbo].[SIZE] ([ID], [TenSize]) VALUES (N'SZ2', 37)
INSERT [dbo].[SIZE] ([ID], [TenSize]) VALUES (N'SZ3', 38)
INSERT [dbo].[SIZE] ([ID], [TenSize]) VALUES (N'SZ4', 39)
INSERT [dbo].[SIZE] ([ID], [TenSize]) VALUES (N'SZ5', 40)
INSERT [dbo].[SIZE] ([ID], [TenSize]) VALUES (N'SZ6', 41)
INSERT [dbo].[SIZE] ([ID], [TenSize]) VALUES (N'SZ7', 42)
GO
INSERT [dbo].[XUATXU] ([ID], [TenXuatXu]) VALUES (N'XX1', N'Mỹ')
INSERT [dbo].[XUATXU] ([ID], [TenXuatXu]) VALUES (N'XX2', N'Việt Nam')
INSERT [dbo].[XUATXU] ([ID], [TenXuatXu]) VALUES (N'XX3', N'Trung Quốc')
INSERT [dbo].[XUATXU] ([ID], [TenXuatXu]) VALUES (N'XX4', N'Nhật Bản')
GO
ALTER TABLE [dbo].[CHITIETDONHANG]  WITH CHECK ADD FOREIGN KEY([IDDonHang])
REFERENCES [dbo].[DONHANG] ([ID])
GO
ALTER TABLE [dbo].[CHITIETDONHANG]  WITH CHECK ADD FOREIGN KEY([IDSanPham])
REFERENCES [dbo].[SanPham] ([ID])
GO
ALTER TABLE [dbo].[CHITIETHOADON]  WITH CHECK ADD FOREIGN KEY([IDCTDonHang])
REFERENCES [dbo].[CHITIETDONHANG] ([ID])
GO
ALTER TABLE [dbo].[CHITIETHOADON]  WITH CHECK ADD FOREIGN KEY([IDHoaDon])
REFERENCES [dbo].[HOADON] ([ID])
GO
ALTER TABLE [dbo].[CHITIETHOADON]  WITH CHECK ADD FOREIGN KEY([IDKhachHang])
REFERENCES [dbo].[KHACHHANG] ([ID])
GO
ALTER TABLE [dbo].[CHITIETHOADON]  WITH CHECK ADD FOREIGN KEY([IDNHanVien])
REFERENCES [dbo].[NHANVIEN] ([ID])
GO
ALTER TABLE [dbo].[CHITIETHOADON]  WITH CHECK ADD FOREIGN KEY([IDSanPham])
REFERENCES [dbo].[SanPham] ([ID])
GO
ALTER TABLE [dbo].[DONHANG]  WITH CHECK ADD FOREIGN KEY([IDKhuyenMai])
REFERENCES [dbo].[KHUYENMAI] ([ID])
GO
ALTER TABLE [dbo].[HOADON]  WITH CHECK ADD FOREIGN KEY([IDDonHang])
REFERENCES [dbo].[DONHANG] ([ID])
GO
ALTER TABLE [dbo].[KHUYENMAI]  WITH CHECK ADD FOREIGN KEY([NguoiTao])
REFERENCES [dbo].[NHANVIEN] ([ID])
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD FOREIGN KEY([IDHang])
REFERENCES [dbo].[Hang] ([ID])
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD FOREIGN KEY([IDMauSac])
REFERENCES [dbo].[MAUSAC] ([ID])
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD FOREIGN KEY([IDSize])
REFERENCES [dbo].[SIZE] ([ID])
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD FOREIGN KEY([IDXuatXu])
REFERENCES [dbo].[XUATXU] ([ID])
GO
/****** Object:  StoredProcedure [dbo].[SP_deleteDonHang]    Script Date: 03/12/2023 4:22:46 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- lệnh xóa đơn hàng 
create proc [dbo].[SP_deleteDonHang]
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
GO
/****** Object:  StoredProcedure [dbo].[SP_deleteHoaDon]    Script Date: 03/12/2023 4:22:46 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[SP_deleteHoaDon]
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

GO
/****** Object:  StoredProcedure [dbo].[SP_deleteHoaDonCho]    Script Date: 03/12/2023 4:22:46 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[SP_deleteHoaDonCho]
@maSp varchar(10),
@soLuong int,
@maDonHang int
as 
begin
	if exists (select * from CHITIETDONHANG where IDDonHang  = @maDonHang)
		begin
			update SanPham set SoLuong += @soLuong where id = @maSp
			delete from CHITIETDONHANG where IDSanPham = @maSp and IDDonHang = @madonHang
			delete from HOADON where TrangThai = 0 and IDDonHang = @maDonHang 
			delete from donhang where id = @maDonHang
		end
end
GO
/****** Object:  StoredProcedure [dbo].[SP_LamMoiCTDonHang]    Script Date: 03/12/2023 4:22:46 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[SP_LamMoiCTDonHang]
@maSp varchar(10),
@soLuong int
as 
begin
	if exists (select * from CHITIETDONHANG where IDDonHang is null)
		begin
			update SanPham set SoLuong += @soLuong where id = @maSp
			delete from CHITIETDONHANG where IDSanPham = @maSp and IDDonHang is null
		end
end
GO


