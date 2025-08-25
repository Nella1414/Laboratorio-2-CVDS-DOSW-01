package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.reto4;

import java.util.*;

public class Convertidor {

    // Tabla de tasas de conversión
    private static final Map<String, Map<String, Double>> rates = new HashMap<>();

    static {
        rates.put("USD", Map.of(
                "USD", 1.0,
                "EUR", 0.91,
                "JPY", 150.0,
                "COP", 4000.0
        ));
        rates.put("EUR", Map.of(
                "USD", 1.10,
                "EUR", 1.0,
                "JPY", 165.0,
                "COP", 4400.0
        ));
        rates.put("JPY", Map.of(
                "USD", 0.0067,
                "EUR", 0.0061,
                "JPY", 1.0,
                "COP", 27.0
        ));
        rates.put("COP", Map.of(
                "USD", 0.00025,
                "EUR", 0.00023,
                "JPY", 0.037,
                "COP", 1.0
        ));
    }

    // Conversión de una moneda a otra
    public double transformar(String inicial, String objetivo, double monto) {
        if (!rates.containsKey(inicial) || !rates.get(inicial).containsKey(objetivo)) {
            throw new IllegalArgumentException("Conversión no soportada: " + inicial + " -> " + objetivo);
        }
        return monto * rates.get(inicial).get(objetivo);
    }

    // Conversión a múltiples monedas (usando streams)
    public Map<String, Double> convertirAMultiples(String inicial, double monto, List<String> objetivos) {
        return objetivos.stream()
                .collect(HashMap::new,
                        (map, obj) -> map.put(obj, transformar(inicial, obj, monto)),
                        HashMap::putAll);
    }
}
