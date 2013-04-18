create table manager (
	password varchar( 256 )
);

create table media (
	media_id integer,
	type char( 2 ),
	author varchar( 256 ),
	title varchar( 256 ),
	duration integer,
	genre varchar( 256 ),
	rating double,
	total_reviews integer,
	price double,
	numsold integer,
	releaseyear integer,
	constraint pk_media_id primary key ( media_id )
);

create table customer (
	customer_id integer not null,
	name varchar( 256 ),
	address varchar( 256 ),
	balance double,
	constraint pk_customer_id primary key ( customer_id )
);

create table purchase (
	purchase_id integer not null,
	media_id integer,
	price double,
	p_date date,
	p_time time,
	constraint pk_purchase_id primary key ( purchase_id ),
	constraint fk_media_id foreign key ( media_id ) references media ( media_id )
);

create table customer_purchases (
	customer_id integer,
	purchase_id integer,
	constraint fk_customer_id foreign key ( customer_id ) references customer ( customer_id ),
	constraint fk_purchase_id foreign key ( purchase_id ) references purchase ( purchase_id )
);


insert into customer( customer_id, name, address, balance ) values ( 1, 'George W. Bush', '123 Texas St.', 350.0 );