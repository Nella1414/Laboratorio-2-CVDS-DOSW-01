package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.reto2;

public class Queso extends Ingrediente{
    public Queso(){
        this.costo = 5000;
        this.nombre = "Queso";
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
