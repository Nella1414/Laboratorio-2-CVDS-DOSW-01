package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.reto2;

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
