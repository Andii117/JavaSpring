package com.hjara.market.domain.repository;

import com.hjara.market.domain.Product;

import java.util.List;
import java.util.Optional;

/**
 * Nombre: ProductRepository
 * Descripción: Interface encargada de los servicios que se deben implementar al instaciar
 * productos
 *
 * */
public interface ProductRepository {

    /**
     * Nombre: getAll
     * Descripción: Servicio que retorna una lista de productos
     * Parámetros
     *      Entrada:
     *      Salida:  Lista de todos los productos.
     * */
    List<Product> getAll();

    /**
     * Nombre:getByCategory
     * Descripción: Servicio que obtiene una lista de productos dado su categoria.
     * Parámetros
     *       Entrada: categoryId - Identificador de la categoria
     *       Salida:  Lista de prodcutos dado una categoria
     * */
    Optional<List<Product>> getByCategory(int categoryId);
    /**
     * Nombre:getScarseProdcuts
     * Descripción: Servicio que obtiene una lista de productos escasos dado una cantidad ingresada.
     * Parámetros
     *       Entrada: quantity - Cantidad miníma de productos
     *       Salida:  Lista de prodcutos escasos
     * */
    Optional<List<Product>> getScarseProdcuts(int quantity);
    /**
     * Nombre:getProduct
     * Descripción: Servicio que obtiene un producto dado su identificador
     * Parámetros
     *       Entrada: productId - Identificador del producto
     *       Salida:  Información del producto.
     * */
    Optional<Product> getProduct(int productId);
    /**
     * Nombre:save
     * Descripción: Servicio que almacena un producto
     * Parámetros
     *       Entrada: product - producto
     *       Salida:  Información del producto.
     * */
    Product save(Product product);
    /**
     * Nombre:delete
     * Descripción: Servicio que elimina un producto
     * Parámetros
     *       Entrada: productId - identificaro del producto
     *       Salida:
     * */
    void delete(int productId);

    /**
     * Nombre:exist
     * Descripción: Servicio que valida la existencia de un producto
     * Parámetros
     *       Entrada: productId - identificaro del producto
     *       Salida:  True  - Existe el producto
     *                False - No existe el producto
     * */
    Boolean exist(int productId);
}
