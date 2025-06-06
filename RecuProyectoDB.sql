CREATE database if not exists RecuProyecto;

DROP TABLE IF EXISTS Contacto;

CREATE TABLE Contacto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido1 VARCHAR(50) NOT NULL,
    apellido2 VARCHAR(50),
    telefono int(20) unique,
    email VARCHAR(100) unique
);
INSERT INTO Contacto (nombre, apellido1, apellido2, telefono, email) VALUES
('Juan', 'Pérez', 'Gómez', '612345678', 'juan.perez@email.com'),
('María', 'López', 'Ramírez', '623456789', 'maria.lopez@email.com'),
('Carlos', 'García', NULL, '634567890', 'carlos.garcia@email.com'),
('Ana', 'Martínez', 'Fernández', '645678901', 'ana.martinez@email.com'),
('Luis', 'Sánchez', 'Torres', NULL, 'luis.sanchez@email.com'),
('Lucía', 'Núñez', 'Cabrera', '611112223', 'lucia.nunez@email.com'),
('Diego', 'Romero', 'Santos', '622223334', 'diego.romero@email.com'),
('Elena', 'Jiménez', NULL, '633334445', 'elena.jimenez@email.com'),
('Javier', 'Molina', 'Vargas', NULL, 'javier.molina@email.com'),
('Paula', 'Ortega', 'Delgado', '644445556', 'paula.ortega@email.com'),
('Andrés', 'Iglesias', 'Reyes', '655556667', 'andres.iglesias@email.com'),
('Sofía', 'Castillo', NULL, '666667778', 'sofia.castillo@email.com'),
('Manuel', 'Rubio', 'Herrera', '677778889', 'manuel.rubio@email.com'),
('Carmen', 'Medina', 'Ramos', NULL, 'carmen.medina@email.com'),
('Fernando', 'Peña', NULL, '688889990', 'fernando.pena@email.com'),
('Natalia', 'Cruz', 'Méndez', '699990001', 'natalia.cruz@email.com'),
('Alberto', 'Silva', 'León', '600001112', 'alberto.silva@email.com'),
('Laura', 'Vega', 'Morales', '611223344', 'laura.vega@email.com'),
('Raúl', 'Campos', NULL, '622334455', 'raul.campos@email.com'),
('Patricia', 'Fuentes', 'Navarro', NULL, 'patricia.fuentes@email.com'),
('Sergio', 'Gallardo', 'Luna', '633445566', 'sergio.gallardo@email.com'),
('Noelia', 'Paredes', NULL, '644556677', 'noelia.paredes@email.com'),
('Mario', 'Durán', 'Giménez', '655667788', 'mario.duran@email.com'),
('Teresa', 'Aguirre', 'Salas', NULL, 'teresa.aguirre@email.com'),
('Iván', 'Montoya', 'Benítez', '666778899', 'ivan.montoya@email.com');