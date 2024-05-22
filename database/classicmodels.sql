use classicmodels;
/*Hiển thị một số trường dữ liệu trong bảng products (productCode, productName, productVendor, quantityInStock, MSRP), buyPrice với điều kiện buyPrice > 20 và <100.*/
select p.productName, p.productVendor, p.quantityInStock,p.MSRP, p.buyPrice
from products p
where p.buyPrice between 20 and 100;

/*Hiển thị thông tin product có tên sản phẩm chứa ký tự a/A hoặc prductVendor chứa ký tự b/B*/
select * from products 
where productName like '%a%' or productVendor like '%b%';

/*Cập nhập tên khách hàng (customerName) thành ‘James’ với mã khách hàng (customerNumber) là 106 */
update customers set customerName = "james" where customerNumber = 106;

/*Tính tổng số tiền của các đơn hàng theo trạng thái đặt hàng*/
select orders.status, sum(orderdetails.priceEach * orderdetails.quantityOrdered) as totalAmount
from orders
join orderdetails
on orderdetails.orderNumber = orders.orderNumber
group by orders.status;

/*Tính tổng doanh thu của những năm lớn hơn năm 2003.*/
select sum(orderdetails.priceEach * orderdetails.quantityOrdered) as totalAmout
from orders
join orderdetails 
on orderdetails.orderNumber = orders.orderNumber
where year(orders.orderDate) > 2003;

/*Tính tổng tiền từng đơn hàng*/
select orderNumber, sum(orderdetails.priceEach * orderdetails.quantityOrdered) as TotalAmountPerOrder
from orderdetails
group by orderNumber;

/*Hiển thị tất cả các sản phẩm được mua vào năm 2003, chuyển toàn bộ tên sản phẩm sang chữ hoa, tên nhà sản xuất chữ thường.*/
select p.productCode, UCASE(p.productName) as `name_product`, LCASE(p.productVendor) as `product_vendor`
from products p
join orderdetails ordt
on p.productCode = ordt.productCode
join orders od
on ordt.orderNumber = od.orderNumber
where year(od.orderDate) = 2003
group by p.productCode;


