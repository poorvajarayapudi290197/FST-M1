REM   Script: Activity3
REM   Select from table

CREATE table customer2(CustomerId int PRIMARY KEY,CustomerName Varchar(52) NOT NULL,ContactName Varchar(32),Address Varchar(255),city Varchar(30),postalcode varchar(20),country varchar(20) 
);

DESCRIBE


DESCRIBE customer2


CREATE table salesman(salesman_id int PRIMARY KEY,salesman_name varchar2(20) NOT NULL,salesman_city varchar2(20),commission varchar2(20))  
;

DESCRIBE salesman


INSERT ALL 
    INTO salesman VALUES(5001, 'James Hoog', 'New York', 15) 
    INTO salesman VALUES(5002, 'Nail Knite', 'Paris', 13) 
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11) 
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14) 
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13) 
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12);

INSERT ALL 
    INTO salesman VALUES(5001, 'James Hoog', 'New York', 15) 
    INTO salesman VALUES(5002, 'Nail Knite', 'Paris', 13) 
    INTO salesman VALUES(5005, 'Pit Alex', 'London', 11) 
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14) 
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13) 
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12) 
SELECT 1 FROM DUAL;

SELECT * FROM salesman;

select salesman_id,salesman_city from salesman;

select * from salesman;

select * from salesman where salesman_city='Paris';

select * from salesman;

select salesman_id,commission where salesman_name='Paul Adam';

select salesman_id,commission from salesman where salesman_name='Paul Adam';
