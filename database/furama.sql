create database furama_resort;
use furama_resort;

create table ViTri (
    IDViTri int primary key auto_increment,
    TenViTri varchar(45)
);

-- Bảng TrinhDo (Qualifications)
create table TrinhDo (
    IDTrinhDo int primary key auto_increment,
    TenTrinhDo varchar(45)
);

-- Bảng BoPhan (Departments)
create table BoPhan (
    IDBoPhan int primary key auto_increment,
    TenBoPhan varchar(45)
);

-- Bảng NhanVien (Employees)
create table NhanVien (
    IDNhanVien int primary key auto_increment,
    HoTen varchar(45),
    NgaySinh date,
    SoCMND varchar(45),
	Luong int,
    SoDT varchar(45),
    Email varchar(45),
    DiaChi varchar(45),
	IDViTri int,
    IDTrinhDo int,
    IDBoPhan int,
    foreign key (IDTrinhDo) references TrinhDo(IDTrinhDo),
    foreign key (IDViTri) references ViTri(IDViTri),
    foreign key (IDBoPhan) references BoPhan(IDBoPhan)
);

-- Bảng LoaiKhach (Customer Types)
create table LoaiKhach (
    IDLoaiKhach int primary key auto_increment,
    TenLoaiKhach varchar(45) 
);

-- Bảng KhachHang (Customers)
create table KhachHang (
    IDKhachHang int primary key auto_increment,
    HoTen varchar(45),
    NgaySinh date,
    GioiTinh varchar(45),
    SoCMND varchar(45),
    SoDT varchar(45),
    Email varchar(45),
    DiaChi varchar(45),
    IDLoaiKhach int,
    foreign key (IDLoaiKhach) references LoaiKhach(IDLoaiKhach)
);

-- Bảng KieuThue (Rental Types)
create table KieuThue (
    IDKieuThue int primary key auto_increment,
    TenKieuThue varchar(45),
    Gia int  
);

-- Bảng LoaiDichVu (Service Types)
create table LoaiDichVu (
    IDLoaiDichVu int primary key auto_increment,
    TenLoaiDichVu varchar(45) 
);

-- Bảng DichVu (Services)
create table DichVu (
    IDDichVu int primary key auto_increment,
    TenDichVu varchar(45),
    DienTich int,
    SoTang int,
    SoNguoiToiDa int,
    ChiPhiThue int,
    IDKieuThue int,
    IDLoaiDichVu int,
    TrangThai varchar(45),
    foreign key (IDKieuThue) references KieuThue(IDKieuThue),
    foreign key (IDLoaiDichVu) references LoaiDichVu(IDLoaiDichVu)
);

-- Bảng DichVuDiKem (Additional Services)
create table DichVuDiKem (
    IDDichVuDiKem int primary key auto_increment,
    TenDichVuDiKem varchar(45),
    Gia int,
    DonVi varchar(45),
    TrangThaiDung varchar(45)
);

-- Bảng HopDong (Contracts)
create table HopDong (
    IDHopDong int primary key auto_increment,
    NgayLamHopDong date,
    NgayKetThuc date,
    TienDatCoc int,
    TongTien int,
    IDKhachHang int,
    IDNhanVien int,
    IDDichVu int,
    foreign key (IDKhachHang) references KhachHang(IDKhachHang),
    foreign key (IDNhanVien) references NhanVien(IDNhanVien),
    foreign key (IDDichVu) references DichVu(IDDichVu)
);

-- Bảng HopDongChiTiet (Contract Details)
create table HopDongChiTiet (
    IDHopDongChiTiet int primary key auto_increment,
    IDHopDong int,
    IDDichVuDiKem int,
    SoLuong int,
    foreign key (IDHopDong) references HopDong(IDHopDong),
    foreign key (IDDichVuDiKem) references DichVuDiKem(IDDichVuDiKem)
);

insert into ViTri values (default,'Quản lý'),(default,'Nhân viên');
insert into TrinhDo values (default,'Trung cấp'),(default,'Cao đẳng'),(default,'Đại học'),(default,'Sau đại học');
insert into BoPhan values (default,'Sale-Marketing'),(default,'Hành chinh'),(default,'Phục vụ'),(default,'Quản lý');
insert into LoaiKhach values(default,'Diamond'),(default,'Platinium'),(default,'Gold'),(default,'Silver'),(default,'Member');
insert into KieuThue values(default,'year',null),(default,'month',null),(default,'day',null),(default,'hour',null);
insert into LoaiDichVu values(default,'Villa'),(default,'House'),(default,'Room');
insert into nhanvien(IDNhanVien,HoTen,NgaySinh,SoCMND,Luong,SoDT,Email,DiaChi,IDViTri,IDTrinhDo,IDBoPhan) values
(1,"Nguyễn Văn An",'1970-11-07',456231786,10000000,0901234121,'annguyen@gmail.com',"295 Nguyễn Tất Thành, Đà Nẵng",1,3,1),
(2,"Lê Văn Bình",'1997-04-09','654231234',7000000,0934212314,'binhlv@gmail.com',"22 Yên Bái, Đà Nẵng",1,2,2),
(3,"Hồ Thị Yến",'1995-12-12',999231723,14000000,0412352315,'thiyen@gmail.com',"K234/11 Điện Biên Phủ, Gia Lai",1,3,2),
(4,"Võ Công Toản",'1980-04-04',123231365,17000000,0374443232,'toan0404@gmail.com',"77 Hoàng Diệu, Quảng Trị",1,4,4),
(5,"Nguyễn Bỉnh Phát",'1999-12-09',454363232,6000000,0902341231,'phatphat@gmail.com',"43 Yên Bái, Đà Nẵng",2,1,1),
(6,"Khúc Nguyễn An Nghi",'2000-11-08',964542311,7000000,0978653213,'annghi20@gmail.com',"294 Nguyễn Tất Thành, Đà Nẵng",2,2,3),
(7,"Nguyễn Hữu Hà",'1993-01-01',534323231,8000000,0941234553,'nhh0101@gmail.com',"4 Nguyễn Chí Thanh, Huế",2,3,2),
(8,"Nguyễn Hà Đông",'1989-09-03',234414123,9000000,0642123111,'donghanguyen@gmail.com',"111 Hùng Vương, Hà Nội",2,4,4),
(9,"Tòng Hoang",'1982-09-03',256781231,6000000,0245144444,'hoangtong@gmail.com',"213 Hàm Nghi, Đà Nẵng",2,4,4),
(10,"Nguyễn Công Đạo",'1994-01-08',755434343,8000000,0988767111,'nguyencongdao12@gmail.com',"6 Hoà Khánh, Đồng Nai",2,3,2);

INSERT INTO KhachHang (`HoTen`, `NgaySinh`, `GioiTinh`, `SoCMND`, `SoDT`, `Email`, `DiaChi`, `IDLoaiKhach`) VALUES 
('Nguyễn Thị Hào', '1970-11-07', '0', '643431213', '0945423362', 'thihao07@gmail.com', '23 Nguyễn Hoàng, Đà Nẵng', '5'),
('Phạm Xuân Diệu', '1992-08-08', '1', '865342123', '0954333333', 'xuandieu92@gmail.com', 'K77/22 Thái Phiên, Quảng Trị', '3'),
('Trương Đình Nghệ', '1990-02-27', '1', '488645199', '0373213122', 'nghenhan2702@gmail.com', 'K323/12 Ông Ích Khiêm, Vinh', '1'),
('Dương Văn Quan', '1981-07-08', '1', '543432111', '0490039241', 'duongquan@gmail.com', 'K453/12 Lê Lợi, Đà Nẵng', '1'),
('Hoàng Trần Nhi Nhi', '1995-12-09', '0', '795453345', '0312345678', 'nhinhi123@gmail.com', '224 Lý Thái Tổ, Gia Lai', '4'),
('Tôn Nữ Mộc Châu', '2005-12-06', '0', '732434215', '0988888844', 'tonnuchau@gmail.com', '37 Yên Thế, Đà Nẵng', '4'),
('Nguyễn Mỹ Kim', '1984-04-08', '0', '856453123', '0912345698', 'kimcuong84@gmail.com', 'K123/45 Lê Lợi, Hồ Chí Minh', '1'),
('Nguyễn Thị Hào', '1999-04-08', '0', '965656433', '0763212345', 'haohao99@gmail.com', '55 Nguyễn Văn Linh, Kon Tum', '3'),
('Trần Đại Danh', '1994-07-01', '1', '432341235', '0643343433', 'danhhai99@gmail.com', '24 Lý Thường Kiệt, Quảng Ngãi', '1'),
('Nguyễn Tâm Đắc', '1989-07-01', '1', '344343432', '0987654321', 'dactam@gmail.com', '22 Ngô Quyền, Đà Nẵng', '2');

-- cau 1
select * from NhanVien where HoTen regexp '^[HTK]' and length(HoTen) <= 16;
-- cau 2
select * from Khachhang where (year(curdate()) - year(NgaySinh)) between 18 and 50
and (DiaChi like '%Đà Nẵng%' or DiaChi like '%Quảng Trị%');
-- cau 3
select kh.HoTen, count(hd.IDHopDong) as SoLanDatPhong
from KhachHang kh
join LoaiKhach lk 
on KH.IDLoaiKhach = lk.IDLoaiKhach
join HopDong hd 
on kh.IDKhachHang = hd.IDKhachHang
where lk.TenLoaiKhach = 'Diamond'
group by kh.HoTen
order by SoLanDatPhong;
-- cau 4
select kh.IDKhachHang,kh.HoTen,lk.TenLoaiKhach,hd.IDHopDong,dv.TenDichVu,hd.NgayLamHopDong,hd.NgayKetThuc, (dv.ChiPhiThue + hdct.SoLuong * dvdk.Gia) as TongTien
from KhachHang kh
join LoaiKhach lk 
on kh.IDLoaiKhach = lk.IDLoaiKhach
left join HopDong hd 
on kh.IDKhachHang = hd.IDKhachHang
left join HopDongChiTiet hdct 
on hd.IDHopDong = hdct.IDHopDong
left join DichVu dv 
on hd.IDDichVu = dv.IDDichVu
left join DichVuDiKem dvdk 
on hdct.IDDichVuDiKem = dvdk.IDDichVuDiKem
order by kh.IDKhachHang, hd.IDHopDong;

-- cau 5
select dv.IDDichVu, dv.TenDichVu, dv.DienTich, dv.ChiPhiThue, ldv.TenLoaiDichVu
from DichVu dv 
join LoaiDichVu ldv
on ldv.IDLoaiDichVu = dv.IDLoaiDichVu
left join HopDong hd
on hd.IDDichVu = dv.IDDichVu
left join KhachHang kh 
on hd.IDKhachHang = kh.IDKhachHang
where year(hd.NgayLamHopDong) = 2019
    and (
        month(hd.NgayLamHopDong) = 1 or
        month(hd.NgayLamHopDong) = 2 or
        month(hd.NgayLamHopDong) = 3
    ) and kh.IDKhachHang is null
order by dv.IDDichVu;

-- cau 6

select dv.IDDichVu,dv.TenDichVu,dv.DienTich,dv.SoNguoiToiDa,dv.ChiPhiThue,ldv.TenLoaiDichVu
from DichVu dv
join LoaiDichVu ldv 
on dv.IDLoaiDichVu = ldv.IDLoaiDichVu
join HopDong hd 
on dv.IDDichVu = hd.IDDichVu
join KhachHang kh
on hd.IDKhachHang = kh.IDKhachHang
where year(hd.NgayLamHopDong) = 2018
    and kh.IDKhachHang not in (
        select distinct IDKhachHang
        from HopDong
        where year(NgayLamHopDong) = 2019
    )
order by dv.IDDichVu;

-- cau 7
select distinct HoTen from KhachHang;

select HoTen from KhachHang
group by HoTen;

-- cau 8
select month(hd.NgayLamHopDong) as Thang,count(distinct hd.IDKhachHang) as SoLuongKhachHangDatPhong
from HopDong hd
where year(hd.NgayLamHopDong) = 2020
group by month(hd.NgayLamHopDong)
order by Thang;

-- cau 9
select hd.IDHopDong,hd.NgayLamHopDong,hd.NgayKetThuc,hd.TienDatCoc,count(hdct.IDHopDongChiTiet) as SoLuongDichVuDiKem
from HopDong hd
left join HopDongChiTiet hdct 
on hd.IDHopDong = hdct.IDHopDong
group by hd.IDHopDong, hd.NgayLamHopDong, hd.NgayKetThuc, hd.TienDatCoc
order by hd.IDHopDong;

-- cau 10
select distinct dvdk.IDDichVuDiKem,dvdk.TenDichVuDiKem,dvdk.Gia,dvdk.DonVi,dvdk.TrangThaiDung
from KhachHang kh
join LoaiKhach lk 
on kh.IDLoaiKhach = lk.IDLoaiKhach
join HopDong hd 
on kh.IDKhachHang = hd.IDKhachHang
join HopDongChiTiet hdct 
on hd.IDHopDong = hdct.IDHopDong
join DichVuDiKem dvdk 
on hdct.IDDichVuDiKem = dvdk.IDDichVuDiKem
where(lk.TenLoaiKhach = 'Diamond') and (kh.DiaChi like '%Vinh%' or kh.DiaChi like '%Quảng Ngãi%');

-- cau 11 
select hd.IDHopDong,nv.HoTen,kh.HoTen as TenKhachHang,kh.SoDT as SoDienThoaiKhachHang,dv.TenDichVu,sum(hdct.SoLuong) as SoLuongDichVuDikem,hd.TienDatCoc
from HopDong hd
join NhanVien nv 
on hd.IDNhanVien = nv.IDNhanVien
join KhachHang kh 
on hd.IDKhachHang = kh.IDKhachHang
join DichVu dv 
on hd.IDDichVu = dv.IDDichVu
left join HopDongChiTiet hdct 
on hd.IDHopDong = hdct.IDHopDong
where year(hd.NgayLamHopDong) = 2020 and month(hd.NgayLamHopDong) in (10, 11, 12) and hd.IDHopDong not in (
        select distinct hd.IDHopDong
        from HopDong hd
        where year(hd.NgayLamHopDong) = 2020
        and month(hd.NgayLamHopDong) in (1, 2, 3) 
    )
group by hd.IDHopDong, nv.HoTen, kh.HoTen, kh.SoDT, dv.TenDichVu, hd.TienDatCoc
order by hd.IDHopDong;

-- cau 12
select dvdk.IDDichVuDiKem, dvdk.TenDichVuDiKem, dvdk.Gia, dvdk.DonVi, dvdk.TrangThaiDung, count(*) as SoLanSuDung
from HopDong hd
join HopDongChiTiet hdct 
on hd.IDHopDong = hdct.IDHopDong
join DichVuDiKem dvdk 
on hdct.IDDichVuDiKem = dvdk.IDDichVuDiKem
group by dvdk.IDDichVuDiKem, dvdk.TenDichVuDiKem, dvdk.Gia, dvdk.DonVi, dvdk.TrangThaiDung
order by count(*) desc;

-- cau 13
select hd.IDHopDong,ldv.TenLoaiDichVu,dvdk.TenDichVuDiKem,count(*) as SoLanSuDung
from HopDong hd
join HopDongChiTiet hdct 
on hd.IDHopDong = hdct.IDHopDong
join DichVuDiKem dvdk 
on hdct.IDDichVuDiKem = dvdk.IDDichVuDiKem
join DichVu dv 
on hd.IDDichVu = dv.IDDichVu
join LoaiDichVu ldv 
on dv.IDLoaiDichVu = ldv.IDLoaiDichVu
group by hd.IDHopDong, ldv.TenLoaiDichVu, dvdk.TenDichVuDiKem
having count(*) = 1;

-- cau 14 
select nv.IDNhanVien,nv.HoTen,td.TenTrinhDo as TrinhDo,bp.TenBoPhan,nv.SoDT as SoDienThoai,nv.DiaChi,count(hd.IDHopDong) AS SoHopDong
from NhanVien nv
join HopDong hd 
on nv.IDNhanVien = hd.IDNhanVien
join TrinhDo td
on nv.IDTrinhDo = td.IDTrinhDo
join BoPhan bp
on nv.IDBoPhan = bp.IDBoPhan
where year(hd.NgayLamHopDong) between 2020 and 2021
group by nv.IDNhanVien, nv.HoTen, td.TenTrinhDo, bp.TenBoPhan, nv.SoDT, nv.DiaChi
having count(hd.IDHopDong) <= 3;

-- cau 15
delete from NhanVien
where IDNhanVien not in (
    select nv.IDNhanVien
    from NhanVien nv
    left join HopDong hd on nv.IDNhanVien = hd.IDNhanVien where year(hd.NgayLamHopDong) between 2020 and 2021
);

-- cau 16
update KhachHang set HoTen = 'Diamond'
where IDKhachHang in (
    select kh.IDKhachHang
    from KhachHang kh
    join HopDong hd 
    on kh.IDKhachHang = hd.IDKhachHang
    where kh.HoTen = 'Platinium' and year(hd.NgayLamHopDong) = 2019
    group by kh.IDKhachHang
    having sum(hd.TongTien) > 10000000
);

-- cau 19
SELECT IDNhanVien AS ID,HoTen,Email,SoDT AS SoDienThoai,NgaySinh,DiaChi FROM NhanVien
UNION ALL
SELECT IDKhachHang AS ID,HoTen,Email,SoDT AS SoDienThoai, NgaySinh,DiaChi FROM KhachHang;
