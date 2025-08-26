package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.Reto7;

public interface Command {
    void execute();
    void undo();
    String getDes();
}
