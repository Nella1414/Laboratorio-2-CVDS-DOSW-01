package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.Reto7;
import java.util.*;
import java.util.stream.Collectors;

public class ControlRemotoApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ControlRemoto control = new ControlRemoto();

        Luz luz = new Luz();
        Puerta puerta = new Puerta();
        Musica musica = new Musica();
        Volumen volumen = new Volumen();

        System.out.print("Número de acciones a registrar: ");
        int n = sc.nextInt(); sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.println("\nAcción " + i + ":");
            System.out.print("Usuario: ");
            String usuario = sc.nextLine();

            System.out.println("Seleccione acción: 1. Encender luz 2. Abrir puerta 3. Reproducir música 4. Ajustar volumen");
            int opcion = sc.nextInt();
            sc.nextLine();

            Command comando = null;
            switch (opcion) {
                case 1: comando = new EncenderLuzCommand(luz); break;
                case 2: comando = new AbrirPuertaCommand(puerta); break;
                case 3: comando = new ReproducirMusicaCommand(musica); break;
                case 4:
                    System.out.print("Ingrese valor (0-100): ");
                    int nivel = sc.nextInt(); sc.nextLine();
                    comando = new AjustarVolumenCommand(volumen, nivel);
                    break;
            }

            comando.execute();

            System.out.print("¿Deshacer acción? (si/no): ");
            boolean deshacer = sc.nextLine().equalsIgnoreCase("si");
            if (deshacer) comando.undo();

            control.ejecutarAccion(usuario, comando, deshacer);
        }

        // Mostrar resultados
        control.mostrarHistorial();
        control.investigarUsuarios();
    }
}
