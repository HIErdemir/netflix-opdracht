--Geef de accounts met slechts 1 profiel.
SELECT AccountName 
FROM  
	(SELECT AccountID, COUNT(*) as AccountProfilen
	FROM NProfile
	GROUP BY  AccountID 
	HAVING COUNT(*) = 1) as Pietje

JOIN Account ON Account.AccountID = Pietje.AccountID

--Voor een door de gebruiker geselecteerde film, hoeveel kijkers hebben deze in z’n geheel bekeken?
-- Selecteer alle movies
-- per program
-- Hoevaak is programID voorgekomen in NProfile

SELECT Program.ProgramTitle, COUNT(ViewedProgram.ProfileID)
FROM Movie
JOIN Program ON Program.ProgramID = Movie.ProgramID
JOIN ViewedProgram ON ViewedProgram.ProgramID = Program.ProgramID
JOIN NProfile ON Nprofile.ProfileID = ViewedProgram.ProfileID
GROUP BY Program.ProgramTitle

--Geef de film met de langste tijdsduur voor kijkers onder 16 jaar.

SELECT TOP 1 Program.ProgramTitle , Movie.ContentRating, MAX(Program.Duration) AS Duration
FROM Program
JOIN Movie ON Movie.ProgramID = Program.ProgramID
WHERE Movie.ContentRating < 16
GROUP BY Program.ProgramTitle, Movie.ContentRating
ORDER BY MAX(Program.Duration) DESC

--Welke films zijn er door een door de gebruiker geselecteerd account bekeken?




