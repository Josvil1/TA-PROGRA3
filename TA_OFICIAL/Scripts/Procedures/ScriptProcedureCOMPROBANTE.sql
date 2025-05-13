-- COMPROBANTE:

DROP PROCEDURE IF EXISTS insertarComprobante;
DELIMITER $$
CREATE PROCEDURE insertarComprobante(
    IN p_pedido_id INT,
    IN p_tipo VARCHAR(50),
    IN p_numero_serie VARCHAR(50),
    IN p_fecha_emision DATETIME,
    IN p_total DECIMAL(10,2),
    IN p_usuario_creacion INT,
    OUT p_id_comprobante INT
)
BEGIN
    INSERT INTO comprobante(pedido_id, tipo, numero_serie, fecha_emision, total, usuario_creacion)
    VALUES (p_pedido_id, p_tipo, p_numero_serie, p_fecha_emision, p_total, p_usuario_creacion);
    
    SET p_id_comprobante = LAST_INSERT_ID();
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS modificarComprobante;
DELIMITER $$
CREATE PROCEDURE modificarComprobante(
    IN p_id INT,
    IN p_tipo VARCHAR(50),
    IN p_numero_serie VARCHAR(50),
    IN p_usuario_actualizacion INT
)
BEGIN
    UPDATE comprobante
    SET tipo = p_tipo,
        numero_serie = p_numero_serie,
        usuario_actualizacion = p_usuario_actualizacion,
        fecha_actualizacion = CURRENT_TIMESTAMP
    WHERE id = p_id;
END $$
DELIMITER ;




DROP PROCEDURE IF EXISTS eliminarComprobante;
DELIMITER $$
CREATE PROCEDURE eliminarComprobante(
    IN p_id_comprobante INT,
    IN p_usuario_actualizacion INT
)
BEGIN
    UPDATE comprobante
    SET activo = 0,
        usuario_actualizacion = p_usuario_actualizacion,
        fecha_actualizacion = CURRENT_TIMESTAMP
    WHERE id = p_id_comprobante;
END $$
DELIMITER ;


DROP PROCEDURE IF EXISTS obtenerComprobantePorId;
DELIMITER $$
CREATE PROCEDURE obtenerComprobantePorId(
    IN p_id INT
)
BEGIN
    SELECT * FROM comprobante WHERE id = p_id AND activo = 1;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS listarComprobante;
DELIMITER $$
CREATE PROCEDURE listarComprobante()
BEGIN
    SELECT id, pedido_id, tipo, numero_serie, fecha_emision, total
    FROM comprobante
    WHERE activo = 1;
END $$
DELIMITER ;

