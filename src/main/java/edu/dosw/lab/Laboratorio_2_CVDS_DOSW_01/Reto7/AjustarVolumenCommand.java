package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.Reto7;

public class AjustarVolumenCommand implements Command {
    private Volumen volumen;
    private int nivel;
    public AjustarVolumenCommand(Volumen volumen, int nivel) {
        this.volumen = volumen;
        this.nivel = nivel;
    }
    public void execute() { volumen.adjust(nivel); }
    public void undo() { volumen.reset(); }
    public String getDes() { return "Ajustar volumen a " + nivel + "%"; }
}
