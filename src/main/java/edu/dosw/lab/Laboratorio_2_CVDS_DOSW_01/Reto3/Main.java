package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.Reto3;
import java.util.stream.Collectors;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Vehiculo> cars = new ArrayList<>();

        boolean next = true; //variable para continuar
        while (next) {
            System.out.println("Seleccione el tipo de vehículo:\n1. Tierra\n2. Acuático\n3. Aéreo");
            int type = sc.nextInt();

            System.out.println("Seleccione la categoría del vehículo:\n1. Económico\n2. Lujo\n3. Usado");
            int cat = sc.nextInt();
            String categoria = (cat == 1) ? "Económico" : (cat == 2) ? "Lujo" : "Usado";

            System.out.println("Seleccione el modelo de vehículo:");
            if (type == 1) {
                System.out.println("1. Auto\n2. Bicicleta\n3. Moto");
            } else if (type == 2) {
                System.out.println("1. Lancha\n2. Velero\n3. JetSki");
            } else {
                System.out.println("1. Avión\n2. Avioneta\n3. Helicóptero");
            }
            int mod = sc.nextInt();
            String model = "";

            if (type == 1) model = (mod == 1) ? "Auto" : (mod == 2) ? "Bicicleta" : "Moto";
            if (type == 2) model = (mod == 1) ? "Lancha" : (mod == 2) ? "Velero" : "JetSki";
            if (type == 3) model = (mod == 1) ? "Avion" : (mod == 2) ? "Avioneta" : "Helicoptero";

            Vehiculo v = VehiculoFactory.crearVehiculo(type + "", categoria, model);
            cars.add(v);

            System.out.println("¿Desea agregar otro vehículo? (si/no): ");
            next = sc.next().equalsIgnoreCase("si");
        }
        System.out.println("\n--- RESUMEN DE COMPRA ---");
        int i = 1;
        for (Vehiculo v : cars) {
            System.out.println("Vehículo " + i++ + ":\n" + v);
        }

        double subtotal = cars.stream().mapToDouble(Vehiculo::getPrice).sum();
        double discount = 0;
        double total = subtotal - discount;

        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Descuento aplicado: $" + discount);
        System.out.println("Total a pagar: $" + total);
        System.out.println("\n¡Gracias por su compra en el Reino de los Vehículos!");
    }
}
