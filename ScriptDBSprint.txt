create database dbmodulo06;
use dbmodulo06;

CREATE TABLE usuarios (
  idUsuario int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  nombreUsuario varchar(50) NOT NULL,
  apellidoUsuario varchar(50) NOT NULL,
  nickname varchar(50) DEFAULT NULL,
  contrasena varchar(100) DEFAULT NULL,
  runUsuario varchar(20) NOT NULL,
  correoUsuario varchar(50) NOT NULL,
  telefonoUsuario varchar(20) DEFAULT NULL,
  tipoUsuario enum('CLIENTE','ADMINISTRATIVO','PROFESIONAL') NOT NULL
  );

CREATE TABLE clientes (
  idCliente int NOT NULL AUTO_INCREMENT,
  idUsuario int NOT NULL,
  nombreEmpresa varchar(50) NOT NULL,
  rutEmpresa varchar(20) NOT NULL,
  telefonoEmpresa varchar(20) DEFAULT NULL,
  correoEmpresa varchar(50) DEFAULT NULL,
  direccionEmpresa varchar(100) DEFAULT NULL,
  comunaEmpresa varchar(50) DEFAULT NULL,
  PRIMARY KEY (idCliente),
  UNIQUE KEY rutEmpresa (rutEmpresa),
  KEY idUsuario (idUsuario),
  CONSTRAINT clientes_ibfk_1 FOREIGN KEY (idUsuario) REFERENCES usuarios (idUsuario) ON DELETE CASCADE ON UPDATE CASCADE
) ;

CREATE TABLE administrativos (
  idAdministrativo int NOT NULL AUTO_INCREMENT,
  idUsuario int NOT NULL,
  areaAdministrativo varchar(50) DEFAULT NULL,
  experienciaPrevia varchar(20) DEFAULT NULL,
  PRIMARY KEY (idAdministrativo),
  KEY idUsuario (idUsuario),
  CONSTRAINT administrativos_ibfk_1 FOREIGN KEY (idUsuario) REFERENCES usuarios (idUsuario) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE capacitaciones (
  idCapacitacion int NOT NULL AUTO_INCREMENT,
  rutEmpresa varchar(20) NOT NULL,
  nombreCapacitacion varchar(100) NOT NULL,
  detalleCapacitacion text,
  PRIMARY KEY (idCapacitacion),
  CONSTRAINT fk_ClienteRut FOREIGN KEY (RutEmpresa) REFERENCES clientes (RutEmpresa) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE pagos (
  idPago int NOT NULL AUTO_INCREMENT,
  rutEmpresa varchar(20) DEFAULT NULL,
  monto int DEFAULT NULL,
  fecha varchar(20) DEFAULT NULL,
  detallePago text,
  PRIMARY KEY (idPago),
  KEY fk_pagosRut (rutEmpresa),
  CONSTRAINT fk_pagosRut FOREIGN KEY (rutEmpresa) REFERENCES clientes (rutEmpresa) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE profesionales (
  idProfesional int NOT NULL AUTO_INCREMENT,
  idUsuario int NOT NULL,
  tituloProfesional varchar(100) DEFAULT NULL,
  fechaIngresoProfesional date DEFAULT NULL,
  PRIMARY KEY (idProfesional),
  KEY idUsuario (idUsuario),
  CONSTRAINT profesionales_ibfk_1 FOREIGN KEY (idUsuario) REFERENCES usuarios (idUsuario) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE visitas (
  idVisita int NOT NULL AUTO_INCREMENT,
  idCliente int NOT NULL,
  diaVisita varchar(50) NOT NULL,
  horaVisita varchar(50) NOT NULL,
  lugar varchar(50) NOT NULL,
  comentario varchar(100) NOT NULL,
  PRIMARY KEY (idVisita),
  KEY idCliente (idCliente),
  CONSTRAINT visitas_ibfk_1 FOREIGN KEY (idCliente) REFERENCES clientes (idCliente)
);

CREATE TABLE revisiones (
  idRevision int NOT NULL AUTO_INCREMENT,
  idVisita int DEFAULT NULL,
  nombreRevision varchar(50) NOT NULL,
  detalleRevision text NOT NULL,
  estadoRevision enum('pendiente','aprobada','reprobada') NOT NULL,
  PRIMARY KEY (idRevision),
  KEY idVisita (idVisita),
  CONSTRAINT revisiones_ibfk_1 FOREIGN KEY (idVisita) REFERENCES visitas (idVisita) ON DELETE CASCADE ON UPDATE CASCADE
);


INSERT INTO usuarios (nombreUsuario, apellidoUsuario, nickname, contrasena, runUsuario, correoUsuario, telefonoUsuario, tipoUsuario) VALUES 
('bastian','munoz','profesional','$2a$10$m0ZAZ/Sjf6JhYor9K/hsHeePISsmBVs44qiAmQbhFEIqufM5Jr6fG','11111111-1','bmunoz@gmail.com','+56 911111111','profesional'),
('bastian','espinosa','cliente','$2a$10$m0ZAZ/Sjf6JhYor9K/hsHeePISsmBVs44qiAmQbhFEIqufM5Jr6fG','11111111-2','bespinosa@gmail.com','+56 921111111','cliente'),
('ariel','alfaro','administrativo','$2a$10$m0ZAZ/Sjf6JhYor9K/hsHeePISsmBVs44qiAmQbhFEIqufM5Jr6fG','11111111-3','aalfaro@gmail.com','+56 931111111','administrativo');
select * from usuarios;


insert into clientes (idUsuario,nombreEmpresa,rutEmpresa,telefonoEmpresa,correoEmpresa,direccionEmpresa,comunaEmpresa) values
(2,'Empresa 1','99999999-1','+56 999999991','empresa1@gmail.com','Avenida 1', 'Providencia');
select * from clientes;



insert into administrativos (idUsuario,areaAdministrativo,experienciaPrevia) values
(3,'RRHH','1');
select * from administrativos;

insert into profesionales (idUsuario,tituloProfesional,fechaIngresoProfesional) values
(1,'Analista Programador','2024-01-01');
select * from profesionales;

insert into capacitaciones (rutEmpresa,nombreCapacitacion,detalleCapacitacion) values
('99999999-1','Uso de mouse', 'Como usar correctamente el mouse');
select * from capacitaciones;

INSERT INTO pagos (rutEmpresa, monto, fecha, detallePago) values
('99999999-1', 50000, '2024-10-03', 'Pago correspondiente a la capacitación de personal administrativo.');
select * from pagos;



SELECT u.idUsuario, u.nombreUsuario, u.apellidoUsuario, u.runUsuario, u.correoUsuario, u.telefonoUsuario, u.tipoUsuario, a.idAdministrativo, a.areaAdministrativo, a.experienciaPrevia FROM usuarios u INNER JOIN administrativos a ON u.idUsuario = a.idUsuario WHERE u.tipoUsuario = 'administrativo';

SELECT u.idUsuario, u.nombreUsuario, u.apellidoUsuario, u.runUsuario, u.correoUsuario, u.telefonoUsuario, u.tipoUsuario, c.idCliente, c.rutEmpresa, c.telefonoEmpresa, c.correoEmpresa, c.direccionEmpresa, c.comunaEmpresa from usuarios u INNER JOIN clientes c on u.idUsuario = c.idUsuario where u.tipoUsuario = 'cliente';

SELECT u.idUsuario, u.nombreUsuario, u.apellidoUsuario, u.runUsuario, u.correoUsuario, u.telefonoUsuario, u.tipoUsuario, p.tituloProfesional, p.fechaIngresoProfesional from usuarios u INNER JOIN profesionales p on u.idUsuario = p.idUsuario where u.tipoUsuario = 'profesional';

