package app.controller;

import app.model.DeliveredProduct;
import app.model.OrderModel;
import app.model.PickupProduct;
import app.model.Product;
import app.view.OrderView;

public class OrderController {
    private static final double DELIVERY_FEE_PERCENTAGE = 5;
    private OrderView orderView;
    private OrderModel orderModel;

    public OrderController(OrderView orderView, OrderModel orderModel) {
        this.orderView = orderView;
        this.orderModel = orderModel;
    }

    public void processOrder(String productName, double price, int quantity, boolean requiresDelivery) {
        Product product;
        if (requiresDelivery) {
            product = new DeliveredProduct(productName, price, quantity, DELIVERY_FEE_PERCENTAGE);
        } else {
            product = new PickupProduct(productName, price, quantity);
        }

        orderModel.addProduct(product);
        orderView.showOrderDetails(orderModel.getOrderTotal());
    }
}