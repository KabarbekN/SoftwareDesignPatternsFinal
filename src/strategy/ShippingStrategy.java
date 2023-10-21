package strategy;

import state.Order;

public interface ShippingStrategy {
    double calculateCost(Order order);
}
