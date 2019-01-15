


--Structure for table netflix.account
CREATE TABLE Account(
AccountID int IDENTITY(1,1) NOT NULL,
Email nvarchar(128) NOT NULL,
AccountName nvarchar(128) NOT NULL,
AccountPassword nvarchar(50) NOT NULL,

PRIMARY KEY (AccountID),
);

INSERT INTO Account( Email, AccountName, AccountPassword)
VALUES(1,'johansam@live.nl', 'Johan', 'johny23' );

INSERT INTO Account( Email, AccountName, AccountPassword)
VALUES(2,'colinda@Hotmail.com', 'Colinda', 'Connie21' );

INSERT INTO Account( Email, AccountName, AccountPassword)
VALUES(3,'aozkan@gmail.com', 'Ahmet', 'Ozkanahmtrt' );

INSERT INTO Account( Email, AccountName, AccountPassword)
VALUES(4,'Ruudhermans@live.nl', 'Ruud', 'NacBreda076' );

INSERT INTO Account(, Email, AccountName, AccountPassword)
VALUES(5,'JanMontizaan@live.nl', 'Jantje', 'Jantjebreda' );


--Structure for table netflix.Sunscription
CREATE TABLE Subscription(
SubID int IDENTITY(1,1) NOT NULL,
NameSub nvarchar(128) NOT NULL,
Adress nvarchar(80) NOT NULL,
Housenumber int NOT NULL,
Addition nvarchar(3) ,
Residence nvarchar(50) NOT NULL,
AccountID  int NOT NULL,

PRIMARY KEY (SubID),
CONSTRAINT FK_AccountIDSub FOREIGN KEY(AccountID) REFERENCES Account(AccountID) 
ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO Subscription(SubID, NameSub, Adress, Housenumber, Addition , Residence, AccountID)
VALUES(45,'Jan', 'Montlaan', '20' , 'a', 'Breda',1);

INSERT INTO Subscription(SubID, NameSub, Adress, Housenumber, Addition , Residence, AccountID)
VALUES(46,'Jan', 'Montlaan', '20' , 'a', 'Breda',1);

--Structure for netflix.profile
CREATE TABLE  NProfile(
NameUser nvarchar(30) NOT NULL,
ProfileID int IDENTITY(1,1) NOT NULL,
Birthdate date NOT NULL,
AccountID int NOT NULL,

PRIMARY KEY(ProfileID),
CONSTRAINT FK_AccountProfile FOREIGN KEY(AccountID) REFERENCES Account(AccountID) 
ON DELETE CASCADE ON UPDATE CASCADE
);



--Structure for netflix.program
CREATE TABLE Program(
ProgramTitle nvarchar(128) NOT NULL,
ProgramID int NOT NULL,
ProgramType char(1) NOT NULL,

PRIMARY KEY(ProgramID)
);

--Structure for view behavior profile
CREATE TABLE ViewedProgram(
ViewedProgramID int NOT NULL,
ProfileID int NOT NULL,
ProgramID int NOT NULL,
PercentageWatched int ,

PRIMARY KEY(ViewedProgramID),
CONSTRAINT FK_ProfileViewed FOREIGN KEY(ProfileID) REFERENCES NProfile(ProfileID),
CONSTRAINT FK_ProgramViewed FOREIGN KEY(ProgramID) REFERENCES Program(ProgramID) 
);
--Structure for netflix.movie
CREATE TABLE Movie(
MovieID int IDENTITY NOT NULL,
ProgramID int NOT NULL,
Title nvarchar(128) NOT NULL,
Duration int NOT NULL,
Genre nvarchar(50) NOT NULL,
MovieLanguage nvarchar(30) NOT NULL,
ContentRating nvarchar(10) NOT NULL,

PRIMARY KEY(MovieID),
CONSTRAINT FK_ProgramMovie FOREIGN KEY(ProgramID) REFERENCES Program(ProgramID) 
ON DELETE CASCADE ON UPDATE CASCADE
);



--Structure for netflix.Tvshow
CREATE TABLE TvShow(
Title nvarchar(128) NOT NULL,
Genre nvarchar(50) NOT NULL,
ShowLanguage nvarchar(30) NOT NULL,
ContentRating nvarchar(10) NOT NULL,
TvShowID int  NOT NULL,

PRIMARY KEY(TvShowID)
);



--Structure for netflix.episode
CREATE TABLE Episode(
SeasonID int NOT NULL,
EpisodeID int NOT NULL,
Title nvarchar(128) NOT NULL,
Duration int NOT NULL,
ProgramID int NOT NULL,
TvShowID int NOT NULL

PRIMARY KEY(EpisodeID),

CONSTRAINT FK_ProgramEpisode FOREIGN KEY(ProgramID) REFERENCES Program(ProgramID) 
ON DELETE CASCADE ON UPDATE CASCADE,

CONSTRAINT FK_TvShowIDEpisode FOREIGN KEY(TvShowID) REFERENCES TvShow(TvShowID) 
ON DELETE CASCADE ON UPDATE CASCADE
);






