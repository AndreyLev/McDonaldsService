package repository;

import model.ProductModel;


import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductRepositoryFunctionalImpl implements ProductRepository {
    private Collection<ProductModel> items = Collections.emptyList();
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
        ProductModel copy = item.withId(nextId++);
        items = Stream.concat(items.stream(), Stream.of(copy))
                .collect(Collectors.toList())
                ;
        return copy;

    }

    @Override
    public ProductModel update(ProductModel item) {
       return null;
    }

    @Override
    public boolean removeById(int id) {
        Collection<ProductModel> original = items;
        Collection<ProductModel> copy = items.stream()
                .filter(o -> o.getId() == id)
                .collect(Collectors.toList())
                ;
        items = copy;
        return original.size() == copy.size();
    }
}
