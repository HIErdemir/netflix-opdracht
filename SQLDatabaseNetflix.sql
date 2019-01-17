


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
ProfileID int IDENTITY(1000,1) NOT NULL,
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

--Dumping data for program
INSERT INTO Program(ProgramTitle, ProgramID, ProgramType, Duration)  --MOVIE
VALUES('The Titanic',1 ,'M', 195 )

INSERT INTO Program(ProgramTitle, ProgramID, ProgramType, Duration)  --MOVIE 
VALUES('The Raid',2 ,'M', 123 )

INSERT INTO Program(ProgramTitle, ProgramID, ProgramType, Duration)   --MOVIE
VALUES('The Breadwinner',3 ,'M',120 )

INSERT INTO Program(ProgramTitle, ProgramID, ProgramType, Duration)   --MOVIE
VALUES('Battle Royale',4 ,'M',150 ) 

INSERT INTO Program(ProgramTitle, ProgramID, ProgramType, Duration)    --MOVIE
VALUES('Children of the corn',5 ,'M',100 )

INSERT INTO Program(ProgramTitle, ProgramID, ProgramType, Duration)   --MOVIE
VALUES('Intouchables',6 ,'M',180 )




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

--Dumping data for Movies
INSERT INTO Movie(MovieID, ProgramID, Genre, MovieLanguage, ContentRating)
VALUES(1,1,'Romance','English',6 );

INSERT INTO Movie(MovieID, ProgramID, Genre, MovieLanguage, ContentRating)
VALUES(2,2,'Horror','English',16 );

INSERT INTO Movie(MovieID, ProgramID, Genre, MovieLanguage, ContentRating)
VALUES(3,3,'Comedy','English', 6 );

INSERT INTO Movie(MovieID, ProgramID, Genre, MovieLanguage, ContentRating)
VALUES(4,4,'Action','English',12 );

INSERT INTO Movie(MovieID, ProgramID, Genre, MovieLanguage, ContentRating)
VALUES(5,5,'Horror','English',16 );

INSERT INTO Movie(MovieID, ProgramID, Genre, MovieLanguage, ContentRating)
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
VALUES('For Walhalla',1016 ,'E',55 )

INSERT INTO Episode(SeasonNr,EpisodeNr,ProgramID,TvShowID,EpisodeID)
VALUES(1,1,1016,2,5);

INSERT INTO Program(ProgramTitle, ProgramID, ProgramType, Duration)     --SHOW VI
VALUES('The Sea',1017 ,'E',62 )

INSERT INTO Episode(SeasonNr,EpisodeNr,ProgramID,TvShowID,EpisodeID)
VALUES(1,2,1017,2,6);

INSERT INTO Program(ProgramTitle, ProgramID, ProgramType, Duration)     --SHOW VI
VALUES('The power',1018 ,'E',45 )

INSERT INTO Episode(SeasonNr,EpisodeNr,ProgramID,TvShowID,EpisodeID)
VALUES(2,1,1018,2,7);

INSERT INTO Program(ProgramTitle, ProgramID, ProgramType, Duration)      --SHOW VI
VALUES('Final battle',1019 ,'E',50 )

INSERT INTO Episode(SeasonNr,EpisodeNr,ProgramID,TvShowID,EpisodeID)
VALUES(2,2,1019,2,8);

INSERT INTO Program(ProgramTitle, ProgramID, ProgramType, Duration)      --SHOW LP
VALUES('Hasta la Vista',1020 ,'E',67 )

INSERT INTO Episode(SeasonNr,EpisodeNr,ProgramID,TvShowID,EpisodeID)
VALUES(1,1,1020,3,9);

INSERT INTO Program(ProgramTitle, ProgramID, ProgramType, Duration)    --SHOW LP
VALUES('Si',1021 ,'E',55 )

INSERT INTO Episode(SeasonNr,EpisodeNr,ProgramID,TvShowID,EpisodeID)
VALUES(1,2,1021,3,10);

INSERT INTO Program(ProgramTitle, ProgramID, ProgramType, Duration)    --SHOW LP
VALUES('Lopa de mayo',1022 ,'E',50 )

INSERT INTO Episode(SeasonNr,EpisodeNr,ProgramID,TvShowID,EpisodeID)
VALUES(2,1,1022,3,11);

INSERT INTO Program(ProgramTitle, ProgramID, ProgramType, Duration)    --SHOW LP
VALUES('Hasta mayana',1023 ,'E',60 )

INSERT INTO Episode(SeasonNr,EpisodeNr,ProgramID,TvShowID,EpisodeID)
VALUES(2,2,1023,3,12);

INSERT INTO Program(ProgramTitle, ProgramID, ProgramType, Duration)    --SHOW GTST
VALUES('De liefde',1024 ,'E',40 )

INSERT INTO Episode(SeasonNr,EpisodeNr,ProgramID,TvShowID,EpisodeID)
VALUES(1,1,1024,4,13);

INSERT INTO Program(ProgramTitle, ProgramID, ProgramType, Duration)      --SHOW GTST
VALUES('Goede tijden ',1025 ,'E',50 )

INSERT INTO Episode(SeasonNr,EpisodeNr,ProgramID,TvShowID,EpisodeID)
VALUES(1,2,1025,4,14);

INSERT INTO Program(ProgramTitle, ProgramID, ProgramType, Duration)      --SHOW GTST
VALUES('Het hart',1026 ,'E',30 )

INSERT INTO Episode(SeasonNr,EpisodeNr,ProgramID,TvShowID,EpisodeID)
VALUES(2,1,1026,4,15);

INSERT INTO Program(ProgramTitle, ProgramID, ProgramType, Duration)      --SHOW GTST
VALUES('Gebroken of niet?',1027 ,'E',45 )

INSERT INTO Episode(SeasonNr,EpisodeNr,ProgramID,TvShowID,EpisodeID)
VALUES(2,2,1027,4,16);


--Dumping data for ViewedProgram

--Profile1
INSERT INTO ViewedProgram(ViewedProgramID,ProfileID,ProgramID,PercentageWatched) 
VALUES(1,1,1,28);

INSERT INTO ViewedProgram(ViewedProgramID,ProfileID,ProgramID,PercentageWatched) 
VALUES(2,1,2,15);

--Profile2
INSERT INTO ViewedProgram(ViewedProgramID,ProfileID,ProgramID,PercentageWatched) 
VALUES(3,2,3,2);

--Profile4
INSERT INTO ViewedProgram(ViewedProgramID,ProfileID,ProgramID,PercentageWatched) 
VALUES(4,4,1011,98);

--Profile5
INSERT INTO ViewedProgram(ViewedProgramID,ProfileID,ProgramID,PercentageWatched) --
VALUES(5,5,1,1);

INSERT INTO ViewedProgram(ViewedProgramID,ProfileID,ProgramID,PercentageWatched) 
VALUES(6,4,1012,20);

INSERT INTO ViewedProgram(ViewedProgramID,ProfileID,ProgramID,PercentageWatched) 
VALUES(7,4,1012,20);

INSERT INTO ViewedProgram(ViewedProgramID,ProfileID,ProgramID,PercentageWatched) 
VALUES(8,4,1012,20);

INSERT INTO ViewedProgram(ViewedProgramID,ProfileID,ProgramID,PercentageWatched) 
VALUES(9,4,1012,20);




