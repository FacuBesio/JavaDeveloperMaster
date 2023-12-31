drop database if exists jdbc_parte2_colegio;
create database jdbc_parte2_colegio;
use jdbc_parte2_colegio;

create table cursos(
    id int auto_increment primary key,
    titulo varchar(25) not null,
    profesor varchar(25),
    dia enum('LUNES','MARTES','MIERCOLES','JUEVES','VIERNES'),
    turno enum('MA�ANA','TARDE','NOCHE')
);

SELECT * FROM cursos;

create table alumnos(
    id int auto_increment primary key,
    nombre varchar(25) not null,
    apellido varchar(25) not null,
    edad int,
    idCurso int not null
);

alter table alumnos
    add constraint FK_alumnos_idCurso
    foreign key(idCurso)
    references cursos(id);

SELECT * FROM alumnos;