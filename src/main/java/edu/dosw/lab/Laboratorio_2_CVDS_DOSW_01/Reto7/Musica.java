package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.Reto7;

public class Musica {
    private boolean itsplaying = false;
    public void play() { itsplaying = true; System.out.println("Música reproducida"); }
    public void stop() { itsplaying = false; System.out.println("Música detenida"); }
}
