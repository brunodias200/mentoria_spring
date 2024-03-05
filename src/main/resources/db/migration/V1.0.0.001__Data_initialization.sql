INSERT INTO `permission` (`name`, `created_at`, `modified_at`, `enabled`) VALUES
    ('PERMISSION_DETAIL', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, TRUE),
    ('PERMISSION_ENABLE_DISABLE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, TRUE),
    ('PERMISSION_READ', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, TRUE),
    ('PROFILE_DETAIL', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, TRUE),
    ('PROFILE_ENABLE_DISABLE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, TRUE),
    ('PROFILE_READ', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, TRUE),
    ('USER_DETAIL', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, TRUE),
    ('USER_ENABLE_DISABLE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, TRUE),
    ('USER_READ', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, TRUE),
    ('USER_WRITE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, TRUE);

INSERT INTO `profile` (`name`, `created_at`, `modified_at`, `enabled`) VALUES
    ('Administrator', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, TRUE);

INSERT INTO `profile_permission` SELECT pro.`id`, per.`id` FROM `profile` pro INNER JOIN `permission` per;

INSERT INTO `profile` (`name`, `created_at`, `modified_at`, `enabled`) VALUES
    ('Read only', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, TRUE);

INSERT INTO `profile_permission` (profile_id, permission_id) VALUES
    ((SELECT pro.`id` FROM `profile` pro WHERE pro.`name` = 'Read only'), (SELECT per.`id` FROM `permission` per WHERE per.`name` = 'PERMISSION_READ')),
    ((SELECT pro.`id` FROM `profile` pro WHERE pro.`name` = 'Read only'), (SELECT per.`id` FROM `permission` per WHERE per.`name` = 'PROFILE_READ')),
    ((SELECT pro.`id` FROM `profile` pro WHERE pro.`name` = 'Read only'), (SELECT per.`id` FROM `permission` per WHERE per.`name` = 'USER_READ'));