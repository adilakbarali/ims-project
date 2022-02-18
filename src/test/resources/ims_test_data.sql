INSERT INTO customers(`first_name`, `surname`) VALUES('Adil', 'Akbarali');
INSERT INTO customers(`first_name`, `surname`) VALUES('Morgan', 'Walsh');
INSERT INTO customers(`first_name`, `surname`) VALUES('Richard', 'Mansworth');
INSERT INTO customers(`first_name`, `surname`) VALUES('Cameron', 'Guthrie');
INSERT INTO customers(`first_name`, `surname`) VALUES('Piers', 'Barber');

INSERT INTO items(`item_name`, `value`) VALUES('Monitor', 129.99);
INSERT INTO items(`item_name`, `value`) VALUES('Keyboard', 29.99);
INSERT INTO items(`item_name`, `value`) VALUES('Mouse', 15.99);
INSERT INTO items(`item_name`, `value`) VALUES('Headset', 22.99);
INSERT INTO items(`item_name`, `value`) VALUES('8GB Flash Drive', 9.99);

INSERT INTO orders(`fk_customer_id`) VALUES(1);
INSERT INTO orders(`fk_customer_id`) VALUES(2);
INSERT INTO orders(`fk_customer_id`) VALUES(3);
INSERT INTO orders(`fk_customer_id`) VALUES(4);


INSERT INTO orders_items(`fk_order_id`, `fk_item_id`, `quantity`) VALUES(1, 2, 2);
INSERT INTO orders_items(`fk_order_id`, `fk_item_id`, `quantity`) VALUES(1, 1, 1);
INSERT INTO orders_items(`fk_order_id`, `fk_item_id`, `quantity`) VALUES(1, 3, 1);
INSERT INTO orders_items(`fk_order_id`, `fk_item_id`, `quantity`) VALUES(2, 5, 3);