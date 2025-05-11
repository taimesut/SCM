CREATE TABLE `user` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `username` varchar(100) not null unique,
    `password` VARCHAR(100) NOT NULL,
    `user_role` VARCHAR(100) NOT NULL,
    `create_date` date NOT NULL,
    `email` varchar(100),
    `name` varchar(100) not null,
    `phone` varchar(100),
    `address` varchar(100),
    `avatar` varchar(255) default 'null'
);

CREATE TABLE `purpose` (
    id INT PRIMARY KEY AUTO_INCREMENT,
	`name` varchar(100) not null unique
);

CREATE TABLE `category` (
    id INT PRIMARY KEY AUTO_INCREMENT,
	`name` varchar(100) not null unique
);

CREATE TABLE `warehouse` (
    id INT PRIMARY KEY AUTO_INCREMENT,
	`name` varchar(100) not null,
    `address` varchar(100) not null
);



CREATE TABLE `shipment_company` (
    id INT PRIMARY KEY AUTO_INCREMENT,
	`email` varchar(100),
    `name` varchar(100) not null,
    `phone` varchar(100),
    `address` varchar(100) not null
);

CREATE TABLE `supplier` (
    id INT PRIMARY KEY AUTO_INCREMENT,
	`email` varchar(100),
    `name` varchar(100) not null unique,
    `phone` varchar(100),
    `address` varchar(100) not null
);

CREATE TABLE `shipment_company_contact` (
    id INT PRIMARY KEY AUTO_INCREMENT,
	`shipment_company_id` int,
    `content` varchar(255) not null,
    `note` varchar(255),
	FOREIGN KEY (`shipment_company_id`) REFERENCES shipment_company(`id`)
);

CREATE TABLE `product` (
    id INT PRIMARY KEY AUTO_INCREMENT,
	`name` varchar(100) not null,
	`price` int not null default 0,
    `is_active` boolean default true,
    `use_date` date,
    `update_date` date not null,
    `note` varchar(255),
    `category_id` int,
	FOREIGN KEY (`category_id`) REFERENCES category(`id`)
);

CREATE TABLE `receipt` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `create_date` date NOT NULL,
	`type_receipt` varchar(50) not null,
    `partner_id` int, -- customer or supplier
    `creator_id` int,
    `status` varchar(50),
    `note` varchar(255),
    `warehouse_id` int not null,
	FOREIGN KEY (`warehouse_id`) REFERENCES warehouse(`id`)
);

CREATE TABLE `detail_receipt` (
    id INT PRIMARY KEY AUTO_INCREMENT,
	`receipt_id` int,
    `product_id` int,
    `amount` int not null,
    `price` int not null,
    `purpose_id` int,
	FOREIGN KEY (`product_id`) REFERENCES product(`id`),
	FOREIGN KEY (`receipt_id`) REFERENCES `receipt`(`id`),
	FOREIGN KEY (`purpose_id`) REFERENCES purpose(`id`)
);

CREATE TABLE `invoice` (
    id INT PRIMARY KEY AUTO_INCREMENT,
	`receipt_id` int,
    `create_date` date,
    `status` varchar(100),
    `total` int,
    `payment_method` varchar(100),
    `note` varchar(255),
    `payment_date` date,
	FOREIGN KEY (`receipt_id`) REFERENCES `receipt`(`id`)
);

CREATE TABLE `inventory` (
    id INT PRIMARY KEY AUTO_INCREMENT,
	`product_id` int,
	`warehouse_id` int,
	`amount` int,
	FOREIGN KEY (`product_id`) REFERENCES `product`(`id`),
	FOREIGN KEY (`warehouse_id`) REFERENCES `warehouse`(`id`)
);

CREATE TABLE `log_inventory` (
    id INT PRIMARY KEY AUTO_INCREMENT,
	`receipt_id` int,
	`product_id` int,
	`warehouse_id` int,
	`type_receipt` varchar(100),
	`amount` int,
    `price` int,
    `create_date` date,
	FOREIGN KEY (`receipt_id`) REFERENCES `receipt`(`id`),
	FOREIGN KEY (`product_id`) REFERENCES `product`(`id`),
	FOREIGN KEY (`warehouse_id`) REFERENCES `warehouse`(`id`)
);

CREATE TABLE `delivery_schedule` (
    id INT PRIMARY KEY AUTO_INCREMENT,
	`receipt_id` int,
	`shipment_company_id` int,
	`expected_date` date,
	`actual_date` date,
	`create_date` date,
    `type_shipment` varchar(100),
    `note` varchar(255),
	FOREIGN KEY (`receipt_id`) REFERENCES `receipt`(`id`),
	FOREIGN KEY (`shipment_company_id`) REFERENCES `shipment_company`(`id`)
);

CREATE TABLE `shipment` (
    id INT PRIMARY KEY AUTO_INCREMENT,
	`receipt_id` int,
	`shipment_company_id` int,
	`export_date` date,
	`ship_date` date,
    `type_shipment` varchar(100),
    `note` varchar(255),
	FOREIGN KEY (`receipt_id`) REFERENCES `receipt`(`id`),
	FOREIGN KEY (`shipment_company_id`) REFERENCES `shipment_company`(`id`)
);

CREATE TABLE `review_shipment_company` (
    id INT PRIMARY KEY AUTO_INCREMENT,
	`shipment_company_id` int,
	`shipment_id` int,
    `note` varchar(255),
    `performance` int,
	FOREIGN KEY (`shipment_id`) REFERENCES `shipment`(`id`),
	FOREIGN KEY (`shipment_company_id`) REFERENCES `shipment_company`(`id`)
);

CREATE TABLE `review_supplier` (
    id INT PRIMARY KEY AUTO_INCREMENT,
	`receipt_id` int,
	`supplier_id` int,
    `note` varchar(255),
    `price` int,
    `quality` int,
    `support` int,
	FOREIGN KEY (`receipt_id`) REFERENCES `receipt`(`id`),
	FOREIGN KEY (`supplier_id`) REFERENCES `supplier`(`id`)
);

