package com.hjara.market.domain.services;

import com.hjara.market.domain.Product;
import com.hjara.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Nombre: ProductServices
 * Descripción: Clase de tipo servicio en Spring, contiene los servicios del modelo
 *              o logíca de negocio para la entidad producto.
 * */
@Service
public class ProductServices {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Nombre: getAll(Obtener todos los productos)
     * Descripción: Servicio para obtener todos los productos
     *    Parámetros
     *       Entrada:
     *       Salida:  Lista de todos los productos regitrados
     * */
    public List<Product> getAll(){
        return productRepository.getAll();
    }

    /**
     * Nombre: getProduct(Obtener el producto dado un Id de producto)
     * Descripción: Servicio para obtener un producto
     *   Parámetros
     *       Entrada: productId - Llave primaria del producto
     *       Salida:  Información del producto
     * */
    public Optional<Product> getProduct(int productId){
        return productRepository.getProduct(productId);
    }

    /**
     * Nombre: getByCategory(Obtener todos los productos de una categoria)
     * Descripción: Servicio para obtener todos los productos de una categoria
     *   Parámetros
     *       Entrada: categoryId - Llave primaria de la categoria
     *       Salida:  Lista opciónal de todos los productos de una categoria
     * */
    public Optional<List<Product>> getByCategory(int categoryId){
        return  productRepository.getByCategory(categoryId);
    }

    /**
     * Nombre: save(Guarda un producto en Base de datos)
     * Descripción: Servicio que guarda un producto en Base de datos
     *   Parámetros
     *       Entrada: product - Información del producto
     *       Salida:  product Producto guardado
     * */
    public Product save(Product product){
        return productRepository.save(product);
    }

    /**
     * Nombre: delete(Elimina un producto en Base de datos)
     * Descripción: Servicio que elimina un producto en Base de datos
     *   Parámetros
     *       Entrada: productId - Identificador del producto
     *       Salida:  True  - Producto eliminado
     *                False - Producto No eliminado
     * */
    public boolean delete(int productId){
        /*Se utiliza la funci[on getProduct para obtener le producto
        * posteriormente se utiliza la funci[on map para devolver el tipo optional
        * y por ultimo se le pasa el producto a elminar retornando true si fue elimiando
        * */
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
            /*En caso contrario se retorna un false*/
        }).orElse(false);
    }

    /**
     * Nombre: exist(Valida la existencia de un producto en Base de datos)
     * Descripción: Servicio que valida la existencia de un producto en Base de datos
     *   Parámetros
     *       Entrada: productId - Identificador del producto
     *       Salida:  True  - Producto existe
     *                False - Producto No existe
     * */
    public Boolean exist(int productId){
        return productRepository.exist(productId);
    }
}
