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
    (DEFAULT, 'Books', 'https://images.theconversation.com/files/45159/original/rptgtpxd-1396254731.jpg?ixlib=rb-4.1.0&q=45&auto=format&w=1356&h=668&fit=crop'),
    (DEFAULT, 'Clothes', 'https://www.cato.org/sites/cato.org/files/styles/aside_3x/public/2023-11/fast-fashion2.jpeg?itok=72ek8bxI'),
    (DEFAULT, 'Electronics', 'https://www.wearedivisa.com/wp-content/uploads/2021/02/consumer-electronics-ecommerce-digital-marketing.jpg'),
    (DEFAULT, 'Tools', 'https://verloop.io/wp-content/uploads/40-of-the-Best-Ecommerce-Tools-for-2020-1.png'),
	(DEFAULT, 'Toys', 'https://www.cio.com/wp-content/uploads/2023/05/toys-100659819-orig-1.jpg?quality=50&strip=all'),
    (DEFAULT, 'Video Games', 'https://media.gq-magazine.co.uk/photos/645b5c3c8223a5c3801b8b26/16:9/w_2560%2Cc_limit/100-best-games-hp-b.jpg');

SELECT * FROM category;


INSERT INTO product (product_id, title, description, price, category_id)
	VALUES
	(DEFAULT, 'A Song of Ice and Fire', 'A series of high fantasy novels by the American author George R. R. Martin', 18.00, 1),
	(DEFAULT, 'Let the Right One In', 
	'John Ajvide Lindqvist. The story centers on the relationship between a 12-year-old boy and a centuries-old vampire child.', 14.91, 1),
	(DEFAULT, 'Double-breasted Trench Coat', 'Beige', 59.99, 2),
	(DEFAULT, 'Creased Tapered Jeans', 'Light Denim Blue', 34.99 , 2),
	(DEFAULT, 'Saker Mini CHainsaw', 'Electric Chainsaw, Cordless, Small Handheld, Pruning Shears for Tree Branches, Courtyard and Garden.', 89.99, 3),
	(DEFAULT, 'SE 30-inch Telescoping Magnetic Pick-Up Tool', 'Extendable Magnetic Wand Pickup Tool for Mechanics, Household, Office & Industry, Stainless Steel, Black Handle', 10.00, 3),
	(DEFAULT, 'Marshall Stanmore III Bluetooth Wireless Speaker', 'This generation of the home line-up has an even wider soundstage than before, delivering immersive Marshall signature sound', 329.99, 4),
	(DEFAULT, 'Epson EpiqVision Flex', 'CO-W01 Portable Projector, 3-Chip 3LCD, Widescreen, 3,000 Lumens Color/White Brightness, 5 W Speaker, 300-Inch Home Entertainment and Work', 299.99, 4),
	(DEFAULT, 'Pbooo Dancing Cactus Mimicking Toy', 'Talking Repeat Singing Sunny Cactus Toy 120 Pcs Songs for Baby 15S Record Your Sound', 15.99, 5),
	(DEFAULT, 'Spider-Man Action Figure', 'Marvel Titan Hero Series Spider-Man 12-Inch Action Figure with Fx Port', 7.79, 5),
	(DEFAULT, 'Capcom Vs. SNK 2', 'The sequel to the fighting game Capcom vs. SNK. Originally released on NAOMI hardware in arcades, with Sega handling the American arcade release.', 51.98 , 6),
	(DEFAULT, 'Guilty Gear: Strive', 'Mankind knew that they cannot change society. So instead of reflecting on themselves, they blamed the Beasts.', 39.99 , 6);
