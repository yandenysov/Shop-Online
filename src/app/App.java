package app;

import app.controller.OrderController;
import app.model.OrderModel;
import app.view.OrderView;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        OrderView orderView = new OrderView();
        OrderModel orderModel = new OrderModel();
        OrderController orderController = new OrderController(orderView, orderModel);
        Scanner scanner = new Scanner(System.in);
        boolean continueShopping = true;

        while (continueShopping) {

            System.out.println("Please, enter the name of the product you want to buy: ");
            String name = scanner.next();

            System.out.println("Enter the price of the product, USD: ");
            double price = scanner.nextDouble();

            System.out.println("Enter the amount that you would like to buy, pcs: ");
            int quantity = scanner.nextInt();

            System.out.println("Would you like the products to be delivered to you (additional 5% fee): Y/N?");
            String deliveryConfirmation = scanner.next();
            boolean requiresDelivery = false;
            if (deliveryConfirmation.equalsIgnoreCase("y")) requiresDelivery = true;
            orderController.processOrder(name, price, quantity, requiresDelivery);

            System.out.println("Would you like to add another product to your order? Total cost will then be merged: Y/N?");
            String continueShoppingConfirmation = scanner.next();
            if (continueShoppingConfirmation.equalsIgnoreCase("n")) continueShopping = false;
        }
        System.out.println("Thank you for using Online Shop!");
    }
}