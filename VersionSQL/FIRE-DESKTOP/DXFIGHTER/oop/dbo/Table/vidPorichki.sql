/****** Object:  Table [dbo].[vidPorichki]    Committed by VersionSQL https://www.versionsql.com ******/

SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
CREATE TABLE [dbo].[vidPorichki](
	[poruchka] [nchar](30) NULL,
	[cena] [nchar](10) NULL,
	[id_vid] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_vidPorichki] PRIMARY KEY CLUSTERED 
(
	[id_vid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
