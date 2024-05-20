drop database if exists student_manager;
create database if not exists student_manager;

use student_manager;

create table class(
id int primary key
auto_increment,
name varchar(255)
);

create table teacher(
id int primary key
auto_increment,
name varchar(255),
age int,
country text,
id_class int,
foreign key (id_class) references class(id)
);

insert into `class`(name)
values ("Hoa"), ("Vy");

insert into `teacher`(name,age,country,id_class)
values ("Anh",25,"Đà Nẵng",1),
 ("Em",27,"Sài Gòn",1);

