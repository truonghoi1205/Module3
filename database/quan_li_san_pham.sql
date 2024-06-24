create database quan_li_san_pham;
 
use quan_li_san_pham;

create table category(
id int primary key auto_increment,
name varchar(255)
);

create table product(
id int primary key auto_increment,
name varchar(255),
price double,
quantity int,
description text,
color varchar(255),
categoryId int,
foreign key (categoryId) references category(id)
);

