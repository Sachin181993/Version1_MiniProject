
-- CREATE DATABASE login;
USE login;


DROP TABLE IF EXISTS users;

CREATE TABLE users(
user_id  INT PRIMARY KEY AUTO_INCREMENT,
Username VARCHAR(30) UNIQUE,
pass     VARCHAR(50)
);

INSERT INTO users VALUES(1,"sachin","sach");
INSERT INTO users (username,pass) VALUES("alpha","1234");
INSERT INTO users (username,pass) VALUES("bravo","5678");
INSERT INTO users (username,pass) VALUES("charlie","1212");

select * from users where username="sachin" and pass= "sach";
select * from users;

-- Encrypting the password
-- UPDATE login_page SET pass = MD5(pass) WHERE user_id <>123;
SELECT * FROM users;

-- delete from users where user_id = 7;

DROP TABLE IF EXISTS products;

-- products
CREATE TABLE products(
product_id INT PRIMARY KEY,
product_name VARCHAR(30),
product_desc VARCHAR(150),
product_value INT NOT NULL
);

INSERT INTO products VALUES(23,"bread","white",21);
INSERT INTO products VALUES(34,"milk","cow",15);
INSERT INTO products VALUES(21,"eggs","chicken",32);
INSERT INTO products VALUES(65,"butter","Irish",24);
INSERT INTO products VALUES(76,"cheese","Vegan",22);
INSERT INTO products VALUES(287,"yogurt","strawberry",13);
INSERT INTO products VALUES(87,"cereals","cornflakes",4);

SELECT * FROM products;


DROP TABLE IF EXISTS orders;

-- ORDERS

CREATE TABLE orders(
order_id INT PRIMARY KEY,
user_id INT,
FOREIGN KEY (user_id) REFERENCES users(user_id),
product_id INT,
FOREIGN KEY (product_id) REFERENCES products(product_id),
order_date DATE NULL,
quantity INT NOT NULL
);

INSERT INTO orders VALUES(23,1,23,"22-07-13",2);
INSERT INTO orders VALUES(34,2,34,"22-07-11",5);
INSERT INTO orders VALUES(21,2,65,"22-06-26",3);
INSERT INTO orders VALUES(65,3,21,"22-06-28",4);
INSERT INTO orders VALUES(54,3,76,"22-06-28",5);
INSERT INTO orders VALUES(76,4,287,"22-06-28",6);
INSERT INTO orders VALUES(85,4,87,"22-06-28",3);

SELECT * FROM orders;

select u.user_id,p.product_name, p.product_desc, p.product_value from products p JOIN orders o ON o.product_id = p.product_id 
Join users u ON o.user_id = u.user_id where u.userid = 1 Order by 	u.user_id;
commit;