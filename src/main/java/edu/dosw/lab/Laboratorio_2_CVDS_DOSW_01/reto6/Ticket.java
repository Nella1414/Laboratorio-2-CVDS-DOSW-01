package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.reto6;

public class Ticket {
    private String descripcion;
    private String nivel;     // básico, intermedio, avanzado
    private String prioridad; // baja, media, alta

    public Ticket(String descripcion, String nivel, String prioridad) {
        this.descripcion = descripcion;
        this.nivel = nivel.toLowerCase();
        this.prioridad = prioridad.toLowerCase();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNivel() {
        return nivel;
    }

    public String getPrioridad() {
        return prioridad;
    }
}
