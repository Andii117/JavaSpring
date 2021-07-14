package com.hjara.market.domain.repository;


import com.hjara.market.domain.Purchase;

import java.util.List;
import java.util.Optional;

/**
 * Nombre: PurchaseRepository (Repositorio de compras)
 * Descripción: Clase encarga de definir los servicios de las compras a implementar
 * */
public interface PurchaseRepository {

    /**
     * Nombre: getAll
     * Descripción: Lista de compras
     * Parámetros
     *      Entrada:
     *      Salida:  Lista de todos las compras de la tienda.
     * */
    List<Purchase> getAll();
    /**
     * Nombre: getByClient
     * Descripción: Lista de compras realizadas por un cliente en particular
     * Parámetros
     *      Entrada: clientId - Identificador del cliente
     *      Salida:  Lista de todos las compras de la tienda hechas por un cliente
     * */
    Optional<List<Purchase>> getByClient(String clientId);

    /**
     * Nombre: save
     * Descripción: Guardar la compra realizada
     * Parámetros
     *      Entrada: purchase - Compra
     *      Salida:  Purchase - Objeto compra
     * */
    Purchase save(Purchase purchase);

    
}
