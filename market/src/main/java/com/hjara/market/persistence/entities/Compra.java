package com.hjara.market.persistence.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/*Esta clase mapea la tabla(compras) de la BD*/
@Entity
/*Se hace una referencia de la entidad compras*/
@Table(name="compras")
public class Compra {

    /*Anotación para clave primaria*/
    @Id
    /*Anotación para que spring realice el autoincremento al crear un nuevo registro*/
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    /*Se incluye la anotación debido a que la columna no se llama igual en la entidad*/
    @Column(name = "id_compra")
    private Integer idCompra;

    @Column(name = "id_cliente")
    private Integer idCliente;

    private LocalDateTime fecha;

    @Column(name = "medio_pago")
    private String medioPago;

    private String comentario;

    private Boolean estado;

    /*Esta variable hace referencia al Join entre Cliente y Compras*/
    /*La anotación hace referencia a la relación Un Cliente tiene Muchos Compras*/
    @ManyToOne
    /*Anotación para tener el ID de la relación ClientesCompras*/
    /*el id_cliente es la columna que relaciona las entidades*/
    /*las anotaciones insertable = false, updatable = false se coloca para que no se cree desde esta clase*/
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "producto")
    private List<ComprasProducto> productos;



    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
