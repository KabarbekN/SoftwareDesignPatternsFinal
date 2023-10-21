package state;

public class PaymentReceived implements OrderState{
    @Override
    public void process(Order order) {
        System.out.println("Payment received. Preparing to ship.");
        order.setState(new Shipped());
        order.notifyObservers();
    }
}
