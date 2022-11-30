create database if not exists project_shop_smartphone;
use project_shop_smartphone;

create table if not exists user(
	username varchar(30) primary key,
    password varchar(200),
    is_delete bit default 0
);

create table  if not exists role(
	id int primary key auto_increment,
    name varchar(30),
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
    name varchar(30),
    is_delete bit default 0
);

create table if not exists customer(
	id int primary key auto_increment,
	name varchar(30),
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
	name varchar(50),
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

create table if not exists screen(
id int primary key auto_increment,
is_delete bit default 0,
`name` varchar(45)
)
;create table if not exists operating_system(
id int primary key auto_increment,
is_delete bit default 0,
`name` varchar(45)
);
create table if not exists rear_camera(
id int primary key auto_increment,
is_delete bit default 0,
`name` varchar(45)
);
create table if not exists front_camera(
id int primary key auto_increment,
is_delete bit default 0,
`name` varchar(45)
);
create table if not exists processor_chip(
id int primary key auto_increment,
is_delete bit default 0,
`name` varchar(45)
);
create table if not exists ram(
id int primary key auto_increment,
is_delete bit default 0,
`name` varchar(45)
);
create table if not exists `storage`(
id int primary key auto_increment,
is_delete bit default 0,
`name` varchar(45)
);
create table if not exists bettery(
id int primary key auto_increment,
is_delete bit default 0,
`name` varchar(45)
);
create table if not exists charge(
id int primary key auto_increment,
is_delete bit default 0,
`name` varchar(45)
);
create table if not exists type_smartphone(
id int primary key auto_increment,
is_delete bit default 0,
`name` varchar(45)
);
create table if not exists specifications(
id int primary key auto_increment,
is_delete bit default 0,
screen_id int,
operating_system_id int,
rear_camera_id int,
front_camera_id int,
processor_chip_id int,
ram_id  int,
storage_id int,
bettery_id int,
charge_id int,
utility_description text,
foreign key(screen_id) references screen(id),
foreign key(operating_system_id) references operating_system(id),
foreign key(rear_camera_id) references rear_camera(id),
foreign key(front_camera_id) references front_camera(id),
foreign key(processor_chip_id) references processor_chip(id),
foreign key(ram_id) references ram(id),
foreign key(storage_id) references `storage`(id),
foreign key(bettery_id) references bettery(id),
foreign key(charge_id) references charge(id)

);

create table if not exists type_smartphone(
id int primary key auto_increment,
is_delete bit default 0,
`name` varchar(45)
);

create table if not exists smartphone(
id int primary key auto_increment,
is_delete bit default 0,
trailer text,
insurance varchar(100),
price int,
image text,
Specifications_id int,
type_smartphone_id int,
customer_id int,
foreign key(type_smartphone_id) references type_smartphone(id),
foreign key(Specifications_id) references specifications(id),
foreign key(customer_id) references customer(id)

);





