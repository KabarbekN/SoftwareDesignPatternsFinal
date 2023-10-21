package strategy;

import state.Order;

public class ExpressShipping implements ShippingStrategy{
    @Override
    public double calculateCost(Order order) {
        return order.getTotalPrice() * 1.2;
    }
}
