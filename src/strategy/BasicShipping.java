package strategy;

import state.Order;

public class BasicShipping implements ShippingStrategy{
    @Override
    public double calculateCost(Order order) {
        return order.getTotalPrice() * 1.1;
    }
}
