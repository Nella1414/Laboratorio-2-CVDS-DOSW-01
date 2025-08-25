package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.reto2;

public class Salsa extends Ingrediente{
    public Salsa(){
        this.costo = 3000;
        this.nombre = "Salsas";
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

