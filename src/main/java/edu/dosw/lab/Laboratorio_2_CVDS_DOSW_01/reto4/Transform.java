package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.reto4;

import java.util.*;

public class Transformar {

    // Tabla de tasas de conversión
    private static final Map<String, Map<String, Double>> tasas = new HashMap<>();

    static {
        tasas.put("USD", Map.of(
                "USD", 1.0,
                "EUR", 0.91,
                "JPY", 150.0,
                "COP", 4000.0
        ));
        tasas.put("EUR", Map.of(
                "USD", 1.10,
                "EUR", 1.0,
                "JPY", 165.0,
                "COP", 4400.0
        ));
        tasas.put("JPY", Map.of(
                "USD", 0.0067,
                "EUR", 0.0061,
                "JPY", 1.0,
                "COP", 27.0
        ));
        tasas.put("COP", Map.of(
                "USD", 0.00025,
                "EUR", 0.00023,
                "JPY", 0.037,
                "COP", 1.0
        ));
    }

    /**
     * Convierte una moneda a otra.
     *
     * @param origen   Moneda de origen
     * @param destino  Moneda de destino
     * @param monto    Cantidad a convertir
     * @return Valor convertido
     */
    public double convertir(String origen, String destino, double monto) {
        if (!tasas.containsKey(origen) || !tasas.get(origen).containsKey(destino)) {
            throw new IllegalArgumentException("Conversión no soportada: " + origen + " -> " + destino);
        }
        return monto * tasas.get(origen).get(destino);
    }

    /**
     * Convierte un monto en una moneda a múltiples monedas destino.
     *
     * @param origen    Moneda de origen
     * @param monto     Cantidad a convertir
     * @param destinos  Lista de monedas destino
     * @return Mapa con los resultados de las conversiones
     */
    public Map<String, Double> convertirAMultiples(String origen, double monto, List<String> destinos) {
        return destinos.stream()
                .collect(HashMap::new,
                        (mapa, destino) -> mapa.put(destino, convertir(origen, destino, monto)),
                        HashMap::putAll);
    }
}
