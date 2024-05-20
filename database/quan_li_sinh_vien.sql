create database quan_ly_sinh_vien;
use quan_ly_sinh_vien;

create table class(
c_id int primary key
auto_increment,
c_name varchar(60) not null,
start_date datetime not null,
status bit
);

create table student(
s_id int primary key
auto_increment,
s_name varchar(30) not null,
address varchar(50),
phone varchar(20),
status bit,
c_id int not null,
foreign key (c_id) references class(c_id)
);

create table subject(
sub_id int primary key
auto_increment,
sub_name varchar(30) not null,
credit tinyint not null 
default 1 check (credit >= 1),
Status BIT DEFAULT 1
);

create table mark(
m_id int primary key
auto_increment,
sub_id int not null,
s_id int not null,
mark float default 0 check(mark between 0 and 100),
exam_time tinyint default 1,
unique (sub_id, s_id),
foreign key (sub_id) references subject(sub_id),
foreign key (s_id) references student(s_id)
);

insert into class(c_name, start_date, status) 
values ('A1', "2008-12-20",1),('A2',"2008-12-22",1),('B3', now(),0);

insert into student(s_name, address, phone, status, c_id)
values ('Hung','Ha Noi', '0912113113', 1, 1),('Hoa','Hai phong', null, 1, 1),('Manh','HCM', null, 0, 2);

update student 
set phone = '0123123123'
where s_id = 3;
/*Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’*/
select * from student where student.s_name like "h%";
/*Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.*/
select * from class where month(start_date) = 12;
/*Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.*/
select * from subject where credit between 3 and 5;
/*Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.*/
update student set c_id = 2 where s_id = 1;
/*Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.*/
select s_name, sub_name, mark from student
join mark 
on student.s_id = mark.s_id 
join subject 
on subject.sub_id = mark.sub_id
order by mark desc, s_name;