package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.reto6;

public class TecnicoAvanzado extends Tecnico {
    @Override
    public boolean puedeResolver(Ticket ticket) {
        return ticket.getNivel().equals("avanzado");
    }
}