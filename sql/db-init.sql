use dbshop;

-- insert users
-- password is 12345 (bcrypt encoded) 
insert into security_user (username, password, first_name, last_name) values 
	('admin', '$2a$04$4pqDFh9SxLAg/uSH59JCB.LwIS6QoAjM9qcE7H9e2drFuWhvTnDFi', 'Admin', 'Admin');
-- password is abcdef (bcrypt encoded)
insert into security_user (username, password, first_name, last_name) values 
	('petar', '$2a$04$Yr3QD6lbcemnrRNLbUMLBez2oEK15pdacIgfkvymQ9oMhqsEE56EK', 'Petar', 'Petrovic');

-- insert authorities
insert into security_authority (name) values ('ROLE_ADMIN'); -- super user
insert into security_authority (name) values ('ROLE_USER'); -- normal user

-- insert mappings between users and authorities
insert into security_user_authority (user_id, authority_id) values (1, 1); -- admin has ROLE_ADMIN
insert into security_user_authority (user_id, authority_id) values (1, 2); -- admin has ROLE_USER too
insert into security_user_authority (user_id, authority_id) values (2, 2); -- petar has ROLE_USER

INSERT INTO furniture_type(type_name) VALUES ("Sofa");
INSERT INTO furniture_type(type_name) VALUES ("Fotelja");
INSERT INTO furniture_type(type_name) VALUES ("Kauc");
INSERT INTO furniture_type(type_name) VALUES ("Stolica");
INSERT INTO furniture_type(type_name) VALUES ("Sto");

INSERT INTO furniture_piece(name, code, price, furniture_type_id) VALUES ("Valerijana", "AX-3244", 24000, 1);
INSERT INTO furniture_piece(name, code, price, furniture_type_id) VALUES ("Kroki", "HTR32", 98000, 2);
INSERT INTO furniture_piece(name, code, price, furniture_type_id) VALUES ("Megbe", "RxCC32", 12000, 3);
INSERT INTO furniture_piece(name, code, price, furniture_type_id) VALUES ("Trego", "FR-421", 56000, 4);
INSERT INTO furniture_piece(name, code, price, furniture_type_id) VALUES ("Mastadon", "FE-31251", 43240, 5);
INSERT INTO furniture_piece(name, code, price, furniture_type_id) VALUES ("Fitoer", "YTE-314", 100000, 2);
