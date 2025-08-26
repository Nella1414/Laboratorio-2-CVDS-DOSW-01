package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.reto1;

/**
 * Catálogo de tipos de productos disponibles en la tienda.
 * Cada tipo conoce su identificador de menú, nombre desplegado y precio unitario.
 */
public enum ProductType {
    CAMISETA(1, "Camiseta", 20000),
    PANTALON(2, "Pantalon", 50000),
    GALLETAS(3, "Galletas", 500),
    JUGO(4, "Jugo Natural", 3000);

    private final int id;
    private final String displayName;
    private final int unitPrice;

    ProductType(int id, String displayName, int unitPrice) {
        this.id = id;
        this.displayName = displayName;
        this.unitPrice = unitPrice;
    }

    public int getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public static ProductType fromId(int id) {
        for (ProductType type : values()) {
            if (type.id == id) return type;
        }
        return null;
    }
}
