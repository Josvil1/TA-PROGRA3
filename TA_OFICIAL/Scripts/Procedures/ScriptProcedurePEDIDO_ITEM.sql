-- PARA PEDIDO_ITEM

DROP PROCEDURE IF EXISTS insertarPedidoItem;
DELIMITER $$
CREATE PROCEDURE insertarPedidoItem(
    IN p_pedido_id INT,
    IN p_producto_id INT,
    IN p_cantidad INT,
    IN p_precio DECIMAL(10,2),
    IN p_usuario_creacion INT,
    OUT p_id_item INT
)
BEGIN
    INSERT INTO pedido_item(pedido_id, producto_id, cantidad, precio, usuario_creacion)
    VALUES (p_pedido_id, p_producto_id, p_cantidad, p_precio, p_usuario_creacion);
    
    SET p_id_item = LAST_INSERT_ID();
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS modificarPedidoItem;
DELIMITER $$
CREATE PROCEDURE modificarPedidoItem(
    IN p_id INT,
    IN p_cantidad INT,
    IN p_precio DECIMAL(10,2),
    IN p_usuario_actualizacion INT
)
BEGIN
    UPDATE pedido_item
    SET cantidad = p_cantidad,
        precio = p_precio,
        usuario_actualizacion = p_usuario_actualizacion,
        fecha_actualizacion = CURRENT_TIMESTAMP
    WHERE id = p_id;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS eliminarPedidoItem;
DELIMITER $$
CREATE PROCEDURE eliminarPedidoItem(
    IN p_id_item INT,
    IN p_usuario_actualizacion INT
)
BEGIN
    UPDATE pedido_item
    SET activo = 0,
        usuario_actualizacion = p_usuario_actualizacion,
        fecha_actualizacion = CURRENT_TIMESTAMP
    WHERE id = p_id_item;
END $$
DELIMITER ;


DROP PROCEDURE IF EXISTS obtenerPedidoItemPorId;
DELIMITER $$
CREATE PROCEDURE obtenerPedidoItemPorId(
    IN p_id INT
)
BEGIN
    SELECT * FROM pedido_item WHERE id = p_id AND activo = 1;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS listarPedidoItem;
DELIMITER $$
CREATE PROCEDURE listarPedidoItem()
BEGIN
    SELECT id, pedido_id, producto_id, cantidad, precio
    FROM pedido_item
    WHERE activo = 1;
END $$
DELIMITER ;

