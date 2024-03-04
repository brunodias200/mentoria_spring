SET FOREIGN_KEY_CHECKS=0;

CREATE TABLE `permission`(
	`id` BIGINT NOT NULL AUTO_INCREMENT ,
	`name` VARCHAR(60) NOT NULL,
	`created_at` DATETIME(0) NOT NULL,
	`modified_at` DATETIME(0) NOT NULL,
	`enabled` BIT(1) NOT NULL,
	CONSTRAINT `pkPermission` PRIMARY KEY (`id`)
);

ALTER TABLE `permission` ADD CONSTRAINT `ukPermission_name` UNIQUE (`name`);

SET FOREIGN_KEY_CHECKS=1;
