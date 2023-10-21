import decorator.GiftWrapDecorator;
import decorator.OrderDecorator;
import models.Product;
import observer.EmailNotificationObserver;
import observer.OrderStatusObserver;
import singleton.OrderProcessingSystem;
import state.Order;
import strategy.BasicShipping;
import strategy.ShippingStrategy;

public class ApplicationRunner {

    public void start(){
        OrderProcessingSystem orderProcessingSystem = OrderProcessingSystem.getInstance();

        Order order1 = new Order();
        order1.addProduct(new Product("kuk", 46.4));
        order1.addProduct(new Product("dsfdfs", 56.8));

        double totalPrice = order1.getTotalPrice(); // Set the order's total price
        System.out.println(totalPrice);
        orderProcessingSystem.addOrder(order1);

        order1.process();

        ShippingStrategy standardShipping = new BasicShipping();
        double shippingCost = standardShipping.calculateCost(order1);

        System.out.println("Shipping cost: $" + shippingCost);

        OrderStatusObserver emailObserver = new EmailNotificationObserver("customer@example.com");
        order1.registerObserver(emailObserver);

        // Decorate the order with gift wrapping
        OrderDecorator giftWrapDecorator = new GiftWrapDecorator(order1);
        double decoratedTotalPrice = giftWrapDecorator.decorate();
        System.out.println("Decorated Total Price: $" + decoratedTotalPrice);

        order1.process();
    }
}
