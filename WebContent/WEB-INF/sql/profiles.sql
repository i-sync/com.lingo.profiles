Create Database `Profiles`;
use `Profiles`;
Create table `RPC`
(
	ID int primary key auto_increment,
	PID int,
	CID int,
	AddDate datetime
)

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
    UpdateDate datetime,
);

Create Table Skill
(
	ID int primary key auto_increment,
    PID int ,
    Title varchar(1024),
    Content varchar(4096)
);

Create Table Project 
(
	ID int primary key auto_increment,
    PID int,
    Title varchar(512),
    Image MediumBlob,
    Link varchar(128),
    Tags varchar(256),
    Intro varchar(4096)
);

Create Table Education
(
	ID int primary key auto_increment,
    PID int,
    Title varchar(256),
    Period varchar(256),
    Professional varchar(128),
    Link varchar(128),
    Intro varchar(4096)
);

Create Table Living 
(
	ID int primary key auto_increment,
    PID int,
    Title varchar(256),
    Content varchar(4096)
);

Create Table Link
(
	ID int primary key auto_increment,
    PID int,
    Title varchar(256),
    Link varchar(128),
    Logo MediumBlob 
);


#PROC
CREATE PROCEDURE `proc_profile_delete`(IN id INT)
BEGIN
	DECLARE result INT;
	DECLARE EXIT HANDLER FOR SQLEXCEPTION 
    BEGIN
          #.. set any flags etc  eg. SET @flag = 0; ..
          SET result=0;
          SELECT result as RESULT;
          ROLLBACK;
    END;
	START TRANSACTION;
		#delete related table : skill, project, education, link, living...
        DELETE FROM SKILL WHERE PID=id;
        DELETE FROM PROJECT WHERE PID=id;
        DELETE FROM EDUCATION WHERE PID=id;
        DELETE FROM LINK WHERE PID=id;
        DELETE FROM LIVING WHERE PID=id;
        
        #delete from profile
        DELETE FROM `PROFILE` WHERE ID=id;
        DELETE FROM RPC WHERE PID=id;
        SET result=1;
    COMMIT;   
	
    SELECT result as RESULT;
END

CREATE PROCEDURE `proc_profile_select` (IN id INT)
BEGIN
	SELECT * FROM `PROFILE` WHERE ID=id;
    #skill, project, education, link, living...
    SELECT * FROM SKILL WHERE PID=id;
    SELECT * FROM PROJECT WHERE PID=id;
    SELECT * FROM EDUCATION WHERE PID=id;
    SELECT * FROM LINK WHERE PID=id;
    SELECT * FROM LIVING WHERE PID=id;
END
