package state;

public class OrderPlaced implements OrderState{
    @Override
    public void process(Order order) {
        System.out.println("Order placed, waiting for payment");
        order.setState(new PaymentReceived());
        order.notifyObservers();
    }
}
