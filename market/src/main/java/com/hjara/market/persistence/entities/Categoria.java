package com.hjara.market.persistence.entities;

import javax.persistence.*;
import java.util.List;

/*Esta clase mapea la tabla(categorias) de la BD*/
@Entity
/*Se hace una referencia de la entidad categorias*/
@Table(name = "categorias")
public class Categoria {

    /*Anotación para clave primaria*/
    @Id
    /*Anotación para que spring realice el autoincremento al crear un nuevo registro*/
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    /*Se incluye la anotación debido a que la columna no se llama igual en la entidad*/
    @Column(name = "id_categoria")
    private Integer idCategoria;

    private String descripcion;

    private Boolean estado;

    /*Esta variable hace referencia a la relación entre Productos con Categorias*/
    /*La anotación OneToMany hace referencia a que muchos productos estan en una Categoria*/
    /*En atributo mappedBy es la variable creada en Categoria que hace referencia
     *al Join de las entidades*/
    @OneToMany(mappedBy = "categoria")
    /*Se pone en Lista*/
    private List<Producto> productos;

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
