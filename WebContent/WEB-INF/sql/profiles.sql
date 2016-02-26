Create Database `Profiles`;
use `Profiles`;

Create Table `Profile`
(
	ID int primary key auto_increment,
    `Name` varchar(64),
    Avatar MediumBlob,
    Email varchar(64),
    Phone varchar(32),
    Address varchar(128),
    Intro varchar(4096)
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