CREATE DATABASE IF NOT EXISTS receipt_management-system DEFAULT CHARACTER SET utf8;

DROP TABLE IF EXISTS `receipt`;
CREATE TABLE `receipt` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  `description` longtext NOT NULL,
  `total` decimal(19,2) DEFAULT NULL,
  `cash` decimal(19,2) DEFAULT NULL,
  `change` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;