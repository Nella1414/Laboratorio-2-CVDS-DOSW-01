package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.reto2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Reto2ChefDeHamburguesas {
    public static void ejecutar(){
        System.out.println("Ejecutando reto 2: El chef de 5 estrellas...");
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido a nuestra tienda" +
                "\nSeleccione los ingredientes para su hamburguesa:" +
                "\n1. Pan ($3.000)" +
                "\n2. Carne ($10.000)" +
                "\n3. Queso ($5.000)" +
                "\n4. Vegetales ($3.000)" +
                "\n5. Salsas ($3.000)" +
                "\n6. Agregar un nuevo ingrediente" +
                "\nIngrese los números separados por coma: ");
        String linea = sc.nextLine();
        List<Integer> numeroDeIngrediente = Arrays.stream(linea.split(",")).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());

        Hamburguesa suHamburguesa = new Hamburguesa(numeroDeIngrediente);

        System.out.println("\n--- HAMBURGUESA PERSONALIZADA ---");
        suHamburguesa.getIngredientes();
        int precioDeLaHamburguesa = suHamburguesa.getPrecio();
        System.out.println("Precio total: $" + precioDeLaHamburguesa);
        System.out.println("--------------------------");
        System.out.println("¡Disfrute de su hamburguesa!");
    }
}
