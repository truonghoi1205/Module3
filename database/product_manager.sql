drop database if exists product_manager;
create database if not exists product_manager;
use product_manager;

create table phieu_xuat(
SoPx int primary key 
auto_increment,
NgayXuat date
);
create table vat_tu(
MaVTU int primary key 
auto_increment,
TenVTU varchar(255)
);

create table ct_px(
id_vt int,
id_px int,
primary key (id_vt,id_px),
dg_xuat varchar(255),
sl_xuat varchar(255),
foreign key(id_vt) references vat_tu(MaVTU),
foreign key(id_px) references phieu_xuat(SoPx)
);

create table phieu_nhap(
SoPN int primary key
auto_increment,
Ngay_nhap date
);

create table ct_pn(
id_vt int,
id_pn int,
primary key(id_vt,id_pn),
dg_nhap varchar(255),
sl_nhap varchar(255),
foreign key(id_vt) references vat_tu(MaVTU),
foreign key(id_pn) references phieu_nhap(SoPN)
);
create table ncc(
Ma_ncc int primary key
auto_increment,
Ten_ncc varchar(255),
dia_chi varchar(255)
);

create table don_dh(
So_dh int primary key 
auto_increment,
Ngay_dh date,
id_ncc int,
foreign key(id_ncc) references ncc(Ma_ncc)
);

create table ct_don_dh(
id_vt int,
id_ddh int,
primary key(id_vt,id_ddh),
foreign key(id_vt) references vat_tu(MaVTU),
foreign key(id_ddh) references don_dh(So_dh)
);

create table sdt(
sdt varchar(10) primary key,
id_ncc int,
foreign key(id_ncc) references ncc(Ma_ncc)
);



