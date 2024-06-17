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


