package com.hjara.market.persistence.crud;


import com.hjara.market.persistence.entities.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/*CrudRepository de la entidad Prodcuto*/
/*Extiende de CrudRepostory de Spring que permite hacer consultas a la BD dado los servicios que ya provee*/
public interface ProductoCrudRepository extends CrudRepository<Producto,Integer> {

    /*
        Descripción: QueryMethod encargado de buscar todos los productos que pertenecen
                     a una categoria ordenado por nombre ascendetemente
    *   Parámetros
    *       Entrada: cantidadStock - Cantidad miníma de stock
    *                estado        - Estado del producto(true activo, false inactivo)
    *       Salida:  Lista de productos en stoeck con cantidades minímas a las ingresadas.
    */
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    /*
        Descripción: QueryMethod que se encarga de encontrar una Cantidad de producto menor que la variable cantidadStock
                     y en estado activo.
    *   Parámetros
    *       Entrada: cantidadStock - Cantidad miníma de stock
                     estado        - Estado del producto(true activo, false inactivo)
    *       Salida:  Lista de productos en stoeck con cantidades minímas a las ingresadas.
    */
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);

}
