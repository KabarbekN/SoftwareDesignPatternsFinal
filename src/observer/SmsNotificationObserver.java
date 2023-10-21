package observer;

import state.Order;

public class SmsNotificationObserver implements OrderStatusObserver{
    private String phoneNumber;

    public SmsNotificationObserver(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void update(Order order) {

    }
}
