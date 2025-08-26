package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.Reto7;

public class RegistroAccion {
    String usuario;
    Command comando;
    boolean deshecho;

    public RegistroAccion(String usuario, Command comando, boolean deshecho) {
        this.usuario = usuario;
        this.comando = comando;
        this.deshecho = deshecho;
    }
    @Override
    public String toString() {
        return comando.getDes() + " – Usuario: " + usuario + (deshecho ? " (deshecha)" : "");
    }
}