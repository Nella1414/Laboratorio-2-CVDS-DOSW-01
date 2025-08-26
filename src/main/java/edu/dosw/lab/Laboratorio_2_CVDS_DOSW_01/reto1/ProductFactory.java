package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.reto1;

/**
 * Factory responsable de crear instancias de {@link Product} a partir de un {@link ProductType} y cantidad.
 * Encapsula la lógica de construcción para centralizar posibles validaciones futuras.
 */
public final class ProductFactory {

    private ProductFactory() { /* utility class */ }

    public static Product create(ProductType type, int quantity) {
        if (type == null) throw new IllegalArgumentException("type no puede ser null");
        if (quantity <= 0) throw new IllegalArgumentException("quantity debe ser > 0");
        return new Product(type.getDisplayName(), quantity, type.getUnitPrice());
    }
}
