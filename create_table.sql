CREATE TABLE `user` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `username` varchar(100) not null unique,
    `password` VARCHAR(100) NOT NULL,
    `user_role` VARCHAR(100) NOT NULL,
    `create_date` date,
    `email` varchar(100),
    `name` varchar(100) not null,
    `phone` varchar(100),
    `address` varchar(100),
    `avatar` varchar(255)
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
    `image` varchar(255),
    `note` varchar(255),
    `category_id` int not null,
    `supplier_id` int not null,
	FOREIGN KEY (`category_id`) REFERENCES category(`id`),
    FOREIGN KEY (`supplier_id`) REFERENCES supplier(`id`)
);

CREATE TABLE `receipt_export` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `create_date` date,
    `customer_id` int,
    `creator_id` int,
    `status` varchar(50),
    `note` varchar(255),
    `warehouse_id` int not null,
	FOREIGN KEY (`warehouse_id`) REFERENCES warehouse(`id`),
	FOREIGN KEY (`customer_id`) REFERENCES `user`(`id`),
	FOREIGN KEY (`creator_id`) REFERENCES `user`(`id`)
);

CREATE TABLE `receipt_import` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    `create_date` date,
    `supplier_id` int,
    `creator_id` int,
    `status` varchar(50),
    `note` varchar(255),
    `warehouse_id` int not null,
	FOREIGN KEY (`warehouse_id`) REFERENCES warehouse(`id`),
	FOREIGN KEY (`supplier_id`) REFERENCES `supplier`(`id`),
    FOREIGN KEY (`creator_id`) REFERENCES `user`(`id`)
);

CREATE TABLE `detail_receipt_import` (
    id INT PRIMARY KEY AUTO_INCREMENT,
	`receipt_import_id` int,
    `product_id` int,
    `amount` int not null,
    `price` int not null,
	FOREIGN KEY (`product_id`) REFERENCES product(`id`),
	FOREIGN KEY (`receipt_import_id`) REFERENCES `receipt_import`(`id`)
);
CREATE TABLE `detail_receipt_export` (
    id INT PRIMARY KEY AUTO_INCREMENT,
	`receipt_export_id` int,
    `product_id` int,
    `amount` int not null,
    `price` int not null,
	FOREIGN KEY (`product_id`) REFERENCES product(`id`),
	FOREIGN KEY (`receipt_export_id`) REFERENCES `receipt_export`(`id`)
);

CREATE TABLE `invoice_export` (
    id INT PRIMARY KEY AUTO_INCREMENT,
	`receipt_export_id` int default null unique,
    `create_date` date,
    `status` varchar(100),
    `total` int,
    `payment_method` varchar(100),
    `note` varchar(255),
    `payment_date` date,
	FOREIGN KEY (`receipt_export_id`) REFERENCES `receipt_export`(`id`)
);

CREATE TABLE `inventory` (
    id INT PRIMARY KEY AUTO_INCREMENT,
	`product_id` int not null,
	`warehouse_id` int not null,
	`amount` int CHECK (`amount` >= 0),
	`min` int CHECK (`min` >= 0) default 100,
    `use_date` date,
    `update_date` date,
	FOREIGN KEY (`product_id`) REFERENCES `product`(`id`),
	FOREIGN KEY (`warehouse_id`) REFERENCES `warehouse`(`id`),
    unique(`product_id`,`warehouse_id`)
);

CREATE TABLE `log_inventory` (
    id INT PRIMARY KEY AUTO_INCREMENT,
	`receipt_import_id` int default null,
	`receipt_export_id` int default null,
	`product_id` int default null,
	`amount` int,
    `price` int,
    `create_date` date,
	FOREIGN KEY (`receipt_import_id`) REFERENCES `receipt_import`(`id`),
	FOREIGN KEY (`receipt_export_id`) REFERENCES `receipt_export`(`id`),
	FOREIGN KEY (`product_id`) REFERENCES `product`(`id`)
);

CREATE TABLE `shipment` (
    id INT PRIMARY KEY AUTO_INCREMENT,
	`receipt_export_id` int,
	`shipment_company_id` int unique,
	`export_date` date,
	`ship_date` date,
    `note` varchar(255),
	FOREIGN KEY (`receipt_export_id`) REFERENCES `receipt_export`(`id`),
	FOREIGN KEY (`shipment_company_id`) REFERENCES `shipment_company`(`id`)
);

CREATE TABLE `delivery_schedule` (
    id INT PRIMARY KEY AUTO_INCREMENT,
	`shipment_id` int not null unique,
	`expected_date` date,
	`actual_date` date,
	`create_date` date,
    `note` varchar(255),
	FOREIGN KEY (`shipment_id`) REFERENCES `shipment`(`id`)
);



CREATE TABLE `review_shipment_company` (
    id INT PRIMARY KEY AUTO_INCREMENT,
	`shipment_id` int unique,
    `note` varchar(255),
    `performance` int,
	FOREIGN KEY (`shipment_id`) REFERENCES `shipment`(`id`)
);

CREATE TABLE `review_supplier` (
    id INT PRIMARY KEY AUTO_INCREMENT,
	`receipt_import_id` int unique,
    `note` varchar(255),
    `price` int,
    `quality` int,
    `support` int,
	FOREIGN KEY (`receipt_import_id`) REFERENCES `receipt_import`(`id`)
);

