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
oID int,
pID int,
primary key(oID,pID),
odQTY int,
foreign key (oID) references `order`(oID),
foreign key (pID) references product(pID)
);

insert into product(pName, pPrice) 
values ("May Giat",3),
("Tu Lanh",5),
("Dieu Hoa",7),
("Quat",1),
("Bep Dien",2);

insert into customer(cName, cAge) 
values ("Minh Quan",10),
("Ngoc Oanh",20),
("Hong Ha",50);

insert into `order`(oDate, oTotalPrice,cID) 
values ("2006-03-21",null,1),
("2006-03-23",null,2),
("2006-03-16",null,1);

insert into order_detail(oID, pID, odQTY) 
values (1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,2,3);

/*Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order*/
select oID, oDate, oTotalPrice from `order`;

/*Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách*/
select cName, pName, odQTY from customer
join `order`
on customer.cID = `order`.cID
join order_detail
on order_detail.oID = `order`.oID
join product
on product.pID = order_detail.pID;

/*Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào*/
select cName from customer 
where cID not in (select distinct cID from `order`);

/*Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng 
tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)*/
select `order`.oID, `order`.oDate, sum(odQTY*pPrice) as oPrice from `order` 
join order_detail 
on `order`.oID = order_detail.oID 
join product 
on order_detail.pID = product.pID 
group by `order`.oID, `order`.oDate;
