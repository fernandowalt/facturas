package org.gomez.appfacturas.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {

    private Integer id;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private ItemFactura[] items;
    private int indiceItems;
    public static final int MAX_ITEMS = 12;
    private static int ultimoFolio;


    public Factura(String descripcion, Cliente cliente) {

        this.descripcion = descripcion;
        this.cliente = cliente;
        this.items = new ItemFactura[MAX_ITEMS];
        this.id = ++ultimoFolio;
        this.fecha = new Date();
    }

    public Integer getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ItemFactura[] getItemFacturas() {
        return items;
    }

    public void addItem(ItemFactura item) {
        if (indiceItems < MAX_ITEMS) {
            this.items[indiceItems++] = item;
        }
    }

    public float calcularTotal() {
        float total = 0.0f;
        for (int i = 0; i < indiceItems; i++) {

            total += this.items[i].cancularImporte();
        }
        return total;
    }

    public String generarDetalle() {
        StringBuilder sb = new StringBuilder("Factura Nª: ");
        SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM, yyyy");
        sb.append(id)
                .append("\nCliente: ")
                .append(this.cliente.getNombre())
                .append("\t NIF: ")
                .append(this.cliente.getNit())
                .append("\nDescripcion: ")
                .append(this.descripcion)
                .append("\n")
                .append("Fecha Emisión: ")
                .append(df.format(this.fecha)).append("\n");


        sb
                .append("\n#\tNombre\t$\t Cant.\tTotal\n")
                .append("\n");

        for (int i = 0; i < indiceItems; i++) {

            sb
                    .append(this.items[i].toString())
                    .append("\n");
        }
        sb.append("\n Gran Total: ")
                .append(calcularTotal());
        return sb.toString();


    }

    @Override
    public String toString() {
        return generarDetalle();
    }
}
