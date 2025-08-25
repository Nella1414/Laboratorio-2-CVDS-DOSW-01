package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.reto2;

public class Pan extends Ingrediente{
    public Pan(){
        this.costo = 3000;
        this.nombre = "Pan";
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
