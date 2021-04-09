# Read Me

Hello, this application/website base has been created for a final project by Tek_Global as proof of learning.
This case Study showcases the culmination of all my acquired knowledge over the course of my 3-Month bootcamp.

This readme should showcase the project broken down into 3 parts.

* Intended Purpose
* Current State
* Setbacks & Future Implementations

## Intended Purpose

This App/Site was created with the intention of allowing my artist and art loving friends to commision 
art from each other. The message forum is to demonstrate that I have learned of CRUD functionality. The Art
Gallery was to be a demonstration of my ability to create unique stylings and objects in HTML that a
User could interact with.

## Current State

The following is the project in its current form. this is the level at which the project is finished.

### General Project Flow

learning HTML and CSS this bootcamp has been incredibly eye-opening. I am glad to say that I have shown 
a wealth of gained knowledge that I had previously not known even since graduating my university. At the 
moment this project has both the ability to register a new user and login with each users actions being 
unique to that user. Once logged in the user can view art requests and current art postings. The user may 
choose to upload their own art via urls or make their own requests that also contain their own info.

### Actions

* User Creation
* User Login
* Art Request
* Request Edit
* Request Deletion
* Art Upload
* View Requests
* View Art

### Entities

The following entities are connected to the user via a join in the database as seen below.

| User          | Message       | Art          |
| ------------- |:-------------:| ------------:|
| Username      | messageid     | artname      |
| email         | name          | artistname   |
| Password      | content       | imageaddress |
| Foreign Keys  | useremail     | useremail    |

### Database

The database is based on SQL and was produced in HeidiSQL. The following is the SQL database creation.

```
CREATE DATABASE `test_case_study` ;
USE `test_case_study`;
CREATE TABLE  `user` (
  `email` varchar(50) primary key,
  `name` varchar(50) NOT NULL DEFAULT '',
  `password` varchar(50) NOT NULL DEFAULT ''
);
CREATE TABLE `art` (
  `artname` varchar(50) primary key,
  `artistname` varchar(50) NOT NULL,
  `imageaddress` varchar(250) NOT NULL,
  useremail varchar(50) not null,
  foreign key (useremail) references `user`(`email`)
) ;
CREATE TABLE `message` (
  `messageid` int primary key AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `content` varchar(50) NOT NULL,
  useremail varchar(50) not null,
 foreign key (useremail) references `user`(`email`)
);
```

<img src="image.PNG" width="250">

## Setbacks and Future Implementations

### Setbacks

I remade this project 5 times over the course of the 3 months that this bootcamp lasted. The first two
times were the result of me still learning HTML and CSS with new functionality with javascript and java.
Each lab we learned different applications with how to create databases and I got too far ahead of myself.
Eventually we settled on java Spring and I finally remade my project for the thrid time. This I thought would be
the last time however I underestimated my project requirements and had to redo the project in Spring boot two
more times to finally get a working project that could store my entities and translate into the database what
was required. Testing has not yet been implemented as Spring boot has pre-tested functionality.

### Future Implementations

Proper testing is the immediate concern as of this build. I have testing in app however to still have a backed
testable file would be immense as a satifying conclusion to this project. Even though spring boot has this testing
already, the implementation of checks are a good measure to ease minds worried on potential unseen issues that could
arise. Javascript to clean up and show a moving gallery would also demonstrate what I have previously learned as a 
result of this bootcamp. Finally One major feature that could be explored is security. this project could have an
administrative difference between users in both actions that the users could take and objects that users could see.
