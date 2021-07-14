package com.hjara.market.persistence.mapper;


import com.hjara.market.domain.Purchase;
import com.hjara.market.persistence.entities.Compra;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * Nombre: PurchaseMapper
 * Descripción: Interface Mapper de la clase PurchaseMapper (Compras)
 *
 * */
@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

    /**
     * Nombre: toPurchase
     * Descripción: Servicio que convierte una compra en Purchase
     * */
    @Mappings({
            @Mapping(source = "idCompra", target = "purchaseId"),
            @Mapping(source = "idCliente", target = "clienteId"),
            @Mapping(source = "fecha", target = "date"),
            @Mapping(source = "medioPago", target = "paymentMethod"),
            @Mapping(source = "comentario", target = "comment"),
            @Mapping(source = "estado", target = "state"),
            @Mapping(source = "productos", target = "items")
    })
    Purchase toPurchase(Compra compra);
    /**
     * Nombre: toPurchase
     * Descripción: Servicio que convierte una lista de compras en Purchase
     * */
    List<Purchase> toPurchases(List<Compra> compras);

    /**
     * Nombre: toPurchase
     * Descripción: Servicio que convierte una un Purchase en compras
     * */
    @InheritInverseConfiguration
    @Mappings({
        @Mapping(target = "cliente", ignore = true)
    })
    Compra toCompra(Purchase purchase);
}
