/****** Object:  Table [dbo].[poruchki]    Committed by VersionSQL https://www.versionsql.com ******/

SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
CREATE TABLE [dbo].[poruchki](
	[poruchka] [nvarchar](50) NOT NULL,
	[id] [int] IDENTITY(1,1) NOT NULL,
	[id_klient] [int] NOT NULL,
	[id_kourier] [int] NOT NULL,
	[id_vid] [int] NOT NULL,
	[adres] [nvarchar](50) NOT NULL,
	[status] [int] NOT NULL,
	[data] [date] NOT NULL,
	[polychatel] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_poruchki] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

ALTER TABLE [dbo].[poruchki]  WITH CHECK ADD  CONSTRAINT [FK_poruchki_status] FOREIGN KEY([status])
REFERENCES [dbo].[status] ([id])
ALTER TABLE [dbo].[poruchki] CHECK CONSTRAINT [FK_poruchki_status]
