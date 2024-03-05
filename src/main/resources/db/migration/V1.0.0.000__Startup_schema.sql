SET FOREIGN_KEY_CHECKS=0;

CREATE TABLE `permission`(
	`id` BIGINT NOT NULL AUTO_INCREMENT ,
	`name` VARCHAR(60) NOT NULL,
	`created_at` DATETIME(0) NOT NULL,
	`modified_at` DATETIME(0) NOT NULL,
	`enabled` BIT(1) NOT NULL,
	CONSTRAINT `pkPermission` PRIMARY KEY (`id`)
);

CREATE TABLE `profile`(
	`id` BIGINT NOT NULL AUTO_INCREMENT ,
	`name` VARCHAR(60) NOT NULL,
	`created_at` DATETIME(0) NOT NULL,
	`modified_at` DATETIME(0) NOT NULL,
	`enabled` BIT(1) NOT NULL,
	CONSTRAINT `pkProfile` PRIMARY KEY (`id`)
);

CREATE TABLE `profile_permission`(
	`profile_id` BIGINT NOT NULL,
	`permission_id` BIGINT NOT NULL,
	CONSTRAINT `pkProfilePermission` PRIMARY KEY (`profile_id`,`permission_id`)
);

CREATE TABLE `user`(
	`id` BIGINT NOT NULL AUTO_INCREMENT ,
	`username` VARCHAR(120) NOT NULL,
	`password` VARCHAR(120) NOT NULL,
	`first_name` VARCHAR(30) NOT NULL,
	`last_name` VARCHAR(30) NOT NULL,
	`allow_change_password` BIT(1) NOT NULL,
	`password_never_expires` BIT(1) NOT NULL,
	`must_change_password_at_logon` BIT(1) NOT NULL,
	`password_last_set` DATETIME(0) NOT NULL,
	`locked` BIT(1) NOT NULL,
	`expires_on` DATE NULL,
	`last_logon_date` DATETIME(0) NULL,
	`last_logout_date` DATETIME(0) NULL,
	`created_at` DATETIME(0) NOT NULL,
	`modified_at` DATETIME(0) NOT NULL,
	`enabled` BIT(1) NOT NULL,
	CONSTRAINT `pkUser` PRIMARY KEY (`id`)
);

CREATE TABLE `user_profile`(
	`user_id` BIGINT NOT NULL,
	`profile_id` BIGINT NOT NULL,
	CONSTRAINT `pkUserProfile` PRIMARY KEY (`user_id`,`profile_id`)
);

ALTER TABLE `permission` ADD CONSTRAINT `ukPermission_name` UNIQUE (`name`);

ALTER TABLE `profile` ADD CONSTRAINT `ukProfile_name` UNIQUE (`name`);

ALTER TABLE `user` ADD CONSTRAINT `ukUser_username` UNIQUE (`username`);

ALTER TABLE `profile_permission` ADD CONSTRAINT `fkProfilePermission_Permission` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`) ON DELETE Restrict ON UPDATE Restrict;

ALTER TABLE `profile_permission` ADD CONSTRAINT `fkProfilePermission_Profile` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`id`) ON DELETE Restrict ON UPDATE Restrict;

ALTER TABLE `user_profile` ADD CONSTRAINT `fkUserProfile_Profile` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`id`) ON DELETE Restrict ON UPDATE Restrict;

ALTER TABLE `user_profile` ADD CONSTRAINT `fkUserProfile_User` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE Restrict ON UPDATE Restrict;

SET FOREIGN_KEY_CHECKS=1;
