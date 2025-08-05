package org.mx.la.asociaciones.enums;

public enum TipoCompra {

    SUPERMERCADO("Supermercado"),
    FARMACIA("Farmacia"),
    TIENDA_DEPARTAMENTAL("Tienda Departamental"),
    TIENDA_ELECTRONICA("Tienda Electrónica"),
    LIBRERIA("Librería"),
    MERCADO("Mercado"),
    GASOLINERA("Gasolinera"),
    RESTAURANTE("Restaurante"),
    TALLER_AUTOMOTRIZ("Taller Automotriz"),
    CINE_TEATRO("Cine o Teatro");

    private final String descripcion;

    TipoCompra(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
