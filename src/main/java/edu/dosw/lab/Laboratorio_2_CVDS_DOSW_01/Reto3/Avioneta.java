package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.Reto3;

public class Avioneta extends Vehiculo {
    public Avioneta(String category) {
        super("Avioneta", category,
                category.equals("Económico") ? 250 : category.equals("Lujo") ? 400 : 200,
                category.equals("Económico") ? 150000000 : category.equals("Lujo") ? 300000000 : 100000000,
                category.equals("Económico") ? "Instrumentos básicos de vuelo" :
                        category.equals("Lujo") ? "Cabina digital + piloto automático" : "Equipamiento estándar");
    }
}
