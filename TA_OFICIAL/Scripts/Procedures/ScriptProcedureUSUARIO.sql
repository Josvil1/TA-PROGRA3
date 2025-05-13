DROP PROCEDURE IF EXISTS insertarUsuario;
DROP PROCEDURE IF EXISTS modificarUsuario;
DROP PROCEDURE IF EXISTS eliminarUsuario;
DROP PROCEDURE IF EXISTS listarUsuarios;
DROP PROCEDURE IF EXISTS obtenerUsuarioPorId;

DELIMITER $$

CREATE PROCEDURE insertarUsuario (
    IN p_email VARCHAR(100),
    IN p_contrasena VARCHAR(100),
    IN p_rol_id INT,
    IN p_activo TINYINT,
    OUT p_id INT
)
BEGIN
    INSERT INTO usuario(email, contrasena, rol_id, activo)
    VALUES (p_email, p_contrasena, p_rol_id, p_activo);
    SET p_id = LAST_INSERT_ID();
END $$

CREATE PROCEDURE modificarUsuario (
    IN p_id INT,
    IN p_email VARCHAR(100),
    IN p_contrasena VARCHAR(100),
    IN p_rol_id INT,
    IN p_activo TINYINT
)
BEGIN
    UPDATE usuario
    SET email = p_email, contrasena = p_contrasena, rol_id = p_rol_id, activo = p_activo
    WHERE id = p_id;
END $$

CREATE PROCEDURE eliminarUsuario (
    IN p_id INT
)
BEGIN
    UPDATE usuario SET activo = 0 WHERE id = p_id;
END $$

CREATE PROCEDURE listarUsuarios()
BEGIN
    SELECT id, email, rol_id, activo FROM usuario WHERE activo = 1;
END $$

CREATE PROCEDURE obtenerUsuarioPorId (
    IN p_id INT
)
BEGIN
    SELECT id, email, rol_id, activo
    FROM usuario
    WHERE id = p_id AND activo = 1;
END $$