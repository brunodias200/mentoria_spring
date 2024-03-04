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

CREATE TABLE `profile`(
	`id` BIGINT NOT NULL AUTO_INCREMENT ,
	`name` VARCHAR(60) NOT NULL,
	`created_at` DATETIME(0) NOT NULL,
	`modified_at` DATETIME(0) NOT NULL,
	`enabled` BIT(1) NOT NULL,
	CONSTRAINT `pkProfile` PRIMARY KEY (`id`)
);

ALTER TABLE `profile` ADD CONSTRAINT `ukProfile_name` UNIQUE (`name`);

INSERT INTO `profile` (name, created_at, modified_at, enabled) VALUES
    ('USER', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, TRUE),
    ('ADMIN', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, TRUE);

INSERT INTO `permission` (name, created_at, modified_at, enabled) VALUES
    ('PERMISSION_READ', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, TRUE),
    ('USER_READ', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, TRUE);


SET FOREIGN_KEY_CHECKS=1;
