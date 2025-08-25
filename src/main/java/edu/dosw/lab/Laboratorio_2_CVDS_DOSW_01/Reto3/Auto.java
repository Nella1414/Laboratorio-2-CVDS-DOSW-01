package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.Reto3;

public class Auto extends Vehiculo {
    public Auto(String category) {
        super("Auto", category,
                category.equals("Económico") ? 120 : category.equals("Lujo") ? 180 : 100,
                category.equals("Económico") ? 25000000 : category.equals("Lujo") ? 50000000 : 10000000,
                category.equals("Económico") ? "Aire acondicionado básico" :
                        category.equals("Lujo") ? "Aire acondicionado + GPS" : "Equipamiento estándar");
    }
}
