-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;
INSERT INTO estudiante(
    estu_id,
    estu_cedula,
    estu_nombre,
    estu_apellido,
    estu_genero,
    estu_fecha_nacimiento
) VALUES (
    nextval('seq_estudiante'),
    '1712345678',
    'Esteban',
    'Chachalo',
    'M',
    '2003-01-19'
);