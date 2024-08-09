SET SEARCH_PATH TO ecommerce;
DROP TABLE IF EXISTS ecommerce.order;
DROP TABLE IF EXISTS cart;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS ecommerce.user;

create table ecommerce.user(
	user_id SERIAL,
	username varchar(50) NOT NULL,
	email varchar(50) UNIQUE NOT NULL,
	password varchar(50) NOT NULL,
	first_name varchar(20) NOT NULL,
	last_name varchar(20) NOT NULL,
	address varchar(50) NOT NULL,
	phone varchar(11),
	created_at timestamp,
	updated_at timestamp,
	role varchar(10),
	PRIMARY KEY(user_id)
);

create table category(
	category_id SERIAL,
	name varchar(50) NOT NULL,
	PRIMARY KEY(category_id)
);

create table product(
	product_id SERIAL,
	title varchar(50) NOT NULL,
	description varchar(20),
	price decimal(10,2) NOT NULL,
	category_id int,
	time_created timestamp,
	PRIMARY KEY(product_id),
	CONSTRAINT fk_category
		FOREIGN KEY(category_id) 
		REFERENCES category(category_id)
);

create table cart(
	cart_id SERIAL,
	quantity int,
	total decimal(10,2),
	product_id int,
	user_id int,
	PRIMARY KEY(cart_id),
	CONSTRAINT fk_user
		FOREIGN KEY(user_id)
		REFERENCES ecommerce.user(user_id),
	CONSTRAINT fk_product
		FOREIGN KEY(product_id)
		REFERENCES product(product_id)
);

create table ecommerce.order(
	order_id SERIAL,
	total decimal(10,2),
	user_id int,
	cart_id int,
	PRIMARY KEY(order_id),
	CONSTRAINT fk_user
		FOREIGN KEY(user_id)
		REFERENCES ecommerce.user(user_id),
	CONSTRAINT fk_cart
		FOREIGN KEY(cart_id)
		REFERENCES cart(cart_id)
);