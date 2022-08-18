CREATE TABLE IF NOT EXISTS ligero(
	l_matricula INT PRIMARY KEY,
    l_color VARCHAR(20) NOT NULL,
    l_androide VARCHAR(30) NULL,
    CONSTRAINT fk_l_matricula FOREIGN KEY (l_matricula) REFERENCES vehiculo (v_matricula)
);

INSERT INTO ligero VALUES (2, "BLANCO/ROJO", "R2-D2");
INSERT INTO ligero VALUES (3, "AMARILLO", "C-3PO");
INSERT INTO ligero VALUES (4, "ROJO", NULL);
INSERT INTO ligero VALUES (5, "NEGRO", "Androide TIE");