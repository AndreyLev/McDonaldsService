package service;

import model.OrderModel;
import model.ProductModel;
import repository.CategoryRepository;
import repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class McDonaldsService implements McDonaldsServiceInterface {
    private final ProductRepository repository;

    public McDonaldsService(ProductRepository repository) {
        this.repository = repository;
    }


    @Override
    public boolean sellItem(OrderModel order) {


        List<Integer> costs = new ArrayList<>();
        for (Integer id : order.getWhatProductsWereSold()) {
            for (ProductModel product: repository.getAll()) {
                if (id == product.getId()) {
                    int index = order.getWhatProductsWereSold().indexOf(id);
                    List<Integer> temp = order.getHowManyProductsWereSold();
                    costs.add(product.getPrice() * temp.get(index));
                }
            }
        }

        order.setAtWhatCostWereProductsSold(costs);
        return true;
    }

    @Override
    public List<String> printItemsByCategories(CategoryRepository category) {
       List<ProductModel> temp = repository.getAll().stream()
               .filter(o -> o.getCategoryName() == category)
               .collect(Collectors.toList())
               ;

       List<String> result = new ArrayList<>();

        for (ProductModel productModel : temp) {
            result.add(productModel.getName());
        }

        return result;
    }

    @Override
    public List<ProductModel> getProductsByText(String text) {
        return repository.getAll().stream()
                .filter(o -> o.getName().toLowerCase().contains(text.toLowerCase()))
                .collect(Collectors.toList())
                ;
    }


}
