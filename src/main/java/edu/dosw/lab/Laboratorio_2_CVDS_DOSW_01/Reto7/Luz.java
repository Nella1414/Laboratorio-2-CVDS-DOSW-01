package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.Reto7;

public class Luz {
    private boolean itson = false;
    public void on() { itson = true; System.out.println("Luz encendida"); }
    public void off() { itson = false; System.out.println("Luz apagada"); }
}
