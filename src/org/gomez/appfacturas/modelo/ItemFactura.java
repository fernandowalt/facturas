package org.gomez.appfacturas.modelo;

public class ItemFactura {
    private int codigo;
    private Producto producto;
    private int cantidad;


    public ItemFactura(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;

    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public double cancularImporte() {
        return this.cantidad * this.producto.getPrecio();


    }

    @Override
    public String toString() {
        return producto.toString() +
                "\t" + cantidad +
                "\t" + cancularImporte();
    }
}
