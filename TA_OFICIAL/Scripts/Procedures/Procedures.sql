DELIMITER $$
DROP PROCEDURE IF EXISTS insertarRol;
DROP PROCEDURE IF EXISTS listarRoles;
DROP PROCEDURE IF EXISTS modificarRol;
DROP PROCEDURE IF EXISTS obtenerRolPorId;

CREATE PROCEDURE insertarRol (
    IN p_nombre VARCHAR(50),
    OUT p_id INT
)
BEGIN
    INSERT INTO rol(nombre) VALUES (p_nombre);
    SET p_id = LAST_INSERT_ID();
END $$

-- DELIMITER ;

CREATE PROCEDURE listarRoles()
BEGIN
    SELECT * FROM rol;
END $$

DELIMITER $$

CREATE PROCEDURE modificarRol (
    IN p_id INT,
    IN p_nuevo_nombre VARCHAR(50)
)
BEGIN
    UPDATE rol
    SET nombre = p_nuevo_nombre
    WHERE id = p_id;
END $$



CREATE PROCEDURE obtenerRolPorId(
    IN p_id INT
)
BEGIN
    SELECT * FROM rol WHERE id = p_id;
END $$

DELIMITER ;
