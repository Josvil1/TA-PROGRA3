-- PARA ITEM_CARRITO:
DROP PROCEDURE IF EXISTS insertarItemCarrito;
DELIMITER $$
CREATE PROCEDURE insertarItemCarrito(
    IN p_carrito_id INT,
    IN p_producto_id INT,
    IN p_cantidad INT,
    IN p_subtotal DECIMAL(10,2),
    IN p_usuario_creacion INT,
    OUT p_id_item INT
)
BEGIN
    INSERT INTO item_carrito(carrito_id, producto_id, cantidad, subtotal, usuario_creacion)
    VALUES (p_carrito_id, p_producto_id, p_cantidad, p_subtotal, p_usuario_creacion);
    
    SET p_id_item = LAST_INSERT_ID();
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS modificarItemCarrito;
DELIMITER $$
CREATE PROCEDURE modificarItemCarrito(
    IN p_id INT,
    IN p_cantidad INT,
    IN p_subtotal DECIMAL(10,2),
    IN p_usuario_actualizacion INT
)
BEGIN
    UPDATE item_carrito
    SET cantidad = p_cantidad,
        subtotal = p_subtotal,
        usuario_actualizacion = p_usuario_actualizacion,
        fecha_actualizacion = CURRENT_TIMESTAMP
    WHERE id = p_id;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS eliminarItemCarrito;
DELIMITER $$
CREATE PROCEDURE eliminarItemCarrito(
    IN p_id_item INT,
    IN p_usuario_actualizacion INT
)
BEGIN
    UPDATE item_carrito
    SET activo = 0,
        usuario_actualizacion = p_usuario_actualizacion,
        fecha_actualizacion = CURRENT_TIMESTAMP
    WHERE id = p_id_item;
END $$
DELIMITER ;



DROP PROCEDURE IF EXISTS obtenerItemCarritoPorId;
DELIMITER $$
CREATE PROCEDURE obtenerItemCarritoPorId(
    IN p_id INT
)
BEGIN
    SELECT * FROM item_carrito WHERE id = p_id AND activo = 1;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS listarItemCarrito;
DELIMITER $$
CREATE PROCEDURE listarItemCarrito()
BEGIN
    SELECT id, carrito_id, producto_id, cantidad, subtotal
    FROM item_carrito
    WHERE activo = 1;
END $$
DELIMITER ;


