package edu.dosw.lab.Laboratorio_2_CVDS_DOSW_01.reto1;

/**
 * Representa un producto comprado por el cliente.
 * Esta clase es intencionalmente simple y contiene únicamente
 * nombre, cantidad y precio unitario.
 */
public class Product {
    private String productName;
    private int quantity;        // cantidad adquirida
    private int price;           // precio unitario

    /**
     * Constructor principal.
     * @param productName nombre del productos
     * @param quantity cantidad (>=1)
     * @param price precio unitario (>=0)
     */
    public Product(String productName, int quantity, int price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * Constructor anterior (sin precio). Conservado para compatibilidad si fuese usado.
     * Se marca como deprecated para incentivar usar el nuevo.
     */
    @Deprecated
    public Product(String productName, int quantity) {
        this(productName, quantity, 0);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductPrice() {
        return price;
    }

    public void setProductPrice(int price) {
        this.price = price;
    }

    public int getTotal() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return String.format("%d %s - %d (%d * %d)", quantity, productName, getTotal(), quantity, price);
    }
}
