package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.Reto7;

public class Volumen {
    private int level = 0;
    public void adjust(int valor) {
        level = valor; System.out.println("Volumen ajustado a " + level + "%");
    }
    public void reset() { level = 0; System.out.println("Volumen regresado a 0%"); }
}
