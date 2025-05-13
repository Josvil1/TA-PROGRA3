DROP PROCEDURE IF EXISTS insertarAdministrador;
DROP PROCEDURE IF EXISTS modificarAdministrador;
DROP PROCEDURE IF EXISTS eliminarAdministrador;
DROP PROCEDURE IF EXISTS listarAdministradores;
DROP PROCEDURE IF EXISTS obtenerAdministradorPorId;
-- PARA ADMINISTRADOR:
DELIMITER $$
CREATE PROCEDURE insertarAdministrador (
    IN p_usuario_id INT,
    IN p_nombre_usuario VARCHAR(50),
    IN p_ultimo_ingreso DATETIME,
    IN p_cargo VARCHAR(100),
    IN p_usuario_creacion INT,
    IN p_activo TINYINT,
    OUT p_id INT
)
BEGIN
    INSERT INTO administrador (
        usuario_id, nombre_usuario, ultimo_ingreso, cargo,
        usuario_creacion, activo
    ) VALUES (
        p_usuario_id, p_nombre_usuario, p_ultimo_ingreso, p_cargo,
        p_usuario_creacion, p_activo
    );
    SET p_id = LAST_INSERT_ID();
END $$

DROP PROCEDURE IF EXISTS modificarAdministrador;
DELIMITER $$

CREATE PROCEDURE modificarAdministrador (
    IN p_id INT,
    IN p_nombre_usuario VARCHAR(50),
    IN p_ultimo_ingreso DATETIME,
    IN p_cargo VARCHAR(100),
    IN p_usuario_actualizacion INT,
    IN p_activo TINYINT
)
BEGIN
    UPDATE administrador
    SET nombre_usuario = p_nombre_usuario,
        ultimo_ingreso = p_ultimo_ingreso,
        cargo = p_cargo,
        usuario_actualizacion = p_usuario_actualizacion,
        fecha_actualizacion = CURRENT_TIMESTAMP,
        activo = p_activo
    WHERE id = p_id;
END $$


CREATE PROCEDURE eliminarAdministrador (
    IN p_id INT,
    IN p_usuario_actualizacion INT
)
BEGIN
    UPDATE administrador
    SET activo = 0,
        usuario_actualizacion = p_usuario_actualizacion,
        fecha_actualizacion = CURRENT_TIMESTAMP
    WHERE id = p_id;
END $$



CREATE PROCEDURE listarAdministradores()
BEGIN
    SELECT id, nombre_usuario, cargo, ultimo_ingreso
    FROM administrador
    WHERE activo = 1;
END $$

CREATE PROCEDURE obtenerAdministradorPorId (
    IN p_id INT
)
BEGIN
    SELECT id, nombre_usuario, cargo, ultimo_ingreso
    FROM administrador
    WHERE id = p_id AND activo = 1;
END $$

DELIMITER ;