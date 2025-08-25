package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.Reto3;

public class VehiculoFactory {
    public static Vehiculo crearVehiculo(String tipo, String categoria, String modelo) {
        switch (modelo.toLowerCase()) {
            case "auto": return new Auto(categoria);
            case "avioneta": return new Avioneta(categoria);
            default: throw new IllegalArgumentException("Modelo no válido");
        }
    }
}
