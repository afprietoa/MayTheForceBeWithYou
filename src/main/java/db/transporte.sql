CREATE TABLE IF NOT EXISTS transporte(
	t_matricula INT PRIMARY KEY,
    t_tripulantes INT NOT NULL,
    t_pasajeros INT NOT NULL,
    CONSTRAINT fk_t_matricula FOREIGN KEY (t_matricula) REFERENCES vehiculo (v_matricula)
);

INSERT INTO transporte VALUES (1, 4, 6);
INSERT INTO transporte VALUES (6, 1, 6);
INSERT INTO transporte VALUES (7, 47060, 0);
INSERT INTO transporte VALUES (8, 342953, 843342);
INSERT INTO transporte VALUES (9, 6, 20);
INSERT INTO transporte VALUES (10, 279144, 38000);