package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.reto6;

public abstract class Tecnico {
    protected Tecnico siguiente;

    public void setSiguiente(Tecnico siguiente) {
        this.siguiente = siguiente;
    }

    public abstract boolean puedeResolver(Ticket ticket);

    public void procesar(Ticket ticket) {
        if (puedeResolver(ticket)) {
            System.out.println(getClass().getSimpleName() + " resolvió el ticket: " + ticket.getDescripcion());
        } else if (siguiente != null) {
            System.out.println(getClass().getSimpleName() + " no pudo resolver, pasa al siguiente...");
            siguiente.procesar(ticket);
        } else {
            System.out.println("Ningún técnico disponible. Ticket pendiente de escalamiento: " + ticket.getDescripcion());
        }
    }
}

