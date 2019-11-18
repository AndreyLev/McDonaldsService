package repository;

import model.ProductModel;

import java.util.Collection;
import java.util.Optional;

public interface ProductRepository {
    Collection<ProductModel> getAll();

    Optional<ProductModel> getById(int id);

    ProductModel create(ProductModel item);

    ProductModel update(ProductModel item);

    boolean removeById(int id);
}
