package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.Reto7;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ControlRemoto {
    private List<RegistroAccion> historial = new ArrayList<>();

    public void ejecutarAccion(String usuario, Command comando, boolean deshacer) {
        comando.execute();
        if (deshacer) {
            comando.undo();
        }
        historial.add(new RegistroAccion(usuario, comando, deshacer));
    }

    public void mostrarHistorial() {
        System.out.println("\n--- Historial completo ---");
        int i = 1;
        for (RegistroAccion r : historial) {
            System.out.println((i++) + ": " + r);
        }
    }

    public void investigarUsuarios() {
        System.out.println("\n--- Investigando quién desconfiguró los electrodomésticos ---");
        Map<String, Long> conteo = historial.stream()
                .collect(Collectors.groupingBy(r -> r.usuario, Collectors.counting()));
        conteo.forEach((usuario, cantidad) ->
                System.out.println(usuario + " realizó " + cantidad + " acciones."));
    }
}
