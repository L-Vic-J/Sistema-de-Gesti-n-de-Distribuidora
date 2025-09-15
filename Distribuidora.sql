 
 -- Base de datos de distibuidora
 CREATE DATABASE Distribuidora;
 
 -- Tabla de Usuarios
 
 CREATE TABLE Usuario (
 id_Usuario INT PRIMARY KEY AUTO_INCREMENT,
 nombre VARCHAR (50) not null,
 correo VARCHAR (50) not null,
 contraseña VARCHAR (50)not null,
 rol CHAR (13) not null
 );
 
-- Tabla de Camiones
CREATE TABLE Camion (
    id_Camion INT PRIMARY KEY AUTO_INCREMENT,
    placa VARCHAR(20) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    capacidadMaxima DOUBLE NOT NULL
);

-- Tabla de Productos
CREATE TABLE Producto (
    id_Producto INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(100),
    cantidad INT NOT NULL,
    peso DOUBLE NOT NULL,
    unidad VARCHAR(10) NOT NULL,
    precio DOUBLE NOT NULL,
    disponible BOOLEAN NOT NULL
);

DROP TABLE Producto;
-- Tabla de Pedidos
CREATE TABLE Pedido (
    id_Pedido INT PRIMARY KEY AUTO_INCREMENT,
    id_Cliente INT NOT NULL,
    direccionEntrega VARCHAR(100) NOT NULL,
    pesoTotal DOUBLE NOT NULL,
    estado ENUM('Pendiente','Asignado','Entregado') DEFAULT 'Pendiente',
    id_Camion INT,
    FOREIGN KEY (id_Cliente) REFERENCES Usuario(id_Usuario),
    FOREIGN KEY (id_Camion) REFERENCES Camion(id_Camion)
);

-- Tabla intermedia Pedido-Producto
CREATE TABLE Pedido_Producto (
    id_Pedido INT NOT NULL,
    id_Producto INT NOT NULL,
    cantidad INT NOT NULL,
    PRIMARY KEY (id_Pedido, id_Producto),
    FOREIGN KEY (id_Pedido) REFERENCES Pedido(id_Pedido),
    FOREIGN KEY (id_Producto) REFERENCES Producto(id_Producto)
);


CREATE TABLE Clientes (
 id_Cliente INT PRIMARY KEY AUTO_INCREMENT,
 nombre VARCHAR (50) not null,
 correo VARCHAR (50) not null,
 contraseña VARCHAR (50)not null,
 rol CHAR (13) not null
);


INSERT INTO Clientes (nombre,correo,contraseña,rol) VALUES
("Jimena Gonzalez Ramirez","jgonzalez@gmail.com","Cliente!","Cliente");

INSERT INTO Usuario (nombre,correo,contraseña,rol) VALUES
("Victor Leiton Jimenez","vleiton@gmail.com","Administrador55","Administrador"),
("Andres Perez Sosa","asosa@gmail.com","Operador33","Operador"),
("Jimena Gonzalez Ramirez","jgonzalez@gmail.com","Cliente!","Cliente");


SELECT * FROM Usuario;

-- Camiones
INSERT INTO camion (placa, modelo, capacidadMaxima) VALUES
('ABC123', 'Toyota Hino', 1500),
('XYZ789', 'Isuzu NPR', 2000);

-- Productos
INSERT INTO producto (nombre, descripcion, cantidad, peso, unidad, precio, disponible) VALUES
('Arroz', 'Arroz blanco 5kg', 100, 5, 'kg', 10.50, true),
('Frijoles', 'Frijol negro 2kg', 80, 2, 'kg', 6.00, true);
 
USE Distribuidora;
SHOW TABLES;

DROP TABLE Clientes;

SELECT * FROM Usuario;

DELETE FROM Usuario WHERE id_Usuario=3;
