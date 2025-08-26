package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.reto5;

/**
 * Implementación base de un café simple sin toppings.
 */
public class BaseCoffee implements Beverage {
    @Override
    public String getDescription() {
        return "Café base";
    }

    @Override
    public int cost() {
        return 2000; // precio base del café
    }
}
