CREATE TABLE IF NOT EXISTS cliente(
	c_identidad INT PRIMARY KEY,
    c_nombre VARCHAR(40) NOT NULL,
    c_especie VARCHAR(30) NOT NULL,
    c_genero VARCHAR(30) NOT NULL
);

INSERT INTO cliente VALUES (1, "Luke Skywalker", "Humano", "Masculino");
INSERT INTO cliente VALUES (2, "Leia Organa", "Humano", "Femenino");
INSERT INTO cliente VALUES (3, "Rey Skywalker", "Humano", "Femenino");
INSERT INTO cliente VALUES (4, "Obi-Wan Kenobi", "Humano", "Masculino");
INSERT INTO cliente VALUES (5, "Maz Kanata", "Humanoide", "Femenino");
INSERT INTO cliente VALUES (6, "Anakin Skywalker", "Humano", "Masculino");
INSERT INTO cliente VALUES (7, "Yoda", "Yoda", "Masculino");
INSERT INTO cliente VALUES (8, "Ahsoka Tano", "Togruta", "Femenino");
INSERT INTO cliente VALUES (9, "Grogu", "Yoda", "Masculino");
INSERT INTO cliente VALUES (10, "Aayla Secura", "Twi'lek", "Femenino");
INSERT INTO cliente VALUES (11, "Chewbacca", "Wookiee", "Masculino");
INSERT INTO cliente VALUES (12, "Wicket W. Warrick", "Ewok", "Masculino");