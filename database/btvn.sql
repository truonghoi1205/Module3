create database btvn_student_manager;
use btvn_student_manager;

create table classrooms(
id_class int primary key auto_increment,
class_name varchar(20),
teacher_name varchar(20)
);

create table students(
student_id int primary key auto_increment,
student_code varchar(10) unique not null,
first_name varchar(30),
last_name varchar(30),
gerder varchar(10),
dob date,
note varchar(50),
id_class int,
foreign key (id_class) references classrooms(id_class)
);

create table scores(
score_id int primary key auto_increment,
student_id int unique not null,
math float(2),
physics float(2),
chemistry float(2),
literature float(2),
classification varchar(20),
foreign key (student_id) references students(student_id) on delete cascade
);

insert into classrooms values(default, 'C01','Tran Thi Huong'),
(default,'C02','Nguyen Thi Tien'),
(default,'C03','Pham Nhu Quynh'),
(default,'C04','Pham Thanh Hung'),
(default,'C05','Tran Thi Thanh'),
(default,'C06','Vo Van Hoang'),
(default,'C07','Le Giang'),
(default,'C08','Tran Thi Lan'),
(default,'C09','Nguyen Phuong'),
(default,'C10','Truong Hong');

insert into students values(default, 'HS001', 'Dang Thi','Na','Nu','2001-04-14','',10),
(default, 'HS002', 'Tran Van','Tu','Nam','2001-07-23','',10),
(default, 'HS003', 'Nguyen Thi Hong','Nhung','Nu','1999-09-06','',2),
(default, 'HS004', 'Nguyen Thanh','Hoan','Nam','1999-11-21','',2),
(default, 'HS005', 'Tran Ngoc','Xuan','Nu','2000-12-30','',5),
(default, 'HS006', 'Tran Thi Cam','Vy','Nu','2000-01-05','',5),
(default, 'HS007', 'Phan Van','Giang','Nam','2000-03-18','',5),
(default, 'HS008', 'Pham Thu','Nguyet','Nu','2002-07-20','',7),
(default, 'HS009', 'Phan Thi','Nho','Nu','2002-12-01','',7),
(default, 'HS010', 'Tran Van','Tri','Nam','2003-11-28','',8);

insert into scores values(default, 1,8,5,7,10,'Kha'),
(default,3,7.5,7.9,6.0,8.0,'Kha'),
(default,8,3.8,7.0,5.0,4.2,'Trung binh'),
(default,5,8.0,9.5,9.8,9.0,'Gioi'),
(default,10,7.0,5.0,6.5,8.0,'Kha'),
(default,9,3.0,5.7,6.0,2.2,'Kem'),
(default,6,7.3,7.7,6.4,8.0,'Kha'),
(default,7,null,null,null,null,''),
(default,4,null,null,null,null,''),
(default,2,null,null,null,null,'');

/*Hiện danh sách sinh viên: mã hs, họ và tên (là 1 cột), ngày sinh.*/
select student_code as 'Mã học sinh', concat(first_name," ",last_name) as 'Họ và tên', dob as 'Ngày sinh' from students;

/*Hiện danh sách sinh viên: mã hs, họ và tên (là 1 cột), sinh ngày 20*/
select student_code as 'Mã học sinh', concat(first_name," ",last_name) as 'Họ và tên', dob as 'Ngày sinh' 
from students where day(dob) = 20;

/* Hiện danh sách sinh viên: mã hs, họ và tên (là 1 cột), ngày sinh là 6/9/1999*/
select student_code as 'Mã học sinh', concat(first_name," ",last_name) as 'Họ và tên', dob as 'Ngày sinh' 
from students where date(dob) = '1999-09-06';

/*Hiện danh sách sinh viên: mã hs, họ và tên (là 1 cột), tên là NA*/
select student_code as 'Mã học sinh', concat(first_name," ",last_name) as 'Họ và tên' 
from students where last_name = 'NA';

/*Hiện danh sách sinh viên: mã hs, họ và tên (là 1 cột), tên bắt đầu bằng chữ N*/
select student_code as 'Mã học sinh', concat(first_name," ",last_name) as 'Họ và tên' 
from students where last_name like 'n%';

/*Hiện danh sách sinh viên: mã hs, họ và tên (là 1 cột), trong tên có NA*/
select student_code as 'Mã học sinh', concat(first_name," ",last_name) as 'Họ và tên' 
from students where last_name like '%na%';

/*Đếm số sinh viên tên bắt đầu bằng chữ N*/
select count(last_name like 'n%') as 'Tổng sv'
from students;

/*Hiện danh sách sinh viên: họ và tên (là 1 cột), ngày sinh, tên lớp, tên GVCN.*/
select concat(first_name," ",last_name) as 'Họ và tên', dob as 'Ngày sinh', class_name as 'Tên lớp', teacher_name as 'Tên GVCN'
from students
join classrooms
on classrooms.id_class = students.id_class;

/*Hiện danh sách sinh viên: họ và tên (là 1 cột), ngày sinh, điểm trung bình, xếp loại*/
select students.student_id as STT, concat(first_name," ",last_name) as 'Họ và tên', dob as 'Ngày sinh', 
(math+physics+chemistry+literature)/4 as 'Điểm trung bình', classification as 'Xếp loại'
from students
join scores
on scores.student_id = students.student_id
group by students.student_id;

/*Đếm số học sinh của mỗi lớp*/
select count(student_code) as 'Số lượng sinh viên', class_name as 'Tên lớp'
from students
join classrooms
on classrooms.id_class = students.id_class
group by classrooms.id_class;

/*Hiển thị lớp có số lượng sinh viên lớn hơn 5*/
select class_name as 'Tên lớp'
from classrooms
join students
on classrooms.id_class = students.id_class
group by classrooms.id_class
having count(student_code) > 5;

/*Hiện thông lớp có số lượng sinh viên nhiều nhất*/
select count(s.student_code) as sl, c.class_name
from classrooms c
join students s
on c.id_class = s.id_class
group by c.id_class
having sl = ( 
	select max(sl) from (
		select count(student_code) as sl 
        from students 
        group by id_class
	) as abc
);

/* Tìm học sinh có điểm lớn nhất */
select concat(first_name,' ', last_name) as 'Họ và Tên', round((math+physics+chemistry+literature)/4,1) as 'Điểm trung bình'
from students s
join scores sc
on s.student_id = sc.student_id
group by sc.score_id
having `Điểm trung bình` = ( 
	select max(round((math+physics+chemistry+literature)/4,1)) from scores
);

/*Hiện ra danh sách các học sinh có điểm tb > 8*/
select concat(first_name,' ', last_name) as 'Họ và Tên', round((math+physics+chemistry+literature)/4,1) as 'Điểm trung bình'
from students s
join scores sc
on s.student_id = sc.student_id
group by sc.score_id
having `Điểm trung bình` > 8;

/*Tổng điểm tb của các bạn có tên bắt đầu bằng chữ NA*/
select sum(round((math+physics+chemistry+literature)/4,1)) as 'Tổng điểm trung bình'
from students s
join scores sc
on s.student_id = sc.student_id
where s.last_name like 'na%';

/*Hiện ra danh sách các học sinh có xếp loại là giỏi*/
select concat(first_name,' ', last_name) as `Họ và tên`, classification as `Xếp loại`
from students s
join scores sc
on s.student_id = sc.student_id
where sc.classification like 'gioi';

/*Đếm số lượng học sinh giỏi*/
select count(classification) as `Số lượng`, classification as `Xếp loại`
from scores 
where classification like 'gioi'
group by classification;

/*Đếm số lượng học sinh giỏi của từng lớp*/
select count(classification) as `Số lượng`, c.class_name as `Tên lớp`
from classrooms c
left join students s
on c.id_class = s.id_class
left join scores sc
on sc.student_id = s.student_id and classification = 'gioi'
group by class_name;

/*In ra các học sinh chưa tham gia thi*/
select concat(first_name,' ', last_name) as `Họ và Tên`
from students s
left join scores sc
on s.student_id = sc.student_id
where sc.math is null and sc.physics is null and sc.chemistry is null and sc.literature is null;

/*In ra học sinh có điểm trung bình lớn nhất của từng lớp*/
