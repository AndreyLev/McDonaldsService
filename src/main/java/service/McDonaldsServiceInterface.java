package service;

import model.OrderModel;
import model.ProductModel;
import repository.CategoryRepository;

import java.util.List;

public interface McDonaldsServiceInterface {

    boolean sellItem(OrderModel order);
    List<String> printItemsByCategories(CategoryRepository category);
    List<ProductModel> getProductsByText(String text);

}
