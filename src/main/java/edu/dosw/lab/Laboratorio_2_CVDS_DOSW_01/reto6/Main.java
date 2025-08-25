package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.reto6;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Configuración de la cadena de responsabilidad
        Tecnico basico = new TecnicoBasico();
        Tecnico intermedio = new TecnicoIntermedio();
        Tecnico avanzado = new TecnicoAvanzado();
        basico.setSiguiente(intermedio);
        intermedio.setSiguiente(avanzado);

        List<Ticket> tickets = new ArrayList<>();

        System.out.print("Número de tickets: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nTicket " + (i+1));
            System.out.print("Nivel (básico, intermedio, avanzado): ");
            String nivel = sc.nextLine();
            System.out.print("Prioridad (baja, media, alta): ");
            String prioridad = sc.nextLine();
            System.out.print("Descripción: ");
            String descripcion = sc.nextLine();
            tickets.add(new Ticket(descripcion, nivel, prioridad));
        }

        System.out.println("\n--- Procesando Tickets ---");
        tickets.forEach(basico::procesar);

        // ---- Estadísticas con Streams ----
        System.out.println("\n--- Estadísticas ---");
        Map<String, Long> porNivel = tickets.stream()
                .collect(Collectors.groupingBy(Ticket::getNivel, Collectors.counting()));

        porNivel.forEach((nivel, cantidad) ->
                System.out.println("Tickets nivel " + nivel + ": " + cantidad));
    }
}
