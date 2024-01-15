package app.model;

public class PickupProduct implements Product {
    private String name;
    private double price;
    private int quantity;

    public PickupProduct(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public double calculateTotalCost() {
        return price * quantity;
    }
}
