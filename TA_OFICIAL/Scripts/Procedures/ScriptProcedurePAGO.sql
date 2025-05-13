-- PARA LA TABLA PAGO

DROP PROCEDURE IF EXISTS insertarPago;
DELIMITER $$
CREATE PROCEDURE insertarPago(
    IN p_pedido_id INT,
    IN p_metodo VARCHAR(50),
    IN p_monto DECIMAL(10,2),
    IN p_estado VARCHAR(30),
    IN p_fecha_pago DATETIME,
    IN p_usuario_creacion INT,
    OUT p_id_pago INT
)
BEGIN
    INSERT INTO pago(pedido_id, metodo, monto, estado, fecha_pago, usuario_creacion)
    VALUES (p_pedido_id, p_metodo, p_monto, p_estado, p_fecha_pago, p_usuario_creacion);
    
    SET p_id_pago = LAST_INSERT_ID();
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS modificarPago;
DELIMITER $$
CREATE PROCEDURE modificarPago(
    IN p_id INT,
    IN p_estado VARCHAR(30),
    IN p_usuario_actualizacion INT
)
BEGIN
    UPDATE pago
    SET estado = p_estado,
        usuario_actualizacion = p_usuario_actualizacion,
        fecha_actualizacion = CURRENT_TIMESTAMP
    WHERE id = p_id;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS eliminarPago;
DELIMITER $$
CREATE PROCEDURE eliminarPago(
    IN p_id_pago INT,
    IN p_usuario_actualizacion INT
)
BEGIN
    UPDATE pago
    SET activo = 0,
        usuario_actualizacion = p_usuario_actualizacion,
        fecha_actualizacion = CURRENT_TIMESTAMP
    WHERE id = p_id_pago;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS obtenerPagoPorId;
DELIMITER $$
CREATE PROCEDURE obtenerPagoPorId(
    IN p_id INT
)
BEGIN
    SELECT * FROM pago WHERE id = p_id AND activo = 1;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS listarPago;
DELIMITER $$
CREATE PROCEDURE listarPago()
BEGIN
    SELECT id, pedido_id, metodo, monto, estado, fecha_pago
    FROM pago
    WHERE activo = 1;
END $$
DELIMITER ;


