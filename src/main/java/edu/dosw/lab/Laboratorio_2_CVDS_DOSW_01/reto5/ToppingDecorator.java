package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.reto5;

/**
 * Decorador concreto de un topping.
 */
public class ToppingDecorator extends BeverageDecorator {
    private final Topping topping;

    public ToppingDecorator(Beverage beverage, Topping topping) {
        super(beverage);
        this.topping = topping;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", " + topping.getName();
    }

    @Override
    public int cost() {
        return beverage.cost() + topping.getPrice();
    }
}
