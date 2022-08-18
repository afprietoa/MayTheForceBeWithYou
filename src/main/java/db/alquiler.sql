CREATE TABLE IF NOT EXISTS alquiler(
	a_id INT PRIMARY KEY,
    a_cliente INT NOT NULL,
    a_vehiculo INT NOT NULL,
    a_fecha DATETIME NOT NULL,
    a_ocasion VARCHAR(50) NOT NULL,
    a_duracion INT NOT NULL,
    a_costo DOUBLE NOT NULL,
    CONSTRAINT fk_a_cliente FOREIGN KEY (a_cliente) REFERENCES cliente (c_identidad),
    CONSTRAINT fk_a_vehiculo FOREIGN KEY (a_vehiculo) REFERENCES vehiculo (v_matricula)
);

INSERT INTO alquiler VALUES (7110, 1, 6, "2005-05-19 00:00:00", "La Venganza de los Sith", 4, 238.03);
INSERT INTO alquiler VALUES (7143, 2, 6, "2018-05-25 00:00:00", "Han Solo", 10, 252.99);
INSERT INTO alquiler VALUES (7176, 3, 9, "2015-12-18 00:00:00", "El Despertar de la Fuerza", 14, 1095.27);
INSERT INTO alquiler VALUES (7187, 1, 1, "2018-05-25 00:00:00", " Han Solo", 15, 374.64);
INSERT INTO alquiler VALUES (7209, 4, 8, "1999-05-19 00:00:00", "La Amenaza Fantasma", 18, 1145.38);
INSERT INTO alquiler VALUES (7220, 2, 9, "2018-05-25 00:00:00", "Han Solo", 17, 839.24);
INSERT INTO alquiler VALUES (7242, 5, 10, "2017-12-15 00:00:00", "Los Últimos JEDI", 17, 1396.31);
INSERT INTO alquiler VALUES (7253, 3, 6, "1999-05-19 00:00:00", "La Amenaza Fantasma", 24, 826.54);
INSERT INTO alquiler VALUES (7264, 1, 3, "1999-05-19 00:00:00", "La Amenaza Fantasma", 9, 427.71);
INSERT INTO alquiler VALUES (7275, 6, 6, "2018-05-25 00:00:00", "Han Solo", 7, 556.67);
INSERT INTO alquiler VALUES (7286, 4, 6, "2015-12-18 00:00:00", "El Despertar de la Fuerza", 9, 451.35);
INSERT INTO alquiler VALUES (7297, 2, 8, "1977-05-25 00:00:00", "Una nueva esperanza", 9, 395.32);
INSERT INTO alquiler VALUES (7308, 7, 5, "2018-05-25 00:00:00", "Han Solo", 13, 1099.22);
INSERT INTO alquiler VALUES (7319, 5, 2, "2002-05-16 00:00:00", "El Ataque de los Clones", 11, 833.2);
INSERT INTO alquiler VALUES (7330, 3, 8, "2019-12-20 00:00:00", "El Ascenso de Skywalker", 23, 528.94);
INSERT INTO alquiler VALUES (7341, 8, 10, "1983-05-25 00:00:00", "El Retorno del JEDI", 11, 207.56);
INSERT INTO alquiler VALUES (7352, 6, 4, "2017-12-15 00:00:00", "Los Últimos JEDI", 15, 492.47);
INSERT INTO alquiler VALUES (7363, 4, 8, "2016-12-16 00:00:00", "Rogue One", 11, 742.71);
INSERT INTO alquiler VALUES (7374, 9, 10, "2016-12-16 00:00:00", "Rogue One", 24, 175.44);
INSERT INTO alquiler VALUES (7385, 7, 2, "1983-05-25 00:00:00", "El Retorno del JEDI", 13, 1016.47);
INSERT INTO alquiler VALUES (7396, 5, 4, "2016-12-16 00:00:00", "Rogue One", 7, 19.04);
INSERT INTO alquiler VALUES (7407, 10, 1, "2019-12-20 00:00:00", "El Ascenso de Skywalker", 24, 387.95);
INSERT INTO alquiler VALUES (7418, 8, 8, "2002-05-16 00:00:00", "El Ataque de los Clones", 19, 1024.49);
INSERT INTO alquiler VALUES (7429, 6, 4, "2002-05-16 00:00:00", "El Ataque de los Clones", 20, 444.75);
INSERT INTO alquiler VALUES (7451, 9, 4, "2005-05-19 00:00:00", "La Venganza de los Sith", 4, 69.09);
INSERT INTO alquiler VALUES (7462, 7, 3, "1999-05-19 00:00:00", "La Amenaza Fantasma", 7, 556.8);
INSERT INTO alquiler VALUES (7484, 10, 6, "2018-05-25 00:00:00", "Han Solo", 20, 272.61);
INSERT INTO alquiler VALUES (7495, 8, 9, "2016-12-16 00:00:00", "Rogue One", 6, 116.87);
INSERT INTO alquiler VALUES (7528, 9, 6, "1977-05-25 00:00:00", "Una nueva esperanza", 4, 285.43);
INSERT INTO alquiler VALUES (7561, 10, 6, "1980-05-21 00:00:00", "El Imperio contraataca", 28, 1377.01);