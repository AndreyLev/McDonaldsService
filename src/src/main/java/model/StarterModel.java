package model;

import repository.CategoryRepository;

public class StarterModel extends ProductModel{

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    private int amount;

    public StarterModel(int price, String name, String about, CategoryRepository categoryName) {
        super(price, name, about, categoryName);
    }
}
