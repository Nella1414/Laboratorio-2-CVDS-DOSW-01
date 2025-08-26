package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.reto5;

/**
 * Decorador abstracto que mantiene una referencia a otra bebida.
 */
public abstract class BeverageDecorator implements Beverage {
    protected final Beverage beverage;

    protected BeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
    }
}
