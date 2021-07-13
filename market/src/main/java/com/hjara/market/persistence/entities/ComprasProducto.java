package com.hjara.market.persistence.entities;

import javax.persistence.*;
import java.util.List;

/*Esta clase mapea la tabla(compras_productos) de la BD*/
@Entity
/*Se hace una referencia de la entidad compras_productos*/
@Table(name = "compras_productos")
public class ComprasProducto {

    /*La anotación EmbeddedId es usada para identificar la llave el proyecto*/
    @EmbeddedId
    /*Obtiene el id primario de la clase ComprasProductoPK*/
    private ComprasProductoPK id;

    private Integer cantidad;

    private Double total;

    private Boolean estado;

    /*Esta relación se hace por que una compra tiene muchas comrpasproductos*/
    @ManyToOne
    /*El name de la columna id_compra es la relación que existe entre compras con compras_productos*/
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Compra compra;

    /*Esta relación se hace por que un producto tiene muchos comprasproductos*/
    /*con la variable producto en la clase compra*/
    @OneToMany(mappedBy = "productos")
    private List<ComprasProducto> producto;


    public ComprasProductoPK getId() {
        return id;
    }

    public void setId(ComprasProductoPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
