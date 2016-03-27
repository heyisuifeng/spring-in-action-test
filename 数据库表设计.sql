CREATE DATABASE shiro;

CREATE TABLE t_permission(
   permission_id INT NOT NULL AUTO_INCREMENT,
   permissionName VARCHAR(50),
   created_by VARCHAR(20),
   created_time TIMESTAMP,
   PRIMARY KEY (permission_id)
);

CREATE TABLE t_user(
   user_id INT NOT NULL AUTO_INCREMENT,
   user_name VARCHAR(30),
   `password` VARCHAR(30),
   created_by VARCHAR(20),
   created_time TIMESTAMP,
   PRIMARY KEY (user_id)
);

CREATE TABLE t_role(
   role_id INT NOT NULL AUTO_INCREMENT,
   role_name VARCHAR(30),
   describtion VARCHAR(50),
   created_by VARCHAR(20),
   created_time TIMESTAMP,
   PRIMARY KEY(role_id)
);

CREATE TABLE user_role_mapping(
   id INT NOT NULL AUTO_INCREMENT,
   user_id INT NOT NULL,
   role_id INT NOT NULL,
   created_by VARCHAR(20),
   created_time TIMESTAMP,
   PRIMARY KEY(id),
   CONSTRAINT FKURM_USER_ID FOREIGN KEY (user_id) REFERENCES t_user (user_id),
   CONSTRAINT FKURM_ROLE_ID FOREIGN KEY (role_id) REFERENCES t_role (role_id)
);

CREATE TABLE role_permission_mapping(
   id INT NOT NULL AUTO_INCREMENT,
   role_id INT NOT NULL,
   permission_id INT NOT NULL,
   created_by VARCHAR(20),
   created_time TIMESTAMP,
   PRIMARY KEY (id),
   CONSTRAINT FKRPM_ROLE_ID FOREIGN KEY (role_id) REFERENCES t_role(role_id),
   CONSTRAINT FKRPM_PERMISSION_ID FOREIGN KEY (permission_id) REFERENCES t_permission(permission_id)
);