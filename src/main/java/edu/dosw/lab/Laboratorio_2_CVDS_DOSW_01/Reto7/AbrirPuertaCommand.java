package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.Reto7;

public class AbrirPuertaCommand implements Command {
    private Puerta puerta;
    public AbrirPuertaCommand(Puerta puerta) { this.puerta = puerta; }
    public void execute() { puerta.open(); }
    public void undo() { puerta.close(); }
    public String getDes() { return "Abrir puerta"; }
}
