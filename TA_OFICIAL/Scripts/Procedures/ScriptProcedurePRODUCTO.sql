-- INSERTAR PRODUCTO
DROP PROCEDURE IF EXISTS insertarProducto;
DELIMITER $$
CREATE PROCEDURE insertarProducto(
    OUT p_id INT,
    IN p_nombre VARCHAR(100),
    IN p_descripcion VARCHAR(100),
    IN p_precio DECIMAL(10,2),
    IN p_stock INT,
    IN p_categoria VARCHAR(100),
    IN p_usuario_creacion INT
)
BEGIN
    INSERT INTO producto(nombre, descripcion, precio, stock, categoria, usuario_creacion)
    VALUES (p_nombre, p_descripcion, p_precio, p_stock, p_categoria, p_usuario_creacion);
    SET p_id = LAST_INSERT_ID();
END $$
DELIMITER ;

-- MODIFICAR PRODUCTO
DROP PROCEDURE IF EXISTS modificarProducto;
DELIMITER $$
CREATE PROCEDURE modificarProducto(
    IN p_id INT,
    IN p_nombre VARCHAR(100),
    IN p_descripcion VARCHAR(100),
    IN p_precio DECIMAL(10,2),
    IN p_stock INT,
    IN p_categoria VARCHAR(100),
    IN p_usuario_actualizacion INT
)
BEGIN
    UPDATE producto
    SET nombre = p_nombre,
        descripcion = p_descripcion,
        precio = p_precio,
        stock = p_stock,
        categoria = p_categoria,
        usuario_actualizacion = p_usuario_actualizacion
    WHERE id = p_id;
END $$
DELIMITER ;

-- ELIMINAR (lógica) PRODUCTO
DROP PROCEDURE IF EXISTS eliminarProducto;
DELIMITER $$
CREATE PROCEDURE eliminarProducto(
    IN p_id INT,
    IN p_usuario_actualizacion INT
)
BEGIN
    UPDATE producto 
    SET activo = 0,
        usuario_actualizacion = p_usuario_actualizacion,
        fecha_actualizacion = CURRENT_TIMESTAMP
    WHERE id = p_id;
END $$
DELIMITER ;

-- OBTENER PRODUCTO POR ID
DROP PROCEDURE IF EXISTS obtenerProductoPorId;
DELIMITER $$
CREATE PROCEDURE obtenerProductoPorId(IN p_id INT)
BEGIN
    SELECT * FROM producto WHERE id = p_id AND activo = 1;
END $$
DELIMITER ;

-- LISTAR PRODUCTOS ACTIVOS
DROP PROCEDURE IF EXISTS listarProductos;
DELIMITER $$
CREATE PROCEDURE listarProductos()
BEGIN
    SELECT id, nombre, descripcion, precio, stock, categoria FROM producto WHERE activo = 1;
END $$
DELIMITER ;