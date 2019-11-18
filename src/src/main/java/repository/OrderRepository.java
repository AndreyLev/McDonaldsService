package repository;

import model.OrderModel;

import java.util.Collection;
import java.util.Optional;

public interface OrderRepository {

    Collection<OrderModel> getAll();

    Optional<OrderModel> getById(int id);

    OrderModel create(OrderModel order);

    OrderModel update(OrderModel order);

    boolean removeById(int id);

}
