package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.reto2;

public class Lechuga extends Ingrediente{
    public Lechuga(){
        this.nombre = "Lechuga";
        this.costo = 2000;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getCosto() {
        return costo;
    }
}
