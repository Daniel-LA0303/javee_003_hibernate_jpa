package org.example.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "facturas")
public class Factura {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String descripcion;
        private BigDecimal total; // Cambiado a BigDecimal

        @ManyToOne(cascade = CascadeType.REMOVE)
        @JoinColumn(name = "id_cliente")
        private Cliente cliente;

        public Factura() {
        }

        public Factura(String descripcion, Long total) {
            this.descripcion = descripcion;
            this.total = BigDecimal.valueOf(total);
        }


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public BigDecimal getTotal() {
            return total;
        }

        public void setTotal(BigDecimal total) {
            this.total = total;
        }
        public Cliente getCliente() {
            return cliente;
        }

        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
        }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", total=" + total +
                ", cliente=" + cliente +
                '}';
    }
}
