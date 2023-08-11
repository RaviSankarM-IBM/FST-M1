REM   Script: FST-M1-JUL2023-SQL_Activity7_8
REM   FST-M1-JUL2023-SQL-Activity7_8

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

