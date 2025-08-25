package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.reto2;

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

