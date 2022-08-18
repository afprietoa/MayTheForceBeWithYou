CREATE TABLE IF NOT EXISTS capitan(
	c_licencia INT PRIMARY KEY,
    c_nombre CHAR(40) NOT NULL,
    c_especie CHAR(30) NOT NULL,
    c_transporte INT NOT NULL,
    CONSTRAINT fk_c_transporte FOREIGN KEY (c_transporte) REFERENCES transporte (t_matricula)
);

INSERT INTO capitan VALUES (1, "Han Solo", "Humano", 1);
INSERT INTO capitan VALUES (2, "Jango Fett", "Mandaloriano", 6);
INSERT INTO capitan VALUES (3, "General Grievous", "Androide", 7);
INSERT INTO capitan VALUES (4, "Grand Moff Tarkin", "Humano", 8);
INSERT INTO capitan VALUES (5, "Darth Vader", "Humano/Androide", 9);
INSERT INTO capitan VALUES (6, "Kendal Ozzel", "Humano", 10);
