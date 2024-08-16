DROP DATABASE `selfLearn-c04-01-02`;
create database `selfLearn-c04-01-02`;


use `selfLearn-c04-01-02`;


show tables;

drop table student ;

CREATE TABLE student(
	id int primary key auto_increment,
	name varchar(255) not null,
	balance int default 1000
);

alter table student add constraint `balance_constraint` check (balance >= 0);

insert into student(id, name) value (12, "joun test");

insert into student(name) value ('joun test 1');

insert into student(name) value ('boeing');


UPDATE student 
	set balance = balance + 100
	where id = 13;


SELECT * FROM student;


 