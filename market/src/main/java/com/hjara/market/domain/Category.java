package com.hjara.market.domain;

/**
*  Nombre: Category (Categoria)
*  Descripción: Clase encargada de comunicarse con la BD unicamente con las variables
*               que se soliciten, protegiendo la BD de la API.
* */

public class Category {

    /*Variables*/
    private int categoryId;

    private String category;

    private Boolean active;

    /*Getters and Setters*/

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
