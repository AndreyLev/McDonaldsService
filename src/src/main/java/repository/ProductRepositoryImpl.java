package repository;

import model.ProductModel;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Optional;

public class ProductRepositoryImpl implements ProductRepository{

    private final Collection<ProductModel> items = new LinkedList<>();
    private int nextId = 1;

    @Override
    public Collection<ProductModel> getAll() {

        return Collections.unmodifiableCollection(items);
    }

    @Override
    public Optional<ProductModel> getById(int id) {
        return items.stream()
                .filter(o -> o.getId() == id)
                .findFirst()
                ;
    }

    @Override
    public ProductModel create(ProductModel item) {
        item.setId(nextId++);
        items.add(item);
        return item;
    }

    @Override
    public ProductModel update(ProductModel item) {
        for (ProductModel model : items) {
            if (model.getId() == item.getId()) {
                model.setId(item.getId());
                model.setName(item.getName());
                model.setPrice(item.getPrice());
                return model;
            }
        }
        return null;
    }

    @Override
    public boolean removeById(int id) {

        return items.removeIf(o -> o.getId() == id);
    }
}
