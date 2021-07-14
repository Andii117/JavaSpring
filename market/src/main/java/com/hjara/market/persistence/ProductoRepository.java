package com.hjara.market.persistence;

import com.hjara.market.domain.Product;
import com.hjara.market.domain.repository.ProductRepository;
import com.hjara.market.persistence.crud.ProductoCrudRepository;
import com.hjara.market.persistence.entities.Producto;
import com.hjara.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*Esta clase se encarga de los servicios para hacer operaciones en la base de datos*/
@Repository
public class ProductoRepository implements ProductRepository {

    /*Inyección de dependencia:Notación para que spring cree las instancias*/
    @Autowired
    /*Variable utilizada para instanciar la clase ProductoCrudRepository*/
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    /*Variable utilizada para instanciar la clase ProductMapper*/
    private ProductMapper mapper;

    /**  Nombre:      getAll (Obtener todos los productos)
    *    Descripción: Servicio encargado de obtener todos los productos.
    *    Parámetros
    *       Entrada:
    *       Salida:  Lista de todos los productos regitrados
     */
    @Override
    public List<Product> getAll()
    {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    /**
        Nombre:      getByCategory(Obtiene productos por categoria)
        Descripción: Servicio getByCategoria obtiene los productos dado una categoria
                     ordenado por el nombre en ascendete.
    *   Parámetros
    *       Entrada: categoryId - Llave primaria de la categoria
    *       Salida:  Lista de productos dado la categoria ordenada por Nombre ascendete.
    */
    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos=productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    /**
        Nombre:      getEscasos (Obtener los productos escasos)
        Descripción: Servicio encargado de obtener la cantidad de stock de un producto
                     que este en estado activo.
    *   Parámetros
    *       Entrada: cantidadStock - Cantidad miníma del prodcuto en stock
    *       Salida:  Lista de productos escasos
    */
    @Override
    public Optional<List<Product>> getScarseProdcuts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity,true);
        /*la función map retorna un objeto de tipo Optional dentro de la conversión de produtso a product*/
        return productos.map(prods -> mapper.toProducts(prods));
    }

    /**
     *   Nombre:      getProduct (Obtener producto)
     *   Descripción: Servicio que obtiene un producto dado su Id.
     *   Parámetros
     *       Entrada: productId - identificador del producto
     *       Salida:  Producto - Información del producto
     * */
    @Override
    public Optional<Product> getProduct(int productId) {
        /*el servicio findById devuelve un Optional y se mapea para convertir el producto en product*/
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    /**
     *   Nombre:      save (Guardar un producto)
     *   Descripción: Servicio que guarda un producto en la base de datos
     *   Parámetros
     *       Entrada: product - identifición del producto.
     *       Salida:  Información del producto
     * */
    @Override
    public Product save(Product product) {
        /*Se transforma el Product a producto*/
        Producto producto = mapper.toProducto(product);
        /*Se utiliza la función del productoCrudRepository y cambiarlo a terminos del product*/
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    /**
     *   Nombre:      delete (Eliminar un producto)
     *   Descripción: Servicio que elimina un producto en la base de datos
     *   Parámetros
     *       Entrada: producto - identifición del producto.
     *       Salida:
     * */
    @Override
    public void delete(int productId){
        productoCrudRepository.deleteById(productId);
    }

    /**
     *   Nombre:      exist (Valida la existencia un producto)
     *   Descripción: Servicio que valida la existencia un producto en la base de datos
     *   Parámetros
     *       Entrada: productId - identifición del producto.
     *       Salida:  True  - Existe el producto en BD
     *                False - No existe el producto en BD
     * */
    @Override
    public Boolean exist(int productId) {
        return productoCrudRepository.existsById(productId);
    }

}
