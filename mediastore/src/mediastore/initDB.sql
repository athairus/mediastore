create table manager (
	password varchar( 256 )
);

create table media (
	media_id int not null primary key generated always as identity ( start with 1, increment by 1 ),
	type char( 2 ),
	author varchar( 256 ),
	title varchar( 256 ),
	duration int,
	genre varchar( 256 ),
	rating double,
	total_reviews int,
	price double,
	numsold int,
	releaseyear int
);

create table customer (
	customer_id int not null primary key generated always as identity ( start with 1, increment by 1 ),
	name varchar( 256 ),
	address varchar( 256 ),
	balance double
);

create table purchase (
	purchase_id int not null primary key generated always as identity ( start with 1, increment by 1 ),
	media_id int,
	price double,
	dt timestamp,
	constraint fk_media_id foreign key ( media_id ) references media ( media_id )
);

create table customer_purchases (
	customer_id int,
	purchase_id int,
	constraint fk_customer_id foreign key ( customer_id ) references customer ( customer_id ),
	constraint fk_purchase_id foreign key ( purchase_id ) references purchase ( purchase_id )
);


insert into customer( name, address, balance ) values ( 'George W. Bush', '123 Texas St.', 350.0 );
insert into manager( password ) values ( 'cole' );