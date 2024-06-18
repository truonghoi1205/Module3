use library;

create table students(
id int primary key auto_increment,
name varchar(255),
dob date,
class_name varchar(255)
);

create table authors(
id int primary key auto_increment,
name varchar(255)
);

create table category(
id int primary key auto_increment,
name varchar(255)
);

create table books(
id int primary key auto_increment,
title varchar(255),
page_size int,
categoryId int,
authorId int,
foreign key (categoryId) references category(id),
foreign key (authorId) references authors(id)
);

create table borrows(
id int primary key auto_increment,
borrow_date date,
return_date date,
studentId int,
bookId int,
foreign key (studentId) references students(id),
foreign key (bookId) references books(id)
);

insert into category(name) values('Tự nhiên'),
('Xã hội'),
('Truyện'),
('Tiểu Thuyết'),
('Khác');


insert into authors(name)
values ('Nguyễn Thái Học'),
('Trần Minh Hoàng'),
('Dương Trung Quốc'),
('Lê Văn Hiến'),
('Hà Văn Minh');

insert into students(name,dob,class_name)
values('Nguyễn Văn A','1999-12-12','C0822G1'),
('Nguyễn Văn B','1999-12-13','C0822G1'),
('Nguyễn Văn C','1999-12-14','C0822G1'),
('Nguyễn Văn D','1999-12-15','C0922G1'),
('Nguyễn Văn E','1999-12-16','C1022G1');

insert into books(title, page_size, authorId, categoryId)
values('Toán',45,1,1),
('Văn',34,2,2),
('Sử',56,3,2),
('Địa',76,4,2),
('Hóa',32,5,1);

insert into borrows(studentId, bookId, borrow_date, return_date)
values(1,1,'2022-12-12','2022-12-13'),
(2,2,'2022-12-12','2022-12-13'),
(3,3,'2022-12-12','2022-12-15'),
(4,4,'2022-12-12','2022-12-15'),
(1,5,'2022-12-13','2022-12-15'),
(1,5,'2022-12-14','2022-12-14'),
(3,4,'2022-12-15','2022-12-29'),
(3,3,'2022-12-08','2022-12-14'),
(1,2,'2022-12-06','2022-12-30');

select b.title,b.page_size,c.name as 'Thể Loại',a.name as 'Tác giả' from books b
join authors a
on a.id = b.authorId
join category c
on c.id = b.categoryId;

select s.name "Tên hs", b.title as "Tên sách", borrow_date, return_date from students s
join borrows br
on br.studentId = s.id
join books b
on b.id = br.bookId;

select count(b.id) as sl ,b.title from books b
join borrows br 
on br.bookId = b.id
group by b.id
order by sl desc limit 2;

select count(b.id) as sl, b.title from books b
join borrows br
on br.bookId = b.id
group by b.id 
having sl = ( 
		select max(sl) from (
        select count(bookId) as sl 
        from borrows
        group by bookId
	) as a
);

select b.title from books b
left join borrows br
on br.bookId = b.id 
where br.bookId is null
group by b.id;

select distinct count(br.id) as sl, s.name from students s
join borrows br
on br.studentId = s.id
group by s.id
order by sl desc;

select count(s.id) as sl, s.name from students s
join borrows br
on br.studentId = s.id
group by s.id 
having sl = ( 
		select max(sl) from (
        select count(studentId) as sl 
        from borrows
        group by studentId
	) as a
);


create index index_title 
on books(title);

create view view_book as
select b.title, count(br.id) as borrow_count
from books b
join borrows br 
on b.id = br.bookId
group by b.id;

DELIMITER $$
create procedure AddNewBook(
    in title varchar(255),
    in page_size int,
    in authorId int,
    in categoryId int
)
BEGIN
    INSERT INTO Books (title, page_size, categoryId, authorId)
    VALUEs (title, page_size, categoryId, authorId);
END $$

DELIMITER ;

call AddNewBook( "fff",10,1,1)





