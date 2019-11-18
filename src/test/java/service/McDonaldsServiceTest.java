package service;

import model.BurgerModel;
import model.DrinkModel;
import model.OrderModel;
import model.ProductModel;
import org.junit.jupiter.api.Test;
import repository.CategoryRepository;
import repository.OrderRepositoryImpl;
import repository.ProductRepositoryImpl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static repository.CategoryRepository.COLD_DRINKS;

class McDonaldsServiceImplTest {


    @Test
    void shouldPrintTrueByCategories() {
        OrderRepositoryImpl orderRepository = new OrderRepositoryImpl();
        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
        McDonaldsService mcDonaldsService = new McDonaldsService(productRepository);
        productRepository.create(new BurgerModel(52, "Чизбургер", "Рубленый бифштекс", CategoryRepository.SANDWICHES, "Говядина"));
        productRepository.create(new BurgerModel(50, "Гамбургер", "Бифштекс на карамелизованной булочке", CategoryRepository.SANDWICHES, "Говядина"));
        productRepository.create(new BurgerModel(52, "Чикенбургер", "Обжаренная куриная котлета", CategoryRepository.SANDWICHES, "Курица"));
        productRepository.create(new DrinkModel(65, "Кока-Кола", "Классика, чтобы освежиться", COLD_DRINKS, "MEDIUM"));
        productRepository.create(new DrinkModel(65, "Фанта", "Прекрасный солнечный напиток для самых ярких", COLD_DRINKS, "MEDIUM"));
        productRepository.create(new DrinkModel(65, "Спрайт", "Напиток для тех, кто всегда в движении", COLD_DRINKS, "MEDIUM"));


        List<String> sourceList = mcDonaldsService.printItemsByCategories(CategoryRepository.SANDWICHES);
        List<String> whatShouldPrint = new LinkedList<>();
        whatShouldPrint.add("Чизбургер");
        whatShouldPrint.add("Гамбургер");
        whatShouldPrint.add("Чикенбургер");
        boolean result = sourceList.equals(whatShouldPrint);


        assertEquals(true, result);
    }

    @Test
    void shouldSellItem()
    {
        OrderRepositoryImpl orderRepository = new OrderRepositoryImpl();
        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
        McDonaldsService mcDonaldsService = new McDonaldsService(productRepository);
        productRepository.create(new BurgerModel(52, "Чизбургер", "Рубленый бифштекс", CategoryRepository.SANDWICHES, "Говядина"));
        productRepository.create(new BurgerModel(50, "Гамбургер", "Бифштекс на карамелизованной булочке", CategoryRepository.SANDWICHES, "Говядина"));
        productRepository.create(new BurgerModel(52, "Чикенбургер", "Обжаренная куриная котлета", CategoryRepository.SANDWICHES, "Курица"));
        productRepository.create(new DrinkModel(65, "Кока-Кола", "Классика, чтобы освежиться", COLD_DRINKS, "MEDIUM"));
        productRepository.create(new DrinkModel(65, "Фанта", "Прекрасный солнечный напиток для самых ярких", COLD_DRINKS, "MEDIUM"));
        productRepository.create(new DrinkModel(65, "Спрайт", "Напиток для тех, кто всегда в движении", COLD_DRINKS, "MEDIUM"));


        List<Integer> basket = new ArrayList<>();
        basket.add(2_2);
        basket.add(5_2);
        OrderModel order = new OrderModel(basket);
        boolean result = mcDonaldsService.sellItem(order);


        assertEquals(true, result);
    }

    @Test
    void shouldGetItemsByText()
    {
        OrderRepositoryImpl orderRepository = new OrderRepositoryImpl();
        ProductRepositoryImpl productRepository = new ProductRepositoryImpl();
        McDonaldsService mcDonaldsService = new McDonaldsService(productRepository);
        productRepository.create(new BurgerModel(52, "Чизбургер", "Рубленый бифштекс", CategoryRepository.SANDWICHES, "Говядина"));
        productRepository.create(new BurgerModel(50, "Гамбургер", "Бифштекс на карамелизованной булочке", CategoryRepository.SANDWICHES, "Говядина"));
        productRepository.create(new BurgerModel(52, "Чикенбургер", "Обжаренная куриная котлета", CategoryRepository.SANDWICHES, "Курица"));
        productRepository.create(new DrinkModel(65, "Кока-Кола", "Классика, чтобы освежиться", COLD_DRINKS, "MEDIUM"));
        productRepository.create(new DrinkModel(65, "Фанта", "Прекрасный солнечный напиток для самых ярких", COLD_DRINKS, "MEDIUM"));
        productRepository.create(new DrinkModel(65, "Спрайт", "Напиток для тех, кто всегда в движении", COLD_DRINKS, "MEDIUM"));


        List<ProductModel> testList = mcDonaldsService.getProductsByText("бургер");
        List<String> productNames = new ArrayList<>();
        for (ProductModel model : testList) {
            productNames.add(model.getName());
        }
        List<String> copyProductNames = new ArrayList<>();
        copyProductNames.add("Чизбургер");
        copyProductNames.add("Гамбургер");
        copyProductNames.add("Чикенбургер");
        boolean result = productNames.equals(copyProductNames);

        assertEquals(true, result);
    }
}