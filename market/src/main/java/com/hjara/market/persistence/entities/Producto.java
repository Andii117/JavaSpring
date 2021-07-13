package com.hjara.market.persistence.entities;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

/*Esta clase mapea la tabla(productos) de la BD*/
@Entity
/*Se hace una referencia de la entidad productos*/
@Table(name="productos")
public class Producto {

    /*Anotación para clave primaria*/
    @Id
    /*Anotación para que spring realice el autoincremento al crear un nuevo registro*/
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    /*Se incluye la anotación debido a que la columna no se llama igual en la entidad*/
    @Column(name = "id_producto")
    private Integer idProducto;

    private String nombre;

    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "codigo_barras")
    private String codigoBarras;

    @Column(name = "precio_venta")
    private Double precioVenta;

    @Column(name = "cantidad_stock")
    private Integer cantidadStock;

    private Boolean estado;

    /*Atributo para obtener la relación entre categoria y productos*/
    /*La anotación hace referencia a la relación Una Categoria tiene Muchos Productos*/
    @ManyToOne
    /*Anotación para tener el ID de la relación CategoriaProducto*/
    /*el id_categoria es la columna que relaciona las entidades*/
    /*las anotaciones insertable = false, updatable = false se coloca para que no se cree desde esta clase*/
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    private Categoria categoria;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
