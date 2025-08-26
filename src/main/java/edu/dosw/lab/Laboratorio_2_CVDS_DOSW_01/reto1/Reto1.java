package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.reto1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Aplicación de consola para gestión simple de compras.
 * Refactorizada para mayor legibilidad, separación de responsabilidades
 * y eliminación de código repetido.
 */
public class Reto1 {

    private static final String LINE = "--------------------------------";

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Bienvenido a la tienda de Don Pepe!");
            String clientType = readClientType(scanner);

            List<Product> cart = new ArrayList<>();
            boolean exit = false;
            while (!exit) {
                int menu = readMenuOption(scanner);
                switch (menu) {
                    case 1:
                        manageProductSelection(scanner, cart);
                        break;
                    case 2:
                        printInvoice(clientType, cart);
                        exit = true;
                        break;
                    default:
                        // Nunca debería llegar aquí por validación previa
                        break;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Entrada no válida. Por favor, ingrese un número.");
        }
    }

    // Entrada y validación --------------------------------------------------
    private static String readClientType(Scanner scanner) {
        while (true) {
            System.out.print("Ingrese tipo de cliente (nuevo / frecuente): ");
            String type = scanner.nextLine().trim().toLowerCase();
            if (type.equals("nuevo") || type.equals("frecuente")) {
                System.out.println(LINE);
                return type;
            }
            System.out.println("Tipo inválido. Intente de nuevo.");
        }
    }

    private static int readMenuOption(Scanner scanner) {
        while (true) {
            System.out.println("Ingrese la acción que desea realizar:");
            System.out.println("1. Listar / agregar productos");
            System.out.println("2. Generar factura");
            System.out.print("Opción: ");
            String input = scanner.nextLine();
            try {
                int opt = Integer.parseInt(input);
                if (opt == 1 || opt == 2) {
                    System.out.println(LINE);
                    return opt;
                }
            } catch (NumberFormatException ignored) { }
            System.out.println("Opción inválida. Intente nuevamente.");
        }
    }

    private static int readPositiveInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                int value = Integer.parseInt(input);
                if (value > 0) return value;
            } catch (NumberFormatException ignored) { }
            System.out.println("Valor inválido. Debe ser un número entero positivo.");
        }
    }

    // Gestión de productos --------------------------------------------------
    private static void manageProductSelection(Scanner scanner, List<Product> cart) {
        boolean back = false;
        while (!back) {
            printCatalog();
            int choice = readPositiveInt(scanner, "Seleccione un producto (5 para salir): ");
            if (choice == 5) { // salir
                back = true;
                continue;
            }
            ProductType type = ProductType.fromId(choice);
            if (type == null) {
                System.out.println("Id no válido.");
                continue;
            }
            int quantity = readPositiveInt(scanner, "Cantidad: ");
            Product product = ProductFactory.create(type, quantity);
            cart.add(product);
            System.out.printf("%d unidades de %s agregadas.%n", quantity, type.getDisplayName());
            System.out.println(LINE);
        }
    }

    private static void printCatalog() {
        System.out.println(LINE);
        System.out.println("Productos disponibles:");
        for (ProductType type : ProductType.values()) {
            System.out.printf("%d. %s - $%d%n", type.getId(), type.getDisplayName(), type.getUnitPrice());
        }
        System.out.println("5. Salir\n");
    }

    // Facturación -----------------------------------------------------------
    private static void printInvoice(String clientType, List<Product> cart) {
        System.out.println(LINE);
        System.out.println("--- RECIBO DE COMPRA ---");
        System.out.println("Cliente: " + clientType);
        if (cart.isEmpty()) {
            System.out.println("(Sin productos)");
        } else {
            System.out.println("Productos:");
            cart.forEach(p -> System.out.println(p));
        }
        int subtotal = calculateSubtotal(cart);
        System.out.println("Subtotal: $" + subtotal);

        double discountRate = clientType.equals("frecuente") ? 0.10 : 0.05;
        double discount = subtotal * discountRate;
        System.out.printf("Descuento (%.0f%%): -$%.2f%n", discountRate * 100, discount);
        System.out.printf("Total a pagar: $%.2f%n", subtotal - discount);
        System.out.println("Muchas gracias por su compra!!");
        System.out.println(LINE);
    }

    private static int calculateSubtotal(List<Product> products) {
        int subtotal = 0;
        for (Product product : products) {
            subtotal += product.getProductPrice() * product.getQuantity();
        }
        return subtotal;
    }
}