package state;

public class Shipped implements OrderState{
    @Override
    public void process(Order order) {
        System.out.println("Order shipped. Awaiting delivery.");
        order.notifyObservers();
    }
}
