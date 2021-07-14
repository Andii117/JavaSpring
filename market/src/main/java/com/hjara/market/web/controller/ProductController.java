package com.hjara.market.web.controller;

import com.hjara.market.domain.Product;
import com.hjara.market.domain.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Nombre: ProductController
 * Descripción: Clase encargada de controlar las peticiones a la APIRest
 *
 * */

/*Anotación que le indica a Spring que es una clase controller*/
@RestController
/*Anotación para obtener el Path inicial de las peticiones*/
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServices productServices;

    /**
     * Nombre:getAll (Obtener todos los productos)
     * Descripción: Obtiene todos los productos
     *    Parámetros
     *       Entrada:
     *       Salida: Lista de todos los productos
     * */
    public List<Product> getAll(){
        return productServices.getAll();
    }

    /**
     * Nombre:getProduct (Obtener un producto)
     * Descripción: Obtener un producto dado su Id
     *    Parámetros
     *       Entrada: productId - Identificador del producto
     *       Salida:  Información del producto.
     * */
    public Optional<Product> getProduct(int productId){
        return productServices.getProduct(productId);
    }

    /**
     * Nombre:getByCategory (Obtener un producto)
     * Descripción:
     *    Parámetros
     *       Entrada: categoryId - Identificador de la categoria
     *       Salida:  Lista de productos.
     * */
    public Optional<List<Product>> getByCategory(int categoryId){
        return productServices.getByCategory(categoryId);
    }

    /**
     * Nombre:save (Guarda un producto)
     * Descripción:Servicio que guarda un producto
     *    Parámetros
     *       Entrada: product - Producto
     *       Salida : Información del producto.
     * */
    public Product save(Product product){
        return productServices.save(product);
    }

    /**
     * Nombre:delete (Elimina un producto)
     * Descripción: Servicio que elimina un producto
     *    Parámetros
     *       Entrada: productId - Producto
     *       Salida : True  - Producto eliminado
     *                False - Producto no eliminado
     * */
    public boolean delete(int productId){
        return productServices.delete(productId);
    }

}
