CREATE TABLE employees (
	id bigint auto_increment,
	first_name varchar(50),
	last_name varchar(50),
	hire_date timestamp,
	gender varchar(50),
	position varchar(50),
	salary decimal,
	PRIMARY KEY (id)
);

INSERT INTO employees (first_name, last_name, hire_date, gender, position, salary)
VALUES ('Vasya', 'Pupkin', '2016-01-02', 'Male', 'Plumber', 100);