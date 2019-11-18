package repository;

import model.OrderModel;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Optional;

public class OrderRepositoryImpl implements OrderRepository {
    private final Collection<OrderModel> orders = new LinkedList<>();
    private int nextId = 1;

    @Override
    public Collection<OrderModel> getAll() {
        return Collections.unmodifiableCollection(orders);
    }

    @Override
    public Optional<OrderModel> getById(int id) {
        return orders.stream()
                .filter(o -> o.getId() == id)
                .findFirst()
                ;
    }

    @Override
    public OrderModel create(OrderModel order) {
        order.setId(nextId++);
        orders.add(order);
        return order;
    }

    @Override
    public OrderModel update(OrderModel order) {

        for (OrderModel orderModel : orders) {
            if (orderModel.getId() == order.getId()) {
                orderModel.setId(order.getId());
                //orderModel.setOrder(order.getOrder());
                return orderModel;
            }
        }
        return null;
    }

    @Override
    public boolean removeById(int id) {
        return orders.removeIf(o -> o.getId() == id);
    }
}
