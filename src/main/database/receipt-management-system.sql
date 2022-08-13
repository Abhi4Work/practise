CREATE DATABASE IF NOT EXISTS receiptmanagementsystem DEFAULT CHARACTER SET utf8;

DROP TABLE IF EXISTS `receipt`;
CREATE TABLE `receiptmanagementsystem`.`receipt` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `type` varchar(50) NOT NULL,
  `description` longtext NOT NULL,
  `total` DOUBLE PRECISION(19,2) DEFAULT NULL,
  `cash` DOUBLE PRECISION(19,2) DEFAULT NULL,
  `change` DOUBLE PRECISION(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;