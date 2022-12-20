create database if not exists project_smartphone;
use project_smartphone;

create table if not exists user(
	username varchar(30) primary key,
    `password` varchar(200),
    is_delete bit default 0
);

create table  if not exists role(
	id int primary key auto_increment,
    `name` varchar(30),
    is_delete bit default 0
);

create table if not exists user_role(
	username varchar(50),
    role_id int,
    is_delete bit default 0,
    foreign key(username) references user(username),
    foreign key(role_id) references role(id),
    primary key(username, role_id)
);


create table if not exists customer_type(
	id int primary key auto_increment,
    `name` varchar(30),
    is_delete bit default 0
);

create table if not exists customer(
	id int primary key auto_increment,
	`name` varchar(30),
	is_delete bit default 0,
	day_of_birth varchar(30),
	gender int,
	id_card varchar(12),
	email varchar(100),
	address varchar(200),
	phone_number varchar(15),
	username varchar(30) unique,
	customer_type_id int,
	foreign key (username) references user(username),
	foreign key (customer_type_id) references customer_type(id)
);
create table if not exists employee(
	id int primary key auto_increment,
	`name` varchar(50),
	gender int,
	email varchar(100),
	address varchar(200),
	phone_number varchar(15),
	username varchar(30) unique,
	id_card varchar(12),
	day_of_birth varchar(30),
	image varchar(500),
	is_delete bit default 0,
	foreign key (username) references user(username)
);

create table if not exists type_smartphone(
id int primary key auto_increment,
is_delete bit default 0,
`name` varchar(45)
);
create table if not exists specifications(
id int primary key auto_increment,
is_delete bit default 0,
screen varchar(50),
operating_system varchar(50),
rear_camera varchar(50),
front_camera varchar(50),
processor_chip varchar(50),
ram  varchar(50),
`storage` varchar(50),
bettery varchar(50),
charge varchar(50)
);

create table if not exists type_smartphone(
id int primary key auto_increment,
is_delete bit default 0,
`name` varchar(45)
);
create table if not exists image(
id int primary key auto_increment,
is_delete bit default 0,
`name` text,
smartphone_id int,
foreign key(smartphone_id) references smartphone(id) );

create table if not exists smartphone(
id int primary key auto_increment,
is_delete bit default 0,
insurance varchar(100),
producer varchar(50),
price int,
Specifications_id int,
type_smartphone_id int,
customer_id int,
foreign key(type_smartphone_id) references type_smartphone(id),
foreign key(Specifications_id) references specifications(id),
foreign key(customer_id) references customer(id)

);





