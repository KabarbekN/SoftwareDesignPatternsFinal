package observer;

import state.Order;

public interface OrderStatusObserver {
    void update(Order order);
}
