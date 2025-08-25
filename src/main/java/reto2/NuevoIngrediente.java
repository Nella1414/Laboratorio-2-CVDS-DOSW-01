package reto2;

public class NuevoIngrediente extends Ingrediente{

    public NuevoIngrediente(String nombre, int costo){
        this.nombre = nombre;
        this.costo = costo;
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
