package com.hjara.market.persistence.mapper;

import com.hjara.market.domain.Category;
import com.hjara.market.persistence.entities.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * Nombre: CategoryMapper
 * Descripción: Interface encargada de mappear la entidad Categoria
 * */
@Mapper(componentModel = "spring")
public interface CategoryMapper {

    /**
     * Nombre: toCategory
     * Descripción: Servicio encargado de convertir la entidad Categoria a Category
     * */
    /*la anotación Mappings realiza la conversión de datos de categoria a category*/
    @Mappings(
            {
                    /*la anotación Mapping transforma los datos de una categoria a category*/
                    @Mapping(source = "idCategoria", target = "categoryId"),
                    @Mapping(source = "descripcion", target = "category"),
                    @Mapping(source = "estado", target = "active"),
            }
    )
    Category toCategory(Categoria categoria);

    /**
     * Nombre: toCategoria
     * Descripción: Servicio encargado de convertir una Cateogry a una Categoria
     * */
    /*La anotación InheritInverseConfiguration invierte los mappings del servicio toCategory*/
    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);
}
