package reto2;

public class Vegetales extends Ingrediente{
    public Vegetales(){
        this.costo = 4000;
        this.nombre = "Vegetales";
    }

    @Override
    public int getCosto() {
        return costo;
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}

