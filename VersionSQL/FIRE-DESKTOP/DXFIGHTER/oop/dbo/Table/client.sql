/****** Object:  Table [dbo].[client]    Committed by VersionSQL https://www.versionsql.com ******/

SET ANSI_NULLS ON
SET QUOTED_IDENTIFIER ON
CREATE TABLE [dbo].[client](
	[username] [nvarchar](50) NOT NULL,
	[id] [int] IDENTITY(1,1) NOT NULL,
	[prieti] [int] NOT NULL,
	[neprieti] [int] NOT NULL,
 CONSTRAINT [PK_client] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

ALTER TABLE [dbo].[client] ADD  CONSTRAINT [DF_client_prieti]  DEFAULT ((0)) FOR [prieti]
ALTER TABLE [dbo].[client] ADD  CONSTRAINT [DF_client_neprieti]  DEFAULT ((0)) FOR [neprieti]
