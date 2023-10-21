package state;

import models.Product;
import observer.OrderStatusObserver;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private OrderState orderState;
    private List<Product> products;
    private List<OrderStatusObserver> orderStatusObservers;
    public Order() {
        orderState = new OrderPlaced();
        orderStatusObservers = new ArrayList<>();
        products = new ArrayList<>();
    }

    public void process() {
        orderState.process(this);
    }

    public void setState(OrderState state) {
        this.orderState = state;
    }

    public void registerObserver(OrderStatusObserver observer) {
        orderStatusObservers.add(observer);
    }

    public void removeObserver(OrderStatusObserver observer) {
        orderStatusObservers.remove(observer);
    }

    public OrderState getOrderState(){
        return orderState;
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public void removeProduct(Product product){
        products.remove(product);
    }

    public double getTotalPrice(){
        double sum = 0;
        for (Product product: products){
            sum += product.getPrice();
        }
        return sum;
    }

    public void notifyObservers() {
        for (OrderStatusObserver observer : orderStatusObservers) {
            observer.update(this);
        }
    }
}
