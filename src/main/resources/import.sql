INSERT INTO estudiante(
    estu_id,
    estu_nombre,
    estu_apellido,
    estu_genero,
    estu_fechaNacimiento
)
VALUES(
    nextval('seq_estudiante'),
    'Esteban',
    'Chachalo',
    'M',
    '2003-01-19'
);


INSERT INTO profesor(
    prof_id,
    prof_nombre,
    prof_apellido,
    prof_titulo,
    prof_departamento
)
VALUES(
    nextval('seq_profesor'),
    'Ruben',
    'Arroyo',
    'Ingeniero de Software',
    'Ciencias de la Computacion'
);