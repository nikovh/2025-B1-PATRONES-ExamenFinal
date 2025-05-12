package cl.patrones.examen.productos.model;

import cl.patrones.examen.productos.domain.Producto;
import cl.patrones.examen.productos.domain.Categoria;
import cl.patrones.examen.productos.service.CalculadorDescuento;

import java.time.LocalDate;

public class ProductoConDescuento implements Producto {

    // private final Producto producto;
    private final Producto original;
    private final Long descuento;
    private final Long precioFinal;

    public ProductoConDescuento(Producto original) {
        this.original = original;
        CalculadorDescuento calculador = new CalculadorDescuento();
        double porcentaje = calculador.obtenerMayorPorcentaje(original, LocalDate.now());

        Long lista = original.getPrecioLista();
        this.descuento = Math.round(lista * porcentaje);
        this.precioFinal = lista - this.descuento;
    }

    @Override
    public String getSku() {
        return original.getSku();
    }

    @Override
    public String getNombre() {
        return original.getNombre();
    }

    @Override
    public String getImagen() {
        return original.getImagen();
    }

    @Override
    public Long getCosto() {
        return original.getCosto();
    }

    @Override
    public Long getPrecioLista() {
        return original.getPrecioLista();
    }

    @Override
    public Categoria getCategoria() {
        return original.getCategoria();
    }

    @Override
    public Long getDescuento() {
        return descuento;
    }

    @Override
    public Long getPrecioFinal() {
        return precioFinal;
    }


}
