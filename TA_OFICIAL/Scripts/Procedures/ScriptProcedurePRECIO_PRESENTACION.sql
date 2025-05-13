-- PRECIO_PRESENTACION:

DROP PROCEDURE IF EXISTS insertarPrecioPresentacion;
DELIMITER $$
CREATE PROCEDURE insertarPrecioPresentacion(
    IN p_producto_id INT,
    IN p_tipo_medida ENUM('DECENA','CENTENA','MILLAR','DOCENA'),
    IN p_cantidad INT,
    IN p_precio DECIMAL(10,2),
    IN p_usuario_creacion INT,
    OUT p_id_presentacion INT
)
BEGIN
    INSERT INTO precio_presentacion(producto_id, tipo_medida, cantidad, precio, usuario_creacion)
    VALUES (p_producto_id, p_tipo_medida, p_cantidad, p_precio, p_usuario_creacion);
    
    SET p_id_presentacion = LAST_INSERT_ID();
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS modificarPrecioPresentacion;
DELIMITER $$
CREATE PROCEDURE modificarPrecioPresentacion(
    IN p_id INT,
    IN p_cantidad INT,
    IN p_precio DECIMAL(10,2),
    IN p_usuario_actualizacion INT
)
BEGIN
    UPDATE precio_presentacion
    SET cantidad = p_cantidad,
        precio = p_precio,
        usuario_actualizacion = p_usuario_actualizacion,
        fecha_actualizacion = CURRENT_TIMESTAMP
    WHERE id = p_id;
END $$
DELIMITER ;


DROP PROCEDURE IF EXISTS eliminarPrecioPresentacion;
DELIMITER $$
CREATE PROCEDURE eliminarPrecioPresentacion(
    IN p_id_presentacion INT,
    IN p_usuario_actualizacion INT
)
BEGIN
    UPDATE precio_presentacion
    SET activo = 0,
        usuario_actualizacion = p_usuario_actualizacion,
        fecha_actualizacion = CURRENT_TIMESTAMP
    WHERE id = p_id_presentacion;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS obtenerPrecioPresentacionPorId;
DELIMITER $$
CREATE PROCEDURE obtenerPrecioPresentacionPorId(
    IN p_id INT
)
BEGIN
    SELECT * FROM precio_presentacion WHERE id = p_id AND activo = 1;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS listarPrecioPresentacion;
DELIMITER $$
CREATE PROCEDURE listarPrecioPresentacion()
BEGIN
    SELECT id, producto_id, tipo_medida, cantidad, precio
    FROM precio_presentacion
    WHERE activo = 1;
END $$
DELIMITER ;

