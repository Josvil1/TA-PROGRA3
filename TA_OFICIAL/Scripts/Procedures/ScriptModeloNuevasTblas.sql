-- ELIMINACIÓN DE TABLAS EN ORDEN DE DEPENDENCIA
DROP TABLE IF EXISTS envio;
DROP TABLE IF EXISTS comprobante;
DROP TABLE IF EXISTS pago;
DROP TABLE IF EXISTS pedido_item;
DROP TABLE IF EXISTS pedido;
DROP TABLE IF EXISTS item_carrito;
DROP TABLE IF EXISTS carrito;
DROP TABLE IF EXISTS precio_presentacion;
DROP TABLE IF EXISTS producto;
DROP TABLE IF EXISTS direccion;
DROP TABLE IF EXISTS p_juridica;
DROP TABLE IF EXISTS p_natural;
DROP TABLE IF EXISTS persona;
DROP TABLE IF EXISTS administrador;
DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS rol;

-- TABLA ROL (para distinguir entre CLIENTE o ADMIN)
CREATE TABLE rol (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) UNIQUE
) ENGINE=InnoDB;

-- TABLA USUARIO (para autenticación general)
CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100) UNIQUE,
    contrasena VARCHAR(100),
    activo TINYINT DEFAULT 1,
    rol_id INT,
    FOREIGN KEY (rol_id) REFERENCES rol(id)
) ENGINE=InnoDB;

-- TABLA PERSONA (solo naturales o jurídicas)
CREATE TABLE persona (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT UNIQUE,
    nombres VARCHAR(100),
    apellidos VARCHAR(100),
    telefono VARCHAR(20),
    activo TINYINT DEFAULT 1,
    usuario_creacion INT DEFAULT NULL,
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    usuario_actualizacion INT DEFAULT NULL,
    fecha_actualizacion DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
) ENGINE=InnoDB;

-- TABLA PERSONA NATURAL
CREATE TABLE p_natural (
    id INT PRIMARY KEY,
	dni INT,
    fecha_nacimiento DATE,
    genero VARCHAR(10),
    FOREIGN KEY (id) REFERENCES persona(id)
) ENGINE=InnoDB;

-- TABLA PERSONA JURÍDICA
CREATE TABLE p_juridica (
    id INT PRIMARY KEY,
    ruc VARCHAR(20),
    razon_social VARCHAR(100),
    representante_legal VARCHAR(100),
    FOREIGN KEY (id) REFERENCES persona(id)
) ENGINE=InnoDB;

-- TABLA ADMINISTRADOR (NO es hijo de persona)
CREATE TABLE administrador (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT UNIQUE,
    nombre_usuario VARCHAR(50),
    ultimo_ingreso DATETIME,
    cargo VARCHAR(100),
    activo TINYINT DEFAULT 1,
    usuario_creacion INT DEFAULT NULL,
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    usuario_actualizacion INT DEFAULT NULL,
    fecha_actualizacion DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
) ENGINE=InnoDB;

-- TABLA DIRECCIÓN (solo para persona, no para administrador)
CREATE TABLE direccion (
    id INT AUTO_INCREMENT PRIMARY KEY,
    persona_id INT,
    alias VARCHAR(100),
    direccion VARCHAR(255),
    ciudad VARCHAR(100),
    referencia VARCHAR(100),
    activo TINYINT DEFAULT 1,
    usuario_creacion INT DEFAULT NULL,
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    usuario_actualizacion INT DEFAULT NULL,
    fecha_actualizacion DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (persona_id) REFERENCES persona(id)
) ENGINE=InnoDB;

-- TABLA PRODUCTO
CREATE TABLE producto (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    descripcion VARCHAR(100),
    precio DECIMAL(10,2),
    stock INT,
    categoria VARCHAR(100),
    activo TINYINT DEFAULT 1,
    usuario_creacion INT DEFAULT NULL,
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    usuario_actualizacion INT DEFAULT NULL,
    fecha_actualizacion DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB;

-- TABLA PRECIO POR PRESENTACIÓN
CREATE TABLE precio_presentacion (
    id INT AUTO_INCREMENT PRIMARY KEY,
    producto_id INT,
    tipo_medida ENUM('DECENA','CENTENA','MILLAR','DOCENA'),
    cantidad INT,
    precio DECIMAL(10,2),
    activo TINYINT DEFAULT 1,
    usuario_creacion INT DEFAULT NULL,
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    usuario_actualizacion INT DEFAULT NULL,
    fecha_actualizacion DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (producto_id) REFERENCES producto(id)
) ENGINE=InnoDB;

-- TABLA CARRITO
CREATE TABLE carrito (
    id INT AUTO_INCREMENT PRIMARY KEY,
    persona_id INT,
    total DECIMAL(10,2),
    activo TINYINT DEFAULT 1,
    usuario_creacion INT DEFAULT NULL,
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    usuario_actualizacion INT DEFAULT NULL,
    fecha_actualizacion DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (persona_id) REFERENCES persona(id)
) ENGINE=InnoDB;

-- ITEMS DEL CARRITO
CREATE TABLE item_carrito (
    id INT AUTO_INCREMENT PRIMARY KEY,
    carrito_id INT,
    producto_id INT,
    cantidad INT,
    subtotal DECIMAL(10,2),
    activo TINYINT DEFAULT 1,
    usuario_creacion INT DEFAULT NULL,
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    usuario_actualizacion INT DEFAULT NULL,
    fecha_actualizacion DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (carrito_id) REFERENCES carrito(id),
    FOREIGN KEY (producto_id) REFERENCES producto(id)
) ENGINE=InnoDB;

-- TABLA PEDIDO
CREATE TABLE pedido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    persona_id INT,
    fecha_pedido DATETIME,
    total DECIMAL(10,2),
    estado VARCHAR(30),
    activo TINYINT DEFAULT 1,
    usuario_creacion INT DEFAULT NULL,
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    usuario_actualizacion INT DEFAULT NULL,
    fecha_actualizacion DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (persona_id) REFERENCES persona(id)
) ENGINE=InnoDB;

-- ITEMS DEL PEDIDO
CREATE TABLE pedido_item (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pedido_id INT,
    producto_id INT,
    cantidad INT,
    precio DECIMAL(10,2),
    activo TINYINT DEFAULT 1,
    usuario_creacion INT DEFAULT NULL,
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    usuario_actualizacion INT DEFAULT NULL,
    fecha_actualizacion DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (pedido_id) REFERENCES pedido(id),
    FOREIGN KEY (producto_id) REFERENCES producto(id)
) ENGINE=InnoDB;

-- TABLA PAGO
CREATE TABLE pago (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pedido_id INT,
    metodo VARCHAR(50),
    monto DECIMAL(10,2),
    estado VARCHAR(30),
    fecha_pago DATETIME,
    activo TINYINT DEFAULT 1,
    usuario_creacion INT DEFAULT NULL,
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    usuario_actualizacion INT DEFAULT NULL,
    fecha_actualizacion DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (pedido_id) REFERENCES pedido(id)
) ENGINE=InnoDB;

-- TABLA ENVÍO
CREATE TABLE envio (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pedido_id INT,
    direccion_id INT,
    estado_envio VARCHAR(30),
    fecha_entrega DATE,
    activo TINYINT DEFAULT 1,
    usuario_creacion INT DEFAULT NULL,
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    usuario_actualizacion INT DEFAULT NULL,
    fecha_actualizacion DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (pedido_id) REFERENCES pedido(id),
    FOREIGN KEY (direccion_id) REFERENCES direccion(id)
) ENGINE=InnoDB;

-- TABLA COMPROBANTE
CREATE TABLE comprobante (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pedido_id INT,
    tipo VARCHAR(50),
    numero_serie VARCHAR(50),
    fecha_emision DATETIME,
    total DECIMAL(10,2),
	activo TINYINT DEFAULT 1,
    usuario_creacion INT DEFAULT NULL,
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    usuario_actualizacion INT DEFAULT NULL,
    fecha_actualizacion DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (pedido_id) REFERENCES pedido(id)
) ENGINE=InnoDB;

-- INSERTAR ROLES INICIALES
-- INSERT INTO rol(nombre) VALUES ('ADMIN'), ('CLIENTE_JURIDICO'), ('CLIENTE_NATURAL');