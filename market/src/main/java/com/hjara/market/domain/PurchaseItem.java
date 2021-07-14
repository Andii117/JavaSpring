package com.hjara.market.domain;

/**
 * Nombre: PurchaseItem (Compras por item)
 * Descripción: Clase encargada de orientar al objetos de dominio de la entida compras_producto
 *
 * */
public class PurchaseItem {

    /*Variables*/
    private int productId;
    private int quantity;
    private double total;
    private boolean active;

    /*Getters and Setters*/

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
