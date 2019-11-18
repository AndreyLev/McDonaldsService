package model;

import repository.CategoryRepository;

public class DrinkModel extends ProductModel{
    private String volume;

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public DrinkModel(int price, String name, String about, CategoryRepository category, String volume) {
        super(price, name, about, category.COLD_DRINKS);
        this.volume = volume;
    }
}
