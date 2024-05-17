package org.example.entity;

import jakarta.persistence.*;
import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cleintes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    @Column(name = "forma_pago")
    private String formaPago;

    //un cliente puede tener varias direcciones
    @OneToMany(
            cascade = CascadeType.ALL, //si se elimina el cliente se eliminan las direcciones
            orphanRemoval = true //si se elimina una direccion se elimina el cliente
    )
    //@JoinColumn(name = "id_cliente") //columna que hace referencia a la tabla cliente
    @JoinTable(
            name = "cliente_direccion", //nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "id_cliente"), //columna que hace referencia a la tabla cliente
            inverseJoinColumns = @JoinColumn(name = "id_direccion"), //columna que hace referencia a la tabla direccion
            uniqueConstraints = @UniqueConstraint(name = "UK_direccion",  //nombre de la constraint
                    columnNames = {"id_cliente", "id_direccion"}) //columnas que deben ser unicas
    )
    private List<Direcciones> direcciones = new ArrayList<>();

    //bidiereccional
    @OneToMany(
            cascade = CascadeType.ALL, //si se elimina el cliente se eliminan las facturas
            orphanRemoval = true, //si se elimina una factura se elimina el cliente
            mappedBy = "cliente" //nombre del atributo en la clase Factura
    )
    private List<Factura> facturas = new ArrayList<>();


    public Cliente() {
        //iniaializar la lista de direcciones
        this.direcciones = new ArrayList<>();
        this.facturas = new ArrayList<>();
    }

    public Cliente(String nombre, String apellido) {
        this();
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Cliente(String nombre, String apellido, String formaPago) {
        this();
        this.nombre = nombre;
        this.apellido = apellido;
        this.formaPago = formaPago;
    }


    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public List<Direcciones> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direcciones> direcciones) {
        this.direcciones = direcciones;
    }

    public Long getId() {        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public void setFactura(Factura factura) {
        this.facturas = facturas;
    }

    public void addFactura(Factura factura) {
        this.facturas.add(factura);
        factura.setCliente(this);
    }



    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cliente{id=").append(id)
                .append(", nombre='").append(nombre).append('\'')
                .append(", apellido='").append(apellido).append('\'')
                .append(", formaPago='").append(formaPago).append('\'')
                .append(", direcciones=[");

        for (Direcciones direccion : direcciones) {
            stringBuilder.append("{calle='").append(direccion.getCalle())
                    .append("', numero=").append(direccion.getNumero()).append("}, ");
        }

        stringBuilder.append("]}");

        return stringBuilder.toString();
    }

}
