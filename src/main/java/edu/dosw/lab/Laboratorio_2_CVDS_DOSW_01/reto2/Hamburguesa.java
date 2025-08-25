package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.reto2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Hamburguesa {
    private ArrayList<Ingrediente> ingredientes;

    public Hamburguesa(List<Integer> listaDeIngredientes){

        this. ingredientes = new ArrayList<>();

        for(int i = 0; i < listaDeIngredientes.size(); i++){

            int opcion = listaDeIngredientes.get(i);
            switch (opcion){
                case 1:
                    Pan pan = new Pan();
                    ingredientes.add(pan);
                    break;
                case 2:
                    Carne carne = new Carne();
                    ingredientes.add(carne);
                    break;
                case 3:
                    Queso queso = new Queso();
                    ingredientes.add(queso);
                    break;
                case 4:
                    Vegetales vegetales = new Vegetales();
                    ingredientes.add(vegetales);
                    break;
                case 5:
                    Salsas salsas = new Salsas();
                    ingredientes.add(salsas);
                    break;
                case 6:
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Ingrese el nombre del nuevo ingrediente: ");
                    String nombre = scanner.nextLine();

                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("Ingrese el precio del ingrediente: ");
                    int costo = scanner2.nextInt();


                    NuevoIngrediente nuevoIngrediente = new NuevoIngrediente(nombre, costo);
                    ingredientes.add(nuevoIngrediente);
                    break;
            }

        }

    }
    public int getCostoPorIngrediente(){
        int total = ingredientes.stream().mapToInt(Ingrediente::getCosto).sum();
        return total;
    }
    public void getIngredientes(){
        String nombres = ingredientes.stream().map(Ingrediente::getNombre).collect(Collectors.joining(", "));
        System.out.println("Ingredientes seleccionados: " + nombres);
    }
}


