

CREATE TABLE ACCOUNT(
ID UNIQUEIDENTIFIER DEFAULT NEWID(),
NameAcc VARCHAR(30),
DOB DATE,
GENDER VARCHAR(10),
IMG IMAGE,
PRIMARY KEY(ID));

