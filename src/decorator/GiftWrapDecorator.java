package decorator;


import state.Order;

public class GiftWrapDecorator extends OrderDecorator {

    public GiftWrapDecorator(Order order) {
        super(order);
    }

    @Override
    public double decorate() {
        System.out.println("Order was decorated");
        return order.getTotalPrice() + 5;
    }
}
