package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.reto5;

import java.util.*;

/**
 * Aplicación de personalización de cafés (versión refactorizada).
 * Mejora: manejo robusto de entrada, separación de responsabilidades y soporte
 * real para añadir toppings dinámicamente sin crear archivos extra.
 */
public class Reto5 {
    private static final String LINE = "--------------------------------";

    // Lista mutable de toppings disponibles (inicializada una sola vez)
    private static final List<Topping> AVAILABLE_TOPPINGS = new ArrayList<>();
    static {
        AVAILABLE_TOPPINGS.add(new Topping(1, "Leche", 1000));
        AVAILABLE_TOPPINGS.add(new Topping(2, "Chocolate", 1500));
        AVAILABLE_TOPPINGS.add(new Topping(3, "Caramelo", 1200));
        AVAILABLE_TOPPINGS.add(new Topping(4, "Crema Batida", 2000));
        AVAILABLE_TOPPINGS.add(new Topping(5, "Menta", 1300));
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Bienvenido a la tienda!");
            int coffees = readPositiveInt(scanner, "Número de cafés a personalizar: ");
            manageCustomToppings(scanner);

            // Lista de cafés, cada uno con su lista de toppings seleccionados
            List<List<Topping>> coffeesToppings = new ArrayList<>();
            for (int i = 1; i <= coffees; i++) {
                coffeesToppings.add(selectToppingsForCoffee(scanner, i));
            }
            printInvoice(coffeesToppings);
        } catch (Exception e) {
            System.out.println("Error: Entrada no válida. Ejecución terminada.");
        }
    }

    // ---------------- Entrada / Utilidades ----------------
    private static int readPositiveInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                int n = Integer.parseInt(line);
                if (n > 0) return n;
            } catch (NumberFormatException ignored) { }
            System.out.println("Valor inválido, ingrese un entero positivo.");
        }
    }

    private static boolean readYesNo(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt + " (si/no): ");
            String ans = scanner.nextLine().trim().toLowerCase();
            if (ans.equals("si")) return true;
            if (ans.equals("no")) return false;
            System.out.println("Respuesta inválida. Use 'si' o 'no'.");
        }
    }

    // ---------------- Gestión de toppings ----------------
    private static void manageCustomToppings(Scanner scanner) {
        System.out.println("Toppings disponibles:");
        printToppings();
        while (readYesNo(scanner, "¿Desea agregar un nuevo topping?")) {
            System.out.print("Nombre del nuevo topping: ");
            String name = scanner.nextLine().trim();
            int price = readPositiveInt(scanner, "Precio del nuevo topping: ");
            int newId = AVAILABLE_TOPPINGS.stream().mapToInt(Topping::getId).max().orElse(0) + 1;
            AVAILABLE_TOPPINGS.add(new Topping(newId, name, price));
            System.out.println("Topping agregado.");
            printToppings();
        }
    }

    private static void printToppings() {
        System.out.println(LINE);
        for (Topping t : AVAILABLE_TOPPINGS) {
            System.out.printf("%d. %s - $%d%n", t.getId(), t.getName(), t.getPrice());
        }
        System.out.println(LINE);
    }

    private static List<Topping> selectToppingsForCoffee(Scanner scanner, int index) {
        System.out.println("--- Café " + index + " ---");
        printToppings();
        System.out.println("Ingrese IDs de toppings separados por coma (vacío para ninguno): ");
        String line = scanner.nextLine().trim();
        List<Topping> list = new ArrayList<>();
        if (line.isEmpty()) return list; // sin toppings
        String[] parts = line.split(",");
        for (String part : parts) {
            String trimmed = part.trim();
            if (trimmed.isEmpty()) continue;
            try {
                int id = Integer.parseInt(trimmed);
                Topping topping = findToppingById(id);
                if (topping != null) {
                    list.add(topping);
                } else {
                    System.out.println("ID " + id + " no encontrado (ignorado).");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada '" + trimmed + "' no es un número (ignorada).");
            }
        }
        return list;
    }

    private static Topping findToppingById(int id) {
        for (Topping t : AVAILABLE_TOPPINGS) {
            if (t.getId() == id) return t;
        }
        return null;
    }

    // ---------------- Factura ----------------
    private static void printInvoice(List<List<Topping>> coffees) {
        System.out.println("\n--- RESUMEN DE CAFÉS PERSONALIZADOS ---");
        int grandTotal = 0;
        int coffeeIndex = 1;
        for (List<Topping> coffee : coffees) {
            int total = coffee.stream().mapToInt(Topping::getPrice).sum();
            grandTotal += total;
            System.out.println(LINE);
            System.out.println("Café " + coffeeIndex++ + ":");
            if (coffee.isEmpty()) {
                System.out.println("Sin toppings (solo café base)");
            } else {
                System.out.println("Toppings:");
                coffee.forEach(t -> System.out.printf(" - %s ($%d)%n", t.getName(), t.getPrice()));
            }
            System.out.println("Total café: $" + total);
        }
        System.out.println(LINE);
        System.out.println("TOTAL A PAGAR: $" + grandTotal);
        System.out.println("Disfrute su café!");
    }
}
