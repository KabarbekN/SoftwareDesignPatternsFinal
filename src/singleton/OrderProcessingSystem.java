package singleton;

import observer.OrderStatusObserver;
import state.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderProcessingSystem {

    private static OrderProcessingSystem instance = null;
    private List<Order> orders;
    private List<OrderStatusObserver> orderStatusObservers;
    private OrderProcessingSystem(){
        orders = new ArrayList<>();
        orderStatusObservers = new ArrayList<>();
    }

    public static OrderProcessingSystem getInstance(){
        if (instance == null){
            instance = new OrderProcessingSystem();
        }
        return instance;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void registerStatusObserver(OrderStatusObserver observer) {
        orderStatusObservers.add(observer);
    }

    public List<OrderStatusObserver> getStatusObservers() {
        return orderStatusObservers;
    }
}
