package org.gomez.appfacturas;

import org.gomez.appfacturas.modelo.*;

import java.util.Scanner;

public class EjemploFactura {
    public static void main(String[] args) {

        Cliente cliente = new Cliente();

        cliente.setNit("22222");
        cliente.setNombre("fernando");

        Scanner s = new Scanner(System.in);
        System.out.println("ingrese la descripción de la factura: ");

        Factura factura = new Factura(s.nextLine(), cliente);

        Producto producto;


        System.out.println();

        for (int i = 0; i < 2; i++) {
            producto = new Producto();
            System.out.print("ingrese producto: " + producto.getCodigo() + ": ");
            producto.setNombre(s.nextLine());

            System.out.print("Ingrese el precio: ");
            producto.setPrecio(s.nextFloat());

            System.out.print("ingrese la cantidad: ");

            factura.addItem(new ItemFactura(s.nextInt(), producto));
            System.out.println();
            s.nextLine();


        }

        System.out.println(factura);


    }
}
