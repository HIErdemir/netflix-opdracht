DROP DATABASE IF EXISTS NetflixStatistix;

CREATE DATABASE NetflixStatistix;

USE NetflixStatistix;


--Structure for table netflix.account
CREATE TABLE Account(
AccountID int IDENTITY(1,1) NOT NULL,
Email nvarchar(128) NOT NULL,
AccountName nvarchar(128) NOT NULL,
AccountPassword nvarchar(50) NOT NULL,

PRIMARY KEY (AccountID),
);

--Dumping data in table AccountID

INSERT INTO Account( Email, AccountName, AccountPassword)
VALUES('johansam@live.nl', 'Johan', 'johny23' );

INSERT INTO Account( Email, AccountName, AccountPassword)
VALUES('colinda@Hotmail.com', 'Colinda', 'Connie21' );

INSERT INTO Account( Email, AccountName, AccountPassword)
VALUES('aozkan@gmail.com', 'Ahmet', 'Ozkanahmtrt' );

INSERT INTO Account( Email, AccountName, AccountPassword)
VALUES('Ruudhermans@live.nl', 'Ruud', 'NacBreda076' );

INSERT INTO Account( Email, AccountName, AccountPassword)
VALUES('JanMontizaan@live.nl', 'Jantje', 'Jantjebreda' );


--Structure for table netflix.Sunscription
CREATE TABLE Subscription(
SubID int IDENTITY(200,1) NOT NULL,
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

--Dumping data in table Subscription
INSERT INTO Subscription(NameSub, Adress, Housenumber, Addition , Residence, AccountID)
VALUES('Jan', 'Montlaan', '20' , 'a', 'Breda',5);

INSERT INTO Subscription(NameSub, Adress, Housenumber, Residence, AccountID)
VALUES('Johan', 'Smeerlaan', '54' , 'Breda',1);

INSERT INTO Subscription(NameSub, Adress, Housenumber, Residence, AccountID)
VALUES('Colinda', 'Dr.Struickenpleen', '123' , 'Amsterdam',2);

INSERT INTO Subscription(NameSub, Adress, Housenumber, Residence, AccountID)
VALUES('Ahmet', 'Wingerdstraat', '50' , 'Breda',3);

INSERT INTO Subscription(NameSub, Adress, Housenumber, Residence, AccountID)
VALUES('Ruudje', 'Mopedikkelaan', '90' , 'Galder',4);

--Structure for netflix.profile
CREATE TABLE  NProfile(
NameUser nvarchar(30) NOT NULL,
ProfileID int IDENTITY(100,1) NOT NULL,
Birthdate nvarchar(12) NOT NULL,
AccountID int NOT NULL,

PRIMARY KEY(ProfileID),
CONSTRAINT FK_AccountProfile FOREIGN KEY(AccountID) REFERENCES Account(AccountID) 
ON DELETE CASCADE ON UPDATE CASCADE
);

--Dumping data in table NProfile
--AccID 1
INSERT INTO NProfile(NameUser, Birthdate, AccountID)
VALUES('Pieter','28-9-2002' ,1 );

INSERT INTO NProfile(NameUser, Birthdate, AccountID)
VALUES('Daisy','2-10-2008' ,1 );

INSERT INTO NProfile(NameUser, Birthdate, AccountID)
VALUES('Johan','28-12-1970' ,1 );

--AccID 2
INSERT INTO NProfile(NameUser, Birthdate, AccountID)
VALUES('Gradus','14-2-1998' ,2 );

INSERT INTO NProfile(NameUser, Birthdate, AccountID)
VALUES('Robin','1-1-1960' ,2 );

INSERT INTO NProfile(NameUser, Birthdate, AccountID)
VALUES('Jaquline','2-1-1970' ,2 );

INSERT INTO NProfile(NameUser, Birthdate, AccountID)
VALUES('Colinda','6-9-1998' ,2 );


--AccID 3

INSERT INTO NProfile(NameUser, Birthdate, AccountID)
VALUES('Ahmet','28-3-1999' ,3 );


--AccID 4

INSERT INTO NProfile(NameUser, Birthdate, AccountID)
VALUES('Ruudje','9-3-1992' ,4 );

INSERT INTO NProfile(NameUser, Birthdate, AccountID)
VALUES('Valerie','6-6-1993' ,4 );

--AccID 5

INSERT INTO NProfile(NameUser, Birthdate, AccountID)
VALUES('Melanie','2-4-1996' ,5 );

INSERT INTO NProfile(NameUser, Birthdate, AccountID)
VALUES('Jaque','7-7-1998' ,5 );

INSERT INTO NProfile(NameUser, Birthdate, AccountID)
VALUES('Henkie','7-7-1998' ,5 );

INSERT INTO NProfile(NameUser, Birthdate, AccountID)
VALUES('Priscilla','23-10-1992' ,5 );

INSERT INTO NProfile(NameUser, Birthdate, AccountID)
VALUES('Francine','28-11-1969' ,5 );




--Structure for netflix.program
CREATE TABLE Program(
ProgramTitle nvarchar(128) NOT NULL,
ProgramID int NOT NULL,
ProgramType char(1) NOT NULL,
Duration int NOT NULL,

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
MovieID int  NOT NULL,
ProgramID int NOT NULL,
Genre nvarchar(50) NOT NULL,
MovieLanguage nvarchar(30) NOT NULL,
ContentRating int NOT NULL,

PRIMARY KEY(MovieID),
CONSTRAINT FK_ProgramMovie FOREIGN KEY(ProgramID) REFERENCES Program(ProgramID) 
ON DELETE CASCADE ON UPDATE CASCADE
);

--Dumping data for Program/Movies
--The Titanic
INSERT INTO Program(ProgramTitle, ProgramID, ProgramType, Duration)  --PROGRAM
VALUES('The Titanic',1 ,'M', 195 )

INSERT INTO Movie(MovieID, ProgramID, Genre, MovieLanguage, ContentRating)  --MOVIE
VALUES(1,1,'Romance','English',6 );

--The Raid
INSERT INTO Program(ProgramTitle, ProgramID, ProgramType, Duration)  --PROGRAM
VALUES('The Raid',2 ,'M', 123 )

INSERT INTO Movie(MovieID, ProgramID, Genre, MovieLanguage, ContentRating)  --MOVIE
VALUES(2,2,'Horror','English',16 );

--The Breadwinner
INSERT INTO Program(ProgramTitle, ProgramID, ProgramType, Duration)   --PROGRAM
VALUES('The Breadwinner',3 ,'M',120 )

INSERT INTO Movie(MovieID, ProgramID, Genre, MovieLanguage, ContentRating)  --MOVIE
VALUES(3,3,'Comedy','English', 6 );

--Battle Royale
INSERT INTO Program(ProgramTitle, ProgramID, ProgramType, Duration)   --PROGRAM
VALUES('Battle Royale',4 ,'M',150 ) 

INSERT INTO Movie(MovieID, ProgramID, Genre, MovieLanguage, ContentRating)  --MOVIE
VALUES(4,4,'Action','English',12 );

--Children of the corn
INSERT INTO Program(ProgramTitle, ProgramID, ProgramType, Duration)    --PROGRAM
VALUES('Children of the corn',5 ,'M',100 )

INSERT INTO Movie(MovieID, ProgramID, Genre, MovieLanguage, ContentRating)  --MOVIE
VALUES(5,5,'Horror','English',16 );

--Intouchables
INSERT INTO Program(ProgramTitle, ProgramID, ProgramType, Duration)   --PROGRAM
VALUES('Intouchables',6 ,'M',180 )

INSERT INTO Movie(MovieID, ProgramID, Genre, MovieLanguage, ContentRating)  --MOVIE
VALUES(6,6,'Comedy','French',6 );





--Structure for netflix.Tvshow
CREATE TABLE TvShow(
Title nvarchar(128) NOT NULL,
Genre nvarchar(50) NOT NULL,
ShowLanguage nvarchar(30) NOT NULL,
ContentRating int NOT NULL,
TvShowID int  NOT NULL,

PRIMARY KEY(TvShowID)
);

--Dumping data for Tvshow
INSERT INTO TvShow(Title, Genre, ShowLanguage, ContentRating, TvShowID)
VALUES('Peaky Blinders','Crime','English',16 , 1);

INSERT INTO TvShow(Title, Genre, ShowLanguage, ContentRating, TvShowID)
VALUES('Vikings','History','English',16, 2);

INSERT INTO TvShow(Title, Genre, ShowLanguage, ContentRating, TvShowID)
VALUES('La Casa del Papel','Crime','Spanish',12 , 3);

INSERT INTO TvShow(Title, Genre, ShowLanguage, ContentRating, TvShowID)
VALUES('Goede tijden Slechte tijden', 'Drama','Dutch',6, 4);


--Structure for netflix.episode
CREATE TABLE Episode(
SeasonNr int NOT NULL,
EpisodeID int NOT NULL,
ProgramID int NOT NULL,
TvShowID int NOT NULL,
EpisodeNr varchar(8) NOT NULL,

PRIMARY KEY(EpisodeID),

CONSTRAINT FK_ProgramEpisode FOREIGN KEY(ProgramID) REFERENCES Program(ProgramID) 
ON DELETE CASCADE ON UPDATE CASCADE,

CONSTRAINT FK_TvShowIDEpisode FOREIGN KEY(TvShowID) REFERENCES TvShow(TvShowID) 
ON DELETE CASCADE ON UPDATE CASCADE
);

--Dumping data for Episodes/Programs
INSERT INTO Program(ProgramTitle, ProgramID, ProgramType, Duration)    --SHOW PB
VALUES('Another day at the office',1011 ,'E',45 )

INSERT INTO Episode(SeasonNr,EpisodeNr,ProgramID,TvShowID,EpisodeID)
VALUES(1,1,1011,1,1);

INSERT INTO Program(ProgramTitle, ProgramID, ProgramType, Duration)    --SHOW PB
VALUES('That looks delicious',1012 ,'E',42 )

INSERT INTO Episode(SeasonNr,EpisodeNr,ProgramID,TvShowID,EpisodeID)
VALUES(1,2,1012,1,2);

INSERT INTO Program(ProgramTitle, ProgramID, ProgramType, Duration)    --SHOW PB
VALUES('Goosh',1013 ,'E',43 )

INSERT INTO Episode(SeasonNr,EpisodeNr,ProgramID,TvShowID,EpisodeID)
VALUES(2,1,1013,1,3);

INSERT INTO Program(ProgramTitle, ProgramID, ProgramType, Duration)    --SHOW PB
VALUES('Wonderfull', 1014,'E',50 )

INSERT INTO Episode(SeasonNr,EpisodeNr,ProgramID,TvShowID,EpisodeID)
VALUES(2,2,1014,1,4);

INSERT INTO Program(ProgramTitle, ProgramID, ProgramType, Duration)     --SHOW VI
VALUES('For Walhalla',1015 ,'E',55 )

INSERT INTO Episode(SeasonNr,EpisodeNr,ProgramID,TvShowID,EpisodeID)
VALUES(1,1,1015,2,5);

INSERT INTO Program(ProgramTitle, ProgramID, ProgramType, Duration)     --SHOW VI
VALUES('The Sea',1016 ,'E',62 )

INSERT INTO Episode(SeasonNr,EpisodeNr,ProgramID,TvShowID,EpisodeID)
VALUES(1,2,1016,2,6);

INSERT INTO Program(ProgramTitle, ProgramID, ProgramType, Duration)     --SHOW VI
VALUES('The power',1017 ,'E',45 )

INSERT INTO Episode(SeasonNr,EpisodeNr,ProgramID,TvShowID,EpisodeID)
VALUES(2,1,1017,2,7);

INSERT INTO Program(ProgramTitle, ProgramID, ProgramType, Duration)      --SHOW VI
VALUES('Final battle',1018 ,'E',50 )

INSERT INTO Episode(SeasonNr,EpisodeNr,ProgramID,TvShowID,EpisodeID)
VALUES(2,2,1018,2,8);

INSERT INTO Program(ProgramTitle, ProgramID, ProgramType, Duration)      --SHOW LP
VALUES('Hasta la Vista',1019 ,'E',67 )

INSERT INTO Episode(SeasonNr,EpisodeNr,ProgramID,TvShowID,EpisodeID)
VALUES(1,1,1019,3,9);

INSERT INTO Program(ProgramTitle, ProgramID, ProgramType, Duration)    --SHOW LP
VALUES('Si',1020 ,'E',55 )

INSERT INTO Episode(SeasonNr,EpisodeNr,ProgramID,TvShowID,EpisodeID)
VALUES(1,2,1020,3,10);

INSERT INTO Program(ProgramTitle, ProgramID, ProgramType, Duration)    --SHOW LP
VALUES('Lopa de mayo',1021 ,'E',50 )

INSERT INTO Episode(SeasonNr,EpisodeNr,ProgramID,TvShowID,EpisodeID)
VALUES(2,1,1021,3,11);

INSERT INTO Program(ProgramTitle, ProgramID, ProgramType, Duration)    --SHOW LP
VALUES('Hasta mayana',1022 ,'E',60 )

INSERT INTO Episode(SeasonNr,EpisodeNr,ProgramID,TvShowID,EpisodeID)
VALUES(2,2,1022,3,12);

INSERT INTO Program(ProgramTitle, ProgramID, ProgramType, Duration)    --SHOW GTST
VALUES('De liefde',1023 ,'E',40 )

INSERT INTO Episode(SeasonNr,EpisodeNr,ProgramID,TvShowID,EpisodeID)
VALUES(1,1,1023,4,13);

INSERT INTO Program(ProgramTitle, ProgramID, ProgramType, Duration)      --SHOW GTST
VALUES('Goede tijden ',1024 ,'E',50 )

INSERT INTO Episode(SeasonNr,EpisodeNr,ProgramID,TvShowID,EpisodeID)
VALUES(1,2,1024,4,14);

INSERT INTO Program(ProgramTitle, ProgramID, ProgramType, Duration)      --SHOW GTST
VALUES('Het hart',1025 ,'E',30 )

INSERT INTO Episode(SeasonNr,EpisodeNr,ProgramID,TvShowID,EpisodeID)
VALUES(2,1,1025,4,15);

INSERT INTO Program(ProgramTitle, ProgramID, ProgramType, Duration)      --SHOW GTST
VALUES('Gebroken of niet?',1026 ,'E',45 )

INSERT INTO Episode(SeasonNr,EpisodeNr,ProgramID,TvShowID,EpisodeID)
VALUES(2,2,1026,4,16);


--Dumping data for ViewedProgram

--Profile101
INSERT INTO ViewedProgram(ViewedProgramID,ProfileID,ProgramID,PercentageWatched) 
VALUES(1,101,1,28);

INSERT INTO ViewedProgram(ViewedProgramID,ProfileID,ProgramID,PercentageWatched) 
VALUES(2,101,2,15);

--Profile102
INSERT INTO ViewedProgram(ViewedProgramID,ProfileID,ProgramID,PercentageWatched) 
VALUES(3,102,3,2);

--Profile104
INSERT INTO ViewedProgram(ViewedProgramID,ProfileID,ProgramID,PercentageWatched) 
VALUES(4,104,1011,98);

--Profile105
INSERT INTO ViewedProgram(ViewedProgramID,ProfileID,ProgramID,PercentageWatched) --
VALUES(5,105,1,1);

--profile106
INSERT INTO ViewedProgram(ViewedProgramID,ProfileID,ProgramID,PercentageWatched) 
VALUES(6,106,1012,20);

--profile107
INSERT INTO ViewedProgram(ViewedProgramID,ProfileID,ProgramID,PercentageWatched) 
VALUES(7,107,6,90);

--prrfile109
INSERT INTO ViewedProgram(ViewedProgramID,ProfileID,ProgramID,PercentageWatched) 
VALUES(8,109,1015,98);

--profile109
INSERT INTO ViewedProgram(ViewedProgramID,ProfileID,ProgramID,PercentageWatched) 
VALUES(9,109,1016,92);

--profile109
INSERT INTO ViewedProgram(ViewedProgramID,ProfileID,ProgramID,PercentageWatched) 
VALUES(10,109,1017,99);

--profile109
INSERT INTO ViewedProgram(ViewedProgramID,ProfileID,ProgramID,PercentageWatched) 
VALUES(11,109,1018,5);

--profile110
INSERT INTO ViewedProgram(ViewedProgramID,ProfileID,ProgramID,PercentageWatched) 
VALUES(12,110,4,90);

INSERT INTO ViewedProgram(ViewedProgramID,ProfileID,ProgramID,PercentageWatched) 
VALUES(13,110,2,50);

--profile112
INSERT INTO ViewedProgram(ViewedProgramID,ProfileID,ProgramID,PercentageWatched) 
VALUES(14,112,1019,43);

INSERT INTO ViewedProgram(ViewedProgramID,ProfileID,ProgramID,PercentageWatched) 
VALUES(15,112,5,89);

--profile113
INSERT INTO ViewedProgram(ViewedProgramID,ProfileID,ProgramID,PercentageWatched) 
VALUES(16,113,1020,34);

--profile114
INSERT INTO ViewedProgram(ViewedProgramID,ProfileID,ProgramID,PercentageWatched) 
VALUES(17,114,1020,67);

INSERT INTO ViewedProgram(ViewedProgramID,ProfileID,ProgramID,PercentageWatched) 
VALUES(18,114,1021,26);

INSERT INTO ViewedProgram(ViewedProgramID,ProfileID,ProgramID,PercentageWatched) 
VALUES(19,114,1022,63);

INSERT INTO ViewedProgram(ViewedProgramID,ProfileID,ProgramID,PercentageWatched) 
VALUES(20,114,1023,78);

INSERT INTO ViewedProgram(ViewedProgramID,ProfileID,ProgramID,PercentageWatched) 
VALUES(21,114,1024,98);

INSERT INTO ViewedProgram(ViewedProgramID,ProfileID,ProgramID,PercentageWatched) 
VALUES(22,114,1012,89);

INSERT INTO ViewedProgram(ViewedProgramID,ProfileID,ProgramID,PercentageWatched) 
VALUES(23,114,1013,23);

INSERT INTO ViewedProgram(ViewedProgramID,ProfileID,ProgramID,PercentageWatched) 
VALUES(24,114,1014,78);

INSERT INTO ViewedProgram(ViewedProgramID,ProfileID,ProgramID,PercentageWatched) 
VALUES(25,114,1025,23);

INSERT INTO ViewedProgram(ViewedProgramID,ProfileID,ProgramID,PercentageWatched) 
VALUES(26,114,1026,90);

