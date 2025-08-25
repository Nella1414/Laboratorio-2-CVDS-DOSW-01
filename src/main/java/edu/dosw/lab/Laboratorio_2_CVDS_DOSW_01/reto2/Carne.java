package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.reto2;

public class Carne extends Ingrediente{
    public Carne(){
        this.costo = 10000;
        this.nombre = "Carne";
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
