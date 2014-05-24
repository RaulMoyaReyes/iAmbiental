
/** DEPENDENCIAS */
INSERT INTO iambiental.dependencias (descripcion, nombre) 
	VALUES ('Salón de la planta de arriba', 'Salón');
INSERT INTO iambiental.dependencias (descripcion, nombre) 
	VALUES ('Dormitorio de Manuel', 'Dormitorio 1');
INSERT INTO iambiental.dependencias (descripcion, nombre) 
	VALUES ('Cocina pequeña', 'Cocina');

/** ACTUADORES */
INSERT INTO iambiental.actuadores (dato, descripcion, estado, fecha, ip, puerto, dependencia_id, tipo, idfisico) 
	VALUES (5.0, 'Interruptor de la luz', 0, '2014-04-29 12:20:16.0', '', NULL, 1, 1, 1);
INSERT INTO iambiental.actuadores (dato, descripcion, estado, fecha, ip, puerto, dependencia_id, tipo, idfisico) 
	VALUES (22.0, 'Termostato', 1, '2014-04-30 12:12:21.0', NULL, NULL, 1, 0, 1);
INSERT INTO iambiental.actuadores (dato, descripcion, estado, fecha, ip, puerto, dependencia_id, tipo, idfisico) 
	VALUES (0.0, 'Interruptor puerta cocina', 1, '2014-04-30 12:15:03.0', NULL, NULL, 1, 1, 1);
INSERT INTO iambiental.actuadores (dato, descripcion, estado, fecha, ip, puerto, tipo, dependencia_id, idfisico) 
	VALUES (0.0, 'Interuptor de la luz de la lampara', 0, '2014-05-03 00:23:29.0', NULL, NULL, 1, 2, 1);
INSERT INTO iambiental.actuadores (dato, descripcion, estado, fecha, ip, puerto, tipo, dependencia_id, idfisico) 
	VALUES (21.0, 'Termostato dormitorio 1', 0, '2014-05-03 00:26:49.0', NULL, NULL, 0, 2, 1);



/** SENSORES */
INSERT INTO iambiental.sensores (dato, descripcion, estado, fecha, ip, puerto, tipo, dependencia_id, idfisico) 
	VALUES (32.0, 'Sensor de temperatura de habitación', 0, '2014-04-29 12:39:03.0', NULL, NULL, 1, 1, 1);
INSERT INTO iambiental.sensores (dato, descripcion, estado, fecha, ip, puerto, tipo, dependencia_id, idfisico) 
	VALUES (28.0, 'Sensor de luz del salón', 1, '2014-04-29 13:14:53.0', NULL, NULL, 0, 1, 1);
INSERT INTO iambiental.sensores (dato, descripcion, estado, fecha, ip, puerto, tipo, dependencia_id, idfisico) 
	VALUES (21.0, 'Sensor de temperatura dormitorio 1', 0, '2014-05-03 00:27:58.0', NULL, NULL, 1, 2, 1);

/** TAREAS PROGRAMADAS */
INSERT INTO iambiental.tareasprogramadas (descripcion) 
	VALUES ('Depuradora');

/** REGLAS PROGRAMADAS */
INSERT INTO iambiental.reglasprogramadas (condicion, descripcion, actuador_id, sensor_id) 
	VALUES ('9<3', 'Encender motor', 1, 1);
INSERT INTO iambiental.tareasprogramadas_reglasprogramadas (tareasprogramadas_id, `reglasProgramadas_id`) 
	VALUES (1, 1);
