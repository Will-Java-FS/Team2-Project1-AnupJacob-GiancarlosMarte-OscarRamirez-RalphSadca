SET SEARCH_PATH TO ecommerce;

INSERT INTO ecommerce.user (user_id, username, email, password, first_name, last_name, role)
    VALUES
    (DEFAULT, 'admin1', 'admin1@email.com', 'A1357', 'Harlow', 'Jefferson', 'ADMIN'),
	(DEFAULT, 'user1', 'user1@email.com', 'U2468', 'Jon', 'Wallace', 'USER'),
	(DEFAULT, 'user2', 'user2@email.com', 'U4682', 'Kenia', 'Bartlett', 'USER'),
	(DEFAULT, 'user3', 'user3@email.com', 'U6824', 'Oaklynn', 'Rodriguez','USER');

SELECT * FROM ecommerce.user;
-- SELECT * FROM user_address;
-- SELECT * FROM ecommerce.user JOIN user_address on user_address.user_id = ecommerce.user.user_id;

INSERT INTO category (category_id, name, image_url)
	VALUES
    (DEFAULT, 'Books', ''),
    (DEFAULT, 'Clothes', ''),
    (DEFAULT, 'Eletronics', ''),
    (DEFAULT, 'Tools', ''),
	(DEFAULT, 'Toys', ''),
    (DEFAULT, 'Video Games', '');

SELECT * FROM category;


-- INSERT INTO product (product_id, title, description, price, category_id)
-- 	VALUES
-- 	(DEFAULT, '', '', , ),
-- 	(DEFAULT, '', '', , ),
-- 	(DEFAULT, '', '', , ),
-- 	(DEFAULT, '', '', , ),
-- 	(DEFAULT, '', '', , ),
-- 	(DEFAULT, '', '', , ),
-- 	(DEFAULT, '', '', , ),
-- 	(DEFAULT, '', '', , ),
-- 	(DEFAULT, '', '', , ),
-- 	(DEFAULT, '', '', , ),
-- 	(DEFAULT, '', '', , ),
-- 	(DEFAULT, '', '', , ),
-- 	(DEFAULT, '', '', , ),
-- 	(DEFAULT, '', '', , ),
-- 	(DEFAULT, '', '', , ),
-- 	(DEFAULT, '', '', , ),
-- 	(DEFAULT, '', '', , ),
-- 	(DEFAULT, '', '', , ),
-- 	(DEFAULT, '', '', , ),
-- 	(DEFAULT, '', '', , ),
-- 	(DEFAULT, '', '', , ),
-- 	(DEFAULT, '', '', , ),
-- 	(DEFAULT, '', '', , ),
-- 	(DEFAULT, '', '', , ),
-- 	(DEFAULT, '', '', , ),
-- 	(DEFAULT, '', '', , ),
-- 	(DEFAULT, '', '', , ),
-- 	(DEFAULT, '', '', , ),
-- 	(DEFAULT, '', '', , ),
-- 	(DEFAULT, '', '', , ),
-- 	(DEFAULT, '', '', , ),
-- 	(DEFAULT, '', '', , ),
-- 	(DEFAULT, '', '', , );
