-- PROCEDIMIENTOS ALMACENADOS PARA LA TABLA DIRECCION

DROP PROCEDURE IF EXISTS insertarDireccion;
DELIMITER $$
CREATE PROCEDURE insertarDireccion(
    OUT p_id INT,
    IN p_persona_id INT,
    IN p_alias VARCHAR(100),
    IN p_direccion VARCHAR(255),
    IN p_ciudad VARCHAR(100),
    IN p_referencia VARCHAR(100),
    IN p_usuario_creacion INT
)
BEGIN
    INSERT INTO direccion(persona_id, alias, direccion, ciudad, referencia, usuario_creacion)
    VALUES (p_persona_id, p_alias, p_direccion, p_ciudad, p_referencia, p_usuario_creacion);
    SET p_id = LAST_INSERT_ID();
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS listarDirecciones;
DELIMITER $$
CREATE PROCEDURE listarDirecciones()
BEGIN
    SELECT id, persona_id, alias, direccion, ciudad, referencia
    FROM direccion
    WHERE activo = 1;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS eliminarDireccion;
DELIMITER $$
CREATE PROCEDURE eliminarDireccion(
    IN p_id INT,
    IN p_usuario_actualizacion INT
)
BEGIN
    UPDATE direccion
    SET activo = 0,
        usuario_actualizacion = p_usuario_actualizacion,
        fecha_actualizacion = CURRENT_TIMESTAMP
    WHERE id = p_id;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS obtenerDireccionPorId;
DELIMITER $$
CREATE PROCEDURE obtenerDireccionPorId(IN p_id INT)
BEGIN
    SELECT id, persona_id, alias, direccion, ciudad, referencia
    FROM direccion
    WHERE id = p_id AND activo = 1;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS modificarDireccion;
DELIMITER $$
CREATE PROCEDURE modificarDireccion(
    IN p_id INT,
    IN p_alias VARCHAR(100),
    IN p_direccion VARCHAR(255),
    IN p_ciudad VARCHAR(100),
    IN p_referencia VARCHAR(100),
    IN p_usuario_actualizacion INT
)
BEGIN
    UPDATE direccion
    SET alias = p_alias,
        direccion = p_direccion,
        ciudad = p_ciudad,
        referencia = p_referencia,
        usuario_actualizacion = p_usuario_actualizacion,
        fecha_actualizacion = CURRENT_TIMESTAMP
    WHERE id = p_id;
END $$
DELIMITER ;
