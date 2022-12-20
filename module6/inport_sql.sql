 use project_smartphone;
insert into smartphone_type(id,is_delete,`name`,image) value
(1,0,"Iphone 8","https://firebasestorage.googleapis.com/v0/b/project-phone-bff73.appspot.com/o/%E1%BA%A3nh%20iphone7%2F1567872433_679_iphone_11%20-%20Copy%20-%20Copy.jpg?alt=media&token=b3051e74-fd03-4ca0-bce0-5cedda6fdf77"),
(2,0,"Iphone 11","https://firebasestorage.googleapis.com/v0/b/project-phone-bff73.appspot.com/o/%E1%BA%A3nh%20iphone7%2Fiphone%20-%20Copy%20-%20Copy.jpg?alt=media&token=a194a22d-1b80-44e6-b508-02554e152e8c"),
(3,0,"Iphone 12","https://firebasestorage.googleapis.com/v0/b/project-phone-bff73.appspot.com/o/%E1%BA%A3nh%20iphone7%2Fiphone-.jpg?alt=media&token=0dbee7c0-9e39-4b89-8d9a-b1be33f67f9f"),
(4,0,"Iphone 13","https://firebasestorage.googleapis.com/v0/b/project-phone-bff73.appspot.com/o/%E1%BA%A3nh%20iphone7%2Fiphone7%20-%20Copy.jpg?alt=media&token=fc2d2cd8-d67d-4fab-a3dd-019601c12b20"),
(5,0,"Iphone 14","https://firebasestorage.googleapis.com/v0/b/project-phone-bff73.appspot.com/o/%E1%BA%A3nh%20iphone7%2F1567872433_679_iphone_11%20-%20Copy%20-%20Copy.jpg?alt=media&token=b3051e74-fd03-4ca0-bce0-5cedda6fdf77");
insert into specifications(id,is_delete,bettery,charge,front_camera,`name`,operating_system,processor_chip,ram,rear_camera,screen,`storage`)value
(1,0,"3300mAh","fast charging","7MP","iphone8","iOS 11","Apple A11 Bionic","2 GB","12MP" ,"4.7 inch ","32GB"),
(2,0,"3500mAh","fast charging","10MP","iphone11","iOS 11","Apple A11 Bionic","4 GB","15MP", "4.8 inch ","64GB"),
(3,0,"3600mAh","fast charging","15MP","iphone12","iOS 11","Apple A11 Bionic","8 GB","20MP", "5.0 inch ","128GB"),
(4,0,"3800mAh","fast charging","20MP","iphone13","iOS 11","Apple A11 Bionic","16 GB","25MP","5.1 inch ","500GB"),
(5,0,"4200mAh","fast charging","25MP","iphone14","iOS 11","Apple A11 Bionic","32 GB","30MP", "5.5 inch ","512GB");

insert into smartphone(id,insurance,is_delete,price,producer,type_smartphone_id,specifications_id)value
(1,"6 tháng",0, "8000000","USA",1,1),
(2,"3 tháng",0, "10000000","USA",2,2),
(3,"12 tháng",0, "11000000","USA",3,3),
(4,"12 tháng",0, "20000000","USA",4,4),
(5,"12 tháng",0, "30000000","USA",5,5),
(6,"6 tháng",0, "8000000","USA",1,1),
(7,"3 tháng",0, "10000000","USA",2,2),
(8,"12 tháng",0, "11000000","USA",3,3),
(9,"12 tháng",0, "20000000","USA",4,4),
(10,"12 tháng",0, "30000000","USA",5,5);
insert into customer_type(id,is_delete,name)value
(1,0,"Vip"),
(2,0,"Gold"),
(3,0,"Silver"),
(4,0,"Member");

insert into role(id,is_delete,name)value
(1,0,"ROLE_ADMIN"),
(2,0,"ROLE_CUSTOMER");

insert into user_role(username,role_id,is_delete)value
("customer",2,0),
("admin",1,0),
("abc",2,0),
("xyz",2,0);

insert into user(username,is_delete,password)values
("admin",0,"$2a$10$rIStUMNBwOI.cWOzXAPt2u6KVa5jqW68mBBDuRmoKlLcIfMoCmxZW"),
("customer",0,"$2a$10$Fn3gdCH0Cf7WohkjkMriIuH.uGxp0NNipvyXlQ12Xh12JczwJgvLu"),
("abc",0,"$2a$10$Fn3gdCH0Cf7WohkjkMriIuH.uGxp0NNipvyXlQ12Xh12JczwJgvLu"),
("xyz",0,"$2a$10$Fn3gdCH0Cf7WohkjkMriIuH.uGxp0NNipvyXlQ12Xh12JczwJgvLu");

insert into customer(id,address,day_of_birth,email,gender,id_card,is_delete,phone_number,customer_type_id,username,name)value
(1,"Quảng nam","12-12-1999","truong1602@gmail.com",0,"09848484848",0,"090907777",1,"customer","nguyễn tấn trường"),
(2,"Quảng nam","12-12-1999","truong1602@gmail.com",0,"09848484848",0,"090907777",2,"abc","nguyễn văn a"),
(3,"Quảng nam","12-12-1999","truong1602@gmail.com",0,"09848484848",0,"090907777",3,"xyz","nguyễn văn b");
  insert into oder_smartphone(id,is_delete,quantity,`status`,time_book_smartphone,customer_id,smartphone_id) value
(1,0,1,0,'2022-12-12',1,1),
(2,0,1,0,'2022-12-28',2,2);
insert into image(id,is_delete,`name`,smartphone_id)value
(1,0,"https://firebasestorage.googleapis.com/v0/b/project-phone-bff73.appspot.com/o/%E1%BA%A3nh%20iphone7%2F1567872433_679_iphone_11%20-%20Copy%20-%20Copy.jpg?alt=media&token=b3051e74-fd03-4ca0-bce0-5cedda6fdf77",1),
(2,0,"https://firebasestorage.googleapis.com/v0/b/project-phone-bff73.appspot.com/o/%E1%BA%A3nh%20iphone7%2F1567872433_679_iphone_11%20-%20Copy.jpg?alt=media&token=85da9596-f4b1-4333-be81-7d1bbd94bf12",2),
(3,0,"https://firebasestorage.googleapis.com/v0/b/project-phone-bff73.appspot.com/o/%E1%BA%A3nh%20iphone7%2Fiphone%20-%20Copy%20-%20Copy.jpg?alt=media&token=a194a22d-1b80-44e6-b508-02554e152e8c",3),
(4,0,"https://firebasestorage.googleapis.com/v0/b/project-phone-bff73.appspot.com/o/%E1%BA%A3nh%20iphone7%2Fiphone-.jpg?alt=media&token=0dbee7c0-9e39-4b89-8d9a-b1be33f67f9f",4);



