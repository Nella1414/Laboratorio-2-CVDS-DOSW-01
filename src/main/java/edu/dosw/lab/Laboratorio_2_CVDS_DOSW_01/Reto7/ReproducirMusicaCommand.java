package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.Reto7;

public class ReproducirMusicaCommand implements Command {
    private Musica musica;
    public ReproducirMusicaCommand(Musica musica) { this.musica = musica; }
    public void execute() { musica.play(); }
    public void undo() { musica.stop(); }
    public String getDes() { return "Reproducir música"; }
}
