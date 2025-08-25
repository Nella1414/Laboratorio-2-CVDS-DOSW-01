package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.reto6;



public class TecnicoIntermedio extends Tecnico {
    @Override
    public boolean puedeResolver(Ticket ticket) {
        return ticket.getNivel().equals("intermedio") && !ticket.getPrioridad().equals("alta");
    }
}


