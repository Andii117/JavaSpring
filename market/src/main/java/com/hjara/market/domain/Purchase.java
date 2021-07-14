package com.hjara.market.domain;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Nombre: Purchase (Compras)
 * Descripción: Clase encargada de orientar al objetos de dominio de la entida compras
 *
 * */
public class Purchase {

    /*Variables*/
    private int purchaseId;
    private String clienteId;
    private LocalDateTime date;
    private String paymentMethod;
    private String comment;
    /*Orden paga o no paga*/
    private String state;
    /*Lista de productos comprados*/
    private List<PurchaseItem> items;

    /*Getters and Setters*/

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<PurchaseItem> getItem() {
        return items;
    }

    public void setItem(List<PurchaseItem> item) {
        this.items = item;
    }
}
