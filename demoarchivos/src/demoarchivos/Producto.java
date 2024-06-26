package demoarchivos;

public class Producto {
    private int precio;
    private String nombre;
    private int cantidad;

    public Producto(int precio, String nombre, int cantidad) {
        this.precio = precio;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return String.format("%-20s %10d %10d", nombre, precio, cantidad);
    }
}