-- INSERTAR PEDIDO
DROP PROCEDURE IF EXISTS insertarPedido;
DELIMITER $$
CREATE PROCEDURE insertarPedido(
    OUT p_id INT,
    IN p_persona_id INT,
    IN p_fecha_pedido DATETIME,
    IN p_total DECIMAL(10,2),
    IN p_estado VARCHAR(30),
    IN p_usuario_creacion INT
)
BEGIN
    INSERT INTO pedido(persona_id, fecha_pedido, total, estado, usuario_creacion)
    VALUES (p_persona_id, p_fecha_pedido, p_total, p_estado, p_usuario_creacion);
    SET p_id = LAST_INSERT_ID();
END $$
DELIMITER ;

-- MODIFICAR PEDIDO
DROP PROCEDURE IF EXISTS modificarPedido;
DELIMITER $$
CREATE PROCEDURE modificarPedido(
    IN p_id INT,
    IN p_estado VARCHAR(30),
    IN p_total DECIMAL(10,2),
    IN p_usuario_actualizacion INT
)
BEGIN
    UPDATE pedido
    SET estado = p_estado,
        total = p_total,
        usuario_actualizacion = p_usuario_actualizacion
    WHERE id = p_id;
END $$
DELIMITER ;

-- ELIMINAR (lógica) PEDIDO
DROP PROCEDURE IF EXISTS eliminarPedido;
DELIMITER $$
CREATE PROCEDURE eliminarPedido(
    IN p_id_pedido INT,
    IN p_usuario_actualizacion INT
)
BEGIN
    UPDATE pedido
    SET activo = 0,
        usuario_actualizacion = p_usuario_actualizacion,
        fecha_actualizacion = CURRENT_TIMESTAMP
    WHERE id = p_id_pedido;
END $$
DELIMITER ;

-- OBTENER PEDIDO POR ID
DROP PROCEDURE IF EXISTS obtenerPedidoPorId;
DELIMITER $$
CREATE PROCEDURE obtenerPedidoPorId(IN p_id INT)
BEGIN
    SELECT * FROM pedido WHERE id = p_id AND activo = 1;
END $$
DELIMITER ;

-- LISTAR PEDIDOS ACTIVOS
DROP PROCEDURE IF EXISTS listarPedidos;
DELIMITER $$
CREATE PROCEDURE listarPedidos()
BEGIN
    SELECT id, persona_id, fecha_pedido, total, estado FROM pedido WHERE activo = 1;
END $$
DELIMITER ;