package com.hjara.market.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/*
* Esta clase se crea debido a la interrelación que existe entre compras y productos
* la cual tiene el ID de compras y el ID de productos el cual no se debe incluir por
* separado en la entidad ComprasProducto
* */

/*Esta clasa se va a embeber*/
@Embeddable
public class ComprasProductoPK implements Serializable {

    @Column(name = "id_compra")
    private Integer idCompra;

    @Column(name = "id_producto")
    private Integer idProducto;

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
}
