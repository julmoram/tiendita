package demoarchivos;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class GestorProductos {
    private List<Producto> productos;
    private String archivo;

    public GestorProductos(String archivo) {
        this.archivo = archivo;
        productos = new LinkedList<>();
        cargarDatos();
    }

    private void cargarDatos() {
        File file = new File(archivo);
        if (!file.exists()) {
            System.out.println("El archivo no existe. Se creará uno nuevo al guardar los datos.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                int precio = Integer.parseInt(linea);
                String nombre = br.readLine();
                int cantidad = Integer.parseInt(br.readLine());
                if (nombre != null) {
                    productos.add(new Producto(precio, nombre, cantidad));
                }
            }
        } catch (IOException e) {
            System.out.println("Hubo un error al cargar los datos: " + e.getMessage());
        }
    }

    public void mostrarLista() {
        if (productos.isEmpty()) {
            System.out.println("La lista está vacía.");
        } else {
            System.out.printf("%-20s %10s %10s\n", "Nombre", "Precio", "Cantidad");
            System.out.println("--------------------------------------------");
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        }
    }

    public void mostrarRegistrosPares() {
        if (productos.isEmpty()) {
            System.out.println("La lista está vacía.");
        } else {
            System.out.printf("%-20s %10s %10s\n", "Nombre", "Precio", "Cantidad");
            System.out.println("--------------------------------------------");
            for (int i = 1; i < productos.size(); i += 2) {
                System.out.println(productos.get(i));
            }
        }
    }

    public void agregarAlInicio(Producto producto) {
        productos.add(0, producto);
    }

    public void agregarAlFinal(Producto producto) {
        productos.add(producto);
    }

    public void guardarDatos() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Producto producto : productos) {
                bw.write(String.valueOf(producto.getPrecio()));
                bw.newLine();
                bw.write(producto.getNombre());
                bw.newLine();
                bw.write(String.valueOf(producto.getCantidad()));
                bw.newLine();
            }
            System.out.println("Datos guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Hubo un error al guardar los datos: " + e.getMessage());
        }
    }
}
