package com.hjara.market.web.controller;

import com.hjara.market.domain.Product;
import com.hjara.market.domain.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/all")
    public ResponseEntity<Product> getAll(){
        return new ResponseEntity(productServices.getAll(), HttpStatus.OK);
    }

    /**
     * Nombre:getProduct (Obtener un producto)
     * Descripción: Obtener un producto dado su Id
     *    Parámetros
     *       Entrada: productId - Identificador del producto
     *       Salida:  Información del producto.
     * */
    @GetMapping("/{Id}")
    public ResponseEntity<Product> getProduct(@PathVariable("Id") int productId){
        return productServices.getProduct(productId)
                .map(product -> new ResponseEntity(product, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    /**
     * Nombre:getByCategory (Obtener un producto)
     * Descripción:
     *    Parámetros
     *       Entrada: categoryId - Identificador de la categoria
     *       Salida:  Lista de productos.
     * */
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId){
        return productServices.getByCategory(categoryId)
                .map(products -> new ResponseEntity(products, HttpStatus.OK))
                .orElse(new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    /**
     * Nombre:save (Guarda un producto)
     * Descripción:Servicio que guarda un producto
     *    Parámetros
     *       Entrada: product - Producto
     *       Salida : Información del producto.
     * */
    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody Product product){
        return new ResponseEntity<>(productServices.save(product), HttpStatus.CREATED);
    }

    /**
     * Nombre:delete (Elimina un producto)
     * Descripción: Servicio que elimina un producto
     *    Parámetros
     *       Entrada: productId - Producto
     *       Salida : True  - Producto eliminado
     *                False - Producto no eliminado
     * */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int productId){
        if (productServices.delete(productId)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
