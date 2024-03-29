USE [DuAn1_CNTT]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 12/10/2019 01:58:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNV] [nvarchar](10) NOT NULL,
	[MatKhau] [nvarchar](50) NOT NULL,
	[HoTen] [nvarchar](50) NOT NULL,
	[VaiTro] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Sinhvien]    Script Date: 12/10/2019 01:58:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Sinhvien](
	[MaSV] [nvarchar](10) NOT NULL,
	[TenSV] [nvarchar](50) NOT NULL,
	[NgaySinh] [date] NOT NULL,
	[GioiTinh] [bit] NULL,
	[ChuyenNganh] [nvarchar](50) NOT NULL,
	[Email] [nvarchar](50) NOT NULL,
	[Lop] [nvarchar](50) NOT NULL,
	[Sdt] [nvarchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaSV] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Sach]    Script Date: 12/10/2019 01:58:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Sach](
	[MaSach] [nvarchar](10) NOT NULL,
	[TenSach] [nvarchar](50) NOT NULL,
	[NhaXB] [nvarchar](50) NOT NULL,
	[TacGia] [nvarchar](50) NOT NULL,
	[SoLuong] [int] NOT NULL,
	[GiaTien] [money] NOT NULL,
	[NgayNK] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaSach] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuMuon]    Script Date: 12/10/2019 01:58:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuMuon](
	[MaPM] [int] IDENTITY(1,1) NOT NULL,
	[MaNV] [nvarchar](10) NULL,
	[MaSV] [nvarchar](10) NULL,
	[NgayMuon] [date] NULL,
	[NgayTra] [date] NULL,
	[TrangThai] [bit] NULL,
 CONSTRAINT [PK_PhieuMuon] PRIMARY KEY CLUSTERED 
(
	[MaPM] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  StoredProcedure [dbo].[sp_PhieuMuonDT]    Script Date: 12/10/2019 01:58:53 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[sp_PhieuMuonDT](@MaPM INT) AS 
BEGIN  
SELECT MaPM,MaNV,MaSV,NgayMuon,NgayTra
FROM PhieuMuon
WHERE TrangThai='0'  
END
GO
/****** Object:  StoredProcedure [dbo].[sp_PhieuMuonCT]    Script Date: 12/10/2019 01:58:53 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROC [dbo].[sp_PhieuMuonCT](@MaPM INT) AS 
BEGIN  
SELECT MaPM,MaNV,MaSV,NgayMuon,NgayTra
FROM PhieuMuon
WHERE TrangThai='1'  
END
GO
/****** Object:  Table [dbo].[PhieuMuonChiTiet]    Script Date: 12/10/2019 01:58:55 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuMuonChiTiet](
	[MaPMCT] [int] IDENTITY(1,1) NOT NULL,
	[MaPM] [int] NULL,
	[MaSach] [nvarchar](10) NULL,
	[SoLuong] [int] NULL,
 CONSTRAINT [PK_PhieuMuonChiTiet] PRIMARY KEY CLUSTERED 
(
	[MaPMCT] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  ForeignKey [FK_PhieuMuon_NhanVien]    Script Date: 12/10/2019 01:58:55 ******/
ALTER TABLE [dbo].[PhieuMuon]  WITH CHECK ADD  CONSTRAINT [FK_PhieuMuon_NhanVien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[PhieuMuon] CHECK CONSTRAINT [FK_PhieuMuon_NhanVien]
GO
/****** Object:  ForeignKey [FK_PhieuMuon_Sinhvien]    Script Date: 12/10/2019 01:58:55 ******/
ALTER TABLE [dbo].[PhieuMuon]  WITH CHECK ADD  CONSTRAINT [FK_PhieuMuon_Sinhvien] FOREIGN KEY([MaSV])
REFERENCES [dbo].[Sinhvien] ([MaSV])
GO
ALTER TABLE [dbo].[PhieuMuon] CHECK CONSTRAINT [FK_PhieuMuon_Sinhvien]
GO
/****** Object:  ForeignKey [FK_PhieuMuonChiTiet_PhieuMuon]    Script Date: 12/10/2019 01:58:55 ******/
ALTER TABLE [dbo].[PhieuMuonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_PhieuMuonChiTiet_PhieuMuon] FOREIGN KEY([MaPM])
REFERENCES [dbo].[PhieuMuon] ([MaPM])
GO
ALTER TABLE [dbo].[PhieuMuonChiTiet] CHECK CONSTRAINT [FK_PhieuMuonChiTiet_PhieuMuon]
GO
