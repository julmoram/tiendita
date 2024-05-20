package demoarchivos;

import java.util.Scanner;

public class DemoArchivos {
    public static void main(String[] args) {
        GestorProductos gestor = new GestorProductos("datos.dat");

        // Mostrar todos los registros guardados
        System.out.println("Todos los registros:");
        gestor.mostrarLista();

        // Mostrar solo los registros pares
        System.out.println("\nRegistros pares:");
        gestor.mostrarRegistrosPares();

        // Iniciar el menú interactivo
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Mostrar lista de productos");
            System.out.println("2. Agregar producto al inicio");
            System.out.println("3. Agregar producto al final");
            System.out.println("4. Guardar datos");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    gestor.mostrarLista();
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombreInicio = scanner.nextLine();
                    System.out.print("Ingrese el precio del producto: ");
                    int precioInicio = scanner.nextInt();
                    System.out.print("Ingrese la cantidad del producto: ");
                    int cantidadInicio = scanner.nextInt();
                    scanner.nextLine();  // Consumir la nueva línea
                    gestor.agregarAlInicio(new Producto(precioInicio, nombreInicio, cantidadInicio));
                    System.out.println("Producto agregado al inicio.");
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombreFinal = scanner.nextLine();
                    System.out.print("Ingrese el precio del producto: ");
                    int precioFinal = scanner.nextInt();
                    System.out.print("Ingrese la cantidad del producto: ");
                    int cantidadFinal = scanner.nextInt();
                    scanner.nextLine();  // Consumir la nueva línea
                    gestor.agregarAlFinal(new Producto(precioFinal, nombreFinal, cantidadFinal));
                    System.out.println("Producto agregado al final.");
                    break;
                case 4:
                    gestor.guardarDatos();
                    break;
                case 5:
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
