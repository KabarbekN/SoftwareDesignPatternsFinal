package decorator;

import state.Order;

public abstract class OrderDecorator {
    protected Order order;

    public OrderDecorator(Order order){
        this.order = order;
    }

    public abstract double decorate();
}
