package org.mx.la.asociaciones.enums;

public enum FormaPago {

    TARJETA_CREDITO("Tarjeta de Crédito"),
    TARJETA_DEBITO("Tarjeta de Débito"),
    PAYPAL("PayPal"),
    TRANSFERENCIA_BANCARIA("Transferencia Bancaria"),
    EFECTIVO("Efectivo");

    private final String descripcion;

    FormaPago(String descripcion) {
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
