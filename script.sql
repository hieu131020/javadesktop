USE [master]
GO
/****** Object:  Database [MotorcycleManagement]    Script Date: 5/19/2021 8:03:10 PM ******/
CREATE DATABASE [MotorcycleManagement]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'MotorcycleManagement', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\MotorcycleManagement.mdf' , SIZE = 3264KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'MotorcycleManagement_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\MotorcycleManagement_log.ldf' , SIZE = 816KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [MotorcycleManagement] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [MotorcycleManagement].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [MotorcycleManagement] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET ARITHABORT OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [MotorcycleManagement] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [MotorcycleManagement] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET  ENABLE_BROKER 
GO
ALTER DATABASE [MotorcycleManagement] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [MotorcycleManagement] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET RECOVERY FULL 
GO
ALTER DATABASE [MotorcycleManagement] SET  MULTI_USER 
GO
ALTER DATABASE [MotorcycleManagement] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [MotorcycleManagement] SET DB_CHAINING OFF 
GO
ALTER DATABASE [MotorcycleManagement] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [MotorcycleManagement] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [MotorcycleManagement] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'MotorcycleManagement', N'ON'
GO
USE [MotorcycleManagement]
GO
/****** Object:  Table [dbo].[TblBike]    Script Date: 5/19/2021 8:03:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TblBike](
	[motocycleID] [varchar](10) NOT NULL,
	[model] [nvarchar](50) NOT NULL,
	[year] [date] NOT NULL,
	[condition] [varchar](50) NOT NULL,
	[price] [float] NOT NULL,
	[quantity] [int] NOT NULL,
	[warranty] [nvarchar](50) NOT NULL,
	[brandID] [varchar](10) NOT NULL,
 CONSTRAINT [PK_TblBike] PRIMARY KEY CLUSTERED 
(
	[motocycleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TblBrand]    Script Date: 5/19/2021 8:03:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TblBrand](
	[brandID] [varchar](10) NOT NULL,
	[brandName] [nvarchar](50) NOT NULL,
	[country] [nvarchar](50) NOT NULL,
	[description] [nvarchar](200) NOT NULL,
 CONSTRAINT [PK_TblBrand] PRIMARY KEY CLUSTERED 
(
	[brandID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TblUser]    Script Date: 5/19/2021 8:03:10 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TblUser](
	[userID] [varchar](10) NOT NULL,
	[fullName] [nvarchar](50) NOT NULL,
	[password] [varchar](50) NOT NULL,
	[status] [bit] NOT NULL,
 CONSTRAINT [PK_TblUser] PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[TblBike] ([motocycleID], [model], [year], [condition], [price], [quantity], [warranty], [brandID]) VALUES (N'B111', N'Raider', CAST(N'2008-11-11' AS Date), N'Good', 50, 7, N'Good', N'A111')
INSERT [dbo].[TblBike] ([motocycleID], [model], [year], [condition], [price], [quantity], [warranty], [brandID]) VALUES (N'B222', N'Exciter', CAST(N'2021-05-19' AS Date), N'Good', 10, 10, N'New', N'A222')
INSERT [dbo].[TblBike] ([motocycleID], [model], [year], [condition], [price], [quantity], [warranty], [brandID]) VALUES (N'B333', N'SHmode', CAST(N'2000-09-29' AS Date), N'Goo', 12, 5, N'New', N'A333')
INSERT [dbo].[TblBike] ([motocycleID], [model], [year], [condition], [price], [quantity], [warranty], [brandID]) VALUES (N'B444', N'WinnerX', CAST(N'2019-02-15' AS Date), N'Good', 20, 35, N'Good', N'A333')
INSERT [dbo].[TblBrand] ([brandID], [brandName], [country], [description]) VALUES (N'A111', N'Suzuki', N'Thailand', N'khoe')
INSERT [dbo].[TblBrand] ([brandID], [brandName], [country], [description]) VALUES (N'A222', N'Yamaha', N'Korea', N'dep')
INSERT [dbo].[TblBrand] ([brandID], [brandName], [country], [description]) VALUES (N'A333', N'Honda', N'Japan', N'tiet kiem xang')
INSERT [dbo].[TblUser] ([userID], [fullName], [password], [status]) VALUES (N'hieu131020', N'Tran Minh Hieu', N'123', 1)
USE [master]
GO
ALTER DATABASE [MotorcycleManagement] SET  READ_WRITE 
GO
