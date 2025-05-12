package cl.patrones.examen.productos.model;

import cl.patrones.examen.productos.domain.Producto;
import cl.patrones.examen.productos.domain.Categoria;
import cl.patrones.examen.productos.service.CalculadorDescuento;

public class ProductoConDescuento implements Producto {

    private final Producto producto;
    private final Long descuento;
    private final Long precioFinal;

    public ProductoConDescuento(Producto producto) {
        this.producto = producto;
        CalculadorDescuento calculador = new CalculadorDescuento();
        this.descuento = calculador.aplicarDescuento(producto);
        this.precioFinal = producto.getPrecioLista() - descuento;
    }

    @Override
    public String getSku() {
        return producto.getSku();
    }

    @Override
    public String getNombre() {
        return producto.getNombre();
    }

    @Override
    public String getImagen() {
        return producto.getImagen();
    }

    @Override
    public Long getCosto() {
        return producto.getCosto();
    }

    @Override
    public Long getPrecioLista() {
        return producto.getPrecioLista();
    }

    @Override
    public Long getDescuento() {
        return this.descuento;
    }

    @Override
    public Long getPrecioFinal() {
        return this.precioFinal;
    }

    @Override
    public Categoria getCategoria() {
        return producto.getCategoria();
    }
}
