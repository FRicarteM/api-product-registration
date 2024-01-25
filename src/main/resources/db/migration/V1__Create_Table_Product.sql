CREATE TABLE products (
	
	id BIGINT NOT NULL UNIQUE,
	product_name CHAR (80) NOT NULL,
	category INT(2) NOT NULL,
	brand VARCHAR(5), 
	type INT(2),
	cost NUMERIC(6) NOT NULL,
	inventory NUMERIC(6) NOT NULL,
	registration_responsible VARCHAR(80) NOT NULL,
	update_responsible VARCHAR(80) NULL,
	registration_date TIMESTAMP NOT NULL,
	update_date TIMESTAMP NULL,
	
	PRIMARY KEY(id)
);