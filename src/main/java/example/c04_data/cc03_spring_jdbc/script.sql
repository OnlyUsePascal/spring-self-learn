drop database if exists `test_spring_jdbc`;

create database `test_spring_jdbc`;

use `test_spring_jdbc`;

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
INSERT INTO `Students`(name) VALUES ("john");
select * from Students where name like "jo%" and id >= 1;
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

