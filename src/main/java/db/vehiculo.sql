CREATE TABLE IF NOT EXISTS vehiculo(
	v_matricula INT PRIMARY KEY,
    v_nombre CHAR(50) NOT NULL,
    v_velocidad FLOAT NOT NULL,
    v_longitud FLOAT NOT NULL
    
);

INSERT INTO vehiculo VALUES (1, "Halcón Milenario", 75, 34.37);
INSERT INTO vehiculo VALUES (2, "Ala-X", 100, 12.5);
INSERT INTO vehiculo VALUES (3, "Ala-Y", 80, 14);
INSERT INTO vehiculo VALUES (4, "Ala-A ", 120, 9.6);
INSERT INTO vehiculo VALUES (5, "Interceptor TIE", 105, 9.2);
INSERT INTO vehiculo VALUES (6, "Esclavo 1", 70, 21.1);
INSERT INTO vehiculo VALUES (7, "Destructor Estelar", 60, 1600);
INSERT INTO vehiculo VALUES (8, "Estrella de la Muerte", 10, 120000);
INSERT INTO vehiculo VALUES (9, "Transbordador Imperial", 50, 20);
INSERT INTO vehiculo VALUES (10, "Ejecutor", 40, 19000);