package app.model;

public class DeliveredProduct implements Product {
    private String name;
    private double price;
    private int quantity;
    private double deliveryFeePercentage;

    public DeliveredProduct(String name, double price, int quantity, double deliveryFeePercentage) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.deliveryFeePercentage = deliveryFeePercentage;
    }

    @Override
    public double calculateTotalCost() {
        return (price * quantity) * (1 + deliveryFeePercentage / 100);
    }
}
