-- INSERTAR CARRITO
DROP PROCEDURE IF EXISTS insertarCarrito;
DELIMITER $$
CREATE PROCEDURE insertarCarrito(
    OUT p_id INT,
    IN p_persona_id INT,
    IN p_total DECIMAL(10,2),
    IN p_usuario_creacion INT
)
BEGIN
    INSERT INTO carrito(persona_id, total, usuario_creacion)
    VALUES (p_persona_id, p_total, p_usuario_creacion);
    SET p_id = LAST_INSERT_ID();
END $$
DELIMITER ;

-- MODIFICAR CARRITO
DROP PROCEDURE IF EXISTS modificarCarrito;
DELIMITER $$
CREATE PROCEDURE modificarCarrito(
    IN p_id INT,
    IN p_total DECIMAL(10,2),
    IN p_usuario_actualizacion INT
)
BEGIN
    UPDATE carrito
    SET total = p_total,
        usuario_actualizacion = p_usuario_actualizacion
    WHERE id = p_id;
END $$
DELIMITER ;

-- ELIMINAR (lógica) CARRITO
DROP PROCEDURE IF EXISTS eliminarCarrito;
DELIMITER $$
CREATE PROCEDURE eliminarCarrito(
    IN p_id_carrito INT,
    IN p_usuario_actualizacion INT
)
BEGIN
    UPDATE carrito
    SET activo = 0,
        usuario_actualizacion = p_usuario_actualizacion,
        fecha_actualizacion = CURRENT_TIMESTAMP
    WHERE id = p_id_carrito;
END $$
DELIMITER ;

-- OBTENER CARRITO POR ID
DROP PROCEDURE IF EXISTS obtenerCarritoPorId;
DELIMITER $$
CREATE PROCEDURE obtenerCarritoPorId(IN p_id INT)
BEGIN
    SELECT * FROM carrito WHERE id = p_id AND activo = 1;
END $$
DELIMITER ;

-- LISTAR CARRITOS ACTIVOS
DROP PROCEDURE IF EXISTS listarCarritos;
DELIMITER $$
CREATE PROCEDURE listarCarritos()
BEGIN
    SELECT id, persona_id, total FROM carrito WHERE activo = 1;
END $$
DELIMITER ;