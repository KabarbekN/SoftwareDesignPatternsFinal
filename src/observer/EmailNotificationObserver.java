package observer;

import state.Order;

public class EmailNotificationObserver implements OrderStatusObserver{
    private String email;
    public EmailNotificationObserver(String email){
        this.email = email;
    }
    @Override
    public void update(Order order) {
        System.out.println("Email notification to: " + email + " was sent, order status changed to " + order.getOrderState().getClass().getSimpleName());
    }
}
