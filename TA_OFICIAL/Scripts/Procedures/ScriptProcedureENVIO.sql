-- PARA ENVIO:

DROP PROCEDURE IF EXISTS insertarEnvio;
DELIMITER $$
CREATE PROCEDURE insertarEnvio(
    IN p_pedido_id INT,
    IN p_direccion_id INT,
    IN p_estado_envio VARCHAR(30),
    IN p_fecha_entrega DATE,
    IN p_usuario_creacion INT,
    OUT p_id_envio INT
)
BEGIN
    INSERT INTO envio(pedido_id, direccion_id, estado_envio, fecha_entrega, usuario_creacion)
    VALUES (p_pedido_id, p_direccion_id, p_estado_envio, p_fecha_entrega, p_usuario_creacion);
    
    SET p_id_envio = LAST_INSERT_ID();
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS modificarEnvio;
DELIMITER $$
CREATE PROCEDURE modificarEnvio(
    IN p_id INT,
    IN p_estado_envio VARCHAR(30),
    IN p_usuario_actualizacion INT
)
BEGIN
    UPDATE envio
    SET estado_envio = p_estado_envio,
        usuario_actualizacion = p_usuario_actualizacion,
        fecha_actualizacion = CURRENT_TIMESTAMP
    WHERE id = p_id;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS eliminarEnvio;
DELIMITER $$
CREATE PROCEDURE eliminarEnvio(
    IN p_id_envio INT,
    IN p_usuario_actualizacion INT
)
BEGIN
    UPDATE envio
    SET activo = 0,
        usuario_actualizacion = p_usuario_actualizacion,
        fecha_actualizacion = CURRENT_TIMESTAMP
    WHERE id = p_id_envio;
END $$
DELIMITER ;


DROP PROCEDURE IF EXISTS obtenerEnvioPorId;
DELIMITER $$
CREATE PROCEDURE obtenerEnvioPorId(
    IN p_id INT
)
BEGIN
    SELECT * FROM envio WHERE id = p_id AND activo = 1;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS listarEnvio;
DELIMITER $$
CREATE PROCEDURE listarEnvio()
BEGIN
    SELECT id, pedido_id, direccion_id, estado_envio, fecha_entrega
    FROM envio
    WHERE activo = 1;
END $$
DELIMITER ;
