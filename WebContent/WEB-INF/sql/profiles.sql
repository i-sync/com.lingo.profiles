Create Database `Profiles`;
use `Profiles`;
Create table `RPC`
(
	ID int primary key auto_increment,
	PID int,
	CID int,
	AddDate datetime
)DEFAULT CHARACTER SET=utf8;

Create Table `Profile`
(
	ID int primary key auto_increment,
    `Name` varchar(64),
    NickName varchar(64),
    Avatar MediumBlob,
    Email varchar(64),
    Phone varchar(32),
    Address varchar(128),
    Intro varchar(4096),
    AddDate datetime,
    UpdateDate datetime
)DEFAULT CHARACTER SET=utf8;

Create Table Skill
(
	ID int primary key auto_increment,
    PID int ,
    Title varchar(1024),
    Content varchar(4096)
)DEFAULT CHARACTER SET=utf8;

Create Table Experience
(
	ID int primary key auto_increment,
	PID int,
	Title varchar(256),
	Company varchar(256),
	Link varchar(128),
	Period varchar(256),
	Location varchar(256),
	Position varchar(256),
	Intro varchar(4096)
)DEFAULT CHARACTER SET=utf8;

Create Table Project 
(
	ID int primary key auto_increment,
    PID int,
    Title varchar(512),
    Image MediumBlob,
    Link varchar(128),
    Tags varchar(256),
    Intro varchar(4096)
)DEFAULT CHARACTER SET=utf8;

Create Table Education
(
	ID int primary key auto_increment,
    PID int,
    Title varchar(256),
    Period varchar(256),
    Professional varchar(128),
    Link varchar(128),
    Intro varchar(4096)
)DEFAULT CHARACTER SET=utf8;

Create Table Living 
(
	ID int primary key auto_increment,
    PID int,
    Title varchar(256),
    Content varchar(4096)
)DEFAULT CHARACTER SET=utf8;

Create Table Link
(
	ID int primary key auto_increment,
    PID int,
    Title varchar(256),
    Icon varchar(64),
    Link varchar(128),
    Logo MediumBlob 
)DEFAULT CHARACTER SET=utf8;


#PROC
CREATE PROCEDURE `proc_profile_delete`(IN id INT)
BEGIN
	DECLARE result INT;
	DECLARE EXIT HANDLER FOR SQLEXCEPTION 
    BEGIN
          #.. set any flags etc  eg. SET @flag = 0; ..
          SET result=0;
          SELECT result as Result;
          ROLLBACK;
    END;
	START TRANSACTION;
		#delete related table : skill, project, education, link, living...
        DELETE FROM Skill WHERE Skill.PID=id;
        DELETE FROM Experience WHERE Experience.PID=id;
        DELETE FROM Project WHERE Project.PID=id;
        DELETE FROM Education WHERE Education.PID=id;
        DELETE FROM Link WHERE Link.PID=id;
        DELETE FROM Living WHERE Living.PID=id;
        
        #delete from profile
        DELETE FROM `Profile` WHERE `Profile`.ID=id;
        DELETE FROM RPC WHERE RPC.PID=id;
        SET result=1;
    COMMIT;   
	
    SELECT result as Result;
END

CREATE PROCEDURE `proc_profile_select` (IN id INT)
BEGIN
	SELECT * FROM `Profile` WHERE `Profile`.ID=id;
    #skill, project, education, link, living...
    SELECT * FROM Skill WHERE Skill.PID=id;
    SELECT * FROM Experience WHERE Experience.PID=id;
    SELECT * FROM Project WHERE Project.PID=id;
    SELECT * FROM Education WHERE Education.PID=id;
    SELECT * FROM Link WHERE Link.PID=id;
    SELECT * FROM Living WHERE Living.PID=id;
END
