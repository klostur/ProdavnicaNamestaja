use dbshop;

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