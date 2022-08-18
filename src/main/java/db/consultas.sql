SELECT 'Consulta 1';
SELECT * FROM capitan ORDER BY c_nombre ASC;

SELECT 'Consulta 2';
SELECT c_nombre, c_especie, c_genero, a_fecha, a_duracion, a_costo  FROM cliente, alquiler WHERE cliente.c_identidad = alquiler.a_cliente AND a_vehiculo = 6;

SELECT 'Consulta 3';
SELECT v_nombre, v_velocidad, v_longitud  FROM vehiculo, alquiler WHERE v_longitud = (SELECT MAX(v_longitud) FROM vehiculo) AND vehiculo.v_matricula = alquiler.a_vehiculo AND a_ocasion = "El Ataque de los Clones";

SELECT 'Consulta 4';
SELECT c_nombre, COUNT(a_vehiculo), AVG(a_costo) FROM capitan JOIN alquiler ON c_transporte = a_vehiculo GROUP BY (c_licencia) HAVING COUNT(a_vehiculo)>=4;

SELECT 'Consulta 5';
SELECT a_ocasion, COUNT(a_id), SUM(a_costo), SUM(a_duracion) FROM alquiler GROUP BY (a_ocasion) ORDER BY SUM(a_duracion) ASC;

SELECT 'Consulta 6';
SELECT c_nombre, SUM(a_duracion) FROM cliente JOIN alquiler ON c_identidad = a_cliente GROUP BY c_nombre ORDER BY SUM(a_duracion) DESC LIMIT 5;

SELECT 'Consulta 7';
SELECT v_nombre, l_androide, SUM(a_costo) FROM vehiculo JOIN ligero ON v_matricula = l_matricula JOIN alquiler ON v_matricula = a_vehiculo GROUP BY v_nombre ORDER BY SUM(a_costo) ASC; 