DROP TABLE IF EXISTS `orders_items`;
DROP TABLE IF EXISTS `items`;
DROP TABLE IF EXISTS `orders`;
DROP TABLE IF EXISTS `customers`;

CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `items` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
    `item_name` VARCHAR(40) DEFAULT NULL,
    `value` DOUBLE DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `orders` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
    `fk_customer_id` INT(11) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`fk_customer_id`) REFERENCES customers(`id`)
);

CREATE TABLE IF NOT EXISTS `orders_items` (
    `fk_order_id` INT(11) NOT NULL,
    `fk_item_id` INT(11) NOT NULL,
    `quantity` INT(11) DEFAULT NULL,
    FOREIGN KEY (`fk_order_id`) REFERENCES orders(`id`),
    FOREIGN KEY (`fk_item_id`) REFERENCES items(`id`)
);