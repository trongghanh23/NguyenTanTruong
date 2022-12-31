create table if not exists `oder_smartphone`(
	id int primary key auto_increment,
	is_delete bit default 0,
	status bit default 0,
	quantity int,
        time_book_smartphone DATETIME,	
        customer_id int,
        smartphone_id int,
        foreign key (customer_id) references customer(id),
        foreign key (smartphone_id) references smartphone(id)
)