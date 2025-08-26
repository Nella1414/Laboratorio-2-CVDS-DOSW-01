package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.Reto7;

public class Puerta {
    private boolean itsopen = false;
    public void open() { itsopen = true; System.out.println("Puerta abierta"); }
    public void close() { itsopen = false; System.out.println("Puerta cerrada"); }
}
