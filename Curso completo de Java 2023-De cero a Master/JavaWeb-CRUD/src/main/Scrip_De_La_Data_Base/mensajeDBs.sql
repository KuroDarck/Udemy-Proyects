DROP DATABASE IF EXISTS mensajes;
create  database mensajes;

use mensajes;

CREATE TABLE `mensaje` (
  `idmensaje` int(11) NOT NULL AUTO_INCREMENT,
  `mensajes` varchar(45) NOT NULL,
  `autor` varchar(45) NOT NULL,
  `fecha` date NOT NULL,
  PRIMARY KEY (`idmensaje`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO mensaje (mensajes, autor, fecha) VALUES
('Hola, ¿cómo estás?', 'Juan Perez', '2023-07-01'),
('Reunión mañana a las 10 am.', 'Maria Lopez', '2023-07-02'),
('¿Alguien puede traer café?', 'Ana Ramirez', '2023-07-03'),
('¡Feliz cumpleaños! 🎉', 'David Smith', '2023-07-04'),
('Recordatorio: pagar las facturas hoy', 'Laura Gomez', '2023-07-05'),
('Enlace para la presentación adjunto.', 'Carlos Ruiz', '2023-07-06'),
('Última llamada para el evento de mañana', 'Sofia Torres', '2023-07-07'),
('Excelente trabajo en el proyecto', 'Peter Lee', '2023-07-08'),
('¿Quién puede cubrir el turno de noche?', 'Marta Flores', '2023-07-09'),
('Actualización del software disponible', 'Emma Wang', '2023-07-10');

