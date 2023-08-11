REM   Script: FST-M1-JUL2023-SQL_Activity1_2_3
REM   FST-M1-JUL2023-SQL-Activity1_2_3

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

