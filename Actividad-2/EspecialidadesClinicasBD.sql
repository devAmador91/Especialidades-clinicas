
CREATE DATABASE EspecialidadesClinicasBD;
USE EspecialidadesClinicasBD;


CREATE TABLE MedicoCirujano (
id INT AUTO_INCREMENT PRIMARY KEY,
Nombre VARCHAR(20),
Apellido VARCHAR(20),
RFC VARCHAR(20),
Direccion VARCHAR(20),
EstadoCivil VARCHAR(20),
Telefono VARCHAR(20)
);

CREATE TABLE MedicoGeneral (
id INT AUTO_INCREMENT PRIMARY KEY,
Nombre VARCHAR(20),
Apellido VARCHAR(20),
RFC VARCHAR(20),
Direccion VARCHAR(20),
EstadoCivil VARCHAR(20),
Telefono VARCHAR(20)
);

CREATE TABLE MedicoForense (
id INT AUTO_INCREMENT PRIMARY KEY,
Nombre VARCHAR(20),
Apellido VARCHAR(20),
RFC VARCHAR(20),
Direccion VARCHAR(20),
EstadoCivil VARCHAR(20),
Telefono VARCHAR(20)
);

CREATE TABLE DatosPerfil (
id INT AUTO_INCREMENT PRIMARY KEY,
Nombre VARCHAR(20),
Apellido VARCHAR(20),
Cedula VARCHAR(20),
Grado VARCHAR(20),
Especialidad VARCHAR(20)
);

INSERT INTO MedicoCirujano VALUES (1, 'Pedro','Hernadez','PEDR067895LGMD','Calle 10','Soltero','5556987451');
INSERT INTO MedicoCirujano VALUES (2, 'Karen','Perez','KRN087495LHMD','Calle 28','Casada','478596325');
INSERT INTO MedicoCirujano VALUES (3, 'Rodrigo','Haren','ROD069895LGHD','Calle 14','Soltero','2223658985');
INSERT INTO MedicoCirujano VALUES (4, 'Jorge','Romero','JORH67895LOMD','Calle 13','Casado','9845214587');
INSERT INTO MedicoCirujano VALUES (5, 'Ramon','Caicedo','RAM097895PGMD','Calle 89','Divorciado','9856487512');


INSERT INTO MedicoGeneral VALUES (1, 'Salvador','Sanchez','SALV067195LGMD','Privada Flor','Soltero','698521478');
INSERT INTO MedicoGeneral VALUES (2, 'Juan','Vega','JUA087195OHMD','Privada Manzano','Casado','5559874562');
INSERT INTO MedicoGeneral VALUES (3, 'Zoe','Hernadez','ZOE061895LGHD','Privada Ciruelo','Soltero','3336541895');
INSERT INTO MedicoGeneral VALUES (4, 'Chistian','Ruiz','CHRH67495COMD','Privada Garzas','Soltero','9857894152');
INSERT INTO MedicoGeneral VALUES (5, 'Irene','Gaeza','IRE097895LGMD','Privada Gaviotas','Soltera','2221547895');

INSERT INTO MedicoForense VALUES (1, 'Alfedo','Almeira','ALFO067895LGMD','Av Gavilanes','Soltero','22245698541');
INSERT INTO MedicoForense VALUES (2, 'Esther','Muller','EST089495ÑHMD','Av 115','Casada','55553216548');
INSERT INTO MedicoForense VALUES (3, 'Micaela','Gutierres','MIC069895QGHD','Av Polonia','Soltera','55552369854');
INSERT INTO MedicoForense VALUES (4, 'Antonio','Dominguez','ANTH65495AOMD','Av Constituyentes','Casado','2222559874');
INSERT INTO MedicoForense VALUES (5, 'Sonia','Pacocha','SON095895SLMD','AV Colosio','Divorciada','9845236589');

INSERT INTO DatosPerfil VALUES (1,'Pedro','Hernadez', 'CED75632', 'Licenciatura', 'MedicoCirujano');
INSERT INTO DatosPerfil VALUES (2,'Karen','Perez', 'CED78953','Maestria', 'MedicoCirujano');
INSERT INTO DatosPerfil VALUES (3,'Rodrigo','Haren', 'CED148563', 'Doctorado', 'MedicoCirujano');
INSERT INTO DatosPerfil VALUES (4,'Jorge','Romero', 'CED985632', 'Licenciatura', 'MedicoCirujano');
INSERT INTO DatosPerfil VALUES (5,'Ramon','Caicedo', 'CED497652', 'Maestria','MedicoCirujano');

