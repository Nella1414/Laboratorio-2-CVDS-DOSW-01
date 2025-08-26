package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.reto5;

/**
 * Representa un topping disponible para personalizar un café.
 * Clase inmutable para simplificar manejo de datos.
 */
public final class Topping {
    private final int id;
    private final String name;
    private final int price;

    public Topping(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getPrice() { return price; }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}
