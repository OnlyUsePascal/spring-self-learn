drop database if exists `selfLearn-c04-01-01-jdbc`;

create database `selfLearn-c04-01-01-jdbc`;

use `selfLearn-c04-01-01-jdbc`;

show databases;

show databases;

show tables;

-- BASIC QUERY
drop table if exists Students;
create table Students(
	id int primary key auto_increment,
	name varchar(255) not null
);

insert into Students(name) values ("joun");
insert into Students(name) values ("dat nguyen");
select * from Students where name like "jo%";
select * from Students;


-- TRANSACTION
show tables;

drop table USER_WALLETS;
create table USER_WALLETS(
	name varchar(255) primary key not null,
	balance int not null default 500
);

insert into USER_WALLETS values
	("Joun", 1000),
	("Joseph", 2000);

select * from USER_WALLETS;
update USER_WALLETS set balance = balance + 100 where name = "Joun";

