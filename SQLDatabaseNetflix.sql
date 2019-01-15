--Structure for table netflix.account
CREATE TABLE Account(
AccountID int NOT NULL,
Email nvarchar(128) NOT NULL,
AccountName nvarchar(128) NOT NULL,
AccountPassword nvarchar(50) NOT NULL,

PRIMARY KEY (AccountID)
FOREIGN KEY ()
);

--Structure for table netflix.Sunscription
CREATE TABLE Subscription(
SubID int NOT NULL,
NameSub nvarchar(128) NOT NULL,
Streetname nvarchar(80) NOT NULL,
Housenumber int(5) NOT NULL,
Addition nvarchar(3) NOT NULL,
Residence nvarchar(50) NOT NULL,
AccountID int NOT NULL,

PRIMARY KEY (SubID)
FOREIGN KEY ()
);

--Structure for netflix.profile
CREATE TABLE  Profile(
NameUser nvarchar(30) NOT NULL,
Birthdate date NOT NULL,
AccountID int NOT NULL,

PRIMARY KEY(NameUser)
FOREIGN KEY()
);

--Structure for view behavior profile
CREATE TABLE ViewedProgram(
ViewedProgramID int NOT NULL,
NameUser nvarchar(30) NOT NULL,
ProgramID int NOT NULL,
PercentageWatched int <= 100 NOT NULL,



--Structure for netflix.program
CREATE TABLE Program(
ProgramTitle nvarchar(128) NOT NULL,
NameUser nvarchar(30) NOT NULL,
ProgramID int IDENTITY NOT NULL,

PRIMARY KEY(ProgramID)
FOREIGN KEY()
);

--Structure fo






