package app.model;

import java.util.ArrayList;
import java.util.List;

public class OrderModel {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public double getOrderTotal() {
        double orderTotal = 0;
        for (Product product : products) {
            orderTotal += product.calculateTotalCost();
        }
        return orderTotal;
    }
}
