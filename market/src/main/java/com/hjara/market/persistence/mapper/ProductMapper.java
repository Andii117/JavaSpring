package com.hjara.market.persistence.mapper;

import com.hjara.market.domain.Product;
import com.hjara.market.persistence.entities.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/*La anotación Mapper indica a mapstruct que es un componente de spring*/
/*el parámetro uses le indica a Mapper que cuando vaya a convertir categoria a category utilice la clase CategoryMapper*/
@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    /**
     * Nombre: toProduct
     * Descripción:  Servicio encargado de convertir el Producto en terminos de Product
     * */
    @Mappings({
            @Mapping(source = "idProducto",     target = "productId"),
            @Mapping(source = "nombre",         target = "name"),
            @Mapping(source = "idCategoria",    target = "categoryId"),
            @Mapping(source = "precioVenta",    target = "price"),
            @Mapping(source = "cantidadStock",  target = "stock"),
            @Mapping(source = "estado",         target = "active"),
            @Mapping(source = "categoria",      target = "category"),
    })
    Product toProduct(Producto producto);
    /**
     * Nombre: toProdcuts
     * Descripción:Servicio que se encarga de convertir una lista de productos en Product
     * */
    List<Product> toProducts(List<Producto> producto);

    @InheritInverseConfiguration
    /*Como no se esta mapeando el codigoBarras se le indica a spring que lo ignore*/
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(Product product);
}
