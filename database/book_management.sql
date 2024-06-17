create database book_management;
use book_management;

create table books(
id int primary key auto_increment,
title varchar(255),
page_size int not null,
author varchar(255)
);

insert into books(title,page_size,author) values("Toán", 45, 'Nguyễn Thái Học'),
("Văn", 34, 'Trần Minh Hoàng'),
("Sử", 56, 'Dương Trung Quốc'),
("Địa", 76, 'Lê Văn Hiến'),
("Hóa", 32, 'Hà Văn Minh');

update books 
join (select id from books where title ="Sử") as temp_book
on books.id = temp_book.id
set page_size = 50;

delete from books where id = 5;

drop table books;

drop database book_management;