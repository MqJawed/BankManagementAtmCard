create table bankdb(
Formno varchar(10),
CustName varchar(40),
FatherName varchar(40),
DOB varchar(40),
Gender varchar(40),
Address varchar(40),
City varchar(40),
State varchar(40),
PinCode varchar(40),
PhoneNo varchar(40),
Email varchar(40));

create table bankdb2(
FormNumber varchar(10),
Religion varchar(40),
Category varchar(40),
Income varchar(40),
Eduacation varchar(40),
Occupation varchar(40),
PAN varchar(40),
Aadhaar varchar(40),
SeniorCitizen varchar(40),
Existing_Account varchar(40));

create table bankdb3(
Formno varchar(10),
AccountType varchar(50),
Cardno varchar(20),
Pin varchar(5),
Facility varchar(100));

create table logindb(
Formno varchar(10),
Cardno varchar(20),
Pin varchar(5));

create table transaction (
Pin varchar(5),
Date varchar(50),
Type varchar(50),
Amount varchar(20));

create table balancedb(
Cardno varchar(20),
Pin varchar(5),
Balance	float);




Pin varchar(5),
Balance Float);

