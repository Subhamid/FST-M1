use Sdet4_Deepali;

create table salesman(
salesman_id int NOT NULL,
name varchar(20),
city varchar(20),
commission int,
PRIMARY KEY (salesman_id)
);

DESCRIBE salesman;

insert into salesman
Values
(5005,'Pit Alex','Paris',11),
(5006,'McLyon','London',14),
(5007,' Paul Adam','Rome',13),
(5003,'Lauson Hen','San Jose',12);

select * from salesman where salesman_id=5003;

select city,commision from salesman where salesman_id=5003 ;