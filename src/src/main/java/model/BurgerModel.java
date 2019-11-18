package model;

import repository.CategoryRepository;

public class BurgerModel extends ProductModel {

    public String getMeatType() {
        return meatType;
    }

    public void setMeatType(String meatType) {
        this.meatType = meatType;
    }

    private String meatType;

    public BurgerModel(int price, String name, String about, CategoryRepository category, String meatType) {
        super(price,name, about, category);
        this.meatType = meatType;
    }


}
