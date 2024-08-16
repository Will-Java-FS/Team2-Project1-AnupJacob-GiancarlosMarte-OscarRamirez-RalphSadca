SET SEARCH_PATH TO ecommerce;
DROP TABLE IF EXISTS order_item;
DROP TABLE IF EXISTS ecommerce.order;
DROP TABLE IF EXISTS cart_item;
DROP TABLE IF EXISTS cart;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS ecommerce.user;
-- SELECT * FROM order_item;
-- SELECT * FROM ecommerce.order;
-- SELECT * FROM cart;
-- SELECT * FROM cart_item;
-- SELECT * FROM product;
-- SELECT * FROM CATEGORY;
-- SELECT * FROM ecommerce.user_address;
-- SELECT * FROM ecommerce.user;

create table ecommerce.user(
	user_id SERIAL,
	username varchar(50) NOT NULL,
	email varchar(50) UNIQUE NOT NULL,
	password varchar(50) NOT NULL,
	first_name varchar(20) NOT NULL,
	last_name varchar(20) NOT NULL,
	role varchar(5),
	PRIMARY KEY(user_id)
);

-- create table user_address(
-- 	user_address_id SERIAL,
-- 	user_id int NOT NULL,
-- 	address_line1 varchar(50),
-- 	address_line2 varchar(50),
-- 	city varchar(50),
-- 	state varchar(2),
-- 	postal_code varchar(50),
-- 	telephone varchar(13),
-- 	mobile varchar(13),
-- 	PRIMARY KEY(user_address_id),
-- 	CONSTRAINT fk_user
-- 		FOREIGN KEY(user_id)
-- 		REFERENCES ecommerce.user(user_id)
-- );
		
create table category(
	category_id SERIAL,
	name varchar(50) NOT NULL,
	image_url varchar(2000),
	PRIMARY KEY(category_id)
);

create table product(
	product_id SERIAL,
	title varchar(50) NOT NULL,
	description varchar(20),
	price decimal(10,2) NOT NULL,
	category_id int,
	image_url varchar(2000),
	PRIMARY KEY(product_id),
	CONSTRAINT fk_category
		FOREIGN KEY(category_id) 
		REFERENCES category(category_id)
);

create table cart(
	cart_id SERIAL,
	total decimal(10,2) NOT NULL,
	user_id int NOT NULL,
	PRIMARY KEY(cart_id),
	CONSTRAINT fk_user
		FOREIGN KEY(user_id)
		REFERENCES ecommerce.user(user_id)
);

create table cart_item(
	cart_item_id SERIAL,
	product_id int NOT NULL,
	cart_id int NOT NULL,
	quantity int DEFAULT 1,
	PRIMARY KEY(cart_item_id),
	CONSTRAINT fk_product
		FOREIGN KEY(product_id)
		REFERENCES product(product_id)
);

create table ecommerce.order(
	order_id SERIAL,
	user_id int NOT NULL,
	cart_id int NOT NULL,
	total decimal(10,2),
	PRIMARY KEY(order_id),
	CONSTRAINT fk_user
		FOREIGN KEY(user_id)
		REFERENCES ecommerce.user(user_id),
	CONSTRAINT fk_cart
		FOREIGN KEY(cart_id)
		REFERENCES cart(cart_id)
);

create table order_item(
	order_items_id SERIAL,
	order_id int NOT NULL,
	product_id int NOT NULL,
	quantity int DEFAULT 1,
	PRIMARY KEY (order_items_id),
	CONSTRAINT fk_order
		FOREIGN KEY (order_id)
		REFERENCES ecommerce.order(order_id),
	CONSTRAINT fk_product
		FOREIGN KEY (product_id)
		REFERENCES product(product_id)
);