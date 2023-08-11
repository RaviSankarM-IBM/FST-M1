REM   Script: FST-M1-JUL2023-SQL_Activity9_10_11
REM   FST-M1-JUL2023-SQL-Activity9_10_11

desc salesman


select * from tab;

CREATE TABLE salesman ( 
    salesman_id int, 
    salesman_name varchar2(20), 
    salesman_city varchar2(20), 
    commission int 
);

DESCRIBE SALESMAN


ALTER TABLE SALESMAN MODIFY SALESMAN_ID INT PRIMARY KEY;

DESCRIBE SALESMAN


INSERT INTO SALESMAN VALUES(5001, 'James Hoog', 'New York', 15);

INSERT ALL 
    INTO salesman VALUES(5002, 'Nail Knite', 'Paris', 13) 
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11) 
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14) 
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13) 
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12) 
SELECT 1 FROM DUAL;

SELECT * FROM salesman;

SELECT SALESMAN_ID, SALESMAN_CITY FROM SALESMAN;

SELECT * FROM SALESMAN WHERE SALESMAN_CITY='Paris';

SELECT SALESMAN_ID, COMMISSION FROM SALESMAN WHERE SALESMAN_NAME='Paul Adam';

DESCRIBE SALESMAN


ALTER TABLE SALESMAN ADD GRADE INT;

DESCRIBE SALESMAN


UPDATE SALESMAN SET GRADE = 100;

SELECT * FROM SALESMAN;

UPDATE SALESMAN SET GRADE = 200 WHERE SALESMAN_CITY = 'Rome';

UPDATE SALESMAN SET GRADE = 300 WHERE SALESMAN_NAME = 'James Hoog';

UPDATE SALESMAN SET SALESMAN_NAME = 'Pierre' WHERE SALESMAN_NAME = 'McLyon';

SELECT * FROM SALESMAN;

create table orders( 
    order_no int primary key, purchase_amount float, order_date date, 
    customer_id int, salesman_id int);

DESC ORDERS


INSERT ALL 
    INTO orders VALUES(70001, 150.5, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3005, 5002)  
    INTO orders VALUES(70009, 270.65, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3001, 5005) 
    INTO orders VALUES(70002, 65.26, TO_DATE('2012/10/05', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70004, 110.5, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70007, 948.5, TO_DATE('2012/09/10', 'YYYY/MM/DD'), 3005, 5002) 
    INTO orders VALUES(70005, 2400.6, TO_DATE('2012/07/27', 'YYYY/MM/DD'), 3007, 5001) 
    INTO orders VALUES(70008, 5760, TO_DATE('2012/08/15', 'YYYY/MM/DD'), 3002, 5001) 
    INTO orders VALUES(70010, 1983.43, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3004, 5006) 
    INTO orders VALUES(70003, 2480.4, TO_DATE('2012/10/10', 'YYYY/MM/DD'), 3009, 5003) 
    INTO orders VALUES(70012, 250.45, TO_DATE('2012/06/27', 'YYYY/MM/DD'), 3008, 5002) 
    INTO orders VALUES(70011, 75.29, TO_DATE('2012/08/17', 'YYYY/MM/DD'), 3003, 5007) 
    INTO orders VALUES(70013, 3045.6, TO_DATE('2012/04/25', 'YYYY/MM/DD'), 3002, 5001) 
SELECT 1 FROM DUAL;

SELECT * FROM ORDERS;

SELECT DISTINCT SALESMAN_ID FROM ORDERS;

SELECT ORDER_NO, ORDER_DATE FROM ORDERS ORDER BY ORDER_DATE ASC;

SELECT ORDER_NO, PURCHASE_AMOUNT FROM ORDERS ORDER BY PURCHASE_AMOUNT DESC;

SELECT * FROM ORDERS WHERE PUCHASE_AMOUNT BETWEEN 1000 AND 2000;

SELECT * FROM ORDERS WHERE PURCHASE_AMOUNT < 500;

SELECT * FROM ORDERS;

SELECT SUM(PUCHASE_AMOUNT) AS 'TOTAL PURCHASE AMOUNT' FROM ORDERS;

SELECT SUM(PURCHASE_AMOUNT) AS 'TOTAL PURCHASE AMOUNT' FROM ORDERS;

SELECT * FROM ORDERS;

SELECT SUM(PURCHASE_AMOUNT) AS 'TOTAL_PURCHASE_AMOUNT' FROM ORDERS;

SELECT AVG(PURCHASE_AMOUNT) AS 'AVERAGE PURCHASE AMOUNT' FROM ORDERS;

SELECT SUM(PURCHASE_AMOUNT) AS 'TOTALPURCHASEAMOUNT' FROM ORDERS;

SELECT COUNT(DISTINCT SALESMAN_ID) AS 'NUMBER OF SALESMAN' FROM ORDERS;

SELECT * FROM ORDERS;

SELECT SUM(ORDER_ID) FROM ORDERS;

SELECT COUNT(ORDER_ID) FROM ORDERS;

SELECT COUNT(order_id) FROM ORDERS;

DESCRIBE ORDERS


SELECT COUNT(order_no) FROM ORDERS;

SELECT COUNT(DISTINCT salesman_id) AS 'NUMBER OF SALESMAN' FROM ORDERS;

SELECT COUNT(DISTINCT SALESMAN_ID) AS 'NUMBER OF SALESMAN' FROM ORDERS;

SELECT SUM(purchase_amount) AS 'TOTAL PURCHASE AMOUNT' FROM ORDERS;

SELECT * FROM ORDERS;

DESCRIBE ORDERS


SELECT * FROM ORDERS;

SELECT MAX(PUCHASE_AMOUNT) FROM ORDERS;

SELECT MAX('PUCHASE_AMOUNT') FROM ORDERS;

SELECT MAX("PUCHASE_AMOUNT") FROM ORDERS;

SELECT MAX(PUCHASE_AMOUNT) AS 'MAXIMUM' FROM ORDERS;

SELECT * FROM ORDERS;

SELECT MAX(PUCHASE_AMOUNT) AS 'MAXIMUM' FROM ORDERS GROUP BY ORDER_NO;

DESCRIBE ORDERS


DESC ORDERS


SELECT * FROM ORDERS;

SELECT ORDER_NO, MAX(PURCHASE_AMOUNT) AS 'MAXIMUM PURCHASE AMOUNT' FROM ORDERS GROUP BY ORDER_NO;

SELECT ORDER_NO, MAX(PURCHASE_AMOUNT) AS "MAXIMUM PURCHASE AMOUNT" FROM ORDERS GROUP BY ORDER_NO;

DESC ORDERS


DESCRIBE ORDERS


SELECT * FROM ORDERS;

SELECT SUM(PURCHASE_AMOUNT) AS "TOTAL PUCHASE AMOUNT" FROM ORDERS;

SELECT AVG(PURCHASE_AMOUNT) AS "AVERAGE PUCHASE AMOUNT" FROM ORDERS;

SELECT MAX(PUCHASE_AMOUNT) AS "MAXIMUM PURCAHSE AMOUNT" FROM ORDERS;

SELECT MAX(PURCHASE_AMOUNT) AS "MAXIMUM PURCAHSE AMOUNT" FROM ORDERS;

SELECT MIM(PURCHASE_AMOUNT) AS "MINIMUM PUCHASE AMOUNT" FROM ORDERS;

SELECT MIN(PURCHASE_AMOUNT) AS "MINIMUM PUCHASE AMOUNT" FROM ORDERS;

SELECT COUNT(DISTINCT SALESMAN_ID) AS "TOTAL SALESMAN" FROM ORDERS;

DESC ORDERS


DESCRIBE ORDERS


SELECT * FROM ORDERS;

SELECT AVG(PURCHASE_AMOUNT) AS "AVERAGE PURCHASE AMOUNT" FROM ORDERS;

SELECT SUM(PURCHASE_AMOUNT) AS "TOTAL PURCHASE AMOUNT" FROM ORDERS;

SELECT AVG(PURCHASE_AMOUNT) AS "AVERAGE PURCHASE AMOUNT" FROM ORDERS;

SELECT MAX(PURCHASE_AMOUNT) AS "MAXIMUM PURCAHSE AMOUNT" FROM ORDERS;

SELECT MIN(PURCHASE_AMOUNT) AS "MINIMUM PUCHASE AMOUNT" FROM ORDERS;

SELECT COUNT(DISTINCT SALESMAN_ID) AS "TOTAL SALESMAN" FROM ORDERS;

SELECT * FROM ORDERS;

SELECT CUSTOMER_ID, MAX(PURCHASE_AMOUNT) AS "MAX PURCHASE AMOUNT" FROM ORDERS ORDER BY CUSTOMER_ID;

SELECT CUSTOMER_ID, MAX(PURCHASE_AMOUNT) AS "MAX PURCHASE AMOUNT" FROM ORDERS GROUP BY CUSTOMER_ID;

SELECT * FROM ORDERS;

SELECT SALESMAN_ID, ORDER_DATE, MAX(PURCHASE_AMOUNT) AS "MAX PURCHASE AMOUNT" FROM ORDERS WHERE ORDER_DATE = To_DATE('2012/08/17', 'YYYY/MM/DD') GROUP BY SALESMAN_ID, ORDER_DATE;

SELECT CUSTOMER_ID, ORDER_DATE, MAX(PURCHASE_AMOUNT) AS "MAX PUCHASE AMOUNT" FROM ORDERS GROUP BY CUSTOMER_ID, ORDER_DATE HAVING MAX(PURCHASE_AMOUNT) IN (2030, 3450, 5760, 6000);

select * from customers;

create table customers ( 
    customer_id int primary key, customer_name varchar(32), 
    city varchar(20), grade int, salesman_id int);

describe customers


INSERT ALL 
    INTO customers VALUES (3002, 'Nick Rimando', 'New York', 100, 5001) 
    INTO customers VALUES (3007, 'Brad Davis', 'New York', 200, 5001) 
    INTO customers VALUES (3005, 'Graham Zusi', 'California', 200, 5002) 
    INTO customers VALUES (3008, 'Julian Green', 'London', 300, 5002) 
    INTO customers VALUES (3004, 'Fabian Johnson', 'Paris', 300, 5006) 
    INTO customers VALUES (3009, 'Geoff Cameron', 'Berlin', 100, 5003) 
    INTO customers VALUES (3003, 'Jozy Altidor', 'Moscow', 200, 5007) 
    INTO customers VALUES (3001, 'Brad Guzan', 'London', 300, 5005) 
SELECT 1 FROM DUAL;

select * from customers;

select * from salesman;

select c.customer_name AS "Customer Name", c.city, s.name AS "Salesman", s.commission from customers c inner join salesman s on c.salesman_id = s.salesman_id;

select c.customer_name AS "Customer Name", c.city, s.name AS "Salesman", s.commission from customers c inner join salesman s on c.salesman_id = s.salesman_id;

SELECT a.customer_name AS "Customer Name", a.city, b.name AS "Salesman", b.commission FROM customers a  
INNER JOIN s;

SELECT a.customer_name AS "Customer Name", a.city, b.name AS "Salesman", b.commission FROM customers a  
INNER JOIN salesman b ON a.salesman_id=b.salesman_id;

select * from salesman;

SELECT a.customer_name AS "Customer Name", a.city, b.name, b.commission FROM customers a  
INNER JOIN salesman b ON a.salesman_id=b.salesman_id;

select * from salesman;

select c.customer_name AS "Customer Name", c.city, s.salesname AS "Salesman", s.commission from customers c inner join salesman s on c.salesman_id = s.salesman_id;

select c.customer_name AS "Customer Name", c.city, s.sales_name AS "Salesman", s.commission from customers c inner join salesman s on c.salesman_id = s.salesman_id;

select * from salesman;

select c.customer_name AS "Customer Name", c.city, s.salesman_name AS "Salesman", s.commission from customers c inner join salesman s on c.salesman_id = s.salesman_id;

select * from customers;

select * from salesman;

SELECT c.customer_name, c.city, c.grade, s.salesman_name AS "Salesman", s.salesman_city FROM customers c  
LEFT OUTER JOIN salesman s ON c.salesman_id=s.salesman_id WHERE c.grade<300  
ORDER BY c.customer_id;

SELECT c.customer_name AS "Customer Name", c.city, s.salesman_name AS "Salesman", s.commission FROM customers c  
INNER JOIN salesman s ON c.salesman_id=s.salesman_id  
WHERE s.commission>12;

SELECT a.order_no, a.order_date, a.purchase_amount, b.customer_name AS "Customer Name", b.grade, s.salesman_name AS "Salesman", c.commission FROM orders a  
INNER JOIN customers b ON a.customer_id=b.customer_id  
INNER JOIN salesman s ON a.salesman_id=s.salesman_id;

SELECT a.order_no, a.order_date, a.purchase_amount, b.customer_name AS "Customer Name", b.grade, s.salesman_name AS "Salesman", s.commission FROM orders a  
INNER JOIN customers b ON a.customer_id=b.customer_id  
INNER JOIN salesman s ON a.salesman_id=s.salesman_id;

SELECT * FROM orders WHERE salesman_id=(SELECT DISTINCT salesman_id FROM orders WHERE customer_id=3007);

SELECT * FROM orders WHERE salesman_id IN (SELECT salesman_id FROM salesman WHERE city='New York');

select * from salesman;

SELECT * FROM orders WHERE salesman_id IN (SELECT salesman_id FROM salesman WHERE salesman_city='New York');

SELECT grade, COUNT(*) FROM customers GROUP BY grade HAVING grade>(SELECT AVG(grade) FROM customers WHERE city='New York');

SELECT order_no, purchase_amount, order_date, salesman_id FROM orders 
WHERE salesman_id IN( SELECT salesman_id FROM salesman 
WHERE commission=( SELECT MAX(commission) FROM salesman));

select * from salesman;

SELECT customer_id, customer_name FROM customers a 
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.customer_id = b.customer_id) 
UNION 
SELECT salesman_id, salesman_name FROM salesman a 
WHERE 1<(SELECT COUNT(*) FROM orders b WHERE a.salesman_id = b.salesman_id) 
ORDER BY customer_name;

SELECT a.salesman_id, salesman_name, order_no, 'highest on', order_date FROM salesman a, orders b 
WHERE a.salesman_id=b.salesman_id 
AND b.purchase_amount=(SELECT MAX(purchase_amount) FROM orders c WHERE c.order_date = b.order_date) 
UNION 
SELECT a.salesman_id, salesman_name, order_no, 'lowest on', order_date FROM salesman a, orders b 
WHERE a.salesman_id=b.salesman_id 
AND b.purchase_amount=(SELECT MIN(purchase_amount) FROM orders c WHERE c.order_date = b.order_date);

