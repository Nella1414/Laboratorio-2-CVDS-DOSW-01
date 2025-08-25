package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.Reto3;

public abstract class Vehiculo {
    protected String type;
    protected String category;
    protected int topSpeed;
    protected double price;
    protected String equipment;

    public Vehiculo(String type, String category, int topSpeed, double price, String equipment) {
        this.type = type;
        this.category = category;
        this.topSpeed = topSpeed;
        this.price = price;
        this.equipment = equipment;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
