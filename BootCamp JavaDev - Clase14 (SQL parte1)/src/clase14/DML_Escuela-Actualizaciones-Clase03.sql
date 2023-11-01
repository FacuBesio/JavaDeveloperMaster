SELECT * FROM alumnos;
SELECT * FROM profesores;
SELECT * FROM cursos;
SELECT * FROM clases;
SELECT * FROM clases_detalle;
SELECT * FROM alumnos;
SELECT * FROM facturacion;
SELECT * FROM facturacion_detalle;

SELECT COUNT(apellido) 
FROM alumnos;
INSERT INTO clases_detalle(id_clase, id_alumno)
VALUES 
	(1,1), 
    (1,4), 
    (1,5), 
    (1,6), 
    (1,7);


INSERT INTO facturacion(factura, id_alumno, tipo)
VALUES 
	(2,1,2), 
    (2,4,2), 
    (2,5,2), 
    (2,6,2), 
    (2,7,2);

INSERT INTO cursos(nombre, duracion)
	VALUES 
		('maquetacion web','18'),
		('maquetado avanzado', '15'),
		('reactjs', '12'),
		('switching & routing', '30'),
		('full office','48');
        
INSERT INTO facturacion_detalle(id_factura, id_curso)
VALUES 
	(1,1), (1,3), (1,5),
    (2,1), (2,2), (2,8), (2,5),
    (3,7), (3,2), (3,3),
    (4,8), (4,1),
    (5,3), (5,4), (5,6);

SELECT * FROM cursos;
/*actualizaciones*/
	## actualizacion condicional
	UPDATE cursos -- tabla a actualizar
	SET duracion = '12:00' -- valor de actualizacion
	WHERE id_curso IN(1, 2, 6); -- valores de referencia
    
    ## actualizacion con casos
	UPDATE cursos
		SET monto = 
			CASE
				WHEN duracion <= '12:00' THEN 2400 -- condicion A
                WHEN duracion <= '15:00' THEN 3000 -- condicion B
				WHEN duracion <= '18:00' THEN 3600 -- condicion C | si AB no se cumple
				WHEN duracion <= '24:00' THEN 4800 -- condicion D | si ABC no se cumple
				ELSE 7200 -- valor | si ABCD no se cumple 
			END;
			
	UPDATE cursos 
		SET duracion = 
			CASE
				WHEN duracion = '12' THEN '12:00'
                WHEN duracion = '15' THEN '15:00'
				WHEN duracion = '18' THEN '18:00'
				WHEN duracion = '30' THEN '36:00'
				WHEN duracion = '48' THEN '48:00'
                ELSE duracion
			END;
	/* actualizcion por consulta */
		UPDATE facturacion_detalle
		SET monto = (
			SELECT monto 
			FROM cursos
			WHERE id_curso = facturacion_detalle.id_curso
		);

/* Consulta con agrupacion de datos */
SELECT 
	id_factura, 
    GROUP_CONCAT(id_detalle) AS detalles, 
    SUM(monto) AS total 
    FROM facturacion_detalle
	GROUP BY id_factura -- agrupa los valores segun el criterio
	ORDER BY id_factura ASC -- organiza los resultados segun los parametros
	LIMIT 100 -- restringe la cantidad de resultados a mostrar
	OFFSET 0; -- muestra los resultados a partir de la posicion indicada
    
SELECT * FROM facturacion;

UPDATE facturacion
	SET total = (
		SELECT SUM(monto) AS total
        FROM facturacion_detalle
        WHERE id_factura = facturacion.id_factura
    );
    
SELECT 
	id_factura,
    id_alumno,
    factura,
    total,
    '21%' AS iva,
    (total * 0.21) AS porcentaje_iva,
    (total * 0.21 + total) AS total_iva
FROM facturacion
	HAVING total_iva >= 12000; -- Si esta utilizando un campo que no existe en la Tabla, se debe utlizar HAVING en lugar de WHERE.
    
SELECT MAX(total) AS TOTAL
FROM facturacion;

SELECT CONCAT(apellido, ' ' , nombre) AS profesores
FROM profesores
WHERE nombre LIKE '%l%'
HAVING profesores LIKE '%s';
    