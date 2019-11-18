package dto;

import model.BurgerModel;
import model.DrinkModel;
import model.PotatoModel;
import model.ProductModel;
import model.StarterModel;

public class ProductDto {


    public ProductDto(int id, String name, int price, String size) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.size = size;
    }

    public ProductDto(int id, String name, int price, int amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.size = Integer.toString(amount);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    private int id;
    private int price;
    private String name;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    private String size;

    public ProductDto(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }



    public static ProductDto from(ProductModel model) {

        if (model instanceof BurgerModel) {
            return new ProductDto(
                    model.getId(),
                    model.getName(),
                    model.getPrice()
            );
        }

        if (model instanceof DrinkModel) {
            return new ProductDto(
                    model.getId(),
                    model.getName(),
                    model.getPrice(),
                    ((DrinkModel) model).getVolume()
            );
        }

        if (model instanceof PotatoModel) {
            return new ProductDto(
                    model.getId(),
                    model.getName(),
                    model.getPrice(),
                    ((PotatoModel) model).getSize()
            );
        }

        if (model instanceof StarterModel) {
            return new ProductDto(
                    model.getId(),
                    model.getName(),
                    model.getPrice(),
                    ((StarterModel) model).getAmount()
            );
        }

        return null;
    }
}
