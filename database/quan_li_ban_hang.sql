drop database if exists quan_li_ban_hang;
create database if not exists quan_li_ban_hang;

use quan_li_ban_hang;

create table customer(
cID int primary key
auto_increment,
cName varchar(50),
cAge int
);

create table `order`(
oID int primary key
auto_increment,
oDate date,
oTotalPrice decimal(10,2)	,
cID int,
foreign key(cID) references customer(cID)
);

create table product(
pID int primary key
auto_increment,
pName varchar(100),
pPrice decimal(10,2)
);

create table order_detail (
odID int primary key
auto_increment,
oID int,
pID int,
odQTY int,
foreign key (oID) references `order`(oID),
foreign key (pID) references product(pID)
);

insert into product(pName, pPrice) 
values ("bánh",30),("kẹo",50);

insert into customer(cName, cAge) 
values ("Hồng",34),("Hội",18);

insert into `order`(oDate, oTotalPrice,cID) 
values ("2024-01-12",34000,1),("2024-02-15",50000,1);

insert into order_detail(oID, pID, odQTY) 
values (1,1,5),(1,2,3);

update product 
set pPrice = 20000 
where pId = 1;

update product 
set pPrice = 25000 
where pId = 2;


