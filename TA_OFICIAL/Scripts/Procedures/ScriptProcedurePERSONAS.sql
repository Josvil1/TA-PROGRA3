-- inserat persona natural y juridica

-- =====================================
-- 1. PERSONA NATURAL
-- =====================================

-- Insertar Persona Natural
DROP PROCEDURE IF EXISTS insertarPersonaNatural;
DELIMITER $$
CREATE PROCEDURE insertarPersonaNatural(
    IN p_email VARCHAR(100),
    IN p_contrasena VARCHAR(100),
    IN p_nombres VARCHAR(100),
    IN p_apellidos VARCHAR(100),
    IN p_telefono VARCHAR(20),
    IN p_dni INT,
    IN p_fecha_nacimiento DATE,
    IN p_genero VARCHAR(10),
    IN p_usuario_creacion INT,
    OUT p_id_persona INT
)
BEGIN
    INSERT INTO usuario(email, contrasena, rol_id)
    VALUES (p_email, p_contrasena, 3); -- 3 = CLIENTE_NATURAL
    SET @id_usuario = LAST_INSERT_ID();

    INSERT INTO persona(usuario_id, nombres, apellidos, telefono, activo, usuario_creacion, fecha_creacion)
    VALUES (@id_usuario, p_nombres, p_apellidos, p_telefono, 1, p_usuario_creacion, NOW());
    SET p_id_persona = LAST_INSERT_ID();

    INSERT INTO p_natural(id, dni, fecha_nacimiento, genero)
    VALUES (p_id_persona, p_dni, p_fecha_nacimiento, p_genero);
END $$
DELIMITER ;

-- Modificar Persona Natural
DROP PROCEDURE IF EXISTS modificarPersonaNatural;
DELIMITER $$
CREATE PROCEDURE modificarPersonaNatural(
    IN p_id_persona INT,
    IN p_nombres VARCHAR(100),
    IN p_apellidos VARCHAR(100),
    IN p_telefono VARCHAR(20),
    IN p_dni INT,
    IN p_fecha_nacimiento DATE,
    IN p_genero VARCHAR(10),
    IN p_usuario_actualizacion INT
)
BEGIN
    UPDATE persona
    SET nombres = p_nombres,
        apellidos = p_apellidos,
        telefono = p_telefono,
        usuario_actualizacion = p_usuario_actualizacion,
        fecha_actualizacion = NOW()
    WHERE id = p_id_persona;

    UPDATE p_natural
    SET dni = p_dni, fecha_nacimiento = p_fecha_nacimiento, genero = p_genero
    WHERE id = p_id_persona;
END $$
DELIMITER ;

-- Eliminar Persona Natural (lógico)
DROP PROCEDURE IF EXISTS eliminarPersonaNatural;
DELIMITER $$
CREATE PROCEDURE eliminarPersonaNatural(
    IN p_id_persona INT,
    IN p_usuario_actualizacion INT
)
BEGIN
    UPDATE persona
    SET activo = 0,
        usuario_actualizacion = p_usuario_actualizacion,
        fecha_actualizacion = CURRENT_TIMESTAMP
    WHERE id = p_id_persona;

    UPDATE usuario
    SET activo = 0
    WHERE id = (
        SELECT usuario_id FROM persona WHERE id = p_id_persona
    );
END $$
DELIMITER ;

-- Listar Personas Naturales
DROP PROCEDURE IF EXISTS listarPersonasNaturales;
DELIMITER $$
CREATE PROCEDURE listarPersonasNaturales()
BEGIN
    SELECT p.id, p.nombres, p.apellidos, p.telefono,
           pn.dni, pn.fecha_nacimiento, pn.genero
    FROM persona p
    INNER JOIN p_natural pn ON p.id = pn.id
    WHERE p.activo = 1;
END $$
DELIMITER ;

-- Obtener Persona Natural por ID
DROP PROCEDURE IF EXISTS obtenerPersonaNaturalPorId;
DELIMITER $$
CREATE PROCEDURE obtenerPersonaNaturalPorId(
    IN p_id_persona INT
)
BEGIN
    SELECT p.id, p.nombres, p.apellidos, p.telefono,
           pn.dni, pn.fecha_nacimiento, pn.genero
    FROM persona p
    INNER JOIN p_natural pn ON p.id = pn.id
    WHERE p.id = p_id_persona;
END $$
DELIMITER ;


-- =====================================
-- 2. PERSONA JURÍDICA
-- =====================================

-- Insertar Persona Juridica
DROP PROCEDURE IF EXISTS insertarPersonaJuridica;
DELIMITER $$
CREATE PROCEDURE insertarPersonaJuridica(
    IN p_email VARCHAR(100),
    IN p_contrasena VARCHAR(100),
    IN p_nombres VARCHAR(100),
    IN p_apellidos VARCHAR(100),
    IN p_telefono VARCHAR(20),
    IN p_ruc VARCHAR(20),
    IN p_razon_social VARCHAR(100),
    IN p_representante_legal VARCHAR(100),
    IN p_usuario_creacion INT,
    OUT p_id_persona INT
)
BEGIN
    INSERT INTO usuario(email, contrasena, rol_id)
    VALUES (p_email, p_contrasena, 2); -- 2 = CLIENTE_JURIDICO
    SET @id_usuario = LAST_INSERT_ID();

    INSERT INTO persona(usuario_id, nombres, apellidos, telefono, activo, usuario_creacion, fecha_creacion)
    VALUES (@id_usuario, p_nombres, p_apellidos, p_telefono, 1, p_usuario_creacion, NOW());
    SET p_id_persona = LAST_INSERT_ID();

    INSERT INTO p_juridica(id, ruc, razon_social, representante_legal)
    VALUES (p_id_persona, p_ruc, p_razon_social, p_representante_legal);
END $$
DELIMITER ;

-- Modificar Persona Juridica
DROP PROCEDURE IF EXISTS modificarPersonaJuridica;
DELIMITER $$
CREATE PROCEDURE modificarPersonaJuridica(
    IN p_id_persona INT,
    IN p_nombres VARCHAR(100),
    IN p_apellidos VARCHAR(100),
    IN p_telefono VARCHAR(20),
    IN p_ruc VARCHAR(20),
    IN p_razon_social VARCHAR(100),
    IN p_representante_legal VARCHAR(100),
    IN p_usuario_actualizacion INT
)
BEGIN
    UPDATE persona
    SET nombres = p_nombres,
        apellidos = p_apellidos,
        telefono = p_telefono,
        usuario_actualizacion = p_usuario_actualizacion,
        fecha_actualizacion = NOW()
    WHERE id = p_id_persona;

    UPDATE p_juridica
    SET ruc = p_ruc, razon_social = p_razon_social, representante_legal = p_representante_legal
    WHERE id = p_id_persona;
END $$
DELIMITER ;

-- Eliminar Persona Juridica (lógico)
DROP PROCEDURE IF EXISTS eliminarPersonaJuridica;
DELIMITER $$
CREATE PROCEDURE eliminarPersonaJuridica(
    IN p_id_persona INT,
    IN p_usuario_actualizacion INT
)
BEGIN
    UPDATE persona
    SET activo = 0,
        usuario_actualizacion = p_usuario_actualizacion,
        fecha_actualizacion = CURRENT_TIMESTAMP
    WHERE id = p_id_persona;

    UPDATE usuario
    SET activo = 0
    WHERE id = (
        SELECT usuario_id FROM persona WHERE id = p_id_persona
    );
END $$
DELIMITER ;

-- Listar Personas Juridicas
DROP PROCEDURE IF EXISTS listarPersonasJuridicas;
DELIMITER $$
CREATE PROCEDURE listarPersonasJuridicas()
BEGIN
    SELECT p.id, p.nombres, p.apellidos, p.telefono,
           pj.ruc, pj.razon_social, pj.representante_legal
    FROM persona p
    INNER JOIN p_juridica pj ON p.id = pj.id
    WHERE p.activo = 1;
END $$
DELIMITER ;

-- Obtener Persona Juridica por ID
DROP PROCEDURE IF EXISTS obtenerPersonaJuridicaPorId;
DELIMITER $$
CREATE PROCEDURE obtenerPersonaJuridicaPorId(
    IN p_id_persona INT
)
BEGIN
    SELECT p.id, p.nombres, p.apellidos, p.telefono,
           pj.ruc, pj.razon_social, pj.representante_legal
    FROM persona p
    INNER JOIN p_juridica pj ON p.id = pj.id
    WHERE p.id = p_id_persona;
END $$
DELIMITER ;





