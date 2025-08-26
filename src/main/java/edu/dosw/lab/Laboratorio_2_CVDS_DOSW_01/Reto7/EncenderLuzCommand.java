package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.Reto7;

public class EncenderLuzCommand implements Command {
    private Luz luz;
    public EncenderLuzCommand(Luz luz) { this.luz = luz; }
    public void execute() { luz.on(); }
    public void undo() { luz.off(); }
    public String getDes() { return "Encender luz"; }
}
