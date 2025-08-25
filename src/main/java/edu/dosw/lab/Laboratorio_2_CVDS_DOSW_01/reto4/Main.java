package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.reto4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Transformar convertidor = new Transformar();

        System.out.print("Ingrese número de transacciones: ");
        int n = sc.nextInt();
        sc.nextLine(); // limpiar buffer

        Map<String, Double> totales = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            System.out.println("---- Transacción " + i + " ----");
            System.out.print("Ingrese monto: ");
            double monto = sc.nextDouble();
            sc.nextLine();

            System.out.print("Ingrese moneda de origen (USD, EUR, JPY, COP): ");
            String origen = sc.nextLine().trim().toUpperCase();

            System.out.print("Ingrese monedas destino (separadas por coma, ej: USD,JPY): ");
            String[] destinosArray = sc.nextLine().split(",");
            List<String> destinos = Arrays.asList(destinosArray);

            // Procesar conversión
            Map<String, Double> resultados = convertidor.convertirAMultiples(origen, monto, destinos);

            // Mostrar resultados de la transacción
            System.out.println("Transacción " + i + ": " + monto + " " + origen);
            resultados.forEach((moneda, valor) -> {
                System.out.println("Convertido a " + moneda + ": " + valor);
                totales.put(moneda, totales.getOrDefault(moneda, 0.0) + valor);
            });
            System.out.println();
        }

        // Mostrar totales acumulados
        System.out.println("---- Totales por moneda ----");
        totales.forEach((moneda, total) ->
                System.out.println(moneda + ": " + total + " " + moneda));
    }
}
